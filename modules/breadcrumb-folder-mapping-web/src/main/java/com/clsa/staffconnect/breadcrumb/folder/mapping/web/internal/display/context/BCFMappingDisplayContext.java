package com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context;

import com.clsa.staffconnect.breadcrumb.folder.mapping.web.dto.BCFMappingDTO;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Krishna Rajappa
 */
public class BCFMappingDisplayContext {

	public BCFMappingDisplayContext(

			RenderRequest renderRequest, RenderResponse renderResponse, ObjectEntryLocalService objectEntryLocalService,
			ObjectDefinitionLocalService objectDefinitionLocalService, Portal portal,
			LayoutLocalService layoutLocalService, BCFMappingDocumentHelper bcfMappingDocumentHelper, DLFolderLocalService dlFolderLocalService,GroupLocalService groupLocalService) {

		this.renderRequest = renderRequest;
		this.renderResponse = renderResponse;
		this._layoutLocalService = layoutLocalService;
		this._objectEntryLocalService = objectEntryLocalService;
		this._objectDefinitionLocalService = objectDefinitionLocalService;
		this._bcfMappingDocumentHelper = bcfMappingDocumentHelper;
		this.dlFolderLocalService = dlFolderLocalService;
		this._groupLocalService = groupLocalService;
		_bcfRequestHelper = new BCFMappingRequestHelper(portal.getHttpServletRequest(renderRequest));

	}

	public PortletURL getPortletURL() throws PortalException {
		PortletURL portletURL = renderResponse.createRenderURL();
		String delta = ParamUtil.getString(renderRequest, "delta");

		if (Validator.isNotNull(delta)) {
			portletURL.setParameter("delta", delta);
		}
		return portletURL;
	}

	public RowChecker getRowChecker() {
		if (_rowChecker == null) {
			_rowChecker = new EmptyOnClickRowChecker(renderResponse);
		}

		return _rowChecker;
	}

	public SearchContainer<BCFMappingDTO> getSearchContainer() throws PortalException {
		int objectTotal = _objectEntryLocalService.getObjectEntriesCount(0L, _getDefinitionId());

		int delta = ParamUtil.getInteger(renderRequest, "delta",10);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = 0;
		int end = 10;
		if (delta > 0 && cur > 0) {
			start = delta * (cur - 1) >= objectTotal ? (objectTotal-(objectTotal%delta)) : delta * (cur - 1);
			end = Math.min(delta * cur, objectTotal);
		}

		if (searchContainer != null) {
			return searchContainer;
		}

		String emptyResultsMessage = "there-are-no-mappings";

		searchContainer = new SearchContainer<>(renderRequest, getPortletURL(), null, emptyResultsMessage);

		if (Validator.isNotNull(_getKeywords())) {

			BaseModelSearchResult<ObjectEntry> baseModelSearchResult = _objectEntryLocalService.searchObjectEntries(0L,
					_getDefinitionId(), _getKeywords(), start, searchContainer.getDelta());

			List<BCFMappingDTO> folderDTOs = baseModelSearchResult.getBaseModels().stream().map(ObjectEntry::getValues)
					.map(this::mapToBCFMappingDTO).collect(Collectors.toList());
			int total = baseModelSearchResult.getLength();

			searchContainer.setResultsAndTotal(() -> folderDTOs, total);

		} else {

			List<BCFMappingDTO> folderDTOs = _objectEntryLocalService.getObjectEntries(0L, _getDefinitionId(), start, end).stream().map(objEn -> {
			Map<String, Serializable> mp = objEn.getValues();
			return mapToBCFMappingDTO(mp);}).collect(Collectors.toList());

			//int total = _objectEntryLocalService.getValuesListCount(_getDefinitionId(), 0L, null, null, _getKeywords());
			searchContainer.setResultsAndTotal(() -> folderDTOs, objectTotal);
		}

		return searchContainer;

	}

