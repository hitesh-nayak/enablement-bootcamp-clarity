<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.custom.object.dto.StateObj" %>



<%

List<StateObj> objectsList = (List<StateObj>)request.getAttribute("objectsList");
String backURL = (String)request.getAttribute("backURL");
int totalCount = objectsList.size();
PortletURL portletURL = renderResponse.createRenderURL();
%>

<liferay-ui:search-container iteratorURL="<%=portletURL%>" total="<%=totalCount%>" var="searchContainer"
                                     delta="10" deltaConfigurable="true"
                                     emptyResultsMessage="No objects available">


            <liferay-ui:search-container-results results="<%=objectsList%>"/>


            <liferay-ui:search-container-row className="com.liferay.custom.object.dto.StateObj"
                                             keyProperty="stateId" modelVar="stateObj">
                <portlet:renderURL var="editObjURL">
                             <portlet:param name="mvcPath" value="/objEditForm.jsp"/>
                             <portlet:param name="name" value="<%= stateObj.getName() %>"/>
                             <portlet:param name="pinCode" value="<%= String.valueOf(stateObj.getPinCode()) %>"/>
                             <portlet:param name="objEntryId" value="<%= String.valueOf(stateObj.getStateId()) %>"/>
                             <portlet:param name="backURL" value="<%= backURL %>"/>
                </portlet:renderURL>
                <liferay-ui:search-container-column-text href="<%=editObjURL%>" name="State Id" property="stateId" >



                </liferay-ui:search-container-column-text>

                <liferay-ui:search-container-column-text name="Name" property="name">

                </liferay-ui:search-container-column-text>
                <liferay-ui:search-container-column-text name="Pin Code" property="pinCode"/>


                <liferay-ui:search-container-column-text name="State Obj Def Id" property="stateObjectDefId"/>
                <liferay-ui:search-container-column-text name="Ext Ref Id" property="extRefId" />


            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator markupView="lexicon" searchContainer="<%=searchContainer%>"/>

        </liferay-ui:search-container>