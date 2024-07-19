<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%

String name = ParamUtil.getString(request,"name");
String pin = ParamUtil.getString(request,"pinCode");
String objEntryId = ParamUtil.getString(request,"objEntryId");
String backURL = ParamUtil.getString(request,"backURL");

%>

<portlet:actionURL var="editObjActionURL" name="editObjAction">
        <portlet:param name="backURL" value="<%= backURL %>"/>
</portlet:actionURL>




<aui:form action="<%=editObjActionURL%>" method="post" name="editObjForm"  enctype="multipart/form-data">
    <aui:input name ="objEntryId" type="hidden" value="<%=objEntryId%>"></aui:input>

    <aui:input name ="stateName" type="text" value="<%=name%>"></aui:input>
    <aui:input name="pinCode" type="text" value="<%=pin%>"></aui:input>
    <aui:button name="submitBtn" type="button" value="Submit" onClick="submitEditForm()"></aui:button>
</aui:form>


<script>

function submitEditForm(){

console.log('submitting form')
$("#<portlet:namespace />editObjForm").submit();


}

</script>