export function promotionRootCategoryGet(vocabularyName) {


    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());



}