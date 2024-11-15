package com.clsa.staffconnect.breadcrumb.folder.mapping.web.portlet.action;

import com.clsa.staffconnect.breadcrumb.folder.mapping.web.constants.BreadcrumbFolderMappingPortletKeys;
import com.clsa.staffconnect.breadcrumb.folder.mapping.web.dto.BCFMappingDTO;
import com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context.BCFMappingDisplayContext;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.object.exception.NoSuchObjectEntryException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Krishna Rajappa
 */
@Component(
        property = {
                "javax.portlet.name=" + BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING,
                "mvc.command.name=/breadcrump_folder_mapping/edit"
        },
        service = MVCActionCommand.class
)
public class EditMappingMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Executing command: "+cmd);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {

            if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {

                if(!validate(actionRequest,cmd)) {
                    log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + LanguageUtil.get(themeDisplay.getLocale(),"validation-error"));
                    SessionErrors.add(actionRequest, "validation_error_msg", LanguageUtil.get(themeDisplay.getLocale(),"validation-error"));
                    return;
                }

                BCFMappingDTO bcfMappingDTO = _updateMapping(actionRequest);

                String redirect = _getSaveAndContinueRedirect(
                        actionRequest, bcfMappingDTO);

                sendRedirect(actionRequest, actionResponse, redirect);
            } else if (cmd.equals("setActive")) {
                setActive(actionRequest);
            } else if(cmd.equals("autoMap")){
                autoMap(actionRequest);
            }
        } catch (Throwable throwable) {
            if (throwable instanceof NoSuchObjectEntryException ||
                    throwable instanceof PrincipalException) {

                SessionErrors.add(actionRequest, throwable.getClass());

                actionResponse.setRenderParameter("mvcPath", "/error.jsp");
            }

        }
    }

    private void autoMap(ActionRequest actionRequest) throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        bcfMappingDocumentHelper.queueBackgroundTask(actionRequest, themeDisplay.getUserId(),themeDisplay.getScopeGroupId());
    }

    private void setActive(ActionRequest actionRequest) throws PortalException, NoSuchAlgorithmException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String objectExternalReferenceCode = ParamUtil.getString(actionRequest, "objectERC");
        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Executing setActive before sanitizing: "+objectExternalReferenceCode);
        objectExternalReferenceCode = objectExternalReferenceCode.replaceAll("&amp;", "&");
        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Executing setActive after sanitizing: "+objectExternalReferenceCode);
        String sha256Hash = bcfMappingDocumentHelper.getSHA256Hash(objectExternalReferenceCode);
        Boolean enable = ParamUtil.getBoolean(actionRequest, "active");
        ObjectEntry objectEntry = null;
        ObjectEntry objectEntryNew = null;
        Map<String, Serializable> auditMap = new HashMap<>();
        ObjectDefinition objectDefinitionAudit = bcfMappingDocumentHelper
                .getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER_MAPPING_AUDIT);
        Exception throwable = null;

        try {
            objectEntry = objectEntryLocalService.getObjectEntry(sha256Hash,
                    themeDisplay.getCompanyId(), 0L);
            Map<String, Serializable> mp = objectEntry.getValues();
            Map<String, Serializable> newMp = new HashMap<>(mp);
            newMp.put(DocumentAPIConstants.KEY_ACTIVE, enable);
            objectEntryNew = objectEntryLocalService.addOrUpdateObjectEntry(sha256Hash,
                    themeDisplay.getUserId(), 0L, objectEntry.getObjectDefinitionId(), newMp,
                    ServiceContextFactory.getInstance(actionRequest));
            log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + "Updated object ->" + objectEntry);
        } catch (Exception e) {
            throwable = e;
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + e.getMessage(), e);
        }

        if (enable)
            auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, DocumentAPIConstants.USER_ACTION_ENABLE_MAPPING);
        else
            auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, DocumentAPIConstants.USER_ACTION_DISABLE_MAPPING);

        auditMap = bcfMappingDocumentHelper.getAddEditAuditMap(themeDisplay.getUserId(), objectEntry, objectEntryNew, auditMap,
                throwable);
        bcfMappingDocumentHelper.messageAuditDetails(bcfMappingDocumentHelper.getMessage(String.valueOf(System.currentTimeMillis()),
                themeDisplay.getUserId(), objectDefinitionAudit.getObjectDefinitionId(), auditMap,
                ServiceContextFactory.getInstance(actionRequest)));

    }

    private String _getSaveAndContinueRedirect(ActionRequest actionRequest, BCFMappingDTO bcfMappingDTO) {

        PortletURL portletURL = _portal.getControlPanelPortletURL(actionRequest,
                BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING, PortletRequest.RENDER_PHASE);

        if (bcfMappingDTO != null) {
            portletURL.setParameter("mvcRenderCommandName", "/breadcrump_folder_mapping/edit");
            portletURL.setParameter("id", String.valueOf(bcfMappingDTO.getId()));
        }

        return portletURL.toString();
    }

    private BCFMappingDTO _updateMapping(ActionRequest actionRequest) throws PortalException, NoSuchAlgorithmException {

        Exception throwable = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Map<String, Serializable> auditMap = new HashMap<>();
        String layoutPlId = ParamUtil.getString(actionRequest, "layoutPlId");
        String addEditFormValue = ParamUtil.getString(actionRequest, "addEditFormValue");
        String layoutId = ParamUtil.getString(actionRequest, "layoutId");
        String layoutGroupId = ParamUtil.getString(actionRequest, "layoutGroupId");
        String rootLayoutBreadcrumb = ParamUtil.getString(actionRequest, "rootLayoutBreadcrumb");
        rootLayoutBreadcrumb = rootLayoutBreadcrumb.replaceAll("&amp;", "&");
        String folderUploadId = ParamUtil.getString(actionRequest, "folderUploadId");
        ObjectDefinition objectDefinition = bcfMappingDocumentHelper
                .getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER);
        ObjectDefinition objectDefinitionAudit = bcfMappingDocumentHelper
                .getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER_MAPPING_AUDIT);
        ObjectEntry objectEntry = null;
        ObjectEntry objectEntryNew = null;
        Map<String, Serializable> mp = new HashMap<>();

        String sha256Hash = bcfMappingDocumentHelper.getSHA256Hash(rootLayoutBreadcrumb);

        try {
            log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + layoutId + "---" + layoutGroupId + "---"
                    + folderUploadId + "---" + layoutPlId + "---" + rootLayoutBreadcrumb + "---" + addEditFormValue);
            Layout layout = layoutLocalService.fetchLayout(layoutPlId, Long.parseLong(layoutGroupId), false);
            mp.put(DocumentAPIConstants.KEY_FOLDER_ID, Long.parseLong(folderUploadId));
            mp.put(DocumentAPIConstants.KEY_LAYOUT_PLID, layout.getPlid());
            mp.put(DocumentAPIConstants.KEY_LAYOUT_BREADCRUMB, rootLayoutBreadcrumb);
            mp.put(DocumentAPIConstants.KEY_ACTIVE, Boolean.TRUE);

            try {
                objectEntry = objectEntryLocalService.getObjectEntry(sha256Hash, themeDisplay.getCompanyId(),
                        0L);
                log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + "Existing object ->" + objectEntry);
            } catch (PortalException e) {
                throwable = e;
                log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + e.getMessage(), e);
            }
            objectEntryNew = objectEntryLocalService.addOrUpdateObjectEntry(sha256Hash,
                    themeDisplay.getUserId(), 0L, objectDefinition.getObjectDefinitionId(), mp,
                    ServiceContextFactory.getInstance(actionRequest));
            log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + "New or updated object ->" + objectEntryNew);
        } catch (Exception e) {
            throwable = e;
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN + e.getMessage(), e);
        }

        if (addEditFormValue.equalsIgnoreCase("ADD_MAPPING"))
            auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, DocumentAPIConstants.USER_ACTION_ADD_MAPPING);

        else
            auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, DocumentAPIConstants.USER_ACTION_EDIT_MAPPING);
        auditMap = bcfMappingDocumentHelper.getAddEditAuditMap(themeDisplay.getUserId(), objectEntry, objectEntryNew, auditMap,
                throwable);
        bcfMappingDocumentHelper.messageAuditDetails(bcfMappingDocumentHelper.getMessage(String.valueOf(System.currentTimeMillis()),
                themeDisplay.getUserId(), objectDefinitionAudit.getObjectDefinitionId(), auditMap,
                ServiceContextFactory.getInstance(actionRequest)));
        BCFMappingDisplayContext mappingDisplayContext = (BCFMappingDisplayContext)actionRequest.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);


        return mappingDisplayContext.mapToBCFMappingDTO(mp);
    }

    private boolean validate(ActionRequest actionRequest,String cmd) throws PortalException {
        String layoutId = ParamUtil.getString(actionRequest, "layoutId","0");
        String folderUploadId = ParamUtil.getString(actionRequest, "folderUploadId","0");
        String layoutPlId = ParamUtil.getString(actionRequest, "layoutPlId");
        String layoutGroupId = ParamUtil.getString(actionRequest, "layoutGroupId");
        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+"Validating ids -> layoutPlid ---->" + layoutPlId + "-----folderId---->" + folderUploadId );
        if (cmd.equals(Constants.ADD)) return Validator.isNotNull(dlFolderLocalService.fetchDLFolder(Long.parseLong(folderUploadId))) && Validator.isNotNull(layoutLocalService.fetchLayout(layoutPlId, Long.parseLong(layoutGroupId), false));
        else return Validator.isNotNull(dlFolderLocalService.fetchDLFolder(Long.parseLong(folderUploadId)));

    }

    @Reference
    private Portal _portal;
    @Reference
    private BCFMappingDocumentHelper bcfMappingDocumentHelper;
    @Reference
    private LayoutLocalService layoutLocalService;
    @Reference
    private ObjectEntryLocalService objectEntryLocalService;
    @Reference
    private DLFolderLocalService dlFolderLocalService;

    private static final Log log = LogFactoryUtil.getLog(EditMappingMVCActionCommand.class);
}
