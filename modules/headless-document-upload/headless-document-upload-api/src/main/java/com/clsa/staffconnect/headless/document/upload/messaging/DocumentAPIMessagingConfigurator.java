package com.clsa.staffconnect.headless.document.upload.messaging;

import com.clsa.staffconnect.headless.document.upload.util.DocumentAPIConstants;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.util.MapUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component
public class DocumentAPIMessagingConfigurator {
    @Activate
    private void _activate(BundleContext bundleContext) {
        Destination destination = _destinationFactory.createDestination(
                DestinationConfiguration.createSerialDestinationConfiguration(
                        DocumentAPIConstants.DOCUMENT_API_MESSAGE_DESTINATION));

        _serviceRegistration = bundleContext.registerService(
                Destination.class, destination,
                MapUtil.singletonDictionary(
                        DocumentAPIConstants.KEY_DESTINATION_NAME, destination.getName()));
    }

    @Deactivate
    private void _deactivate() {
        if (_serviceRegistration != null) {
            _serviceRegistration.unregister();
        }
    }

    @Reference
    private DestinationFactory _destinationFactory;

    private ServiceRegistration<Destination> _serviceRegistration;
}
