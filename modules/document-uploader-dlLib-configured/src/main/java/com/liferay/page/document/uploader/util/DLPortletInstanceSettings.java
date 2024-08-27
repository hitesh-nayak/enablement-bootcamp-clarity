/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.page.document.uploader.util;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.settings.FallbackKeysSettingsUtil;
import com.liferay.portal.kernel.settings.ParameterMapSettings;
import com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.TypedSettings;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.Map;

/**
 * @author Sergio González
 */
@Settings.Config
public class DLPortletInstanceSettings {

	public static DLPortletInstanceSettings getInstance(
			Layout layout, String portletId)
			throws PortalException {

		Settings settings = FallbackKeysSettingsUtil.getSettings(
				new PortletInstanceSettingsLocator(layout, portletId));

		return new DLPortletInstanceSettings(settings);
	}

	public static DLPortletInstanceSettings getInstance(
			Layout layout, String portletId, Map<String, String[]> parameterMap)
			throws PortalException {

		Settings settings = FallbackKeysSettingsUtil.getSettings(
				new PortletInstanceSettingsLocator(layout, portletId));

		Settings parameterMapSettings = new ParameterMapSettings(
				parameterMap, settings);

		return new DLPortletInstanceSettings(parameterMapSettings);
	}

	public DLPortletInstanceSettings(Settings settings) {
		_typedSettings = new TypedSettings(settings);
	}

	public String[] getDisplayViews() {
		return _typedSettings.getValues("displayViews");
	}

	public int getEntriesPerPage() {
		return _typedSettings.getIntegerValue("entriesPerPage");
	}

	public String[] getEntryColumns() {
		return _typedSettings.getValues("entryColumns");
	}

	public int getFileEntriesPerPage() {
		return _typedSettings.getIntegerValue("fileEntriesPerPage");
	}

	public String[] getFileEntryColumns() {
		return _typedSettings.getValues("fileEntryColumns");
	}

	public String[] getFolderColumns() {
		return _typedSettings.getValues("folderColumns");
	}

	public int getFoldersPerPage() {
		return _typedSettings.getIntegerValue("foldersPerPage");
	}

	public String[] getMimeTypes() {
		return _typedSettings.getValues("mimeTypes", _MIME_TYPES_DEFAULT);
	}

	public long getRootFolderId() {
		return _typedSettings.getLongValue(
				"rootFolderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	}

	public long getSelectedRepositoryId() {
		return _typedSettings.getLongValue("selectedRepositoryId");
	}

	public boolean isEnableCommentRatings() {
		return _typedSettings.getBooleanValue("enableCommentRatings");
	}

	public boolean isEnableFileEntryDrafts() {
		return _typedSettings.getBooleanValue("enableFileEntryDrafts");
	}

	public boolean isEnableRatings() {
		return _typedSettings.getBooleanValue("enableRatings");
	}

	public boolean isEnableRelatedAssets() {
		return _typedSettings.getBooleanValue("enableRelatedAssets");
	}

	public boolean isShowActions() {
		return _typedSettings.getBooleanValue("showActions");
	}

	public boolean isShowFoldersSearch() {
		return _typedSettings.getBooleanValue("showFoldersSearch");
	}

	public boolean isShowSubfolders() {
		return _typedSettings.getBooleanValue("showSubfolders");
	}

	private static final String[] _MIME_TYPES_DEFAULT = ArrayUtil.toStringArray(
			DLUtil.getAllMediaGalleryMimeTypes());

	private final TypedSettings _typedSettings;

}