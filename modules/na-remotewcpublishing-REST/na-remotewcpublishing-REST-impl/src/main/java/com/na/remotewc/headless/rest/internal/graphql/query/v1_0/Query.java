package com.na.remotewc.headless.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import com.na.remotewc.headless.rest.dto.v1_0.WebContent;
import com.na.remotewc.headless.rest.resource.v1_0.WebContentResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
public class Query {

	public static void setWebContentResourceComponentServiceObjects(
		ComponentServiceObjects<WebContentResource>
			webContentResourceComponentServiceObjects) {

		_webContentResourceComponentServiceObjects =
			webContentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {webContent(articleId: ___){idPK, extReferenceCode, userIdwc, groupIdwc, folderIdwc, classNameIdwc, classPKwc, articleIdwc, versionwc, uuIdwc, localePrimarywc, localeSecondarywc, titleLangPrimarywc, titleLangSecondarywc, descLangPrimarywc, descLangSecondarywc, fUrlLangPrimarywc, fUrlLangSecondarywc, contentPrimarywc, contentSecondarywc, ddmStructureIDwc, ddmStructureKeywc, ddmTemplateKeywc, layoutUuidwc, dispDatewc, defLang, modDatewc, neverReviewwc, indexablewc, smallImagewc, fileEntryIds, imagesB64Encoded, fileClassNameId, fileClassNamePk, fileEntryUuids, fileNames, fileTitles, fileMimes, fileDescs}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public WebContent webContent(@GraphQLName("articleId") String articleId)
		throws Exception {

		return _applyComponentServiceObjects(
			_webContentResourceComponentServiceObjects,
			this::_populateResourceContext,
			webContentResource -> webContentResource.getWebContent(articleId));
	}

	@GraphQLName("WebContentPage")
	public class WebContentPage {

		public WebContentPage(Page webContentPage) {
			actions = webContentPage.getActions();

			items = webContentPage.getItems();
			lastPage = webContentPage.getLastPage();
			page = webContentPage.getPage();
			pageSize = webContentPage.getPageSize();
			totalCount = webContentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<WebContent> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	}

	private static ComponentServiceObjects<WebContentResource>
		_webContentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}