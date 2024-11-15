package com.clsa.document.upload.custom.headless.internal.resource.v1_0;

import com.clsa.document.upload.custom.headless.dto.v1_0.ApiResponse;
import com.clsa.document.upload.custom.headless.resource.v1_0.UploadDocumentResource;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;

import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;

import com.liferay.object.exception.NoSuchObjectEntryException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.rest.manager.v1_0.ObjectEntryManager;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;

import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;


import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Map;

/**
 * @author Hitesh Nayak
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/upload-document.properties",
        scope = ServiceScope.PROTOTYPE, service = UploadDocumentResource.class
)
public class UploadDocumentResourceImpl extends BaseUploadDocumentResourceImpl {

    private static final Log log = LogFactoryUtil.getLog(UploadDocumentResourceImpl.class);
    private static final String USER_POST_DOCUMENT_REQUEST = "USER_POST_DOCUMENT_REQUEST";

    @Override
    public ApiResponse postUploadDocument(MultipartBody multipartBody) throws Exception {

        String auditObjectUUID = StringUtil.randomString(30);
        ObjectDefinition objectDefinitionAudit = ObjectDefinitionLocalServiceUtil.fetchObjectDefinitionByUuidAndCompanyId("DocumentAPIAudit", documentAPIUtil.getCompanyId(contextHttpServletRequest));

        Map<String, Serializable> auditMap = documentAPIUtil.getInitialAuditmap(contextHttpServletRequest, USER_POST_DOCUMENT_REQUEST);

        ObjectEntry audit = documentAPIUtil.addOrUpdateAuditEntry(auditObjectUUID, Long.parseLong(contextHttpServletRequest.getRemoteUser()), 0L, objectDefinitionAudit.getObjectDefinitionId(), auditMap, ServiceContextFactory.getInstance(contextHttpServletRequest));
        auditMap = audit.getValues();

        Exception throwable = null;
        try {
            if (Validator.isNotNull(multipartBody.getBinaryFile("file"))) {
                auditMap.put("fileName", multipartBody.getBinaryFile("file").getFileName());
                auditMap.put("fileSize", multipartBody.getBinaryFile("file").getSize());
            }
            if (Validator.isNotNull(multipartBody.getValueAsString("breadcrumb")))
                auditMap.put("additionalInformation", multipartBody.getValueAsString("breadcrumb"));

            ApiResponse apiResponse = new ApiResponse();
            String breadCrumb = multipartBody.getValueAsString("breadcrumb");
            ObjectEntry objectEntry = null;
            try {
                objectEntry = ObjectEntryLocalServiceUtil.getObjectEntryByUuidAndGroupId(breadCrumb, 0L);
            } catch (NoSuchObjectEntryException e) {
                log.error(e.getMessage());
            }
            if (Validator.isNull(objectEntry)) {

                auditMap.put("statusCode", HttpServletResponse.SC_NOT_FOUND);
                auditMap.put("responseMessage", "No folder exists for the provided breadcrumb path.");
                audit.setValues(auditMap);
                throw new NoSuchFolderException("No folder exists for the provided breadcrumb path.");
            }
            auditMap.put("r_mappingAPI_c_breadcrumbFolderId", objectEntry.getObjectEntryId());


            Map<String, Serializable> mp = objectEntry.getValues();
            Long dlFolderId = (Long) mp.get("folderId");
            Boolean enabled = (Boolean) mp.get("active");

            if (!enabled) {
                auditMap.put("statusCode", HttpServletResponse.SC_NOT_FOUND);
                auditMap.put("responseMessage", "No folder exists for the provided breadcrumb path (Breadcrumb path is disabled for receiving documents.");
                audit.setValues(auditMap);
                throw new NoSuchFolderException("No folder exists for the provided breadcrumb path.");
            }

            DLFolder dlFolder = DLFolderLocalServiceUtil.fetchDLFolder(dlFolderId);

            if (Validator.isNull(dlFolder)) {
                auditMap.put("statusCode", HttpServletResponse.SC_NOT_FOUND);
                auditMap.put("responseMessage", "No folder exists for the provided breadcrumb path.");
                audit.setValues(auditMap);
                throw new NoSuchFolderException("No folder exists for the provided breadcrumb path.");
            }


            ThemeDisplay themeDisplay = documentAPIUtil.initializeThemeDisplay(dlFolder.getGroupId(), contextHttpServletRequest, contextHttpServletResponse);

            try {
                documentAPIUtil.getDocumentResource(themeDisplay).postDocumentFolderDocument(dlFolderId, multipartBody);

                ObjectEntryManager objectEntryManager = null;


                apiResponse.setStatus("Document was successfully uploaded.");
                auditMap.put("statusCode", HttpServletResponse.SC_OK);
                auditMap.put("responseMessage", "Document was successfully uploaded.");
                audit.setValues(auditMap);
                return apiResponse;
            } catch (Exception e) {
                log.error(e.getMessage());
                throwable = e;
                if (e instanceof PrincipalException.MustHavePermission) {
                    auditMap.put("statusCode", HttpServletResponse.SC_FORBIDDEN);
                    auditMap.put("responseMessage", e.getMessage());
                } else if (e instanceof DuplicateFileEntryException) {
                    auditMap.put("statusCode", HttpServletResponse.SC_CONFLICT);
                    auditMap.put("responseMessage", e.getMessage());
                } else if (e instanceof FileExtensionException) {
                    auditMap.put("statusCode", HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                    auditMap.put("responseMessage", e.getMessage());
                } else {
                    auditMap.put("statusCode", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    auditMap.put("responseMessage", e.getMessage());
                }
                audit.setValues(auditMap);
            }
        } catch (Exception e) {
            throwable = e;
            log.error(e.getMessage());
        } finally {
            log.info("Finally executing audit update -> AuditObject to update -> " + audit + "-> AuditObjectValues ->" + auditMap);
            documentAPIUtil.addOrUpdateAuditEntry(auditObjectUUID, Long.parseLong(contextHttpServletRequest.getRemoteUser()), 0L, objectDefinitionAudit.getObjectDefinitionId(), auditMap, ServiceContextFactory.getInstance(contextHttpServletRequest));
        }

        throw throwable;

    }

    @Reference
    private DocumentAPIUtil documentAPIUtil;
}