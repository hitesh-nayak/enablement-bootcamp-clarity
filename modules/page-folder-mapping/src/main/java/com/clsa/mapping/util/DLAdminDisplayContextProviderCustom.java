
package com.clsa.mapping.util;

import com.liferay.asset.auto.tagger.configuration.AssetAutoTaggerConfiguration;
import com.liferay.asset.auto.tagger.configuration.AssetAutoTaggerConfigurationFactory;
import com.liferay.document.library.kernel.versioning.VersioningStrategy;
import com.liferay.item.selector.ItemSelector;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.trash.TrashHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component(service = DLAdminDisplayContextProviderCustom.class)
public class DLAdminDisplayContextProviderCustom {

	public DLAdminDisplayContextCustom getDLAdminDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		httpServletRequest.setAttribute(
			ItemSelector.class.getName(), _itemSelector);

		DLRequestHelperCustom dlRequestHelperCustom = new DLRequestHelperCustom(
			httpServletRequest);

        return new DLAdminDisplayContextCustom(
				_getAssetAutoTaggerConfiguration(dlRequestHelperCustom),
				httpServletRequest, dlRequestHelperCustom.getLiferayPortletRequest(),
				dlRequestHelperCustom.getLiferayPortletResponse(), _versioningStrategy,
				_trashHelper);
	}

	public DLAdminManagementToolbarDisplayContextCustom
		getDLAdminManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			DLAdminDisplayContextCustom dlAdminDisplayContextCustom) {

		DLRequestHelperCustom dlRequestHelperCustom = new DLRequestHelperCustom(
			httpServletRequest);

		return new DLAdminManagementToolbarDisplayContextCustom(
			httpServletRequest, dlRequestHelperCustom.getLiferayPortletRequest(),
			dlRequestHelperCustom.getLiferayPortletResponse(), dlAdminDisplayContextCustom,
				_dlTrashHelperCustom);
	}

	private AssetAutoTaggerConfiguration _getAssetAutoTaggerConfiguration(
		DLRequestHelperCustom dlRequestHelperCustom) {

		try {
			return _assetAutoTaggerConfigurationFactory.
				getGroupAssetAutoTaggerConfiguration(
					_groupLocalService.getGroup(
						dlRequestHelperCustom.getSiteGroupId()));
		}
		catch (PortalException portalException) {
			return ReflectionUtil.throwException(portalException);
		}
	}

	@Reference
	private AssetAutoTaggerConfigurationFactory
		_assetAutoTaggerConfigurationFactory;

	@Reference
	private DLTrashHelperCustom _dlTrashHelperCustom;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private ItemSelector _itemSelector;

	@Reference
	private TrashHelper _trashHelper;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile VersioningStrategy _versioningStrategy;

}