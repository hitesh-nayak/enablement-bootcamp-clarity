

package com.clsa.mapping.util;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.kernel.model.DLFileEntryConstants;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.view.count.ViewCountManagerUtil;
import com.liferay.portal.util.PropsValues;

import java.util.*;


public class DLPortletInstanceSettingsHelperCustom {

	public DLPortletInstanceSettingsHelperCustom(DLRequestHelperCustom dlRequestHelperCustom) {
		_dlRequestHelperCustom = dlRequestHelperCustom;
	}

	public List<KeyValuePair> getAvailableDisplayViews() {
		if (_availableDisplayViews == null) {
			_populateDisplayViews();
		}

		return _availableDisplayViews;
	}

	public List<KeyValuePair> getAvailableEntryColumns() {
		if (_availableEntryColumns == null) {
			_populateEntryColumns();
		}

		return _availableEntryColumns;
	}

	public List<KeyValuePair> getAvailableMimeTypes() {
		if (_availableMimeTypes == null) {
			_populateMimeTypes();
		}

		return _availableMimeTypes;
	}

	public List<KeyValuePair> getCurrentDisplayViews() {
		if (_currentDisplayViews == null) {
			_populateDisplayViews();
		}

		return _currentDisplayViews;
	}

	public List<KeyValuePair> getCurrentEntryColumns() {
		if (_currentEntryColumns == null) {
			_populateEntryColumns();
		}

		return _currentEntryColumns;
	}

	public List<KeyValuePair> getCurrentMimeTypes() {
		if (_currentMimeTypes == null) {
			_populateMimeTypes();
		}

		return _currentMimeTypes;
	}

