package com.clsa.document.upload.custom.headless.internal.graphql.servlet.v1_0;

import com.clsa.document.upload.custom.headless.internal.graphql.mutation.v1_0.Mutation;
import com.clsa.document.upload.custom.headless.internal.graphql.query.v1_0.Query;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.processing.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author me
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/documentUpload-custom-headless-REST-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

}