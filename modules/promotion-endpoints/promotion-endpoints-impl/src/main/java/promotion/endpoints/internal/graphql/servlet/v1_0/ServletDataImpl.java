package promotion.endpoints.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

import promotion.endpoints.internal.graphql.mutation.v1_0.Mutation;
import promotion.endpoints.internal.graphql.query.v1_0.Query;
import promotion.endpoints.internal.resource.v1_0.PromotionCategoryResourceImpl;
import promotion.endpoints.resource.v1_0.PromotionCategoryResource;

/**
 * @author me
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Query.setPromotionCategoryResourceComponentServiceObjects(
			_promotionCategoryResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "PromotionEndpoints";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/promotion-endpoints-graphql/v1_0";
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
						"query#getPromotionCategoriesByNameCategoryNameGroup",
						new ObjectValuePair<>(
							PromotionCategoryResourceImpl.class,
							"getGetPromotionCategoriesByNameCategoryNameGroupPage"));
					put(
						"query#getPromotionCategoryByIdCategory",
						new ObjectValuePair<>(
							PromotionCategoryResourceImpl.class,
							"getGetPromotionCategoryByIdCategory"));
					put(
						"query#getPromotionSubCategoriesByIdCategory",
						new ObjectValuePair<>(
							PromotionCategoryResourceImpl.class,
							"getGetPromotionSubCategoriesByIdCategoryPage"));

					put(
						"query#PromotionCategory.getPromotionCategoryByIdCategory",
						new ObjectValuePair<>(
							PromotionCategoryResourceImpl.class,
							"getGetPromotionCategoryByIdCategory"));
					put(
						"query#PromotionCategory.getPromotionSubCategoriesByIdCategory",
						new ObjectValuePair<>(
							PromotionCategoryResourceImpl.class,
							"getGetPromotionSubCategoriesByIdCategoryPage"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PromotionCategoryResource>
		_promotionCategoryResourceComponentServiceObjects;

}