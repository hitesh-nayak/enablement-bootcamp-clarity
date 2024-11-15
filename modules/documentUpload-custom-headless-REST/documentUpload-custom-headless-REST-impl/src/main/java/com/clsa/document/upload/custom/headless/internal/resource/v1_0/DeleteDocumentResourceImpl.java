package com.clsa.document.upload.custom.headless.internal.resource.v1_0;

import com.clsa.document.upload.custom.headless.dto.v1_0.ApiResponse;
import com.clsa.document.upload.custom.headless.resource.v1_0.DeleteDocumentResource;

import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/delete-document.properties",
	scope = ServiceScope.PROTOTYPE, service = DeleteDocumentResource.class
)
public class DeleteDocumentResourceImpl extends BaseDeleteDocumentResourceImpl {


}