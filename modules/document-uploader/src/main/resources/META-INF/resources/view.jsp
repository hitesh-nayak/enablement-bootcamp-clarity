<%@ page import="com.liferay.portal.kernel.model.Layout" %>
<%@ include file="/init.jsp" %>


<portlet:actionURL var="uploadPageDocumentURL" name="uploadPageDocument">
    <portlet:param name="redirectURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</portlet:actionURL>


<%
    String folderId = (String) layout.getExpandoBridge().getAttribute("FolderId");
%>

<aui:form action="<%=uploadPageDocumentURL%>"  validateOnBlur="true" method="post" name="uploadPageDocumentForm" enctype="multipart/form-data">
    <aui:input required="true" label="Upload Document" name="uploadPageDocument" type="file">
        <aui:validator name="required"></aui:validator>
    </aui:input>
    <aui:button name="submitBtn" value="Upload" type="button" onClick="submitEditForm()"></aui:button>
</aui:form>



<script>

    function submitEditForm() {
        console.log('submitting form')
        let form = Liferay.Form.get('<portlet:namespace/>uploadPageDocumentForm').formValidator
        form.validate();
        //if(!form.hasErrors()) $("#<portlet:namespace/>uploadPageDocumentForm").submit();
        if(!form.hasErrors()) callFetchApi();
    }

    function callFetchApi(){
        let body = new FormData();
        let file = $('#<portlet:namespace/>uploadPageDocument').prop('files')[0];
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