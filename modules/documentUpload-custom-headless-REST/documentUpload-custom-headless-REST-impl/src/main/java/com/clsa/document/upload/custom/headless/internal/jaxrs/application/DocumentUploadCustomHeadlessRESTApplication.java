package com.clsa.document.upload.custom.headless.internal.jaxrs.application;

import javax.annotation.processing.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author me
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/documentUpload-custom-headless-REST",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=DocumentUploadCustomHeadlessREST"
	},
	service = Application.class
)
@Generated("")
public class DocumentUploadCustomHeadlessRESTApplication extends Application {
}