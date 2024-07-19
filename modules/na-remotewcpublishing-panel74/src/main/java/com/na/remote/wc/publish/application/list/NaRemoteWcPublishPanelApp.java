package com.na.remote.wc.publish.application.list;

import com.na.remote.wc.publish.constants.NaRemoteWcPublishPanelCategoryKeys;
import com.na.remote.wc.publish.constants.NaRemoteWcPublishPortletKeys;

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
		"panel.category.key=" + NaRemoteWcPublishPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class NaRemoteWcPublishPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return NaRemoteWcPublishPortletKeys.NAREMOTEWCPUBLISH;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Reference(target = "(javax.portlet.name=" + NaRemoteWcPublishPortletKeys.NAREMOTEWCPUBLISH + ")")
	private Portlet _portlet;

}