import {promotionRootCategoryGet} from "./promotionRootCategoryGet";
import React, {useEffect, useRef, useState} from "react";
import {promotionSubCategoriesGet} from "./promotionSubCategoriesGet";
import {validatePromotionCategory} from "./validatePromotionCategory";



const PromotionCategory = () => {

    const defaultSelectOption = "Select";
    const defaultSelectValue = "-1";
    let rootCategoriesRef = useRef(null);
    let firstSubCategoriesRef = useRef(null);
    let secondSubCategoriesRef = useRef(null);
    let thirdSubCategoriesRef = useRef(null);
    let fourthSubCategoriesRef = useRef(null);
    const getSubCategories = (categoryId) => {
        return promotionSubCategoriesGet(categoryId)
    }


    const getPromotionRootCategories = () => {
        promotionRootCategoryGet(`promotion`).then(function (json) {

            setRootCategory(json.items);

        })
    }
    useEffect(() => {
        getPromotionRootCategories();
    }, [])

    function changeRootCategories(event) {
        setSelectedValueRoot(event.target.value)
        let categoryId = event.target.value;
        getSubCategories(categoryId).then(function (json) {

            setFirstSubCategory(json.items);
            setSecondSubCategory([]);
            setThirdSubCategory([]);
            setFourthSubCategory([]);
            setSelectedValueFirst(defaultSelectValue);
            setSelectedValueSecond(defaultSelectValue);
            setSelectedValueThird(defaultSelectValue);
            setSelectedValueFourth(defaultSelectValue);

        })
    }

    const [rootCategory, setRootCategory] = useState([])
    const [selectedValueRoot, setSelectedValueRoot] = useState('');


    function changeFirstSubCategories(event) {
        setSelectedValueFirst(event.target.value);
        let categoryId = event.target.value;
        getSubCategories(categoryId).then(function (json) {

            setSecondSubCategory(json.items);
            setThirdSubCategory([]);
            setFourthSubCategory([]);
            setSelectedValueSecond(defaultSelectValue);
            setSelectedValueThird(defaultSelectValue);
            setSelectedValueFourth(defaultSelectValue);

        })
    }

    const [firstSubCategory, setFirstSubCategory] = useState([]);
    const [selectedValueFirst, setSelectedValueFirst] = useState('');


    function changeSecondSubCategories(event) {
        setSelectedValueSecond(event.target.value);
        let categoryId = event.target.value;
        getSubCategories(categoryId).then(function (json) {

            setThirdSubCategory(json.items);
            setFourthSubCategory([]);
            setSelectedValueThird(defaultSelectValue);
            setSelectedValueFourth(defaultSelectValue);

        })

    }

    const [secondSubCategory, setSecondSubCategory] = useState([]);
    const [selectedValueSecond, setSelectedValueSecond] = useState('');

    function changeThirdSubCategories(event) {
        setSelectedValueThird(event.target.value);
        let categoryId = event.target.value;
        getSubCategories(categoryId).then(function (json) {
            setFourthSubCategory(json.items);
            setSelectedValueFourth(defaultSelectValue);

        })

    }

    const [thirdSubCategory, setThirdSubCategory] = useState([]);
    const [selectedValueThird, setSelectedValueThird] = useState('');

    function changeFourthSubCategories(event) {
        setSelectedValueFourth(event.target.value);
        let categoryId = event.target.value;
        getSubCategories(categoryId).then(function (json) {
        })

    }

    const [fourthSubCategory, setFourthSubCategory] = useState([]);
    const [selectedValueFourth, setSelectedValueFourth] = useState('');


    const handleSubmit = (e) => {
        e.preventDefault();
        let formData = new FormData();
        formData.append('rootCategory', selectedValueRoot);
        formData.append('firstCategory', selectedValueFirst);
        formData.append('secondCategory', selectedValueSecond);
        formData.append('thirdCategory', selectedValueThird);
        formData.append('fourthCategory', selectedValueFourth);
        validatePromotionCategory(formData).then(function (json) {
            console.log("isValid? " + JSON.stringify(json));

        })

    }

    return (<form id="categoryForm" action="" onSubmit={handleSubmit}>
        <select ref={rootCategoriesRef} aria-label="select lob" value={selectedValueRoot}
                onChange={(event) => changeRootCategories(event)}>
            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
            {rootCategory.map(rootCategory => {
                return <option key={rootCategory.categoryId}
                               value={rootCategory.categoryId}>{rootCategory.name}</option>
            })}
        </select>
        <select ref={firstSubCategoriesRef} aria-label="select promo type" value={selectedValueFirst}
                onChange={(event) => changeFirstSubCategories(event)}>
            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
            {firstSubCategory.map(firstSubCategory => {
                return <option key={firstSubCategory.categoryId}
                               value={firstSubCategory.categoryId}>{firstSubCategory.name}</option>
            })}
        </select>
        <select ref={secondSubCategoriesRef} aria-label="select promo sub-type" value={selectedValueSecond}
                onChange={(event) => changeSecondSubCategories(event)}>
            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
            {secondSubCategory.map(secondSubCategory => {
                return <option key={secondSubCategory.categoryId}
                               value={secondSubCategory.categoryId}>{secondSubCategory.name}</option>
            })}
        </select>
        <select ref={thirdSubCategoriesRef} aria-label="select discount-type" value={selectedValueThird}
                onChange={(event) => changeThirdSubCategories(event)}>
            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
            {thirdSubCategory.map(thirdSubCategory => {
                return <option key={thirdSubCategory.categoryId}
                               value={thirdSubCategory.categoryId}>{thirdSubCategory.name}</option>
            })}
        </select>
        <select ref={fourthSubCategoriesRef} aria-label="select benefit-type" value={selectedValueFourth}
                onChange={(event) => changeFourthSubCategories(event)}>
            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
            {fourthSubCategory.map(fourthSubCategory => {
                return <option key={fourthSubCategory.categoryId}
                               value={fourthSubCategory.categoryId}>{fourthSubCategory.name}</option>
            })}
        </select>
        <button id={"submitBtn"} type={"submit"}>Submit</button>


    </form>)
}
export default PromotionCategory