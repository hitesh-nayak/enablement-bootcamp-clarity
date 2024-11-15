

package com.clsa.mapping.util;



import com.liferay.portal.kernel.display.context.helper.BaseRequestHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.DLGroupServiceSettings;

import javax.servlet.http.HttpServletRequest;


public class DLRequestHelperCustom extends BaseRequestHelper {

	public DLRequestHelperCustom(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

	public DLGroupServiceSettings getDLGroupServiceSettings() {
		if (_dlGroupServiceSettings != null) {
			return _dlGroupServiceSettings;
		}

		HttpServletRequest httpServletRequest = getRequest();

		_dlGroupServiceSettings =
			(DLGroupServiceSettings)httpServletRequest.getAttribute(
				DLWebKeys.DOCUMENT_LIBRARY_GROUP_SERVICE_SETTINGS);

		if (_dlGroupServiceSettings != null) {
			return _dlGroupServiceSettings;
		}

		String portletResource = getPortletResource();

		try {
			if (Validator.isNotNull(portletResource)) {
				_dlGroupServiceSettings = DLGroupServiceSettings.getInstance(
					getScopeGroupId(), httpServletRequest.getParameterMap());
			}
			else {
				_dlGroupServiceSettings = DLGroupServiceSettings.getInstance(
					getScopeGroupId());
			}
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}

		httpServletRequest.setAttribute(
			DLWebKeys.DOCUMENT_LIBRARY_GROUP_SERVICE_SETTINGS,
			_dlGroupServiceSettings);

		return _dlGroupServiceSettings;
	}

	public DLPortletInstanceSettingsCustom getDLPortletInstanceSettings() {
		if (_dlPortletInstanceSettingsCustom != null) {
			return _dlPortletInstanceSettingsCustom;
		}

		HttpServletRequest httpServletRequest = getRequest();

		_dlPortletInstanceSettingsCustom =
			(DLPortletInstanceSettingsCustom)httpServletRequest.getAttribute(
				DLWebKeys.DOCUMENT_LIBRARY_PORTLET_INSTANCE_SETTINGS);

		if (_dlPortletInstanceSettingsCustom != null) {
			return _dlPortletInstanceSettingsCustom;
		}

		String portletResource = getPortletResource();

		try {
			if (Validator.isNotNull(portletResource)) {
				_dlPortletInstanceSettingsCustom =
					DLPortletInstanceSettingsCustom.getInstance(
						getLayout(), getResourcePortletId(),
						httpServletRequest.getParameterMap());
			}
			else {
				_dlPortletInstanceSettingsCustom =
					DLPortletInstanceSettingsCustom.getInstance(
						getLayout(), getPortletId());
			}
		}
		catch (PortalException portalException) {
			throw new SystemException(portalException);
		}

		httpServletRequest.setAttribute(
			DLWebKeys.DOCUMENT_LIBRARY_PORTLET_INSTANCE_SETTINGS,
				_dlPortletInstanceSettingsCustom);

		return _dlPortletInstanceSettingsCustom;
	}

	private DLGroupServiceSettings _dlGroupServiceSettings;
	private DLPortletInstanceSettingsCustom _dlPortletInstanceSettingsCustom;

}