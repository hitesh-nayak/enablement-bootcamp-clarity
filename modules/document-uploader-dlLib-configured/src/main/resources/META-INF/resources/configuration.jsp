<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFolderConstants" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ include file="/init.jsp" %>
<portlet:defineObjects/>



<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" >
    <portlet:param name="redirectConfigURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL"/>

<liferay-frontend:edit-form
        action="<%= configurationActionURL %>"
        method="post"
        name="fm"
        onSubmit='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "saveConfiguration();" %>'
>
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>"/>
    <aui:input name="folderUploadId" type="hidden"/>

    <liferay-ui:error key="displayViewsInvalid" message="display-style-views-cannot-be-empty"/>
    <liferay-ui:error key="rootFolderIdInvalid" message="please-enter-a-valid-root-folder"/>

    <liferay-frontend:edit-form-body>
<%--        <liferay-frontend:fieldset-group>--%>
            <aui:input name="preferences--selectedRepositoryId--" type="hidden" value="<%= dlAdminDisplayContext.getSelectedRepositoryId() %>" />
            <aui:input name="preferences--rootFolderId--" type="hidden" value="<%= dlAdminDisplayContext.getRootFolderId() %>" />
            <aui:input name="preferences--displayViews--" type="hidden" />
            <aui:input name="preferences--entryColumns--" type="hidden" />

            <liferay-frontend:fieldset
                    collapsible="<%= true %>"
                    id="documentLibraryItemsListingPanel"
                    label="folders-listing"
            >
                <div class="form-group">
                    <aui:input label="root-folder" name="rootFolderName" type="resource"
                               value="<%= dlAdminDisplayContext.getRootFolderName() %>"/>

                    <div class="alert alert-warning <%= dlAdminDisplayContext.isRootFolderInTrash() ? StringPool.BLANK : "hide" %>" id="<portlet:namespace />rootFolderInTrash">
                        <liferay-ui:message key="the-selected-root-folder-is-in-the-recycle-bin-please-remove-it-or-select-another-one" />
                    </div>

                    <div class="alert alert-warning <%= dlAdminDisplayContext.isRootFolderNotFound() ? StringPool.BLANK : "hide" %>" id="<portlet:namespace />rootFolderNotFound">
                        <liferay-ui:message key="the-selected-root-folder-cannot-be-found-please-select-another-one" />
                    </div>

                    <aui:button name="selectFolderButton" value="select"/>

                    <%
                        String taglibRemoveFolder = "Liferay.Util.removeEntitySelection('rootFolderId', 'rootFolderName', this, '" + liferayPortletResponse.getNamespace() + "'); Liferay.Util.removeEntitySelection('selectedRepositoryId', '', this, '" + liferayPortletResponse.getNamespace() + "');";
                    %>

                    <aui:button
                            disabled="<%= (dlAdminDisplayContext.getRootFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) && (dlAdminDisplayContext.getSelectedRepositoryId() == themeDisplay.getScopeGroupId()) %>"
                            name="removeFolderButton" onClick="<%= taglibRemoveFolder %>" value="remove"/>
                </div>
            </liferay-frontend:fieldset>

            <aui:script sandbox="<%= true %>">
                var selectFolderButton = document.getElementById(
                    '<portlet:namespace/>selectFolderButton'
                );

                if (selectFolderButton) {
                    selectFolderButton.addEventListener('click', (event) => {
                        Liferay.Util.openSelectionModal({
                            selectEventName: '<portlet:namespace/>folderSelected',
                            multiple: false,
                            onSelect: function (selectedItem) {
                                console.log(selectedItem)
                                let folderUpload = $('#<portlet:namespace/>folderUploadId');
                                folderUpload.val(selectedItem.folderid);
                                if (!selectedItem) {
                                    return;
                                }

                                var folderData = {
                                    idString: 'rootFolderId',
                                    idValue: selectedItem.folderid,
                                    nameString: 'rootFolderName',
                                    nameValue: selectedItem.foldername,
                                };

                                Liferay.Util.selectFolder(folderData, '<portlet:namespace/>');

                                var repositoryIdElement = document.querySelector(
                                    '#<portlet:namespace/>selectedRepositoryId'
                                );

                                if (repositoryIdElement != null) {
                                    repositoryIdElement.value = selectedItem.repositoryid;
                                }

                                var rootFolderInTrashWarning = document.querySelector(
                                    '#<portlet:namespace/>rootFolderInTrash'
                                );

                                rootFolderInTrashWarning.classList.add('hide');

                                var rootFolderNotFoundWarning = document.querySelector(
                                    '#<portlet:namespace/>rootFolderNotFound'
                                );

                                rootFolderNotFoundWarning.classList.add('hide');
                            },
                            title: '<liferay-ui:message arguments="folder" key="select-x"/>',

                            <%
                                PortletURL selectFolderURL = dlAdminDisplayContext.getSelectFolderURL(request);
                            %>

                            url: '<%= HtmlUtil.escapeJS(selectFolderURL.toString()) %>',
                        });
                    });
                }
            </aui:script>
<%--        </liferay-frontend:fieldset-group>--%>
    </liferay-frontend:edit-form-body>

    <liferay-frontend:edit-form-footer>
        <aui:button type="submit"/>

        <aui:button type="cancel"/>
    </liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>

<script>
    function <portlet:namespace />saveConfiguration() {
        var form = $('#<portlet:namespace/>fm');
        form.submit();
    }
</script>















