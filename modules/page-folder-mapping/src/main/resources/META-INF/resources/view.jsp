<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFolder" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.clsa.mapping.util.PageFolderMappingUtil" %>

<%@ include file="/init.jsp" %>
<portlet:defineObjects/>

<style>
    .search-box{
        margin: 0 auto;
        box-shadow: 5px 10px 18px 10px rgba(0,0,0,0.1);
    }
</style>

<%
    String searchKeyword = Validator.isNotNull(ParamUtil.getString(renderRequest, "searchKeyword"))?ParamUtil.getString(renderRequest, "searchKeyword"):"";
%>
<liferay-portlet:renderURL var="addEditURL">
    <portlet:param name="mvcPath" value="/addEdit.jsp"/>
    <portlet:param name="addEditValue" value="ADD_MAPPING"/>
    <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/>
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="extractDataURL" name="extractData">
    <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/>
</liferay-portlet:actionURL>


<liferay-portlet:renderURL var="searchURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>

<div style="padding-top: 10px">
    <aui:form action="${searchURL}">
        <div class="container-fluid container-fluid-max-xl">
            <aui:input label="" placeholder="Search for Breadcrumb or Folder Id" name="searchKeyword" type="text" value="<%=searchKeyword%>"></aui:input>
            <aui:button cssClass="search-box" type="submit" value="Search"></aui:button>
<%--            <aui:button cssClass="search-box btn-primary" href="<%=addEditURL%>" name="addMapping" value="Add Mapping"></aui:button>--%>
            <aui:button  cssClass="search-box btn-danger" href="<%=extractDataURL%>" name="extractData" value="Auto Map"></aui:button>
        </div>
    </aui:form>
</div>

<div class="container-fluid container-fluid-max-xl">
    <liferay-ui:search-container searchContainer="<%=(SearchContainer)renderRequest.getAttribute("searchContainer")%>"
                                 delta="2" deltaConfigurable="true">

        <liferay-ui:search-container-row className="com.clsa.mapping.dto.LayoutFolderDTO"
                                         keyProperty="objectERC" modelVar="folderLayoutObj">
            <%
                DLFolder dlFolder = DLFolderLocalServiceUtil.fetchFolder(folderLayoutObj.getFolderId());
                Long repositoryId = Validator.isNotNull(dlFolder) ? dlFolder.getRepositoryId() : 0L;
            %>


            <liferay-ui:search-container-column-text name="Page Breadcrumb" property="layoutBreadCrumb">

            </liferay-ui:search-container-column-text>
            <liferay-ui:search-container-column-text name="Folder Id" property="folderId"/>
            <liferay-ui:search-container-column-text name="Folder Name" value="<%=dlFolder.getName()%>"/>
            <liferay-ui:search-container-column-text name="Folder Path" value="<%=PageFolderMappingUtil.getDLFolderTree(folderLayoutObj.getFolderId())%>"/>

            <liferay-ui:search-container-column-text name="Active">
                <%
                if (folderLayoutObj.isActive()) {
                %>
                <span style="color: green" class="commerce-admin-icon-check">
                <span style="color: green" class="c-inner" tabindex="-1" id="uwrv____">
                    <svg style="color: green" aria-hidden="true" class="lexicon-icon lexicon-icon-check" focusable="false">
                        <use style="color: green" href="/o/admin-theme/images/clay/icons.svg#check"></use>
                    </svg>
                </span>
            </span>
                <%
                } else {
                %>
                <span style="color: red" class="commerce-admin-icon-times">
                    <span style="color: red" class="c-inner" tabindex="-1" id="nayw____">
                        <svg style="color: red" aria-hidden="true" class="lexicon-icon lexicon-icon-times" focusable="false">
                            <use style="color: red" href="/o/admin-theme/images/clay/icons.svg#times">
                            </use>
                        </svg>
                    </span>
                </span>
                <%
                }
                %>
            </liferay-ui:search-container-column-text>

            <liferay-ui:search-container-column-text name="Action">
                <liferay-ui:icon-menu direction="left-side" icon="" markupView="lexicon" message=""
                                      showWhenSingleIcon="<%=true%>">
                    <liferay-portlet:renderURL var="editURL">
                        <portlet:param name="mvcPath" value="/addEdit.jsp"/>
                        <portlet:param name="addEditValue" value="EDIT_MAPPING"/>
                        <portlet:param name="rootFolderId" value="<%=String.valueOf(folderLayoutObj.getFolderId())%>"/>
                        <portlet:param name="repositoryId" value="<%=String.valueOf(repositoryId)%>"/>
                        <portlet:param name="rootFolderName" value="<%=Validator.isNotNull(dlFolder)?dlFolder.getName():"Home"%>"/>
                        <portlet:param name="objectERC" value="<%=folderLayoutObj.getObjectERC()%>"/>
                        <portlet:param name="layoutGroupId" value="<%=String.valueOf(folderLayoutObj.getLayoutGroupId())%>"/>
                        <portlet:param name="layoutPlid" value="<%=String.valueOf(folderLayoutObj.getLayoutPlid())%>"/>
                        <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/>
                    java.lang.String editURL = (java.lang.String) pageContext.getAttribute("editURL");
                    <liferay-ui:icon message="" url=""/>
                    <a href="${editURL}" class="dropdown-item">Edit</a>
                    <%
                    if (folderLayoutObj.isActive()) {
                    %>
                    <portlet:actionURL var="disableBreadcrumbURL" name="enableDisableBreadcrumb">
                        <portlet:param name="enable" value="<%="false"%>"/>
                        <portlet:param name="objectERC" value="<%=folderLayoutObj.getObjectERC()%>"/>
                        <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/>
                        <portlet:param name="searchKeyword" value="<%=searchKeyword%>"/>
                    </portlet:actionURL>
                    <liferay-ui:icon message="" url=""/>
                    <a href="${disableBreadcrumbURL}" class="dropdown-item">Disable</a>
                    <%} else {%>
                    <portlet:actionURL var="enableBreadcrumbURL" name="enableDisableBreadcrumb">
                        <portlet:param name="enable" value="<%="true"%>"/>
                        <portlet:param name="objectERC" value="<%=folderLayoutObj.getObjectERC()%>"/>
                        <portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>"/>
                        <portlet:param name="searchKeyword" value="<%=searchKeyword%>"/>
                    </portlet:actionURL>
                    <liferay-ui:icon message="" url=""/>
                    <a href="${enableBreadcrumbURL}" class="dropdown-item">Enable</a>
                    <%}%>
                </liferay-ui:icon-menu>
            </liferay-ui:search-container-column-text>

        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator
                displayStyle="list"
                markupView="lexicon"
        />

    </liferay-ui:search-container>
</div>

<script>
    $(document).ready(function () {

        $('#<portlet:namespace/>addMapping').removeClass("btn-secondary");
        $('#<portlet:namespace/>extractData').removeClass("btn-secondary");
        $('#<portlet:namespace/>searchKeyword').addClass("search-box");

    });
</script>













