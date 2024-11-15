package com.clsa.mapping.util;

import com.clsa.mapping.constants.PageFolderMappingPanelCategoryKeys;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.constants.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PortletPreferenceValueTable;
import com.liferay.portal.kernel.model.PortletPreferencesTable;
import com.liferay.portal.kernel.service.*;

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
        property = {"background.task.executor.class.name=com.clsa.mapping.util.DLFolderBreadcrumbMapperExecutor"},
        service = BackgroundTaskExecutor.class
)
public class DLFolderBreadcrumbMapperExecutor extends BaseBackgroundTaskExecutor {

    private static final int BATCH_SIZE = 20;

    public DLFolderBreadcrumbMapperExecutor() {
        setIsolationLevel(BackgroundTaskConstants.ISOLATION_LEVEL_COMPANY);
    }


    @Override
    public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
        int start = 0;
        _log.info(" Executing DLFolderBreadcrumbMapperExecutor ....");
        Long companyId = backgroundTask.getCompanyId();
        Long userId = backgroundTask.getUserId();
        Long groupId = backgroundTask.getGroupId();

        ServiceContext context = new ServiceContext();
        context.setCompanyId(companyId);
        context.setScopeGroupId(groupId);
        context.setAddGuestPermissions(false);
        context.setAddGroupPermissions(true);

        try {
            List<Object[]> results = fetchPortletPreferenceValues(start, BATCH_SIZE);
            processPortletPreferences(results, companyId, userId, context);
        } catch (Exception e) {
            _log.error("Error fetching folder and page mapping..." + e);
        }


        return BackgroundTaskResult.SUCCESS;
    }

    private List<Object[]> fetchPortletPreferenceValues(int start, int end) {

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
                                )
                                .and(
                                        PortletPreferenceValueTable.INSTANCE.smallValue.neq("")
                                )
                );
        //.limit(start, end);

        return _portletPreferencesLocalService.dslQuery(dslQuery);
    }

    private void processPortletPreferences(List<Object[]> results, long companyId, long userId, ServiceContext context) {
        _log.info("portletPreferenceValues result size " + results.size());

        ObjectDefinition objectDefinition = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolder", companyId);
        ObjectDefinition objectDefinitionAudit = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolderMappingAudit", companyId);

        for (Object[] result : results) {
            try {
                long plid = (Long) result[0];
                // String name = (String) result[1];
                // long smallValue = (Long) result[2];
                Exception throwable = null;
                ObjectEntry objectEntry = null;
                ObjectEntry objectEntryNew = null;
                Map<String, Serializable> auditMap = new HashMap<>();

                String breadcrumb = LayoutLocalServiceUtil.fetchLayout(plid).getBreadcrumb(LanguageUtil.getLocale("en_US"));
                _log.info("breadcrumb : " + breadcrumb);
                _log.info("plid : " + result[0]);
                _log.info("Name : " + result[1]);
                _log.info("Small Value: " + result[2]);


                Map<String, Serializable> mp = new HashMap<>();
                mp.put("folderId", Long.parseLong((String) result[2]));
                mp.put("layoutPlid", (Long) result[0]);
                mp.put("layoutBreadCrumb", breadcrumb.replace("pages >", "").trim());
                mp.put("active", Boolean.TRUE);

                try {
                    objectEntry = ObjectEntryLocalServiceUtil.getObjectEntry(breadcrumb.replace("pages >", "").trim(), companyId, 0L);
                    _log.info(objectEntry);
                } catch (PortalException e) {
                    throwable = e;
                    _log.error(e.getMessage(), e);
                }
                objectEntryNew = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(breadcrumb.replace("pages >", "").trim(), userId, 0L, objectDefinition.getObjectDefinitionId(), mp, context);
                objectEntryNew.setUuid(breadcrumb.replace("pages >", "").trim());
                ObjectEntryLocalServiceUtil.updateObjectEntry(objectEntryNew);


                auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_AUTO_MAPPING);
                PageFolderMappingUtil.addAuditDetails(context, userId, objectEntry, objectEntryNew, auditMap, objectDefinitionAudit, throwable);

            } catch (Exception e) {

                _log.error("Error processing dlfolder mapping to breadcrumb: " + e);
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
        System.out.println("DLFolderBreadcrumbMapperExecutor invoked ....");
    }


    @Reference
    private PortletPreferencesLocalService _portletPreferencesLocalService;

    private static final Log _log = LogFactoryUtil.getLog(DLFolderBreadcrumbMapperExecutor.class);
}