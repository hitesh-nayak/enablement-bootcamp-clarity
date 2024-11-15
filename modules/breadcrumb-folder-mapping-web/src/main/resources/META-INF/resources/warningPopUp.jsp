<portlet:actionURL name="/breadcrump_folder_mapping/edit" var="extractDataURL">
    <portlet:param name="<%= Constants.CMD %>" value="autoMap" />
</portlet:actionURL>

<%
    Boolean autoMapEnabled = (Boolean) renderRequest.getAttribute("autoMapEnabled");
%>

<div class="modal" id="autoMapWarn" tabindex="-1" role="dialog" aria-labelledby="autoMapWarn" style="display: none;">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <c:if test="<%=autoMapEnabled%>">
                    <h2 class="modal-title mt-0"><liferay-ui:message key="start-auto-mapping"></liferay-ui:message></h2>
                </c:if>
                <c:if test="<%=!autoMapEnabled%>">
                    <h2 class="modal-title mt-0"><liferay-ui:message key="auto-mapping-disabled"></liferay-ui:message></h2>
                </c:if>

                <button aria-label="close" class="btn btn-unstyled close modal-closer deactivateBtnAutoMapWarn" id="deactivateBtnAutoMapWarn"
                        type="button">
                    <aui:icon cssClass="icon-monospaced" image="times" markupView="lexicon"/>
                </button>
            </div>
            <div class="modal-body">
                <h5><clay:label
                        displayType="danger"
                        label="WARNING!:"
                /> <liferay-ui:message key="auto-map-warn"></liferay-ui:message></h5>
                <div class="modal-footer">
                    <aui:button cssClass="search-box btn-primary extractDataCancel_btn" name="extractDataCancel" value="Cancel"></aui:button>
                    <c:if test="<%=autoMapEnabled%>">
                        <a class="btn search-box btn-danger extraction_btn" href="<%=extractDataURL%>">Auto Map</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    console.log("Automap url --------->" + '<%=extractDataURL%>');

    $(".extraction_btn").click(function () {
        $("body").css({
            "height": "auto",
            "overflowY": 'auto'
        })
    })
</script>