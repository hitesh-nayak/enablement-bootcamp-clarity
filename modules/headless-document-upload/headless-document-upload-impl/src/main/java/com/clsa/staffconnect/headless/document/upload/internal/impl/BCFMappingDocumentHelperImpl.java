package com.clsa.staffconnect.headless.document.upload.internal.impl;

import com.clsa.staffconnect.headless.document.upload.dto.v1_0.SuccessResponse;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalService;

import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.criteria.FolderItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.item.selector.criteria.folder.criterion.FolderItemSelectorCriterion;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.object.exception.NoSuchObjectDefinitionException;
import com.liferay.object.exception.NoSuchObjectEntryException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.events.ServicePreAction;
import com.liferay.portal.events.ThemeServicePreAction;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import java.util.stream.Collectors;

@Component(service = BCFMappingDocumentHelper.class)

public class BCFMappingDocumentHelperImpl implements BCFMappingDocumentHelper {
    private static final Log log = LogFactoryUtil.getLog(BCFMappingDocumentHelperImpl.class);

    public ThemeDisplay initializeThemeDisplay(
            long groupId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        ServicePreAction servicePreAction = new ServicePreAction();

        servicePreAction.servicePre(
                httpServletRequest, httpServletResponse, false);

        ThemeServicePreAction themeServicePreAction =
                new ThemeServicePreAction();

        themeServicePreAction.run(httpServletRequest, httpServletResponse);

        ThemeDisplay themeDisplay =
                (ThemeDisplay) httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        themeDisplay.setScopeGroupId(groupId);
        themeDisplay.setSiteGroupId(groupId);
        return themeDisplay;
    }

    public String getSHA256Hash(String input) throws NoSuchAlgorithmException {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

    }

    public DocumentResource getDocumentResource(ThemeDisplay themeDisplay) {
        return docResourceFactory.create().user(themeDisplay.getUser()).build();
    }

    public void messageAuditDetails(Message message) {
        messageBus.sendMessage(DocumentAPIConstants.DOCUMENT_API_MESSAGE_DESTINATION, message);
    }

    public Message getMessage(String objectEntryUuid, Long userId, Long objectDefinitionId, Map<String, Serializable> auditMap, ServiceContext serviceContext){
        Message message = new Message();
        Map<String, Serializable> dataMap = new HashMap<>();
        dataMap.put(DocumentAPIConstants.KEY_OBJECT_ENTRY_UUID, objectEntryUuid);
        dataMap.put(DocumentAPIConstants.KEY_USER_ID, userId);
        dataMap.put(DocumentAPIConstants.KEY_OBJECT_DEFINITION_ID, objectDefinitionId);
        dataMap.put(DocumentAPIConstants.KEY_AUDIT_MAP, (Serializable) auditMap);
        dataMap.put(DocumentAPIConstants.KEY_SERVICE_CONTEXT, serviceContext);

        message.setPayload(dataMap);
        return message;
    }


    public Map<String, Serializable> getInitialAuditmap(HttpServletRequest contextHttpServletRequest, String userAction) {
        Map<String, Serializable> auditMap = new HashMap<>();
        auditMap.put(DocumentAPIConstants.KEY_USER_DETAILS, contextHttpServletRequest.getRemoteUser());
        auditMap.put(DocumentAPIConstants.KEY_USER_ACTION, userAction);
        auditMap.put(DocumentAPIConstants.KEY_ENDPOINT, contextHttpServletRequest.getRequestURI());
        auditMap.put(DocumentAPIConstants.KEY_REQUEST_DATE, new Date());
        auditMap.put(DocumentAPIConstants.KEY_CLIENT_ADDRESS, contextHttpServletRequest.getRemoteHost().concat(StringPool.COMMA).concat(String.valueOf(contextHttpServletRequest.getRemotePort())));
        return auditMap;
    }

