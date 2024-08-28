package com.liferay.page.document.uploader.portlet;

import com.liferay.document.library.configuration.DLConfiguration;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.headless.commerce.core.util.ServiceContextHelper;
import com.liferay.page.document.uploader.constants.DocumentUploaderPortletKeys;
import com.liferay.page.document.uploader.util.DLAdminDisplayContextProvider;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author me
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + DocumentUploaderPortletKeys.DOCUMENTUPLOADER,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class DocumentUploaderPortlet extends MVCPortlet {

    private static final Log log = LogFactoryUtil.getLog(DocumentUploaderPortlet.class.getName());


    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String extensions = "";

        try {
            DLConfiguration dlConfiguration = ConfigurationProviderUtil.getCompanyConfiguration(DLConfiguration.class,themeDisplay.getCompanyId());
            String [] extensionsArray = dlConfiguration.fileExtensions();
            renderRequest.setAttribute("extensions",String.join(",", extensionsArray));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }

        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "uploadPageDocumentConfig")
    public void uploadPageDocumentConfig(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        PortletPreferences preferences = actionRequest.getPreferences();
        String folderId = preferences.getValue("folderId", "0");
        log.info(folderId);
        ServiceContext serviceContext = serviceContextHelper.getServiceContext(themeDisplay.getUser());
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadPortletRequest.getFile("uploadPageDocumentConfig");
        String fileName = uploadPortletRequest.getFileName("uploadPageDocumentConfig");
        String mimeType = URLConnection.guessContentTypeFromName(fileName);
        DLFolder dlFolder = DLFolderLocalServiceUtil.fetchDLFolder(Long.parseLong(folderId));
        long repositoryId = dlFolder.getRepositoryId();


        FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(StringUtil.randomString(20), themeDisplay.getUserId(), repositoryId, Long.parseLong(folderId), fileName, mimeType, fileName, fileName, fileName, null, file, null, null, serviceContext);
        log.info(fileEntry);


        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirectConfigURL"));

    }

    @Reference
    private ServiceContextHelper serviceContextHelper;
    @Reference
    private DLAdminDisplayContextProvider dlAdminDisplayContextProvider;
}

