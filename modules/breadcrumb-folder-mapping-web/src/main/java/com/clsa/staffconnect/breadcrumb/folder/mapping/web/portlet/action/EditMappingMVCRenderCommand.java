package com.clsa.staffconnect.breadcrumb.folder.mapping.web.portlet.action;

import com.clsa.staffconnect.breadcrumb.folder.mapping.web.constants.BreadcrumbFolderMappingPortletKeys;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.item.selector.ItemSelector;
import com.liferay.object.exception.NoSuchObjectEntryException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Krishna Rajappa
 */
@Component(
        property = {
                "javax.portlet.name=" + BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING,
                "mvc.command.name=/breadcrump_folder_mapping/edit"
        },
        service = MVCRenderCommand.class
)
public class EditMappingMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {

            renderRequest.setAttribute(ItemSelector.class.getName(), itemSelector);
            renderRequest.setAttribute(DocumentAPIConstants.PAGE_SELECTOR_URL, bcfMappingDocumentHelper.getSelectPageURL(itemSelector, renderRequest, renderResponse));

        } catch (Exception exception) {
            if (exception instanceof NoSuchObjectEntryException || exception instanceof PrincipalException) {

                SessionErrors.add(renderRequest, exception.getClass());

                return "/error.jsp";
            }
        }
        return "/edit_mapping.jsp";
    }

    @Reference
    private ItemSelector itemSelector;

    @Reference
    private BCFMappingDocumentHelper bcfMappingDocumentHelper;

}
