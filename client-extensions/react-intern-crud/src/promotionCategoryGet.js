export function promotionCategoryGet(categoryId) {


    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesById/${categoryId}`,
        {method: 'GET'}
    ).then(res => res.json());



}