	public BCFMappingDTO mapToBCFMappingDTO(Map<String, Serializable> mp) {
		return Optional.ofNullable(mp).map(entry -> {
			long layoutPlid = getLongValue(entry, DocumentAPIConstants.KEY_LAYOUT_PLID);
			Layout layout = _layoutLocalService.fetchLayout(layoutPlid);

			return new BCFMappingDTO(getLongValue(entry, DocumentAPIConstants.KEY_ID), getStringValue(entry, DocumentAPIConstants.KEY_LAYOUT_BREADCRUMB),
					getLongValue(entry, DocumentAPIConstants.KEY_FOLDER_ID), layoutPlid,
					getStringValue(entry, DocumentAPIConstants.KEY_LAYOUT_BREADCRUMB),
					getBooleanValue(entry, DocumentAPIConstants.KEY_ACTIVE),
					Optional.ofNullable(layout).map(Layout::getGroupId).orElse(0L));
		}).orElseThrow(() -> new IllegalArgumentException("Invalid map entry"));
	}

	public BCFMappingDTO mapToBCFMappingDTO(String id) {
		ObjectEntry objectEntry = _objectEntryLocalService.fetchObjectEntry(Long.parseLong(id));
		if(Validator.isNotNull(objectEntry)) return mapToBCFMappingDTO(objectEntry.getValues());
		return null;
	}

	public String getSiteName(Long plid){
		String siteName = "";
		Layout layout = _layoutLocalService.fetchLayout(plid);
		if(Validator.isNotNull(layout)) {
			Group grp = _groupLocalService.fetchGroup(layout.getGroupId());
			if(Validator.isNotNull(grp)) {
				siteName = grp.getName(_bcfRequestHelper.getThemeDisplay().getLocale(),true);
			}else {
				siteName = "Site Not Found";
			}
		}else{
			siteName = "Page has been deleted";
		}
		return siteName;
	}

	private long getLongValue(Map<String, Serializable> map, String key) {
		return Optional.ofNullable(map.get(key)).map(value -> (Long) value).orElse(0L);
	}

	private String getStringValue(Map<String, Serializable> map, String key) {
		return Optional.ofNullable(map.get(key)).map(Object::toString).orElse("");
	}

	private boolean getBooleanValue(Map<String, Serializable> map, String key) {
		return Optional.ofNullable(map.get(key)).map(value -> (Boolean) value).orElse(false);
	}

	private long _getDefinitionId() {
		if (Validator.isNotNull(_objectDefinitionId)) {
			return _objectDefinitionId;
		}

		_objectDefinitionId = _objectDefinitionLocalService.fetchObjectDefinition(_bcfRequestHelper.getCompanyId(),
				DocumentAPIConstants.OBJECT_NAME_BREADCRUMB_FOLDER).getObjectDefinitionId();

		return _objectDefinitionId;
	}

	private String _getKeywords() {
		if (Validator.isNotNull(_keywords)) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(renderRequest, "keywords");

		return _keywords;
	}

	public boolean hasPermission(String actionId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return PortalPermissionUtil.contains(themeDisplay.getPermissionChecker(), actionId);
	}

	public String getDLFolderTree(long folderId) {
		return _bcfMappingDocumentHelper.getDLFolderTree(folderId);
	}

	public DLFolder getDlFolder(Long folderId) {
		return dlFolderLocalService.fetchDLFolder(folderId);
	}

	public Long getLayoutGroupId(Long plid) {
		return _layoutLocalService.fetchLayout(plid).getGroupId();
	}

	 public PortletURL getSelectFolderURL(HttpServletRequest httpServletRequest, long repositoryId, long rootFolderId)
			throws PortalException{
		return _bcfMappingDocumentHelper.getSelectFolderURL(httpServletRequest, repositoryId, rootFolderId);
	 }

	protected final RenderRequest renderRequest;
	protected final RenderResponse renderResponse;
	private final BCFMappingRequestHelper _bcfRequestHelper;

	private final LayoutLocalService _layoutLocalService;
	private final ObjectEntryLocalService _objectEntryLocalService;
	private final ObjectDefinitionLocalService _objectDefinitionLocalService;
	private final BCFMappingDocumentHelper _bcfMappingDocumentHelper;
	private final DLFolderLocalService dlFolderLocalService;
	private final GroupLocalService _groupLocalService;

	protected SearchContainer<BCFMappingDTO> searchContainer;
	private RowChecker _rowChecker;
	private String _keywords;
	private long _objectDefinitionId;

	Log log = LogFactoryUtil.getLog(BCFMappingDisplayContext.class);
}
