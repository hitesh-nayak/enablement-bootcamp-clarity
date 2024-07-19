package com.liferay.custom.object.portlet;

import com.liferay.custom.object.constants.CustomObjectSearchAndEditPortletKeys;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.custom.object.dto.StateObj;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

/**
 * @author Hitesh Nayak
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=CustomObjectSearchAndEdit",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + CustomObjectSearchAndEditPortletKeys.CUSTOMOBJECTSEARCHANDEDIT,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CustomObjectSearchAndEditPortlet extends MVCPortlet {
    private static final Log log = LogFactoryUtil.getLog(CustomObjectSearchAndEditPortlet.class.getName());

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            //Enter the value of the Object Def. id. This value will not change once the object is published and approved.
            //Provide the appropriate value of group id, in case of objects made in my new instance of liferay-7.4-u92 by the default user "Test Test", the objects were mapped to
            //the group id of 0L, it might be different in your case.
            List<ObjectEntry> objEntry = ObjectEntryLocalServiceUtil.getObjectEntries(0L, 34606L, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            List<StateObj> stList = objEntry.stream().map(objEn -> {
                Map<String, Serializable> mp = objEn.getValues();

                //Map the names and values of the fields in your object and object entry to your custom DTO.
                StateObj st = new StateObj((long) mp.get("c_stateId"));
                st.setPinCode((long) mp.get("pinCode"));
                st.setName((String) mp.get("name"));
                st.setExtRefId(objEn.getExternalReferenceCode());
                st.setStateObjectDefId(objEn.getObjectDefinitionId());
                return st;
            }).collect(Collectors.toList());

            renderRequest.setAttribute("objectsList", stList);
            renderRequest.setAttribute("backURL", themeDisplay.getURLCurrent());

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "editObjAction")
    public void editObjAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, IOException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            ObjectEntry objectEntry = ObjectEntryLocalServiceUtil.getObjectEntry(ParamUtil.getLong(actionRequest, "objEntryId"));
            Map<String, Serializable> mp = new HashMap<>();
            mp.put("name", ParamUtil.getString(actionRequest, "stateName"));
            mp.put("pinCode", ParamUtil.getString(actionRequest, "pinCode"));

            ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(objectEntry.getExternalReferenceCode(), themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                    ObjectDefinitionLocalServiceUtil.getObjectDefinition(objectEntry.getObjectDefinitionId()).getObjectDefinitionId(), mp, ServiceContextFactory.getInstance(actionRequest));
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "backURL"));

    }
}