package com.liferay.page.document.uploader.portlet;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.headless.commerce.core.util.ServiceContextHelper;
import com.liferay.page.document.uploader.constants.DocumentUploaderPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;

/**
 * @author me
 */
@Component(
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=DocumentUploader",
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

    @ProcessAction(name = "uploadPageDocument")
    public void uploadPageDocument(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Layout layout = themeDisplay.getLayout();

        String folderId = (String) layout.getExpandoBridge().getAttribute("FolderId");
        ServiceContext serviceContext = serviceContextHelper.getServiceContext(themeDisplay.getUser());

        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadPortletRequest.getFile("uploadPageDocument");
        String fileName = uploadPortletRequest.getFileName("uploadPageDocument");
        String mimeType = URLConnection.guessContentTypeFromName(fileName);
        DLFolder dlFolder = DLFolderLocalServiceUtil.fetchDLFolder(Long.parseLong(folderId));
        long repositoryId = dlFolder.getRepositoryId();


       FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(StringUtil.randomString(20),themeDisplay.getUserId(),repositoryId,Long.parseLong(folderId),fileName,mimeType,fileName,fileName,fileName,null,file,null,null,serviceContext);

        log.info(fileEntry);
        log.info(themeDisplay.getLayout());
        log.info(themeDisplay.getScopeLayout());

        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirectURL"));

    }

    @Reference
    private ServiceContextHelper serviceContextHelper;
}

