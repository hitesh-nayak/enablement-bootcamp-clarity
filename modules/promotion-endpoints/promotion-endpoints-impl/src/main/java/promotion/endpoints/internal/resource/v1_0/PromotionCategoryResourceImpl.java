package promotion.endpoints.internal.resource.v1_0;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import promotion.endpoints.dto.v1_0.PromotionCategory;
import promotion.endpoints.resource.v1_0.PromotionCategoryResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hitesh Nayak
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/promotion-category.properties",
	scope = ServiceScope.PROTOTYPE, service = PromotionCategoryResource.class
)
public class PromotionCategoryResourceImpl
	extends BasePromotionCategoryResourceImpl {

	@Override
	public Page<PromotionCategory> getGetPromotionCategoriesByNameCategoryNameGroupPage(String categoryName, Long groupId) throws Exception {

		long groupId1 = groupId;

		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(
				groupId1, categoryName);
		List<AssetCategory> categoryList = new ArrayList<>();
		if (Validator.isNotNull(assetVocabulary)) {

			categoryList = AssetCategoryLocalServiceUtil.getVocabularyRootCategories(
					assetVocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}
		List<PromotionCategory> promotionCategories = new ArrayList<>();
		Page<PromotionCategory> assetCategoryPage = Page.of(promotionCategories);
		for (AssetCategory assetCategory : categoryList){
			boolean hasSubCategories = false;
			PromotionCategory promotionCategory = new PromotionCategory();
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(assetCategory.getCategoryId());
			if(ListUtil.isNotEmpty(assetCategories)) hasSubCategories = true;
			Long [] subIds = assetCategories.stream().map(AssetCategory::getCategoryId).toArray(Long[]::new);


			promotionCategory.setName(assetCategory.getName());
			promotionCategory.setDesc(HtmlUtil.stripHtml(assetCategory.getDescription("en_US")));
			promotionCategory.setHasSubCategories(hasSubCategories);
			promotionCategory.setSubCategoriesIds(subIds);
			promotionCategory.setSuperCategoryId(assetCategory.getParentCategoryId());
			promotionCategory.setCategoryId(assetCategory.getCategoryId());
			promotionCategories.add(promotionCategory);

		}

		return assetCategoryPage;

	}

	@Override
	public PromotionCategory getGetPromotionCategoryByIdCategory(Long categoryId) throws Exception {

		AssetCategory  assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(categoryId);

			boolean hasSubCategories = false;
			PromotionCategory promotionCategory = new PromotionCategory();
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(assetCategory.getCategoryId());
			if(ListUtil.isNotEmpty(assetCategories)) hasSubCategories = true;
			Long [] subIds = assetCategories.stream().map(AssetCategory::getCategoryId).toArray(Long[]::new);
			promotionCategory.setName(assetCategory.getName());
			promotionCategory.setDesc(HtmlUtil.stripHtml(assetCategory.getDescription("en_US")));
			promotionCategory.setHasSubCategories(hasSubCategories);
			promotionCategory.setSubCategoriesIds(subIds);
			promotionCategory.setSuperCategoryId(assetCategory.getParentCategoryId());
			promotionCategory.setCategoryId(assetCategory.getCategoryId());
			return promotionCategory;
	}

	@Override
	public Page<PromotionCategory> getGetPromotionSubCategoriesByIdCategoryPage(Long categoryId) throws Exception {

		List<AssetCategory> categoryList = AssetCategoryLocalServiceUtil.getChildCategories(categoryId);
		List<PromotionCategory> promotionCategories = new ArrayList<>();
		Page<PromotionCategory> assetCategoryPage = Page.of(promotionCategories);
		for (AssetCategory assetCategory : categoryList){
			boolean hasSubCategories = false;
			PromotionCategory promotionCategory = new PromotionCategory();
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(assetCategory.getCategoryId());
			if(ListUtil.isNotEmpty(assetCategories)) hasSubCategories = true;
			Long [] subIds = assetCategories.stream().map(AssetCategory::getCategoryId).toArray(Long[]::new);


			promotionCategory.setName(assetCategory.getName());
			promotionCategory.setDesc(HtmlUtil.stripHtml(assetCategory.getDescription("en_US")));
			promotionCategory.setHasSubCategories(hasSubCategories);
			promotionCategory.setSubCategoriesIds(subIds);
			promotionCategory.setSuperCategoryId(assetCategory.getParentCategoryId());
			promotionCategory.setCategoryId(assetCategory.getCategoryId());
			promotionCategories.add(promotionCategory);

		}
		return assetCategoryPage;
	}
}