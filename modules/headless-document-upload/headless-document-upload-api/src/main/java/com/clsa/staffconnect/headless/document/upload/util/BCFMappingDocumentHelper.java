package com.clsa.staffconnect.headless.document.upload.util;

import com.clsa.staffconnect.headless.document.upload.dto.v1_0.SuccessResponse;
import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.item.selector.ItemSelector;
import com.liferay.object.exception.NoSuchObjectDefinitionException;
import com.liferay.object.exception.NoSuchObjectEntryException;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import org.osgi.annotation.versioning.ProviderType;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@ProviderType
public interface BCFMappingDocumentHelper {

	ThemeDisplay initializeThemeDisplay(long groupId, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception;

	DocumentResource getDocumentResource(ThemeDisplay themeDisplay);

	void messageAuditDetails(Message message);

	Message getMessage(String objectEntryUuid, Long userId, Long objectDefinitionId, Map<String, Serializable> auditMap,
			ServiceContext serviceContext);

	Map<String, Serializable> getInitialAuditmap(HttpServletRequest contextHttpServletRequest, String userAction);

	ObjectDefinition getObjectDefinitionByName(String objectDefinitionName) throws NoSuchObjectDefinitionException;
	ObjectEntry getObjectEntryByERC(String objectERC) throws NoSuchObjectEntryException;

	SuccessResponse processRequest(MultipartBody multipartBody, String methodType,
			HttpServletResponse contextHttpServletResponse, HttpServletRequest contextHttpServletRequest)
			throws Exception;

	PortletURL getSelectFolderURL(HttpServletRequest httpServletRequest, long repositoryId, long rootFolderId)
			throws PortalException;

	PortletURL getSelectPageURL(ItemSelector itemSelector, RenderRequest renderRequest, RenderResponse renderResponse);

	String getDLFolderTree(Long folderId);

	List<Number> getParentFolderIdsFromTreePath(String treePath);

	void queueBackgroundTask(ActionRequest actionRequest, long userId, long groupId) throws PortalException;

	Map<String, Serializable> getAddEditAuditMap(long userId, ObjectEntry objectEntry, ObjectEntry objectEntryNew,
			Map<String, Serializable> auditMap, Exception throwable);
	String getSHA256Hash(String breadcrumb) throws NoSuchAlgorithmException;
}
