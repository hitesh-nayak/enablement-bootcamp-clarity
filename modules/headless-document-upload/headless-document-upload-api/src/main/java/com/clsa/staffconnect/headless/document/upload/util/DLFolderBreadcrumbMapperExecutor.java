package com.clsa.staffconnect.headless.document.upload.util;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.object.exception.NoSuchObjectDefinitionException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.PortletPreferenceValueTable;
import com.liferay.portal.kernel.model.PortletPreferencesTable;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component(
        immediate = true,
        property = {"background.task.executor.class.name=com.clsa.staffconnect.headless.document.upload.util.DLFolderBreadcrumbMapperExecutor"},
        service = BackgroundTaskExecutor.class
)
public class DLFolderBreadcrumbMapperExecutor extends BaseBackgroundTaskExecutor {

    public DLFolderBreadcrumbMapperExecutor() {
        setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_COMPANY);
    }


    @Override
    public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
        _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +" Executing DLFolder_Layout_Breadcrumb_Mapping_Background_Task.");
        long companyId = backgroundTask.getCompanyId();
        long userId = backgroundTask.getUserId();
        long groupId = backgroundTask.getGroupId();

        ServiceContext context = new ServiceContext();
        context.setCompanyId(companyId);
        context.setScopeGroupId(groupId);
        context.setAddGuestPermissions(false);
        context.setAddGroupPermissions(true);

        try {
            List<Object[]> results = fetchPortletPreferenceValues();
            processPortletPreferences(results, companyId, userId, context);
        } catch (Exception e) {
            _log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +" Error fetching folder and page mapping." + e);
        }


        return BackgroundTaskResult.SUCCESS;
    }

    private List<Object[]> fetchPortletPreferenceValues() {

        DSLQuery dslQuery = DSLQueryFactoryUtil.select(
                        PortletPreferencesTable.INSTANCE.plid,
                        PortletPreferenceValueTable.INSTANCE.name,
                        PortletPreferenceValueTable.INSTANCE.smallValue
                )
                .from(PortletPreferencesTable.INSTANCE)
                .innerJoinON(
                        PortletPreferenceValueTable.INSTANCE,
                        PortletPreferencesTable.INSTANCE.portletPreferencesId.eq(
                                PortletPreferenceValueTable.INSTANCE.portletPreferencesId
                        )
                )
                .where(
                        PortletPreferenceValueTable.INSTANCE.name.eq("rootFolderId")
                                .and(
                                        PortletPreferenceValueTable.INSTANCE.smallValue.isNotNull()
                                ));
        _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Querying db for existing mappings -->"+ dslQuery.toString());

        return _portletPreferencesLocalService.dslQuery(dslQuery);
    }

    private void processPortletPreferences(List<Object[]> results, long companyId, long userId, ServiceContext context) throws NoSuchObjectDefinitionException {
        _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +"portletPreferenceValues result size " + results.size());

        ObjectDefinition objectDefinition = bcfMappingDocumentHelper.getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER);
        ObjectDefinition objectDefinitionAudit = bcfMappingDocumentHelper.getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER_MAPPING_AUDIT);


        for (Object[] result : results) {
            Map<String, Serializable> auditMap = new HashMap<>();
            Exception throwable = null;
            ObjectEntry objectEntry = null;
            ObjectEntry objectEntryNew = null;
            try {
                long plid = (Long) result[0];
                long folderId =Long.parseLong((String) result[2]);


                Layout layout = layoutLocalService.fetchLayout(plid);
                DLFolder dlFolder= dlFolderLocalService.fetchDLFolder(folderId);

                if(Validator.isNull(layout)) throw new NoSuchLayoutException("No layout found for plid " + plid);
                if(Validator.isNull(dlFolder)) throw new NoSuchFolderException("No folder found for folderId " + folderId);
                if(Validator.isNotNull(layout)){
                    Group group = groupLocalService.fetchGroup(layout.getGroupId());
                    if(Validator.isNull(group)) throw new NoSuchGroupException("No Group exists for groupID "+ layout.getGroupId());
                }

                String breadcrumb = layoutLocalService.fetchLayout(plid).getBreadcrumb(LanguageUtil.getLocale("en_US"));
                _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Breadcrumb value before sanitizing: "+breadcrumb);
                breadcrumb = breadcrumb.replaceAll("&amp;", "&");
                breadcrumb = breadcrumb.replace(DocumentAPIConstants.KEY_PAGES_GREP, "").trim();
                _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Breadcrumb value after sanitizing: "+breadcrumb);



                String sha256Hash = bcfMappingDocumentHelper.getSHA256Hash(breadcrumb);


                Map<String, Serializable> mp = new HashMap<>();
                mp.put(DocumentAPIConstants.KEY_FOLDER_ID, Long.parseLong((String) result[2]));
                mp.put(DocumentAPIConstants.KEY_LAYOUT_PLID, (Long) result[0]);
                mp.put(DocumentAPIConstants.KEY_LAYOUT_BREADCRUMB, breadcrumb);
                mp.put(DocumentAPIConstants.KEY_ACTIVE, Boolean.TRUE);

                try {
                    objectEntry = objectEntryLocalService.getObjectEntry(sha256Hash, companyId, 0L);
                    _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +objectEntry);
                } catch (PortalException e) {
                    throwable = e;
                    _log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +e.getMessage(), e);
                }
                objectEntryNew = objectEntryLocalService.addOrUpdateObjectEntry(sha256Hash, userId, 0L, objectDefinition.getObjectDefinitionId(), mp, context);





            } catch (Exception e) {
                throwable = e;
                _log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +"Error processing DLFolder mapping to breadcrumb: " + e);
            }finally {
                auditMap = bcfMappingDocumentHelper.getAddEditAuditMap(userId, objectEntry, objectEntryNew, auditMap, throwable);
                auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, DocumentAPIConstants.USER_ACTION_AUTO_MAPPING);
                bcfMappingDocumentHelper.messageAuditDetails(bcfMappingDocumentHelper.getMessage(String.valueOf(System.currentTimeMillis()), userId, objectDefinitionAudit.getObjectDefinitionId(), auditMap, context));
            }
        }
    }

    @Override
    public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
        return null;
    }

    @Override
    public BackgroundTaskExecutor clone() {
        return this;
    }

    @Activate
    protected void activate(BundleContext bundleContext) {
        _log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN +"DLFolderBreadcrumbMapperExecutor activated.");
    }


    @Reference
    private LayoutLocalService layoutLocalService;
    @Reference
    private ObjectEntryLocalService objectEntryLocalService;
    @Reference
    private PortletPreferencesLocalService _portletPreferencesLocalService;
    @Reference
    private BCFMappingDocumentHelper bcfMappingDocumentHelper;
    @Reference
    private DLFolderLocalService dlFolderLocalService;
    @Reference
    private GroupLocalService groupLocalService;

    private static final Log _log = LogFactoryUtil.getLog(DLFolderBreadcrumbMapperExecutor.class);
}