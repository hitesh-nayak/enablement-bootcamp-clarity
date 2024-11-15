package com.clsa.staffconnect.breadcrumb.folder.mapping.web.portlet;

import com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration.DocumentManagementConfiguration;
import com.clsa.staffconnect.breadcrumb.folder.mapping.web.constants.BreadcrumbFolderMappingPortletKeys;
import com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context.BCFMappingDisplayContext;
import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Hitesh Nayak
 */
@Component(
		configurationPid = "com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration.DocumentManagementConfiguration",
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=BreadcrumbFolderMapping",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + BreadcrumbFolderMappingPortletKeys.BREADCRUMBFOLDERMAPPING,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",

        },
        service = Portlet.class
)
public class BreadcrumbFolderMappingPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			boolean autoMapEnabled = _documentManagementConfiguration.enableAutoMapping();
			log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+" Auto map is enabled:"+autoMapEnabled);
			renderRequest.setAttribute("autoMapEnabled", autoMapEnabled);

			BCFMappingDisplayContext bcfmDisplayContext = new BCFMappingDisplayContext(renderRequest, renderResponse,
					objectEntryLocalService, objectDefinitionLocalService, _portal, layoutLocalService,bcfMappingDocumentHelper,dlFolderLocalService,groupLocalService);

			renderRequest.setAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT, bcfmDisplayContext);
		} catch (Exception e) {
			log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN+ e.getMessage(), e);
		}

		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {

		_documentManagementConfiguration = ConfigurableUtil.createConfigurable(DocumentManagementConfiguration.class, properties);
	}
	private volatile DocumentManagementConfiguration _documentManagementConfiguration;

	@Reference
	private Portal _portal;

	@Reference
	private ObjectDefinitionLocalService objectDefinitionLocalService;
	@Reference
	private LayoutLocalService layoutLocalService;
	@Reference
	private ObjectEntryLocalService objectEntryLocalService;
	@Reference
	private DLFolderLocalService dlFolderLocalService;
	@Reference
	private GroupLocalService groupLocalService;
	@Reference
	private BCFMappingDocumentHelper bcfMappingDocumentHelper;
	private static final Log log = LogFactoryUtil.getLog(BreadcrumbFolderMappingPortlet.class);
}