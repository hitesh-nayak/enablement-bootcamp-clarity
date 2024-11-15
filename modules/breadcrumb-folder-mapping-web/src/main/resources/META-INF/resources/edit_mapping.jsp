<%@ include file="init.jsp" %>

<%
    String addEditValue = ParamUtil.getString(renderRequest, "addEditValue");
    String id = ParamUtil.getString(renderRequest, "id");
    BCFMappingDTO dto = mappingDisplayContext.mapToBCFMappingDTO(Validator.isNotNull(id)?id:String.valueOf(0L));
    Long rootFolderId = Validator.isNotNull(dto) ? dto.getFolderId() : 0L;
    DLFolder dlFolder = mappingDisplayContext.getDlFolder(Validator.isNotNull(dto)?dto.getFolderId():0L);
    Long repositoryId = Validator.isNotNull(dto)&& Validator.isNotNull(dlFolder) ? dlFolder.getRepositoryId() : themeDisplay.getScopeGroupId();
    String rootFolderName = Validator.isNotNull(dto)&& Validator.isNotNull(dlFolder) ? dlFolder.getName() : "Select";
    String objectERC = Validator.isNotNull(dto) ? dto.getObjectERC() : "Select Page";
    Long layoutPlid = Validator.isNotNull(dto) ? dto.getLayoutPlid() : 0L;
    Long layoutGroupId = layoutPlid>0 ? mappingDisplayContext.getLayoutGroupId(layoutPlid) : 0L;
    Layout layoutSelected = null;
    if (layoutPlid > 0) layoutSelected = LayoutLocalServiceUtil.fetchLayout(layoutPlid);

%>
<liferay-portlet:actionURL var="addEditMappingURL" name="/breadcrump_folder_mapping/edit">
    <portlet:param name="<%= Constants.CMD %>" value="<%=ParamUtil.getString(renderRequest, Constants.CMD)%>" />
    <portlet:param name="addEditFormValue" value="<%=addEditValue%>"/>
</liferay-portlet:actionURL>

<liferay-frontend:edit-form
        action="<%= addEditMappingURL %>"
        method="post"
        name="fm"
        onSubmit='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "saveConfiguration();" %>'
>
    <div class="mb-3 alert alert-warning alert-dismissible hide" id="<portlet:namespace />mustChoosePageAndFolder">
        <liferay-ui:message key="please-select-a-page-and-a-corresponding-folder"/>
    </div>
    <div class="row">
        <div class="col-md-6">
                <%--            <aui:input name="addEditFormValue" type="hidden" value="<%=addEditValue%>"/>--%>
            <aui:input name="layoutPlId" type="hidden"
                       value="<%=Validator.isNotNull(layoutSelected)?layoutSelected.getUuid():"0"%>"/>
            <aui:input name="layoutGroupId" type="hidden" value="<%=layoutGroupId%>"/>
            <aui:input name="layoutId" type="hidden"/>
            <liferay-frontend:edit-form-body>
                <liferay-frontend:fieldset-group>
                    <liferay-frontend:fieldset
                            collapsible="<%= false %>"
                            id="layoutListingPanel"
                            label="Layout Listing"
                    >
                        <div class="form-group">
                            <aui:input label="page" name="rootLayoutName" type="resource" value="<%=objectERC%>"/>
                            <aui:input label="root-layout" name="rootLayoutBreadcrumb" type="hidden"
                                       value="<%=objectERC%>"/>

                            <aui:button name="selectPageButton" value="select"
                                        disabled="<%=addEditValue.equalsIgnoreCase("ADD_MAPPING")?false:true%>"/>
                        </div>
                    </liferay-frontend:fieldset>

                    <script>
                        var selectRoleButton = document.getElementById('<portlet:namespace />selectPageButton');

                        selectRoleButton.addEventListener('click', function (event) {
                                Liferay.Util.openSelectionModal(
                                    {
                                        onSelect: function (event) {
                                            console.log(event)
                                            let layoutPlId = $('#<portlet:namespace/>layoutPlId');
                                            layoutPlId.val(event.value);
                                            let rootLayoutName = $('#<portlet:namespace/>rootLayoutName');
                                            let breadCrumb = $('#<portlet:namespace/>rootLayoutBreadcrumb');
                                            let layoutId = $('#<portlet:namespace/>layoutId');
                                            let layoutGroupId = $('#<portlet:namespace/>layoutGroupId');
                                            let breadCrumbVal = event.name.replace("Public Pages >", "").trim();
                                            breadCrumb.val(breadCrumbVal);
                                            rootLayoutName.val(breadCrumbVal);
                                            layoutId.val(event.layoutId);
                                            layoutGroupId.val(event.groupId);
                                            return;
                                        },
                                        selectEventName: '<portlet:namespace />selectPage',
                                        title: 'Select Page',
                                        url: '<%= request.getAttribute(DocumentAPIConstants.PAGE_SELECTOR_URL) %>'
                                    }
                                );
                            }
                        );
                    </script>

                </liferay-frontend:fieldset-group>
            </liferay-frontend:edit-form-body>


        </div>

        <div class="col-md-6">


            <aui:input name="folderUploadId" type="hidden" value="<%=rootFolderId%>"/>

            <liferay-frontend:edit-form-body>
                <liferay-frontend:fieldset-group>
                    <aui:input name="preferences--selectedRepositoryId--" type="hidden"
                               value="<%= repositoryId %>"/>
                    <aui:input name="preferences--rootFolderId--" type="hidden"
                               value="<%= rootFolderId %>"/>
                    <liferay-frontend:fieldset
                            collapsible="<%= false %>"
                            id="documentLibraryItemsListingPanel"
                            label="folders-listing"
                    >
                        <div class="form-group">
                            <aui:input label="folder" name="rootFolderName" type="resource"
                                       value="<%= rootFolderName %>"/>


                            <aui:button name="selectFolderButton" value="select"/>
                        </div>
                    </liferay-frontend:fieldset>

                    <script>
                        var selectFolderButton = document.getElementById('<portlet:namespace/>selectFolderButton');

                        if (selectFolderButton) {
                            selectFolderButton.addEventListener('click', (event) => {
                                Liferay.Util.openSelectionModal({
                                    selectEventName: '<portlet:namespace/>folderSelected',
                                    multiple: false,
                                    onSelect: function (selectedItem) {
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
                                        return;
                                    },
                                    title: '<liferay-ui:message arguments="folder" key="select-x"/>',

                                    <%
                                        PortletURL selectFolderURL = mappingDisplayContext.getSelectFolderURL(request,repositoryId,rootFolderId);
                                    %>

                                    url: '<%= HtmlUtil.escapeJS(selectFolderURL.toString()) %>',
                                });
                            });
                        }
                    </script>
                </liferay-frontend:fieldset-group>
            </liferay-frontend:edit-form-body>

        </div>
    </div>


    <liferay-frontend:edit-form-footer>
        <aui:button type="submit"/>
    </liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>


<script>
    function <portlet:namespace />saveConfiguration() {
        $('#<portlet:namespace/>mustChoosePageAndFolder').addClass("hide");
        var form = $('#<portlet:namespace/>fm');
        if (validate()) form.submit();
        else $('#<portlet:namespace/>mustChoosePageAndFolder').removeClass("hide");
    }

    function validate() {
        let layoutPlId = $('#<portlet:namespace/>layoutPlId');
        let folderUpload = $('#<portlet:namespace/>folderUploadId');
        if(layoutPlId.val() =="0" || folderUpload.val() == 0) return false;
        else return true;
    }
</script>

