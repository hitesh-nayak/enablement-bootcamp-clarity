package com.clsa.document.upload.custom.headless.internal.resource.v1_0;

import com.liferay.headless.delivery.resource.v1_0.DocumentResource;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalServiceUtil;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.events.ServicePreAction;
import com.liferay.portal.events.ThemeServicePreAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.TransactionConfig;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component(immediate = true, service = DocumentAPIUtil.class)
public class DocumentAPIUtil {
    private static final Log log = LogFactoryUtil.getLog(DocumentAPIUtil.class);

    public ThemeDisplay initializeThemeDisplay(
            long groupId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        ServicePreAction servicePreAction = new ServicePreAction();

        servicePreAction.servicePre(
                httpServletRequest, httpServletResponse, false);

        ThemeServicePreAction themeServicePreAction =
                new ThemeServicePreAction();

        themeServicePreAction.run(httpServletRequest, httpServletResponse);

        ThemeDisplay themeDisplay =
                (ThemeDisplay) httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        themeDisplay.setScopeGroupId(groupId);
        themeDisplay.setSiteGroupId(groupId);
        return themeDisplay;
    }

    public DocumentResource getDocumentResource(ThemeDisplay themeDisplay) {
        return docResourceFactory.create().user(themeDisplay.getUser()).build();
    }


    public ObjectEntry addOrUpdateAuditEntry(String auditObjectUUID, Long userId, Long groupId, Long objectDefinitionId, Map<String, Serializable> auditMap, ServiceContext serviceContext) {

        //ObjectDefinitionLocalServiceUtil.getObj
        try {
            return TransactionInvokerUtil.invoke(_transactionConfig, () -> ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(auditObjectUUID, userId, groupId, objectDefinitionId, auditMap, serviceContext));
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public Map<String, Serializable> getInitialAuditmap(HttpServletRequest contextHttpServletRequest, String userAction) {
        Map<String, Serializable> auditMap = new HashMap<>();
        auditMap.put("userDetails", contextHttpServletRequest.getRemoteUser());
        auditMap.put("userAction", userAction);
        auditMap.put("endPoint", contextHttpServletRequest.getRequestURI());
        auditMap.put("requestDate", new Date());
        auditMap.put("clientAddress", contextHttpServletRequest.getRemoteHost().concat(",").concat(String.valueOf(contextHttpServletRequest.getRemotePort())));
        return auditMap;
    }

    public Long getCompanyId(HttpServletRequest httpServletRequest) throws PortalException {
       User user = UserLocalServiceUtil.getUser(Long.parseLong(httpServletRequest.getRemoteUser()));
       return user.getCompanyId();
    }

    private final TransactionConfig _transactionConfig = TransactionConfig.Factory.create(Propagation.REQUIRES_NEW, new Class<?>[]{PortalException.class});

    @Reference
    private DocumentResource.Factory docResourceFactory;

}
