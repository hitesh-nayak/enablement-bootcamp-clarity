package com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Krishna Rajappa
 */
public class BCFMappingManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

	public BCFMappingManagementToolbarDisplayContext(HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse,
			SearchContainer<?> searchContainer) {
		super(httpServletRequest, liferayPortletRequest, liferayPortletResponse, searchContainer);

	}

	@Override
	public String getClearResultsURL() {
		return PortletURLBuilder.create(getPortletURL()).setKeywords(StringPool.BLANK).buildString();
	}

	@Override
	public CreationMenu getCreationMenu() {

	return 	CreationMenuBuilder.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(liferayPortletResponse.createRenderURL(), "mvcRenderCommandName",
					"/breadcrump_folder_mapping/edit", "addEditValue", "ADD_MAPPING", "redirect",
					currentURLObj.toString(), Constants.CMD,Constants.ADD);
			dropdownItem.setLabel(LanguageUtil.get(httpServletRequest, "add-mapping"));
		}).addDropdownItem(dropdownItem -> {
			dropdownItem.setHref("javascript:autoMapWarn();");
			dropdownItem.setLabel(LanguageUtil.get(httpServletRequest, "auto-mapping"));
		}).build();


	}

	@Override
	public String getComponentId() {
		return "bcfMappingsManagementToolbar";
	}

	@Override
	public String getSearchContainerId() {
		return "bcfMappings";
	}

	@Override
	public Boolean isShowSearch() {
		return true;
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

	@Override
	public String getSearchActionURL() {
		return PortletURLBuilder.create(getPortletURL()).buildString();
	}

}
