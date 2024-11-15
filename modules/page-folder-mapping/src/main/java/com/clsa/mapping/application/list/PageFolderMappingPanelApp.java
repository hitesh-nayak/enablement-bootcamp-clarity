package com.clsa.mapping.application.list;

import com.clsa.mapping.constants.PageFolderMappingPanelCategoryKeys;
import com.clsa.mapping.constants.PageFolderMappingPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Hitesh Nayak
 */
@Component(
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PageFolderMappingPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class PageFolderMappingPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PageFolderMappingPortletKeys.PAGEFOLDERMAPPING;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Reference(target = "(javax.portlet.name=" + PageFolderMappingPortletKeys.PAGEFOLDERMAPPING + ")")
	private Portlet _portlet;

}