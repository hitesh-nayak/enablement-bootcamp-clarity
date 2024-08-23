<%@ include file="/init.jsp" %>


<portlet:actionURL var="uploadPageDocumentConfigURL" name="uploadPageDocumentConfig">
    <portlet:param name="redirectConfigURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</portlet:actionURL>
<portlet:defineObjects />
<%
String folderId = portletPreferences.getValue("folderId", "0");


%>


<aui:form action="<%=uploadPageDocumentConfigURL%>"  validateOnBlur="true" method="post" name="uploadPageConfigDocumentForm" enctype="multipart/form-data">
    <aui:input required="true" label="Upload Document" name="uploadPageDocumentConfig" type="file">
        <aui:validator name="required"></aui:validator>
    </aui:input>
    <aui:button name="submitBtn" value="Upload" type="button" onClick="submitEditFormConfig()"></aui:button>
</aui:form>



<script>

    function submitEditFormConfig() {
        console.log('submitting form')
        let form = Liferay.Form.get('<portlet:namespace/>uploadPageConfigDocumentForm').formValidator
        form.validate();
        <%--if(!form.hasErrors()) $("#<portlet:namespace/>uploadPageDocumentForm").submit();--%>
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
        ).then(res => console.log(res));
    }

</script>