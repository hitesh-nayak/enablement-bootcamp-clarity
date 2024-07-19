
<%@page import="org.json.JSONObject"%>
<%@ include file="init.jsp"%>

<%@ page import="java.util.List"%>

<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>

<p>
	<b><liferay-ui:message key="remotewebcontent.caption" /></b>
</p>


<portlet:resourceURL id="/serve/webcontentjson" var="jsonURL" />

<portlet:actionURL name="apiCall" var="apiCallActionURL" />

<div>
	<aui:form action="<%=apiCallActionURL%>" name="apiForm" method="POST">


		<aui:input name="articleTitle">
			<aui:validator name="required" />
			<aui:validator name="string" />
		</aui:input>



		<aui:button type="submit" name="" value="Submit"></aui:button>
		
	</aui:form>

	
</div>




