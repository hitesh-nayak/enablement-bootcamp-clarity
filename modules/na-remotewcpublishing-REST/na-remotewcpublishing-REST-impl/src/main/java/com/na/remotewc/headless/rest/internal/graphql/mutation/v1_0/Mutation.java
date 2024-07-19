package com.na.remotewc.headless.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import com.na.remotewc.headless.rest.dto.v1_0.WebContent;
import com.na.remotewc.headless.rest.resource.v1_0.WebContentResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setWebContentResourceComponentServiceObjects(
		ComponentServiceObjects<WebContentResource>
			webContentResourceComponentServiceObjects) {

		_webContentResourceComponentServiceObjects =
			webContentResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Post a webcontent.")
	public WebContent createWebContent(
			@GraphQLName("webContent") WebContent webContent)
		throws Exception {

		return _applyComponentServiceObjects(
			_webContentResourceComponentServiceObjects,
			this::_populateResourceContext,
			webContentResource -> webContentResource.postWebContent(
				webContent));
	}

	@GraphQLField
	public Response createWebContentBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_webContentResourceComponentServiceObjects,
			this::_populateResourceContext,
			webContentResource -> webContentResource.postWebContentBatch(
				callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(WebContentResource webContentResource)
		throws Exception {

		webContentResource.setContextAcceptLanguage(_acceptLanguage);
		webContentResource.setContextCompany(_company);
		webContentResource.setContextHttpServletRequest(_httpServletRequest);
		webContentResource.setContextHttpServletResponse(_httpServletResponse);
		webContentResource.setContextUriInfo(_uriInfo);
		webContentResource.setContextUser(_user);
		webContentResource.setGroupLocalService(_groupLocalService);
		webContentResource.setRoleLocalService(_roleLocalService);

		webContentResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<WebContentResource>
		_webContentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}