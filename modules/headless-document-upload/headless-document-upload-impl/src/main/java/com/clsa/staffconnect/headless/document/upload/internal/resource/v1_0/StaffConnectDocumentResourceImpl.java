package com.clsa.staffconnect.headless.document.upload.internal.resource.v1_0;

import com.clsa.staffconnect.headless.document.upload.dto.v1_0.SuccessResponse;
import com.clsa.staffconnect.headless.document.upload.resource.v1_0.StaffConnectDocumentResource;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Hitesh Nayak
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/staff-connect-document.properties",
        scope = ServiceScope.PROTOTYPE, service = StaffConnectDocumentResource.class
)
public class StaffConnectDocumentResourceImpl
        extends BaseStaffConnectDocumentResourceImpl {

    @Reference
    private BCFMappingDocumentHelper bcfMappingDocumentHelper;
    private static final Log log = LogFactoryUtil.getLog(StaffConnectDocumentResourceImpl.class);

    @Override
    public SuccessResponse postDocument(MultipartBody multipartBody) throws Exception {
        try {
            return bcfMappingDocumentHelper.processRequest(multipartBody, DocumentAPIConstants.USER_POST_DOCUMENT_REQUEST, contextHttpServletResponse, contextHttpServletRequest);
        } catch (Exception e) {
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage(), e);
            throw e;
        }

    }

    @Override
    public SuccessResponse putDocument(MultipartBody multipartBody) throws Exception {
        try {
            return bcfMappingDocumentHelper.processRequest(multipartBody, DocumentAPIConstants.USER_PUT_DOCUMENT_REQUEST, contextHttpServletResponse, contextHttpServletRequest);
        } catch (Exception e) {
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage(), e);
            throw e;
        }

    }

    @Override
    public SuccessResponse deleteDocument(MultipartBody multipartBody) throws Exception {
        try {
            return bcfMappingDocumentHelper.processRequest(multipartBody, DocumentAPIConstants.USER_DELETE_DOCUMENT_REQUEST, contextHttpServletResponse, contextHttpServletRequest);
        } catch (Exception e) {
            log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getMessage(), e);
            throw e;
        }

    }
}