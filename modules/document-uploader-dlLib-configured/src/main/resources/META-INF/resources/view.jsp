<%@ include file="/init.jsp" %>


<portlet:actionURL var="uploadPageDocumentConfigURL" name="uploadPageDocumentConfig">
    <portlet:param name="redirectConfigURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</portlet:actionURL>
<portlet:defineObjects />
<%
    String folderId = portletPreferences.getValue("folderId", "0");
    String extensions = (String) renderRequest.getAttribute("extensions");
%>


<div class="alert alert-warning <%= "hide" %>" id="<portlet:namespace />accessForbidden">
    <liferay-ui:message key="user-access-forbidden-to-folder" />
</div>
<div class="alert alert-warning <%= "hide" %>" id="<portlet:namespace />conflictFile">
    <liferay-ui:message key="conflicted-file-name" />
</div>
<div class="mb-3 alert alert-dismissible alert-success <%= "hide" %>" id="<portlet:namespace />fileUploadedSuccessfully">
    <liferay-ui:message key="file-uploaded-successfully-to-folder" />
</div>
<aui:form action="<%=uploadPageDocumentConfigURL%>"  validateOnBlur="true" method="post" name="uploadPageConfigDocumentForm" enctype="multipart/form-data">
    <aui:input required="true" label="Upload Document" name="uploadPageDocumentConfig" type="file">
        <aui:validator name="required"></aui:validator>
        <aui:validator name="acceptFiles">'<%=extensions%>'</aui:validator>
    </aui:input>
    <aui:button name="submitBtn" value="Upload" type="button" onClick="submitEditFormConfig()"></aui:button>
</aui:form>



<script>

    function submitEditFormConfig() {
        console.debug('uploadingFile')
        let form = Liferay.Form.get('<portlet:namespace/>uploadPageConfigDocumentForm').formValidator
        form.validate();

        //Document upload through processAction method
        <%--if(!form.hasErrors()) $("#<portlet:namespace/>uploadPageDocumentForm").submit();--%>

        //Document upload through headless-delivery api
        if(!form.hasErrors()) callFetchApiConfig();
    }

    function callFetchApiConfig(){
        let body = new FormData();
        let file = $('#<portlet:namespace/>uploadPageDocumentConfig').prop('files')[0];
        body.append('file',file);
        Liferay.Util.fetch(
            `/o/headless-delivery/v1.0/document-folders/<%=folderId%>/documents`,
            {
                method: 'POST',
                body
            }
        ).then(res => {
            if(res.status === 409){
                $('#<portlet:namespace/>fileUploadedSuccessfully').addClass("hide");
                $('#<portlet:namespace/>accessForbidden').addClass("hide");
                $('#<portlet:namespace/>conflictFile').removeClass("hide");
            }
            if(res.status === 403){
                $('#<portlet:namespace/>conflictFile').addClass("hide");
                $('#<portlet:namespace/>fileUploadedSuccessfully').addClass("hide");
                $('#<portlet:namespace/>accessForbidden').removeClass("hide");
            }
            if(res.status === 200){
                $('#<portlet:namespace/>accessForbidden').addClass("hide");
                $('#<portlet:namespace/>conflictFile').addClass("hide");
                $('#<portlet:namespace/>fileUploadedSuccessfully').removeClass("hide");
            }
        })
    }

</script>