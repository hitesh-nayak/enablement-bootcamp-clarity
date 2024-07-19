package promotion.endpoints.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

import promotion.endpoints.dto.v1_0.PromotionCategory;
import promotion.endpoints.resource.v1_0.PromotionCategoryResource;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Query {

	public static void setPromotionCategoryResourceComponentServiceObjects(
		ComponentServiceObjects<PromotionCategoryResource>
			promotionCategoryResourceComponentServiceObjects) {

		_promotionCategoryResourceComponentServiceObjects =
			promotionCategoryResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {getPromotionCategoriesByNameCategoryNameGroup(categoryName: ___, groupId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public PromotionCategoryPage getPromotionCategoriesByNameCategoryNameGroup(
			@GraphQLName("categoryName") String categoryName,
			@GraphQLName("groupId") Long groupId)
		throws Exception {

		return _applyComponentServiceObjects(
			_promotionCategoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			promotionCategoryResource -> new PromotionCategoryPage(
				promotionCategoryResource.
					getGetPromotionCategoriesByNameCategoryNameGroupPage(
						categoryName, groupId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {getPromotionCategoryByIdCategory(categoryId: ___){name, categoryId, desc, superCategoryId, subCategoriesIds, hasSubCategories}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public PromotionCategory getPromotionCategoryByIdCategory(
			@GraphQLName("categoryId") Long categoryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_promotionCategoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			promotionCategoryResource ->
				promotionCategoryResource.getGetPromotionCategoryByIdCategory(
					categoryId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {getPromotionSubCategoriesByIdCategory(categoryId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public PromotionCategoryPage getPromotionSubCategoriesByIdCategory(
			@GraphQLName("categoryId") Long categoryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_promotionCategoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			promotionCategoryResource -> new PromotionCategoryPage(
				promotionCategoryResource.
					getGetPromotionSubCategoriesByIdCategoryPage(categoryId)));
	}

	@GraphQLTypeExtension(PromotionCategory.class)
	public class GetGetPromotionCategoryByIdCategoryTypeExtension {

		public GetGetPromotionCategoryByIdCategoryTypeExtension(
			PromotionCategory promotionCategory) {

			_promotionCategory = promotionCategory;
		}

		@GraphQLField
		public PromotionCategory getPromotionCategoryByIdCategory()
			throws Exception {

			return _applyComponentServiceObjects(
				_promotionCategoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				promotionCategoryResource ->
					promotionCategoryResource.
						getGetPromotionCategoryByIdCategory(
							_promotionCategory.getCategoryId()));
		}

		private PromotionCategory _promotionCategory;

	}

	@GraphQLTypeExtension(PromotionCategory.class)
	public class GetGetPromotionSubCategoriesByIdCategoryPageTypeExtension {

		public GetGetPromotionSubCategoriesByIdCategoryPageTypeExtension(
			PromotionCategory promotionCategory) {

			_promotionCategory = promotionCategory;
		}

		@GraphQLField
		public PromotionCategoryPage getPromotionSubCategoriesByIdCategory()
			throws Exception {

			return _applyComponentServiceObjects(
				_promotionCategoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				promotionCategoryResource -> new PromotionCategoryPage(
					promotionCategoryResource.
						getGetPromotionSubCategoriesByIdCategoryPage(
							_promotionCategory.getCategoryId())));
		}

		private PromotionCategory _promotionCategory;

	}

	@GraphQLName("PromotionCategoryPage")
	public class PromotionCategoryPage {

		public PromotionCategoryPage(Page promotionCategoryPage) {
			actions = promotionCategoryPage.getActions();

			items = promotionCategoryPage.getItems();
			lastPage = promotionCategoryPage.getLastPage();
			page = promotionCategoryPage.getPage();
			pageSize = promotionCategoryPage.getPageSize();
			totalCount = promotionCategoryPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<PromotionCategory> items;

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

	private void _populateResourceContext(
			PromotionCategoryResource promotionCategoryResource)
		throws Exception {

		promotionCategoryResource.setContextAcceptLanguage(_acceptLanguage);
		promotionCategoryResource.setContextCompany(_company);
		promotionCategoryResource.setContextHttpServletRequest(
			_httpServletRequest);
		promotionCategoryResource.setContextHttpServletResponse(
			_httpServletResponse);
		promotionCategoryResource.setContextUriInfo(_uriInfo);
		promotionCategoryResource.setContextUser(_user);
		promotionCategoryResource.setGroupLocalService(_groupLocalService);
		promotionCategoryResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<PromotionCategoryResource>
		_promotionCategoryResourceComponentServiceObjects;

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