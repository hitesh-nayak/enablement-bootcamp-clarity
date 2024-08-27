<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-asset" uri="http://liferay.com/tld/asset" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.page.document.uploader.util.*" %>



<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    DLRequestHelper dlRequestHelper = new DLRequestHelper(request);

    DLAdminDisplayContext dlAdminDisplayContext = (DLAdminDisplayContext) renderRequest.getAttribute("test123");

    DLPortletInstanceSettings dlPortletInstanceSettings = dlRequestHelper.getDLPortletInstanceSettings();

    DLPortletInstanceSettingsHelper dlPortletInstanceSettingsHelper = new DLPortletInstanceSettingsHelper(dlRequestHelper);

%>


