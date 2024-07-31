export function promotionSubCategoriesGet(categoryId) {


    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionSubCategoriesById/${categoryId}`,
        {method: 'GET'}
    ).then(res => res.json());



}