package com.na.webcontent.remote.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author untodawn035
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/na-webContent-remote-REST",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=NaWebContentRemoteREST"
	},
	service = Application.class
)
@Generated("")
public class NaWebContentRemoteRESTApplication extends Application {
}