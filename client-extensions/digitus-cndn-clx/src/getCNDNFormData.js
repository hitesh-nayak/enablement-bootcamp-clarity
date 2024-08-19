import {Liferay} from "./common/services/liferay/liferay";

const vocabularyName ="";
export function getVoucherType() {

    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());

    return fetch("http://localhost:8082/o/headless-admin-list-type/v1.0/list-type-definitions/by-external-reference-code/fd6a3cfa-e1ec-e60a-88ac-e4492f063434/list-type-entries",
     {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
     .then(Response => Response.json())
}

export function getDept() {
    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());
    return fetch("http://localhost:8082/o/headless-admin-list-type/v1.0/list-type-definitions/by-external-reference-code/520e6f07-81ab-e4d4-6e13-bfddf978bd56/list-type-entries",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())
}
export function getCurrency(){
    return fetch("http://localhost:8082/o/headless-admin-list-type/v1.0/list-type-definitions/by-external-reference-code/d544f547-ecd3-0996-f829-90b49306c88e/list-type-entries",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())
}

export function getReason(){
    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());

    return fetch("http://localhost:8082/o/headless-admin-list-type/v1.0/list-type-definitions/by-external-reference-code/571d2c9b-43dc-7b9b-7764-6021fdcd7e6d/list-type-entries",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())
}

export function getRequestor(){
    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());

    return fetch("http://localhost:8082/o/headless-admin-user/v1.0/user-accounts",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())

    //return Liferay.Util.fetch("http://localhost:58081/object/entry/manager/1/fc7b97dc-2916-528b-b8b4-bc5abccd4d6c").then(Response => Response.json())


}

export function getVerificationBy(){
    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());

    return fetch("http://localhost:8082/o/headless-admin-user/v1.0/user-accounts",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())


}

export function getCustomerName() {
    // return Liferay.Util.fetch(
    //     `/o/promotion-endpoints/v1.0/getPromotionCategoriesByName/${vocabularyName}/${Liferay.ThemeDisplay.getSiteGroupId()}`,
    //     {method: 'GET'}
    // ).then(res => res.json());

    return fetch("http://localhost:8082/o/c/digituscustomers/",
        {headers:{Authorization: `Basic ${btoa('test@liferay.com:learn')}` }})
        .then(Response => Response.json())

}