	public String[] getEntryColumns() {
		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		String[] entryColumns = dlPortletInstanceSettingsCustom.getEntryColumns();

		String portletName = _dlRequestHelperCustom.getPortletName();

		if (!isShowActions()) {
			entryColumns = ArrayUtil.remove(entryColumns, "action");
		}
		else if (!portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY) &&
				 !portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN) &&
				 !ArrayUtil.contains(entryColumns, "action")) {

			entryColumns = ArrayUtil.append(entryColumns, "action");
		}

		return entryColumns;
	}

	public boolean isShowActions() {
		String portletName = _dlRequestHelperCustom.getPortletName();
		String portletResource = _dlRequestHelperCustom.getPortletResource();

		if (portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN) ||
			portletName.equals(PortletKeys.MY_WORKFLOW_TASK) ||
			portletResource.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN) ||
			portletResource.equals(PortletKeys.MY_WORKFLOW_TASK)) {

			return true;
		}

		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		return dlPortletInstanceSettingsCustom.isShowActions();
	}

	public boolean isShowSearch() {
		String portletName = _dlRequestHelperCustom.getPortletName();

		if (portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN)) {
			return true;
		}

		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		return dlPortletInstanceSettingsCustom.isShowFoldersSearch();
	}

	public boolean isShowTabs() {
		String portletName = _dlRequestHelperCustom.getPortletName();

		if (portletName.equals(DLPortletKeys.DOCUMENT_LIBRARY_ADMIN)) {
			return true;
		}

		return false;
	}

	private String[] _getAllEntryColumns() {
		String allEntryColumns = "name,description,size,status";

		if (ViewCountManagerUtil.isViewCountEnabled(
				ClassNameLocalServiceUtil.getClassNameId(
					DLFileEntryConstants.getClassName()))) {

			allEntryColumns += ",downloads";
		}

		if (isShowActions()) {
			allEntryColumns += ",action";
		}

		allEntryColumns += ",modified-date,create-date";

		return StringUtil.split(allEntryColumns);
	}

	private void _populateDisplayViews() {
		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		String[] displayViews = dlPortletInstanceSettingsCustom.getDisplayViews();

		_currentDisplayViews = new ArrayList<>();

		for (String displayView : displayViews) {
			_currentDisplayViews.add(
				new KeyValuePair(
					displayView,
					LanguageUtil.get(
						_dlRequestHelperCustom.getLocale(),
						_displayViews.get(displayView))));
		}

		Arrays.sort(displayViews);

		_availableDisplayViews = new ArrayList<>();

		Set<String> allDisplayViews = SetUtil.fromArray(
			PropsValues.DL_DISPLAY_VIEWS);

		for (String displayView : allDisplayViews) {
			if (Arrays.binarySearch(displayViews, displayView) < 0) {
				_availableDisplayViews.add(
					new KeyValuePair(
						displayView,
						LanguageUtil.get(
							_dlRequestHelperCustom.getLocale(),
							_displayViews.get(displayView))));
			}
		}

		_availableDisplayViews = ListUtil.sort(
			_availableDisplayViews, new KeyValuePairComparator(false, true));
	}

	private void _populateEntryColumns() {
		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		String[] entryColumns = dlPortletInstanceSettingsCustom.getEntryColumns();

		_currentEntryColumns = new ArrayList<>();

		for (String entryColumn : entryColumns) {
			if (entryColumn.equals("action") && !isShowActions()) {
				continue;
			}

			_currentEntryColumns.add(
				new KeyValuePair(
					entryColumn,
					LanguageUtil.get(
						_dlRequestHelperCustom.getLocale(), entryColumn)));
		}

		Arrays.sort(entryColumns);

		_availableEntryColumns = new ArrayList<>();

		Set<String> allEntryColumns = SetUtil.fromArray(_getAllEntryColumns());

		for (String entryColumn : allEntryColumns) {
			if (Arrays.binarySearch(entryColumns, entryColumn) < 0) {
				_availableEntryColumns.add(
					new KeyValuePair(
						entryColumn,
						LanguageUtil.get(
							_dlRequestHelperCustom.getLocale(), entryColumn)));
			}
		}

		_availableEntryColumns = ListUtil.sort(
			_availableEntryColumns, new KeyValuePairComparator(false, true));
	}

	private void _populateMimeTypes() {
		DLPortletInstanceSettingsCustom dlPortletInstanceSettingsCustom =
			_dlRequestHelperCustom.getDLPortletInstanceSettings();

		String[] mediaGalleryMimeTypes =
			dlPortletInstanceSettingsCustom.getMimeTypes();

		Arrays.sort(mediaGalleryMimeTypes);

		ThemeDisplay themeDisplay = _dlRequestHelperCustom.getThemeDisplay();

		_currentMimeTypes = new ArrayList<>();

		for (String mimeType : mediaGalleryMimeTypes) {
			_currentMimeTypes.add(
				new KeyValuePair(
					mimeType,
					LanguageUtil.get(themeDisplay.getLocale(), mimeType)));
		}

		_availableMimeTypes = new ArrayList<>();

		Set<String> allMediaGalleryMimeTypes =
			DLUtil.getAllMediaGalleryMimeTypes();

		for (String mimeType : allMediaGalleryMimeTypes) {
			if (Arrays.binarySearch(mediaGalleryMimeTypes, mimeType) < 0) {
				_availableMimeTypes.add(
					new KeyValuePair(
						mimeType,
						LanguageUtil.get(themeDisplay.getLocale(), mimeType)));
			}
		}
	}

	private static final Map<String, String> _displayViews = HashMapBuilder.put(
		"descriptive", "list"
	).put(
		"icon", "cards"
	).put(
		"list", "table"
	).build();

	private List<KeyValuePair> _availableDisplayViews;
	private List<KeyValuePair> _availableEntryColumns;
	private List<KeyValuePair> _availableMimeTypes;
	private List<KeyValuePair> _currentDisplayViews;
	private List<KeyValuePair> _currentEntryColumns;
	private List<KeyValuePair> _currentMimeTypes;
	private final DLRequestHelperCustom _dlRequestHelperCustom;

}