package com.liferay.custom.object.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;


import com.liferay.mail.messaging.MailMessageListener;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;
import java.util.Map;


public class Test {



    private void triggerWorkflowTask() {

        import com.liferay.object.model.ObjectEntry;
        import com.liferay.object.service.ObjectEntryLocalServiceUtil;
        import com.liferay.portal.kernel.model.User;
        import com.liferay.portal.kernel.service.UserLocalServiceUtil;
        import com.liferay.portal.kernel.util.GetterUtil;
        import com.liferay.portal.kernel.workflow.WorkflowConstants;

        System.out.println("In GROOVY Checking department.");
        String className = (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME);
        System.out.println("classname:" + className);
        long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        System.out.println("classPK:" + classPK);
        ObjectEntry objectEntry = ObjectEntryLocalServiceUtil.fetchObjectEntry(classPK);

        Map<String, Serializable> values = objectEntry.getValues();

        String department = (String) values.get("dept");



        if (department.equalsIgnoreCase("cndncsadept")) returnValue = "csaManager";
        if (department.equalsIgnoreCase("cndnisdept")) returnValue = "finance1";




    }
}








