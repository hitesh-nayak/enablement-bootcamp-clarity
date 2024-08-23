package com.liferay.page.document.uploader.portlet.action;

import com.liferay.page.document.uploader.constants.DocumentUploaderPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;

@Component(
        property = "javax.portlet.name="+ DocumentUploaderPortletKeys.DOCUMENTUPLOADER,
        service = ConfigurationAction.class
)
public class DocumentUploaderConfigurationAction extends DefaultConfigurationAction {

    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
            throws Exception {

        setPreference(
                actionRequest, "folderId",
                ParamUtil.getString(actionRequest, "folderId"));

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

}