    public ObjectDefinition getObjectDefinitionByName(String objectDefinitionName) throws NoSuchObjectDefinitionException {

        DynamicQuery dq = objectDefinitionLocalService.dynamicQuery();
        dq.add(RestrictionsFactoryUtil.eq(DocumentAPIConstants.KEY_NAME, objectDefinitionName));
        ObjectDefinition obj = (ObjectDefinition) objectDefinitionLocalService.dynamicQuery(dq).get(0);

        if (Validator.isNotNull(obj)) return obj;
        else
            throw new NoSuchObjectDefinitionException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + DocumentAPIConstants.OBJECT_DEFINITION_NOT_FOUND + objectDefinitionName);
    }

    public ObjectEntry getObjectEntryByERC(String objectERC) throws NoSuchObjectEntryException {
        DynamicQuery dq = objectEntryLocalService.dynamicQuery();
        dq.add(RestrictionsFactoryUtil.eq(DocumentAPIConstants.KEY_ERC, objectERC));
        List<ObjectEntry> objList = objectEntryLocalService.dynamicQuery(dq);

        if (ListUtil.isNotEmpty(objList)) return objList.get(0);
        else throw new NoSuchObjectEntryException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + DocumentAPIConstants.OBJECT_ENTRY_NOT_FOUND + objectERC);
    }

    public SuccessResponse processRequest(MultipartBody multipartBody, String methodType, HttpServletResponse contextHttpServletResponse, HttpServletRequest contextHttpServletRequest) throws Exception {
        String auditObjectUUID = StringUtil.randomString(30);
        String fileName ="";
        ObjectDefinition objectDefinitionAudit = getObjectDefinitionByName(DocumentAPIConstants.OBJECT_NAME_DOCUMENT_API_AUDIT);

        Map<String, Serializable> auditMap = getInitialAuditmap(contextHttpServletRequest, methodType);

        Exception throwable = null;
        try {
            if (Validator.isNotNull(multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE))) {
                auditMap.put(DocumentAPIConstants.KEY_FILE_NAME, multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE).getFileName());
                auditMap.put(DocumentAPIConstants.KEY_FILE_SIZE, multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE).getSize());
            }
            if (Validator.isNotNull(multipartBody.getValueAsString(DocumentAPIConstants.KEY_BREADCRUMB)))
                auditMap.put(DocumentAPIConstants.KEY_ADDITIONAL_INFORMATION, getSHA256Hash(multipartBody.getValueAsString(DocumentAPIConstants.KEY_BREADCRUMB)));

            SuccessResponse apiResponse = new SuccessResponse();
            String breadCrumb = multipartBody.getValueAsString(DocumentAPIConstants.KEY_BREADCRUMB);
            String sha256Hash = getSHA256Hash(breadCrumb);
            ObjectEntry objectEntry = null;
            try {
                objectEntry = getObjectEntryByERC(sha256Hash);
            } catch (NoSuchObjectEntryException e) {
                log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage());
            }
            if (Validator.isNull(objectEntry)) {

                auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_NOT_FOUND);
                auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND);
                throw new NoSuchFolderException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API+DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND);
            }
            auditMap.put(DocumentAPIConstants.KEY_RELATIONSHIP_BREADCRUMBFOLDER_APIAUDIT, objectEntry.getObjectEntryId());


            Map<String, Serializable> mp = objectEntry.getValues();
            Long dlFolderId = (Long) mp.get(DocumentAPIConstants.KEY_FOLDER_ID);
            Boolean enabled = (Boolean) mp.get(DocumentAPIConstants.KEY_ACTIVE);

            if (!enabled) {
                auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_NOT_FOUND);
                auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND+ " (Breadcrumb path is disabled for receiving documents.)");
                throw new NoSuchFolderException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API+DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND);
            }

            DLFolder dlFolder = dlFolderLocalService.fetchDLFolder(dlFolderId);

            if (Validator.isNull(dlFolder)) {
                auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_NOT_FOUND);
                auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND);
                throw new NoSuchFolderException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API+DocumentAPIConstants.MESSAGE_FOLDER_NOT_FOUND);
            }


            ThemeDisplay themeDisplay = initializeThemeDisplay(dlFolder.getGroupId(), contextHttpServletRequest, contextHttpServletResponse);

            try {
                if (methodType.equalsIgnoreCase(DocumentAPIConstants.USER_POST_DOCUMENT_REQUEST)) {
                    getDocumentResource(themeDisplay).postDocumentFolderDocument(dlFolderId, multipartBody);
                    apiResponse.setMessage(DocumentAPIConstants.MESSAGE_SUCCESSFUL_UPLOAD);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_SUCCESSFUL_UPLOAD);
                } else if (methodType.equalsIgnoreCase(DocumentAPIConstants.USER_PUT_DOCUMENT_REQUEST)) {
                    fileName = multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE).getFileName();
                    FileEntry fileEntry = null;
                    try {
                        fileEntry = dlAppLocalService.getFileEntry(dlFolder.getGroupId(), dlFolderId, multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE).getFileName());
                    } catch (Exception e) {
                        try {
                            fileEntry = dlAppLocalService.getFileEntryByFileName(dlFolder.getGroupId(), dlFolderId, multipartBody.getBinaryFile(DocumentAPIConstants.KEY_FILE).getFileName());
                        } catch (Exception ex) {
                            throw new NoSuchFileEntryException(ex);
                        }
                    }
                    getDocumentResource(themeDisplay).putDocument(fileEntry.getFileEntryId(), multipartBody);
                    apiResponse.setMessage(DocumentAPIConstants.MESSAGE_SUCCESSFUL_UPDATE);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_SUCCESSFUL_UPDATE);
                } else {
                    if (Validator.isNull(multipartBody.getValueAsString(DocumentAPIConstants.KEY_FILE)) || multipartBody.getValueAsString(DocumentAPIConstants.KEY_FILE).isEmpty())
                        throw new BadRequestException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API+ "No file name available.");
                    fileName = multipartBody.getValueAsString(DocumentAPIConstants.KEY_FILE);
                    auditMap.put(DocumentAPIConstants.KEY_FILE_NAME, fileName);
                    FileEntry fileEntry = null;
                    try {
                       fileEntry = dlAppLocalService.getFileEntry(dlFolder.getGroupId(), dlFolderId, multipartBody.getValueAsString(DocumentAPIConstants.KEY_FILE));
                    } catch (Exception e) {
                        try {
                            fileEntry = dlAppLocalService.getFileEntryByFileName(dlFolder.getGroupId(), dlFolderId, multipartBody.getValueAsString(DocumentAPIConstants.KEY_FILE));
                        } catch (Exception ex) {
                            throw new NoSuchFileEntryException(ex);
                        }
                    }
                    getDocumentResource(themeDisplay).deleteDocument(fileEntry.getFileEntryId());
                    apiResponse.setMessage(DocumentAPIConstants.MESSAGE_SUCCESSFUL_DELETE);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, DocumentAPIConstants.MESSAGE_SUCCESSFUL_DELETE);
                }
                auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_OK);
                return apiResponse;
            } catch (Exception e) {
                log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage(), e);
                throwable = e;
                if (e instanceof PrincipalException.MustHavePermission) {
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_FORBIDDEN);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                } else if (e instanceof DuplicateFileEntryException) {
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_CONFLICT);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                } else if (e instanceof FileExtensionException) {
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                } else if (e instanceof BadRequestException) {
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_BAD_REQUEST);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                } else if (e instanceof NoSuchFileEntryException) {
                    throwable = new NoSuchFileEntryException(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API+" No file found with filename or title "+fileName);
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_NOT_FOUND);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                } else {
                    auditMap.put(DocumentAPIConstants.KEY_STATUS_CODE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    auditMap.put(DocumentAPIConstants.KEY_RESPONSE_MESSAGE, e.getMessage());
                }
            }
        } catch (Exception e) {
            throwable = e;
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage());
        } finally {
            log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + "Finally executing audit update " + "-> AuditObjectValues ->" + auditMap);
            messageAuditDetails(getMessage(auditObjectUUID, Long.parseLong(contextHttpServletRequest.getRemoteUser()), objectDefinitionAudit.getObjectDefinitionId(), auditMap, ServiceContextFactory.getInstance(contextHttpServletRequest)));
        }

        throw throwable;
    }

    public PortletURL getSelectFolderURL(HttpServletRequest httpServletRequest, long repositoryId, long rootFolderId) throws PortalException {
        ThemeDisplay _themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ItemSelector itemSelector =
                (ItemSelector) httpServletRequest.getAttribute(
                        ItemSelector.class.getName());

        FolderItemSelectorCriterion folderItemSelectorCriterion = getFolderItemSelectorCriterion(repositoryId, rootFolderId);

        PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();

        long groupId = repositoryId;

        Repository repository = repositoryLocalService.fetchRepository(
                repositoryId);

        if (repository != null) {
            groupId = repository.getGroupId();
        }

        return itemSelector.getItemSelectorURL(
                RequestBackedPortletURLFactoryUtil.create(httpServletRequest),
                groupLocalService.getGroup(
                        GetterUtil.getLong(groupId, _themeDisplay.getScopeGroupId())),
                _themeDisplay.getScopeGroupId(),
                portletDisplay.getNamespace() + DocumentAPIConstants.URL_IDENTIFIER_FOLDER,
                folderItemSelectorCriterion);
    }

    private static FolderItemSelectorCriterion getFolderItemSelectorCriterion(long repositoryId, long rootFolderId) {
        FolderItemSelectorCriterion folderItemSelectorCriterion =
                new FolderItemSelectorCriterion();

        folderItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new FolderItemSelectorReturnType());
        folderItemSelectorCriterion.setFolderId(rootFolderId);
        folderItemSelectorCriterion.setIgnoreRootFolder(true);
        folderItemSelectorCriterion.setRepositoryId(repositoryId);
        folderItemSelectorCriterion.setSelectedFolderId(rootFolderId);
        folderItemSelectorCriterion.setSelectedRepositoryId(
                repositoryId);
        folderItemSelectorCriterion.setShowGroupSelector(true);
        folderItemSelectorCriterion.setShowMountFolder(false);
        return folderItemSelectorCriterion;
    }

    public PortletURL getSelectPageURL(ItemSelector itemSelector, RenderRequest renderRequest, RenderResponse renderResponse) {

        ItemSelectorCriterion itemSelectorCriterion =
                new LayoutItemSelectorCriterion();

        itemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new UUIDItemSelectorReturnType());

        return itemSelector.getItemSelectorURL(
                RequestBackedPortletURLFactoryUtil.create(renderRequest),
                renderResponse.getNamespace() + DocumentAPIConstants.URL_IDENTIFIER_LAYOUT,
                itemSelectorCriterion);


    }

    public String getDLFolderTree(Long folderId) {
        DLFolder dlFolder = dlFolderLocalService.fetchDLFolder(folderId);

        StringBuilder stringPath = new StringBuilder();
        String folderTree = dlFolder.getTreePath();
        List<Number> folders = getParentFolderIdsFromTreePath(folderTree);
        Iterator<Number> folderItr = folders.iterator();
        while (folderItr.hasNext()) {
            Long id = (Long) folderItr.next();
            if (id > 0) stringPath.append(dlFolderLocalService.fetchDLFolder(id).getName());
            if (id > 0 && folderItr.hasNext()) stringPath.append(StringPool.FORWARD_SLASH);
        }

        return stringPath.toString();
    }

    public List<Number> getParentFolderIdsFromTreePath(String treePath) {

        String[] folderIds = treePath.split(StringPool.FORWARD_SLASH);
        return Arrays.stream(folderIds).mapToLong(id -> {
            if (!id.equalsIgnoreCase(StringPool.BLANK)) return Long.parseLong(id);
            return 0;
        }).boxed().collect(Collectors.toList());
    }

    public void queueBackgroundTask(ActionRequest actionRequest, long userId, long groupId) throws PortalException {
        Map<String, Serializable> taskContextMap = new HashMap<>();

        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+ "Queueing auto map task.");
        String taskName = DocumentAPIConstants.FOLDER_BREADCRUMB_MAPPING_BACKGROUND_TASK_NAME;

        BackgroundTaskManagerUtil.addBackgroundTask(
                userId, groupId, taskName,
                DocumentAPIConstants.BACKGROUND_TASK_EXECUTOR_CLASS_NAME,
                taskContextMap, ServiceContextFactory.getInstance(actionRequest));
    }

    public Map<String ,Serializable> getAddEditAuditMap(long userId, ObjectEntry objectEntry, ObjectEntry objectEntryNew, Map<String, Serializable> auditMap, Exception throwable){
        Map<String ,Serializable> map = Validator.isNotNull(objectEntry)? objectEntry.getValues(): auditMap;
        Map<String ,Serializable> newMap = Validator.isNotNull(objectEntryNew)? objectEntryNew.getValues(): auditMap;
        auditMap.put(DocumentAPIConstants.KEY_USER_DETAILS, userId);
        auditMap.put(DocumentAPIConstants.KEY_ADDITIONAL_INFORMATION, Validator.isNotNull(throwable) ? throwable.getMessage() : DocumentAPIConstants.KEY_NOT_APPLICABLE);
        auditMap.put(DocumentAPIConstants.KEY_PREVIOUS_FOLDER_ID, Validator.isNotNull(objectEntry) ? map.get(DocumentAPIConstants.KEY_FOLDER_ID) : 0L);
        auditMap.put(DocumentAPIConstants.KEY_CURRENT_FOLDER_ID, Validator.isNotNull(objectEntryNew) ? newMap.get(DocumentAPIConstants.KEY_FOLDER_ID) : 0L);
        auditMap.put(DocumentAPIConstants.KEY_PREVIOUS_STATUS, Validator.isNotNull(objectEntry) ? ((Boolean) map.get(DocumentAPIConstants.KEY_ACTIVE) ? DocumentAPIConstants.KEY_ENABLED : DocumentAPIConstants.KEY_DISABLED) : DocumentAPIConstants.KEY_NOT_APPLICABLE);
        auditMap.put(DocumentAPIConstants.KEY_CURRENT_STATUS, Validator.isNotNull(objectEntryNew) ? ((Boolean) newMap.get(DocumentAPIConstants.KEY_ACTIVE) ? DocumentAPIConstants.KEY_ENABLED : DocumentAPIConstants.KEY_DISABLED) : DocumentAPIConstants.KEY_NOT_APPLICABLE);
        auditMap.put(DocumentAPIConstants.KEY_RELATIONSHIP_BREADCRUMBFOLDER_ADD_EDIT, Validator.isNotNull(objectEntryNew) ? objectEntryNew.getObjectEntryId() : 0L);
        auditMap.put(DocumentAPIConstants.KEY_ACTION_DATE, new Date());

        return auditMap;
    }


    @Reference
    private DocumentResource.Factory docResourceFactory;
    @Reference
    private ObjectDefinitionLocalService objectDefinitionLocalService;
    @Reference
    private GroupLocalService groupLocalService;
    @Reference
    private RepositoryLocalService repositoryLocalService;
    @Reference
    private DLAppLocalService dlAppLocalService;
    @Reference
    private DLFolderLocalService dlFolderLocalService;
    @Reference
    private ObjectEntryLocalService objectEntryLocalService;
    @Reference
    private MessageBus messageBus;
}
