
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
		<aui:button type="button" value="post-article" name="Tunnel"
		onClick="postWC(`${jsonURL}`)"></aui:button>
	</aui:form>

	
</div>

<script>
	//const postFunc = function 
	const postWC = (resURL) => {
		console.log(resURL)
		try{
		$.ajax({
					url: resURL,
					type: 'POST',
					success:function(data){
						console.log("Formdata::"+data);
						var jsonObj = JSON.parse(data);
						console.log(jsonObj);
						fetch('http://192.168.122.239:8080/o/na-webContent-remote-REST/v1.0/webContent', 
							    {method:"POST",
							     headers:{
							        "Content-Type": "application/json",
							        "Authorization": `Bearer ${'d43e2fa65ccb7424b34530cceefcdd94b1e37443a4676e90e48eb3f94c245fb8'}`
							     },
							     body: JSON.stringify(jsonObj)
							        
							     })
							    .then(Response => Response.json())
							    .then(json => console.log(json))
						
						}
					
					
				});}
		catch(error){
			console.log(error);
		}
}
	
	
	
</script>


