<%@ include file="init.jsp" %>
<%@ include file="warningPopUp.jsp" %>


<clay:management-toolbar
		managementToolbarDisplayContext="<%= new BCFMappingManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, mappingDisplayContext.getSearchContainer()) %>"
/>

<div class="container-fluid container-fluid-max-xl">

			<liferay-ui:search-container
				id="commerceCountries"
				searchContainer="<%= mappingDisplayContext.getSearchContainer() %>"
			>
				<liferay-ui:search-container-row
					className="com.clsa.staffconnect.breadcrumb.folder.mapping.web.dto.BCFMappingDTO"
					keyProperty="id"
					modelVar="bcfmapping"
				>
					<liferay-ui:search-container-column-text
						cssClass="font-weight-bold important"
						href='<%=
							PortletURLBuilder.createRenderURL(
								renderResponse
							).setMVCRenderCommandName(
								"/breadcrump_folder_mapping/edit"
							).setCMD(Constants.UPDATE).setParameter(
								"id", bcfmapping.getId()
							).setParameter(
								"addEditValue", "EDIT_MAPPING"
							).buildPortletURL()
						%>'
						name="id"
						value="<%= String.valueOf(bcfmapping.getId()) %>"
					/>

					<%
				DLFolder dlFolder = DLFolderLocalServiceUtil.fetchFolder(bcfmapping.getFolderId());
			%>


					<liferay-ui:search-container-column-text 
						name="breadcrumb" 
						property="layoutBreadCrumb" 
					/>
					<liferay-ui:search-container-column-text
							name="site-name"
							value="<%=mappingDisplayContext.getSiteName(bcfmapping.getLayoutPlid())%>"
					/>
		
					<liferay-ui:search-container-column-text 
						name="folder-id" 
						property="folderId"
					/>
					<liferay-ui:search-container-column-text 
						name="folder-name" 
						value="<%=Validator.isNotNull(dlFolder)?dlFolder.getName():"mapped-folder-not-found"%>"
					/>
					<liferay-ui:search-container-column-text 
						name="folder-path"					 
						value="<%= Validator.isNotNull(dlFolder)?mappingDisplayContext.getDLFolderTree(dlFolder.getFolderId()):"mapped-folder-not-found"%>"
					/>

					<liferay-ui:search-container-column-text
						name="active"
					>
						<c:choose>
							<c:when test="<%= bcfmapping.isActive() %>">
								<liferay-ui:icon
									cssClass="commerce-admin-icon-check enable-mapping"
									icon="check"
									markupView="lexicon"
								/>
							</c:when>
							<c:otherwise>
								<liferay-ui:icon
									cssClass="commerce-admin-icon-times disable-mapping"
									icon="times"
									markupView="lexicon"
								/>
							</c:otherwise>
						</c:choose>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-jsp
						cssClass="entry-action-column"
						path="/mapping_action.jsp"
					/>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					markupView="lexicon"
				/>
			</liferay-ui:search-container>
</div>

<script>

	function disableScroll() {
		$("body").css({
			"height": "100vh",
			"overflowY": 'hidden'
		})
	}

	function enableScroll() {
		$("body").css({
			"height": "auto",
			"overflowY": 'auto'
		})
	}

	function autoMapWarn() {
		$("#autoMapWarn").show();
		disableScroll();
	}

	$(".extractDataCancel_btn").click(function () {
		$("#autoMapWarn").hide();
		enableScroll();
	})

	$(".deactivateBtnAutoMapWarn").click(function () {
		$("#autoMapWarn").hide();
		enableScroll();
	})
</script>









