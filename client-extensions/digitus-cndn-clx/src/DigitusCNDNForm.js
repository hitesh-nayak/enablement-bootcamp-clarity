import {getDept} from "./getCNDNFormData";
import {getVoucherType} from "./getCNDNFormData";
import {getCustomerName} from "./getCNDNFormData";
import {getRequestor} from "./getCNDNFormData";
import {getReason} from "./getCNDNFormData";
import {getCurrency} from "./getCNDNFormData";
import React, {useEffect, useRef, useState} from "react";
import {validatePromotionCategory} from "./validatePromotionCategory";
import "bootstrap/dist/css/bootstrap.min.css"
import ContainerDivMD6 from "./ContainerDivMD6";
import ContainerDivMD4 from "./ContainerDivMD4";
import {Modal, Button} from "react-bootstrap";



const DigitusCNDNForm = () => {

    //DIGITUS CNDN FORM IMPLEMENTATION
    const defaultSelectOption = "Select";
    const defaultSelectValue = "-1";

    let voucherTypeRef = useRef(null);
    const [voucherTypeValue, setVoucherTypeValue] = useState("");
    const [voucherTypeMap, setVoucherTypeMap] = useState([]);
    const getVoucherTypeMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setVoucherTypeMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getVoucherTypeMap();
    }, [])

    let creationDateRef = useRef(null);
    const [creationDateValue, setCreationDateValue] = useState("");

    let requestorRef = useRef(null);
    const [requestorValue, setRequestorValue] = useState("");
    const [requestorMap, setRequestorMap] = useState([]);
    const getRequestorMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setRequestorMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getRequestorMap();
    }, [])

    let deptRef = useRef(null);
    const [deptValue, setDeptValue] = useState("");
    const [deptMap, setDeptMap] = useState([]);
    const getDeptMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setDeptMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getDeptMap();
    }, [])

    let custNameRef = useRef(null);
    const [custNameValue, setCustNameValue] = useState("");
    const [custNameMap, setCustNameMap] = useState([]);
    const getCustNameMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setCustNameMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getCustNameMap();
    }, [])

    let custCodeRef = useRef(null);
    const [custCodeValue, setCustCodeValue] = useState("");

    let currencyRef = useRef(null);
    const [currencyValue, setCurrencyValue] = useState("");
    const [currencyValueMap, setCurrencyValueMap] = useState([]);
    const getCurrencyValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setCurrencyValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getCurrencyValueMap();
    }, [])


    let reasonRef = useRef(null);
    const [reasonValue, setReasonValue] = useState("");
    const [reasonValueMap, setReasonValueMap] = useState([]);
    const getReasonValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setReasonValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getReasonValueMap();
    }, [])


    let specifyOtherRef = useRef(null);
    const [specifyOtherValue, setSpecifyOtherValue] = useState("");

    let verificationByRef = useRef(null);
    const [verificationByValue, setVerificationByValue] = useState("");
    const [verificationByValueMap, setVerificationByValueMap] = useState([]);
    const getVerificationByValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setVerificationByValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getVerificationByValueMap();
    }, [])

    let cndnNoteAttachmentsRef = useRef(null);
    const [cndnNoteAttachmentsValue, setCndnNoteAttachmentsValue] = useState([]);

    let salesDirectorRef = useRef(null);
    const [salesDirectorValue, setSalesDirectorValue] = useState("");
    const [salesDirectorValueMap, setSalesDirectorValueMap] = useState([]);
    const getSalesDirectorValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setSalesDirectorValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getSalesDirectorValueMap();
    }, [])

    let financeControllerRef = useRef(null);
    const [financeControllerValue, setFinanceControlValue] = useState("");
    const [financeControllerValueMap, setFinanceControllerValueMap] = useState([]);
    const getfinanceControllerValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setFinanceControllerValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getfinanceControllerValueMap();
    }, [])

    let generalManagerRef = useRef(null);
    const [generalManagerValue, setGeneralManagerValue] = useState("");
    const [generalManagerValueMap, setGeneralManagerValueMap] = useState([]);
    const getGeneralManagerValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setGeneralManagerValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getGeneralManagerValueMap();
    }, [])


    let noteDescriptionRef = useRef(null);
    const [noteDescriptionValue, setNoteDescriptionValue] = useState("");

    let stockAdjustmentRef = useRef(null);
    const [stockAdjustmentValue, setStockAdjustmentValue] = useState("");

    let locationRef = useRef(null);
    const [locationValue, setLocationValue] = useState("");

    let lotSerialRef = useRef(null);
    const [lotSerialValue, setLotSerialValue] = useState("");

    let categoryRef = useRef(null);
    const [categoryValue, setCategoryValue] = useState("");
    const [categoryValueMap, setCategoryValueMap] = useState([]);
    const getCategoryValueMap = () => {
        // getVoucherType().then(function (json) {
        //
        //     setVoucherTypeMap(json.items);
        //
        // })
        setCategoryValueMap([1, 2, 3, 4, 5, 6]);
    }
    useEffect(() => {
        getCategoryValueMap();
    }, [])

    let itemDescriptionRef = useRef(null);
    const [itemDescriptionValue, setItemDescriptionValue] = useState("");

    let customerPartNoRef = useRef(null);
    const [customerPartValue, setCustomerPartValue] = useState("");

    let customerPONoRef = useRef(null);
    const [customerPONoValue, setCustomerPONoValue] = useState("");

    let itemNoRef = useRef(null);
    const [itemNoValue, setItemNoValue] = useState("");
    let invoiceNoRef = useRef(null);
    const [invoiceNoValue, setInvoiceNoValue] = useState("");
    let invoiceDateRef = useRef(null);
    const [invoiceDateValue, setInvoiceDateValue] = useState("");
    let quantityRef = useRef(null);
    const [quantityValue, setQuantityValue] = useState("");
    let unitPriceRef = useRef(null);
    const [unitPriceValue, setUnitPriceValue] = useState("");
    let totalPriceRef = useRef(null);
    const [totalPriceValue, setTotalPriceValue] = useState("");
    let remarksRef = useRef(null);
    const [remarksValue, setRemarksValue] = useState("");
    let cndnItemAttachmentsRef = useRef(null);
    const [cndnItemAttachmentsValue, setCndnItemAttachmentsValue] = useState([]);

    let csaItems = [];
    let isItems = [];


    let csaItemButtonRef = useRef(null);
    const [csaItemModalValue, setCsaItemModalValue] = useState(false);
    const csaModalClose = () => setCsaItemModalValue(false);

    let isItemButtonRef = useRef(null);
    const [isItemModalValue, setIsItemModalValue] = useState(false);
    const isModalClose = () => setIsItemModalValue(false);


    const handleCNDNSubmission = (e) => {
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


    return (<form className={"row g-3"} id="categoryForm" action="" onSubmit={handleCNDNSubmission}>
            <h4>AR Debit/Credit Adjustment Request Form</h4>
            <ContainerDivMD6>
                <label className="form-label">
                    Voucher Type
                </label>
                <select className="form-select" ref={voucherTypeRef} name="Voucher Type"
                        value={voucherTypeValue}
                        onChange={(event) => setVoucherTypeValue(event.target.value)}>
                    <option value={defaultSelectValue}>{defaultSelectOption}</option>
                    <option value="cndncredit">Credit</option>
                    <option value="cndndebit">Debit</option>
                    {voucherTypeMap.map(voucher => {
                        return <option key={voucher}
                                       value={voucher.key}>{voucher.name}</option>
                    })}
                </select>
            </ContainerDivMD6>
            <ContainerDivMD6>
                <label className="form-label">Creation Date</label>

                <input required={true} className="form-control" type="date" ref={creationDateRef}
                       name="Creation Date"
                       value={creationDateValue}
                       onChange={(event) => setCreationDateValue(event.target.value)}/>

            </ContainerDivMD6>


            <ContainerDivMD6>
                <label className="form-label">
                    Requestor
                </label>
                <select className="form-select" ref={requestorRef} name="Requestor" value={requestorValue}
                        onChange={(event) => setRequestorValue(event.target.value)}>
                    <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                    {requestorMap.map(requestor => {
                        return <option key={requestor.key}
                                       value={requestor.key}>{requestor.name}</option>
                    })}
                </select>
            </ContainerDivMD6>
            <ContainerDivMD6>
                <label className="form-label">
                    Dept
                </label>
                <select className="form-select" ref={deptRef} name="Dept" value={deptValue}
                        onChange={(event) => setDeptValue(event.target.value)}>
                    <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                    <option value="cndnisdept">IS</option>
                    <option value="cndncsadept">CSA</option>
                    {deptMap.map(dept => {
                        return <option key={dept.key}
                                       value={dept.key}>{dept.name}</option>
                    })}
                </select>
            </ContainerDivMD6>

            <ContainerDivMD6>
                <label className="form-label">
                    Customer Name
                </label>
                <select className="form-select" ref={custNameRef} name="Customer Name" value={custNameValue}
                        onChange={(event) => setCustNameValue(event.target.value)}>
                    <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                    {custNameMap.map(customer => {
                        return <option key={customer.key}
                                       value={customer.key}>{customer.name}</option>
                    })}
                </select>
            </ContainerDivMD6>
            <ContainerDivMD6>
                <label className="form-label">
                    Customer Code
                </label>
                <input className="form-control" ref={custCodeRef} type="text" readOnly={true} name="Customer Code"
                       value={custCodeValue}
                       onChange={event => setCustCodeValue(event.target.value)}/>
            </ContainerDivMD6>
            <ContainerDivMD6>
                <label className="form-label">
                    Currency
                </label>
                <select className="form-select" ref={currencyRef} name="Currency" value={currencyValue}
                        onChange={(event) => setCurrencyValue(event.target.value)}>
                    <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                    {currencyValueMap.map(currency => {
                        return <option key={currency.key}
                                       value={currency.key}>{currency.name}</option>
                    })}
                </select>
            </ContainerDivMD6>

            {(deptValue && deptValue === "cndncsadept") &&
                <>
                    <h5>CSA DEPT INFORMATION</h5>
                    <div className="col-12">
                        <button ref={csaItemButtonRef} className="btn btn-primary" id={"newItemCsa"} type={"button"}
                                onClick={(event) => setCsaItemModalValue(true)}>+ New
                        </button>
                    </div>
                    {csaItemModalValue &&
                        <>
                            <Modal centered={true} show={csaItemModalValue} onHide={csaModalClose}>
                                <Modal.Header closeButton>
                                    <Modal.Title>Add new CSA item</Modal.Title>
                                </Modal.Header>
                                <Modal.Body>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Category
                                            </label>
                                            <select className="form-select" ref={categoryRef} name="Category"
                                                    value={categoryValue}
                                                    onChange={(event) => setCategoryValue(event.target.value)}>
                                                <option value={defaultSelectValue}
                                                        selected={true}>{defaultSelectOption}</option>
                                                {categoryValueMap.map(cat => {
                                                    return <option key={cat.key}
                                                                   value={cat.key}>{cat.name}</option>
                                                })}
                                            </select>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Description
                                            </label>
                                            <input className="form-control" ref={itemDescriptionRef} type="text"
                                                   name="Item Desc"
                                                   value={itemDescriptionValue}
                                                   onChange={event => setItemDescriptionValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Customer Part Number
                                            </label>
                                            <input className="form-control" ref={customerPartNoRef}
                                                   name="Customer part Number"
                                                   value={customerPartValue}
                                                   onChange={(event) => setCustomerPartValue(event.target.value)}>
                                            </input>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Customer PO Number
                                            </label>
                                            <input className="form-control" ref={customerPONoRef} type="text"
                                                   name="Customer po number"
                                                   value={customerPONoValue}
                                                   onChange={event => setCustomerPONoValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Item Number
                                            </label>
                                            <input className="form-control" ref={itemNoRef} type="text"
                                                   name="Item no"
                                                   value={itemNoValue}
                                                   onChange={event => setItemNoValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Invoice Number
                                            </label>
                                            <input className="form-control" ref={invoiceNoRef} type="text"
                                                   name="Invoice Number"
                                                   value={invoiceNoValue}
                                                   onChange={event => setInvoiceNoValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Invoice Date
                                            </label>
                                            <input className="form-control" ref={invoiceDateRef} type="date"
                                                   name="Invoice Date"
                                                   value={invoiceDateValue}
                                                   onChange={event => setInvoiceDateValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Quantity
                                            </label>
                                            <input className="form-control" ref={quantityRef} type="number"
                                                   name="Quantity"
                                                   value={quantityValue}
                                                   onChange={event => setQuantityValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Unit Price
                                            </label>
                                            <input className="form-control" ref={unitPriceRef} type="number"
                                                   name="Unit Price"
                                                   value={unitPriceValue}
                                                   onChange={event => setUnitPriceValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Total Price
                                            </label>
                                            <input className="form-control" ref={totalPriceRef} type="number"
                                                   name="Total Price"
                                                   value={totalPriceValue}
                                                   onChange={event => setTotalPriceValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Remarks
                                            </label>
                                            <input className="form-control" ref={remarksRef} type="number"
                                                   name="Item Remarks"
                                                   value={remarksValue}
                                                   onChange={event => setRemarksValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Attachments
                                            </label>
                                            <input className="form-control" name="Attachments"
                                                   ref={cndnItemAttachmentsRef}
                                                   type={"file"} multiple
                                                   accept="application/pdf"
                                                   onChange={(event => setCndnItemAttachmentsValue(Array.from(event.target.files)))}/>
                                        </ContainerDivMD6>
                                    </div>
                                </Modal.Body>
                                <Modal.Footer>
                                    <Button variant="secondary" onClick={csaModalClose}>
                                        Close
                                    </Button>
                                    <Button variant="primary" onClick={csaModalClose}>
                                        Save
                                    </Button>
                                </Modal.Footer>
                            </Modal>
                        </>
                    }
                    <div>
                        <table className={"table table-responsive"}>
                            <thead>
                            <tr>
                                <th>Select</th>
                                <th>Item Number</th>
                                <th>Customer Part Number</th>
                                <th>Customer PO Number</th>
                                <th>Invoice Number</th>
                                <th>Invoice Date</th>
                                <th>Quantity</th>
                                <th>Unit Price</th>
                                <th>Total Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>

                    <ContainerDivMD6>
                        <label className="form-label">
                            Reason
                        </label>
                        <select className="form-select" ref={reasonRef} name="Reason" value={reasonValue}
                                onChange={(event) => setReasonValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            <option value="others">Others</option>
                            {reasonValueMap.map(reason => {
                                return <option key={reason.key}
                                               value={reason.key}>{reason.name}</option>
                            })}
                        </select>
                    </ContainerDivMD6>
                    {(reasonValue && reasonValue === "others") &&
                        <ContainerDivMD6>
                            <label className="form-label">
                                Please specify others
                            </label>
                            <input className="form-control" name="Please Specify Others" ref={specifyOtherRef}
                                   type="text"
                                   value={specifyOtherValue}
                                   onChange={(event) => setSpecifyOtherValue(event.target.value)}/>
                        </ContainerDivMD6>
                    }


                    <ContainerDivMD6>
                        <label className="form-label">
                            Verification And Confirmed By
                        </label>
                        <select className="form-select" ref={verificationByRef}
                                name="Verification And Confirmed By"
                                value={verificationByValue}
                                onChange={(event) => setVerificationByValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            {verificationByValueMap.map(verBy => {
                                return <option key={verBy.key}
                                               value={verBy.key}>{verBy.name}</option>
                            })}
                        </select>
                    </ContainerDivMD6>
                    <ContainerDivMD6>
                        <label className="form-label">
                            Attachments
                        </label>
                        <input className="form-control" name="Attachments" ref={cndnNoteAttachmentsRef}
                               type={"file"} multiple
                               accept="application/pdf"
                               onChange={(event => setCndnNoteAttachmentsValue(Array.from(event.target.files)))}/>
                    </ContainerDivMD6>


                    <ContainerDivMD4>
                        <label className="form-label">
                            Sales Director
                        </label>
                        <select className="form-select" ref={salesDirectorRef} name="Sales Director"
                                value={salesDirectorValue}
                                onChange={(event) => setSalesDirectorValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            {salesDirectorValueMap.map(dir => {
                                return <option key={dir.key}
                                               value={dir.key}>{dir.name}</option>
                            })}
                        </select>
                    </ContainerDivMD4>
                    <ContainerDivMD4>
                        <label className="form-label">
                            Finance Controller
                        </label>
                        <select className="form-select" ref={financeControllerRef} name="Finance Controller"
                                value={financeControllerValue}
                                onChange={(event) => setFinanceControlValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            {financeControllerValueMap.map(con => {
                                return <option key={con.key}
                                               value={con.key}>{con.name}</option>
                            })}
                        </select>
                    </ContainerDivMD4>
                    <ContainerDivMD4>
                        <label className="form-label">
                            General Manager
                        </label>
                        <select className="form-select" ref={generalManagerRef} name="General Manager"
                                value={generalManagerValue}
                                onChange={(event) => setGeneralManagerValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            {generalManagerValueMap.map(man => {
                                return <option key={man.key}
                                               value={man.key}>{man.name}</option>
                            })}
                        </select>
                    </ContainerDivMD4>


                    <ContainerDivMD6>
                        <label className="form-label">
                            Description
                        </label>
                        <input className="form-control" name="Description" ref={noteDescriptionRef} type="text"
                               value={noteDescriptionValue}
                               onChange={(event) => setNoteDescriptionValue(event.target.value)}/>
                    </ContainerDivMD6>
                    <ContainerDivMD6>
                        <label className="form-label">
                            Stock Adjustment
                        </label>
                        <select className="form-select" ref={stockAdjustmentRef} name="Stock Adjustment"
                                value={stockAdjustmentValue}
                                onChange={(event) => setStockAdjustmentValue(event.target.value)}>
                            <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                            <option value="yes">Yes</option>
                            <option value="no">No</option>
                        </select>
                    </ContainerDivMD6>

                    {(stockAdjustmentValue && stockAdjustmentValue === "yes") &&
                        <>
                            <ContainerDivMD6>
                                <label className="form-label">
                                    Location
                                </label>
                                <input className="form-control" ref={locationRef} type={"text"} name={"Location"}
                                       value={locationValue}
                                       onChange={(event) => setLocationValue(event.target.value)}/>
                            </ContainerDivMD6>
                            <ContainerDivMD6>
                                <label className="form-label">
                                    Lot Serial
                                </label>
                                <input className="form-control" ref={lotSerialRef} type={"text"} name={"Lot Serial"}
                                       value={lotSerialValue}
                                       onChange={(event) => setLotSerialValue(event.target.value)}/>
                            </ContainerDivMD6>
                        </>
                    }
                </>
            }

            {deptValue && deptValue === "cndnisdept" &&
                <>
                    <h5>IS DEPT INFORMATION</h5>
                    <div className="col-12">
                        <button ref={isItemButtonRef} className="btn btn-primary" id={"newItemIs"} type={"button"}
                                onClick={(event) => setIsItemModalValue(true)}>+ New
                        </button>
                    </div>
                    {isItemModalValue &&
                        <>
                            <Modal className={"modal-width"} show={isItemModalValue} onHide={isModalClose} centered={true}>
                                <Modal.Header closeButton>
                                    <Modal.Title>Add new IS item</Modal.Title>
                                </Modal.Header>
                                <Modal.Body>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Category
                                            </label>
                                            <select className="form-select" ref={categoryRef} name="Category"
                                                    value={categoryValue}
                                                    onChange={(event) => setCategoryValue(event.target.value)}>
                                                <option value={defaultSelectValue}
                                                        selected={true}>{defaultSelectOption}</option>
                                                {categoryValueMap.map(cat => {
                                                    return <option key={cat.key}
                                                                   value={cat.key}>{cat.name}</option>
                                                })}
                                            </select>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Description
                                            </label>
                                            <input className="form-control" ref={itemDescriptionRef} type="text"
                                                   name="Item Desc"
                                                   value={itemDescriptionValue}
                                                   onChange={event => setItemDescriptionValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD4>
                                            <label className="form-label">
                                                Quantity
                                            </label>
                                            <input className="form-control" ref={quantityRef} type="number"
                                                   name="Quantity"
                                                   value={quantityValue}
                                                   onChange={event => setQuantityValue(event.target.value)}/>
                                        </ContainerDivMD4>
                                        <ContainerDivMD4>
                                            <label className="form-label">
                                                Unit Price
                                            </label>
                                            <input className="form-control" ref={unitPriceRef} type="number"
                                                   name="Unit Price"
                                                   value={unitPriceValue}
                                                   onChange={event => setUnitPriceValue(event.target.value)}/>
                                        </ContainerDivMD4>
                                        <ContainerDivMD4>
                                            <label className="form-label">
                                                Total Price
                                            </label>
                                            <input className="form-control" ref={totalPriceRef} type="number"
                                                   name="Total Price"
                                                   value={totalPriceValue}
                                                   onChange={event => setTotalPriceValue(event.target.value)}/>
                                        </ContainerDivMD4>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Remarks
                                            </label>
                                            <input className="form-control" ref={remarksRef} type="number"
                                                   name="Item Remarks"
                                                   value={remarksValue}
                                                   onChange={event => setRemarksValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Attachments
                                            </label>
                                            <input className="form-control" name="Attachments"
                                                   ref={cndnItemAttachmentsRef}
                                                   type={"file"} multiple
                                                   accept="application/pdf"
                                                   onChange={(event => setCndnItemAttachmentsValue(Array.from(event.target.files)))}/>
                                        </ContainerDivMD6>
                                    </div>
                                </Modal.Body>
                                <Modal.Footer>
                                    <Button variant="secondary" onClick={isModalClose}>
                                        Close
                                    </Button>
                                    <Button variant="primary" onClick={isModalClose}>
                                        Save
                                    </Button>
                                </Modal.Footer>
                            </Modal>
                        </>
                    }
                    <table className={"table"}>
                        <thead>
                        <tr>
                            <th>Select</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </>
            }
            <div className="col-12">
                <button className="btn btn-primary" id={"submitBtn"} type={"submit"}>Submit</button>
            </div>
        </form>
    )
}
export default DigitusCNDNForm