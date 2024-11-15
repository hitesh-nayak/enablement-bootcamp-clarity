package com.clsa.staffconnect.breadcrumb.folder.mapping.web.application.list;

import com.clsa.staffconnect.breadcrumb.folder.mapping.web.constants.BreadcrumbFolderMappingPanelCategoryKeys;
import com.clsa.staffconnect.breadcrumb.folder.mapping.web.constants.BreadcrumbFolderMappingPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author me
 */
@Component(
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + BreadcrumbFolderMappingPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class BreadcrumbFolderMappingPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Reference(target = "(javax.portlet.name=" + BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING + ")")
	private Portlet _portlet;

}