package com.clsa.staffconnect.headless.document.upload.messaging;

import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Component(
        property = DocumentAPIConstants.KEY_DESTINATION_NAME+"="+DocumentAPIConstants.DOCUMENT_API_MESSAGE_DESTINATION,
        service = MessageListener.class
)
public class DocumentAPIMessageListener implements MessageListener {

    private static final Log log = LogFactoryUtil.getLog(DocumentAPIMessageListener.class.getName());

    @Override
    public void receive(Message message) {

        Map<String, Serializable> dataMap = new HashMap<String, Serializable>();
        if (message.getPayload() instanceof HashMap) dataMap = (Map<String, Serializable>) message.getPayload();

        log.info(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + "Received audit message -> "+dataMap);

        try {
            objectEntryLocalService.addOrUpdateObjectEntry(null, (Long) dataMap.get(DocumentAPIConstants.KEY_USER_ID),
                    0L,(Long) dataMap.get(DocumentAPIConstants.KEY_OBJECT_DEFINITION_ID),(HashMap<String,Serializable>)dataMap.get(DocumentAPIConstants.KEY_AUDIT_MAP),(ServiceContext) dataMap.get(DocumentAPIConstants.KEY_SERVICE_CONTEXT));
        } catch (PortalException e) {
           log.error(DocumentAPIConstants.CLSA_UNIQUE_LOG_IDENTIFIER_API + e.getLocalizedMessage(), e);
        }

    }

    @Reference
    private ObjectEntryLocalService objectEntryLocalService;
}
