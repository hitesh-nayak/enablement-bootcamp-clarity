<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/frontend-data-set" prefix="frontend-data-set" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFolder" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.petra.portlet.url.builder.PortletURLBuilder"%>
<%@page import="com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context.BCFMappingManagementToolbarDisplayContext"%>
<%@page import="com.clsa.staffconnect.breadcrumb.folder.mapping.web.internal.display.context.BCFMappingDisplayContext"%>
<%@page import="com.clsa.staffconnect.breadcrumb.folder.mapping.web.dto.BCFMappingDTO"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="com.liferay.portal.kernel.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>
<%@ page import="com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants" %>
<%@ page import="com.clsa.staffconnect.headless.document.upload.util.BCFMappingDocumentHelper" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
    BCFMappingDisplayContext mappingDisplayContext = (BCFMappingDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>