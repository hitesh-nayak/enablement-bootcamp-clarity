
const vocabularyName ="";
export function getVoucherType() {

    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}

export function getDept() {
    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}

export function getRequestor(){
    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}

export function getCustomerName() {
    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}

export function getCurrency(){
    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}

export function getReason(){
    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
        {method: 'GET'}
    ).then(res => res.json());
}
