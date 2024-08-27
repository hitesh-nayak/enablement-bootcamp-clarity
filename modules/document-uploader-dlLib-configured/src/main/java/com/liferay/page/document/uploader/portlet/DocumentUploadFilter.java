package com.liferay.page.document.uploader.portlet;

import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.page.document.uploader.util.DLAdminDisplayContextProvider;
import com.liferay.page.document.uploader.util.DocumentUploaderUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + "com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet",
                "service.ranking:Integer=200"
        },
        service = PortletFilter.class
)

public class DocumentUploadFilter implements RenderFilter {
    @Override
    public void doFilter(RenderRequest renderRequest, RenderResponse renderResponse, FilterChain filterChain) throws IOException, PortletException {

        renderRequest.setAttribute("test123", dlAdminDisplayContextProvider.getDLAdminDisplayContext(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse)));
        filterChain.doFilter(renderRequest, renderResponse);
    }


    @Override
    public void init(FilterConfig filterConfig) throws PortletException {

    }

    @Override
    public void destroy() {

    }

    @Reference
    private DLAdminDisplayContextProvider dlAdminDisplayContextProvider;
}

