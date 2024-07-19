package com.na.remotewc.headless.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.na.remotewc.headless.rest.internal.graphql.mutation.v1_0.Mutation;
import com.na.remotewc.headless.rest.internal.graphql.query.v1_0.Query;
import com.na.remotewc.headless.rest.internal.resource.v1_0.WebContentResourceImpl;
import com.na.remotewc.headless.rest.resource.v1_0.WebContentResource;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author untodawn035
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setWebContentResourceComponentServiceObjects(
			_webContentResourceComponentServiceObjects);

		Query.setWebContentResourceComponentServiceObjects(
			_webContentResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "NaRemotewcpublishingREST";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/na-remotewcpublishing-REST-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#createWebContent",
						new ObjectValuePair<>(
							WebContentResourceImpl.class, "postWebContent"));
					put(
						"mutation#createWebContentBatch",
						new ObjectValuePair<>(
							WebContentResourceImpl.class,
							"postWebContentBatch"));

					put(
						"query#webContent",
						new ObjectValuePair<>(
							WebContentResourceImpl.class, "getWebContent"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<WebContentResource>
		_webContentResourceComponentServiceObjects;

}