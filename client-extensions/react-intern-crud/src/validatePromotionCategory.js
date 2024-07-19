export function validatePromotionCategory(body) {

    return Liferay.Util.fetch(
        `/o/promotion-endpoints/v1.0/validatePromotionCategory`,
        {
            method: 'POST',
            body
        }
    ).then(res => res.json());

};