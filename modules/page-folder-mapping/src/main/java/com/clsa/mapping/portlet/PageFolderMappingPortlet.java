package com.clsa.mapping.portlet;

import com.clsa.mapping.constants.PageFolderMappingPanelCategoryKeys;
import com.clsa.mapping.dto.LayoutFolderDTO;
import com.clsa.mapping.util.PageFolderMappingUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Reference;
import com.clsa.mapping.constants.PageFolderMappingPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import com.clsa.mapping.util.DLAdminDisplayContextProviderCustom;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hitesh Nayak
 */
@Component(
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=PageFolderMapping",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + PageFolderMappingPortletKeys.PAGEFOLDERMAPPING,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
        },
        service = Portlet.class
)
public class PageFolderMappingPortlet extends MVCPortlet {
    private static final Log log = LogFactoryUtil.getLog(PageFolderMappingPortlet.class);

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        if (ParamUtil.getString(renderRequest, "mvcPath").equalsIgnoreCase("/addEdit.jsp")) {

            log.info("Editing object.");

            renderRequest.setAttribute(PageFolderMappingPanelCategoryKeys.PAGE_SELECTOR_URL, PageFolderMappingUtil.getSelectPageURL(_itemSelector, renderRequest, renderResponse));
            renderRequest.setAttribute("customDocumentContext", dlAdminDisplayContextProviderCustom.getDLAdminDisplayContext(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse)));
            super.render(renderRequest, renderResponse);
        } else {
            String searchKeyword = ParamUtil.getString(renderRequest, "searchKeyword");
            List<ObjectEntry> objectEntries = new ArrayList<>();
            try {
                if (Validator.isNotNull(searchKeyword))
                    objectEntries = ObjectEntryLocalServiceUtil.searchObjectEntries(0L, 42941L, searchKeyword, 100, 100).getBaseModels();
                else
                    objectEntries = ObjectEntryLocalServiceUtil.getObjectEntries(0L, 42941L, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            } catch (PortalException e) {
                log.error(e.getMessage(), e);
            }

            List<LayoutFolderDTO> stList = objectEntries.stream().map(objEn -> {
                Map<String, Serializable> mp = objEn.getValues();
                Layout layout = LayoutLocalServiceUtil.fetchLayout((Long) mp.get("layoutPlid"));
                return new LayoutFolderDTO(objEn.getExternalReferenceCode(), (long) mp.get("folderId"), (long) mp.get("layoutPlid"), (String) mp.get("layoutBreadCrumb"), (Boolean) mp.get("active"), Validator.isNotNull(layout) ? layout.getGroupId() : 0L);
            }).collect(Collectors.toList());

            SearchContainer<LayoutFolderDTO> searchContainer = new SearchContainer<>(renderRequest, renderResponse.createRenderURL(), null, "No Results");
            searchContainer.setResultsAndTotal(stList);
            searchContainer.setSearch(true);


            renderRequest.setAttribute("searchContainer", searchContainer);

            super.render(renderRequest, renderResponse);
        }


    }

    @ProcessAction(name = "addEditMapping")
    public void addEditMapping(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
        Exception throwable = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Map<String, Serializable> auditMap = new HashMap<>();
        String layoutPlId = ParamUtil.getString(actionRequest, "layoutPlId");
        String addEditFormValue = ParamUtil.getString(actionRequest, "addEditFormValue");
        String layoutId = ParamUtil.getString(actionRequest, "layoutId");
        String layoutGroupId = ParamUtil.getString(actionRequest, "layoutGroupId");
        String rootLayoutBreadcrumb = ParamUtil.getString(actionRequest, "rootLayoutBreadcrumb");
        String folderUploadId = ParamUtil.getString(actionRequest, "folderUploadId");
        String backURL = ParamUtil.getString(actionRequest, "backURL");
        ObjectDefinition objectDefinition = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolder",themeDisplay.getCompanyId());
        ObjectDefinition objectDefinitionAudit = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolderMappingAudit",themeDisplay.getCompanyId());
        ObjectEntry objectEntry = null;
        ObjectEntry objectEntryNew = null;

        try {
            log.info(layoutId + "---" + layoutGroupId + "---" + folderUploadId + "---" + layoutPlId + "---" + rootLayoutBreadcrumb + "---" + addEditFormValue);
            Layout layout = LayoutLocalServiceUtil.fetchLayout(layoutPlId, Long.parseLong(layoutGroupId), false);
            log.info(layout);
            log.info(objectDefinition);

            Map<String, Serializable> mp = new HashMap<>();
            mp.put("folderId", Long.parseLong(folderUploadId));
            mp.put("layoutPlid", layout.getPlid());
            mp.put("layoutBreadCrumb", rootLayoutBreadcrumb);
            mp.put("active", Boolean.TRUE);
            log.info(mp);

            try {
                objectEntry = ObjectEntryLocalServiceUtil.getObjectEntry(rootLayoutBreadcrumb, themeDisplay.getCompanyId(), 0L);
                log.info(objectEntry);
            } catch (PortalException e) {
                throwable = e;
                log.error(e.getMessage(), e);
            }
            objectEntryNew = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(rootLayoutBreadcrumb, themeDisplay.getUserId(), 0L, objectDefinition.getObjectDefinitionId(), mp, ServiceContextFactory.getInstance(actionRequest));
            objectEntryNew.setUuid(rootLayoutBreadcrumb);
            ObjectEntryLocalServiceUtil.updateObjectEntry(objectEntryNew);
            log.info(objectEntryNew);
        } catch (Exception e) {
            throwable = e;
            log.error(e.getMessage(), e);
        }


        if (addEditFormValue.equalsIgnoreCase("ADD_MAPPING"))
            auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_ADD_MAPPING);

        else auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_EDIT_MAPPING);

        PageFolderMappingUtil.addAuditDetails(ServiceContextFactory.getInstance(actionRequest), themeDisplay.getUserId(), objectEntry, objectEntryNew, auditMap, objectDefinitionAudit, throwable);
        actionResponse.sendRedirect(backURL);
    }

    @ProcessAction(name = "enableDisableBreadcrumb")
    public void enableDisableBreadcrumb(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String objectExternalReferenceCode = ParamUtil.getString(actionRequest, "objectERC");
        Boolean enable = ParamUtil.getBoolean(actionRequest, "enable");
        String backURL = ParamUtil.getString(actionRequest, "backURL");
        ObjectEntry objectEntry = null;
        ObjectEntry objectEntryNew = null;
        Map<String, Serializable> auditMap = new HashMap<>();
        ObjectDefinition objectDefinitionAudit = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolderMappingAudit",themeDisplay.getCompanyId());
        Exception throwable = null;

        try {
            objectEntry = ObjectEntryLocalServiceUtil.getObjectEntry(objectExternalReferenceCode, themeDisplay.getCompanyId(), 0L);
            Map<String, Serializable> mp = objectEntry.getValues();
            Map<String, Serializable> newMp = new HashMap<>(mp);
            newMp.put("active", enable);
            objectEntryNew = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(objectExternalReferenceCode, themeDisplay.getUserId(), 0L, objectEntry.getObjectDefinitionId(), newMp, ServiceContextFactory.getInstance(actionRequest));
            log.info(objectEntry);
        } catch (Exception e) {
            throwable = e;
            log.error(e.getMessage(), e);
        }

        if (enable) auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_ENABLE_MAPPING);
        else auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_DISABLE_MAPPING);

       PageFolderMappingUtil.addAuditDetails(ServiceContextFactory.getInstance(actionRequest), themeDisplay.getUserId(), objectEntry, objectEntryNew, auditMap, objectDefinitionAudit, throwable);
        actionResponse.sendRedirect(backURL);
    }

    @ProcessAction(name = "extractData")
    public void extractData(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String backURL = ParamUtil.getString(actionRequest, "backURL");

//        List<PortletPreferenceValue> preferenceValues = PortletPreferenceValueLocalServiceUtil.getPortletPreferenceValues(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//        preferenceValues = preferenceValues.stream().filter(pref -> pref.getName().equalsIgnoreCase("rootFolderId")).collect(Collectors.toList());
//        log.info(preferenceValues);
//
//        ObjectDefinition objectDefinition = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolder",themeDisplay.getCompanyId());
//        ObjectDefinition objectDefinitionAudit = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("BreadcrumbFolderMappingAudit",themeDisplay.getCompanyId());
//
//        preferenceValues.forEach(preferenceValue -> {
//            Exception throwable = null;
//            ObjectEntry objectEntry = null;
//            ObjectEntry objectEntryNew = null;
//            Map<String, Serializable> auditMap = new HashMap<>();
//            try {
//                com.liferay.portal.kernel.model.PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPortletPreferences(preferenceValue.getPortletPreferencesId());
//                if (Validator.isNotNull(preferences)) {
//                    Layout layout = LayoutLocalServiceUtil.fetchLayout(preferences.getPlid());
//                    Map<String, Serializable> mp = new HashMap<>();
//                    mp.put("folderId", Long.parseLong(preferenceValue.getSmallValue()));
//                    mp.put("layoutPlid", layout.getPlid());
//                    mp.put("layoutBreadCrumb", layout.getBreadcrumb(Locale.US).replace("Pages >", "").trim());
//                    mp.put("active", Boolean.TRUE);
//
//                    try {
//                        objectEntry = ObjectEntryLocalServiceUtil.getObjectEntry(layout.getBreadcrumb(Locale.US).replace("Pages >", "").trim(), themeDisplay.getCompanyId(), 0L);
//                        log.info(objectEntry);
//                    } catch (PortalException e) {
//                        throwable = e;
//                        log.error(e.getMessage(), e);
//                    }
//                    objectEntryNew = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(layout.getBreadcrumb(Locale.US).replace("Pages >", "").trim(), themeDisplay.getUserId(), 0L, objectDefinition.getObjectDefinitionId(), mp, ServiceContextFactory.getInstance(actionRequest));
//                    objectEntryNew.setUuid(layout.getBreadcrumb(Locale.US).replace("Pages >", "").trim());
//                    ObjectEntryLocalServiceUtil.updateObjectEntry(objectEntryNew);
//                }
//
//                auditMap.put("userAction", PageFolderMappingPanelCategoryKeys.USER_ACTION_AUTO_MAPPING);
//                PageFolderMappingUtil.addAuditDetails(ServiceContextFactory.getInstance(actionRequest), themeDisplay.getUserId(), objectEntry, objectEntryNew, auditMap, objectDefinitionAudit, throwable);
//
//            } catch (PortalException e) {
//                log.error(e.getMessage(), e);
//            }
//        });

        queueBackgroundTask(actionRequest,themeDisplay.getUserId(),themeDisplay.getScopeGroupId());
        actionResponse.sendRedirect(backURL);

    }

    public void queueBackgroundTask(ActionRequest actionRequest, long userId, long groupId) throws PortalException {
        Map<String, Serializable> taskContextMap = new HashMap<>();

        log.info("Queue method called ..");
        System.out.println("Queue ....");
        String taskName = "DL Folder Breadcrumb mapper Background Task";

        BackgroundTaskManagerUtil.addBackgroundTask(
                userId, groupId, taskName,
                "com.clsa.mapping.util.DLFolderBreadcrumbMapperExecutor",
                taskContextMap, ServiceContextFactory.getInstance(actionRequest));
    }


    @Reference
    private DLAdminDisplayContextProviderCustom dlAdminDisplayContextProviderCustom;
    @Reference
    private ItemSelector _itemSelector;
}