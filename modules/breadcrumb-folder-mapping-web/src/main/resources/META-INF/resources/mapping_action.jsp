<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

BCFMappingDTO mappingDTO = (BCFMappingDTO)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>

		<portlet:renderURL var="editURL">
			<portlet:param name="mvcRenderCommandName" value="/breadcrump_folder_mapping/edit" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
			<portlet:param name="id" value="<%= String.valueOf(mappingDTO.getId()) %>" />
			<portlet:param name="addEditValue" value="EDIT_MAPPING" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editURL %>"
		/>

		<portlet:actionURL name="/breadcrump_folder_mapping/edit" var="setActiveURL">
			<portlet:param name="<%= Constants.CMD %>" value="setActive" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="active" value="<%= String.valueOf(!mappingDTO.isActive()) %>" />
			<portlet:param name="objectERC" value="<%= mappingDTO.getObjectERC() %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			message='<%= mappingDTO.isActive() ? "deactivate" : "activate" %>'
			url="<%= setActiveURL %>"
		/>

</liferay-ui:icon-menu>