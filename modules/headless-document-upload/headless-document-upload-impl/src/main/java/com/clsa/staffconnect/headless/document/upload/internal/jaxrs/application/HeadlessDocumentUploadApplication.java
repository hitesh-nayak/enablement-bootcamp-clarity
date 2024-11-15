package com.clsa.staffconnect.headless.document.upload.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Hitesh Nayak
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/headless-document-upload",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=HeadlessDocumentUpload"
	},
	service = Application.class
)
@Generated("")
public class HeadlessDocumentUploadApplication extends Application {
}