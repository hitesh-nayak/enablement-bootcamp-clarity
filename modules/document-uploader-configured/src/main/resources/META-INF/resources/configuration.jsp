<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.liferay.page.document.uploader.util.DocumentUploaderUtil" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>

<portlet:defineObjects/>

<%
    Map<Long, String> treeMap = DocumentUploaderUtil.getDLFolderTrees(DLFolderLocalServiceUtil.getDLFolders(QueryUtil.ALL_POS,QueryUtil.ALL_POS));
    Set<Long> treeSet = treeMap.keySet();
    Iterator<Long> treeSetItr = treeSet.iterator();
%>


<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL"/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>

    <liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL"/>

    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>"/>

    <aui:fieldset>
        <aui:select label="FolderId" name="folderId" value='<%= (String)portletPreferences.getValue("folderId", "0") %>'>
            <%while (treeSetItr.hasNext()) {
                Long folderId = treeSetItr.next();
            %>
                <aui:option label="<%=treeMap.get(folderId)%>" value="<%=folderId%>"/>
            <%}%>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"/>
    </aui:button-row>
</aui:form>