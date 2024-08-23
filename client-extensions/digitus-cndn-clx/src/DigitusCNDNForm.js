import {getDept, getVerificationBy} from "./getCNDNFormData";
import {getVoucherType} from "./getCNDNFormData";
import {getCustomerName} from "./getCNDNFormData";
import {getRequestor} from "./getCNDNFormData";
import {getReason} from "./getCNDNFormData";
import {getCurrency} from "./getCNDNFormData";
import React, {useEffect, useRef, useState} from "react";
import "bootstrap/dist/css/bootstrap.min.css"
import ContainerDivMD6 from "./ContainerDivMD6";
import ContainerDivMD4 from "./ContainerDivMD4";
import {Modal, Button} from "react-bootstrap";
import {
    createAttachments,
    saveAttachments,
    saveCNDNItems,
    saveDraftcndnApplication, updateCNDNNote
} from "./postCNDNFormData";
import {generateRandomString, getRenamedFile} from "./DigitusUtil";
import api from "./common/services/liferay/api";


const DigitusCNDNForm = () => {

    //DIGITUS CNDN FORM IMPLEMENTATION
    const defaultSelectOption = "Select";
    const defaultSelectValue = "-1";

    let voucherTypeRef = useRef(null);
    const [voucherTypeValue, setVoucherTypeValue] = useState("");
    const [voucherTypeMap, setVoucherTypeMap] = useState([]);
    const getVoucherTypeMap = () => {
        getVoucherType().then(function (json) {
            setVoucherTypeMap(json.items);
        })
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
        getRequestor().then(function (json) {

            setRequestorMap(json.items);

        })
    }
    useEffect(() => {
        getRequestorMap();
    }, [])

    let deptRef = useRef(null);
    const [deptValue, setDeptValue] = useState("");
    const [deptMap, setDeptMap] = useState([]);
    const getDeptMap = () => {
        getDept().then(function (json) {

            setDeptMap(json.items);

        })
    }
    useEffect(() => {
        getDeptMap();
    }, [])

    let custNameRef = useRef(null);
    const [custNameValue, setCustNameValue] = useState("");
    const [custNameMap, setCustNameMap] = useState([]);
    const getCustNameMap = () => {
        getCustomerName().then(function (json) {

            setCustNameMap(json.items);

        })
    }
    useEffect(() => {
        getCustNameMap();
    }, [])


    let custCodeRef = useRef(null);
    const [custCodeValue, setCustCodeValue] = useState("");

    function handleCustomerNameChange(event) {

        let custId = event.target.value;
        custNameMap.forEach(customer => {
            if (customer.id === Number(custId)) {
                setCustCodeValue(customer.customerCode);
                setCustNameValue(customer.id);

                setSalesDirectorValue(customer.salesDirectorUserId);
                setFinanceControlValue(customer.financeControllerUserId);
                setGeneralManagerValue(customer.generalManagerUserId);
            }
        })

    }

    let currencyRef = useRef(null);
    const [currencyValue, setCurrencyValue] = useState("");
    const [currencyValueMap, setCurrencyValueMap] = useState([]);
    const getCurrencyValueMap = () => {
        getCurrency().then(function (json) {

            setCurrencyValueMap(json.items);

        })
    }
    useEffect(() => {
        getCurrencyValueMap();
    }, [])


    let reasonRef = useRef(null);
    const [reasonValue, setReasonValue] = useState("");
    const [reasonValueMap, setReasonValueMap] = useState([]);
    const getReasonValueMap = () => {
        getReason().then(function (json) {

            setReasonValueMap(json.items);

        })
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
        getVerificationBy().then(function (json) {

            setVerificationByValueMap(json.items);

        })
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
        getCustomerName().then(function (json) {

            setSalesDirectorValueMap(json.items);

        })

    }
    useEffect(() => {
        getSalesDirectorValueMap();
    }, [])

    let financeControllerRef = useRef(null);
    const [financeControllerValue, setFinanceControlValue] = useState("");
    const [financeControllerValueMap, setFinanceControllerValueMap] = useState([]);
    const getFinanceControllerValueMap = () => {
        getCustomerName().then(function (json) {

            setFinanceControllerValueMap(json.items);

        })

    }
    useEffect(() => {
        getFinanceControllerValueMap();
    }, [])

    let generalManagerRef = useRef(null);
    const [generalManagerValue, setGeneralManagerValue] = useState("");
    const [generalManagerValueMap, setGeneralManagerValueMap] = useState([]);
    const getGeneralManagerValueMap = () => {
        getCustomerName().then(function (json) {

            setGeneralManagerValueMap(json.items);

        })

    }
    useEffect(() => {
        getGeneralManagerValueMap();
    }, [])


    let noteDescriptionRef = useRef(null);
    const [noteDescriptionValue, setNoteDescriptionValue] = useState("");

    let stockAdjustmentRef = useRef(null);
    const [stockAdjustmentValue, setStockAdjustmentValue] = useState("no");

    let locationRef = useRef(null);
    const [locationValue, setLocationValue] = useState("");

    let lotSerialRef = useRef(null);
    const [lotSerialValue, setLotSerialValue] = useState("");

    let categoryRef = useRef(null);
    const [categoryValue, setCategoryValue] = useState("");
    const [categoryValueMap, setCategoryValueMap] = useState([]);
    const getCategoryValueMap = () => {
        getDept().then(function (json) {

            setCategoryValueMap(json.items);

        })

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

    function handlePriceChange(event) {
        setUnitPriceValue(event.target.value);
        if (quantityValue && unitPriceValue) {
            setTotalPriceValue(JSON.stringify(Number(event.target.value) * Number(quantityValue)));
        }
    }

    let totalPriceRef = useRef(null);
    const [totalPriceValue, setTotalPriceValue] = useState("");

    let remarksRef = useRef(null);
    const [remarksValue, setRemarksValue] = useState("");

    let cndnItemAttachmentsRef = useRef(null);
    const [cndnItemAttachmentsValue, setCndnItemAttachmentsValue] = useState([]);

    const [csaItemsMap, setCsaItemsMap] = useState([]);
    const [isItemsMap, setIsItemsMap] = useState([]);
    const [cndnEntity, setCndnEntity] = useState({});

    let docNumberRef = useRef(null);
    const [docNumberValue, setDocNumberValue] = useState("");

    let csaItemButtonRef = useRef(null);
    const [csaItemModalValue, setCsaItemModalValue] = useState(false);
    const csaModalClose = () => setCsaItemModalValue(false);

    let isItemButtonRef = useRef(null);
    const [isItemModalValue, setIsItemModalValue] = useState(false);
    const isModalClose = () => setIsItemModalValue(false);


    const handleCNDNSubmission = (e) => {
        e.preventDefault();

        handleFiles(cndnNoteAttachmentsValue).then(function (resolve) {

            let cndnNote = {...cndnEntity};
            cndnNote.noteattachment = resolve;
            if (deptValue === "cndncsadept") {
                cndnNote.noteitem = csaItemsMap;
                cndnNote.description = noteDescriptionValue;
                cndnNote.financeController = financeControllerValue;
                cndnNote.generalManager = generalManagerValue;
                cndnNote.salesDirector = salesDirectorValue;
                if (stockAdjustmentValue === "no") cndnNote.stockAdjustment = false;
                if (stockAdjustmentValue === "yes") cndnNote.stockAdjustment = true;
                let reasonPicklist = {};
                if (reasonValue) {
                    let reasonType = "";
                    reasonValueMap.forEach(reason => {
                        if (reason.key === reasonValue) reasonType = reason.name;
                    })
                    if (reasonType) {
                        reasonPicklist.key = reasonValue;
                        reasonPicklist.name = reasonType;
                    }
                }
                cndnNote.reason = reasonPicklist;
                cndnNote.location = locationValue;
                cndnNote.lotSerial = lotSerialValue;
                cndnNote.verificationAndConfirmedBy = verificationByValue;

            }
            if (deptValue === "cndnisdept") cndnNote.noteitem = isItemsMap;
            setCndnEntity(cndnNote);

            updateCNDNNote(JSON.stringify(cndnNote), cndnNote.id).then(function (json) {
                window.location.reload();
            });

        });


    }

    function handleFiles(files) {
        return new Promise((resolve, reject) => {
            let cndnAttachments = [];
            if (files.length > 0) {
                files.map(itemAttachment => {
                    let body = new FormData();
                    let newName = generateRandomString(10) + itemAttachment.name;
                    body.append('file', getRenamedFile(itemAttachment, newName));
                    saveAttachments(body).then(json => {
                        let attachment = {}
                        attachment.attachment =
                            {
                                "id": json.id,
                                "name": json.title,
                                "link": {
                                    "href": json.contentUrl,
                                    "label": json.title
                                }
                            }
                        return createAttachments(JSON.stringify(attachment)).then(attachmentResponse => {
                            delete attachmentResponse['actions'];
                            delete attachmentResponse['creator'];
                            delete attachmentResponse['dateCreated'];
                            delete attachmentResponse['dateModified'];
                            cndnAttachments.push(attachmentResponse);

                            if (cndnAttachments.length === files.length) {
                                resolve(cndnAttachments);
                            }
                        })
                    });
                });

                // The below code does not work, present here for retrospection purpose. It does not work because promise is resolving before responses are available.
                // Promise.all(promises)
                //     .then(() => {
                //         resolve(cndnAttachments);
                //     })
                //     .catch(error => {
                //         reject(error);
                //     });
            } else {
                resolve(cndnAttachments);
            }
        });
    }


    function handleItemSave() {
        setCsaItemModalValue(false);
        setIsItemModalValue(false);

        let itemCategory = categoryValue;
        let itemDescription = itemDescriptionValue;
        let itemCustomerPartNo = customerPartValue;
        let itemCustomerPONo = customerPONoValue;
        let itemNo = itemNoValue;
        let itemInvoiceNo = invoiceNoValue;
        let itemInvoiceDate = invoiceDateValue;
        let itemQuantity = quantityValue;
        let itemUnitPrice = unitPriceValue;
        let itemTotalPrice = totalPriceValue;
        let itemRemarks = remarksValue;
        let itemAttachments = [...cndnItemAttachmentsValue];
        handleFiles(itemAttachments).then(function (resolver) {
            if (deptValue === "cndncsadept") {
                let modCsaMap = [...csaItemsMap];
                let csaItem = {};
                //if (itemCategory) csaItem.category = "CSA";
                csaItem.category = "CSA";
                if (itemDescription) csaItem.description = itemDescription;
                if (itemCustomerPartNo) csaItem.customerPartNumber = itemCustomerPartNo;
                if (itemCustomerPONo) csaItem.customerPONumber = itemCustomerPONo;
                if (itemNo) csaItem.itemNumber = itemNo;
                if (itemInvoiceNo) csaItem.invoiceNumber = itemInvoiceNo;
                if (itemInvoiceDate) csaItem.invoiceDate = itemInvoiceDate;
                if (itemQuantity) csaItem.quantity = Number(itemQuantity);
                if (itemUnitPrice) csaItem.unitPrice = Number(itemUnitPrice);
                if (itemTotalPrice) csaItem.totalPrice = Number(itemTotalPrice);
                if (itemRemarks) csaItem.remarks = itemRemarks;
                csaItem.itemattachment = resolver;

                saveCNDNItems(JSON.stringify(csaItem)).then(function (response) {
                    delete response['actions'];
                    delete response['creator'];
                    delete response['dateCreated'];
                    delete response['dateModified'];
                    modCsaMap.push(response);
                    setCsaItemsMap(modCsaMap);
                });

            }
            if (deptValue === "cndnisdept") {
                let modIsMap = [...isItemsMap];
                let isItem = {};
                //if (itemCategory) isItem.category = itemCategory;
                isItem.category = "IS";
                if (itemDescription) isItem.description = itemDescription;
                if (itemUnitPrice) isItem.unitPrice = Number(itemUnitPrice);
                if (itemTotalPrice) isItem.totalPrice = Number(itemTotalPrice);
                if (itemRemarks) isItem.remarks = itemRemarks;
                if (itemQuantity) isItem.quantity = Number(itemQuantity);


                isItem.itemattachment = resolver;

                saveCNDNItems(JSON.stringify(isItem)).then(function (response) {
                    delete response['actions'];
                    delete response['creator'];
                    delete response['dateCreated'];
                    delete response['dateModified'];
                    modIsMap.push(response);
                    setIsItemsMap(modIsMap);
                });

            }
        });


    }


    function handleInitialSave() {
        let testJson = {
            //Mandatory fields only
            "creationDate": "2024-08-16",
            "currency": {
                "key": "cndnsgd",
                "name": "SGD"
            },
            "dept": {
                "key": "cndnisdept",
                "name": "IS"
            },
            "requestor": "20122",
            "voucherType": {
                "key": "cndncredit",
                "name": "Credit"
            },
            "customerCode": "SONY3444",
            "customerName": "Sony",
            "approvalStatus": {
                "key": "draft",
                "name": "Draft"
            }
        }

        let requestBody = {};
        let currencyPicklist = {};
        let deptPicklist = {};
        let voucherPicklist = {};
        let approvalStatus = {
            "key": "draft",
            "name": "Draft"
        }
        if (creationDateValue) requestBody.creationDate = creationDateValue;
        if (currencyValue) {
            let currencyName = "";
            currencyValueMap.forEach(curr => {
                if (curr.key === currencyValue) currencyName = curr.name;
            })
            if (currencyName) {
                currencyPicklist.key = currencyValue;
                currencyPicklist.name = currencyName;
            }
        }
        if (deptValue) {
            let deptName = "";
            deptMap.forEach(dept => {
                if (dept.key === deptValue) deptName = dept.name;
            })
            if (deptName) {
                deptPicklist.key = deptValue;
                deptPicklist.name = deptName;
            }
        }
        if (voucherTypeValue) {
            let voucherName = "";
            voucherTypeMap.forEach(voucher => {
                if (voucher.key === voucherTypeValue) voucherName = voucher.name;
            })
            if (voucherName) {
                voucherPicklist.key = voucherTypeValue;
                voucherPicklist.name = voucherName;
            }
        }
        if (currencyPicklist) requestBody.currency = currencyPicklist;
        if (deptPicklist) requestBody.dept = deptPicklist;
        if (requestorValue) requestBody.requestor = requestorValue;
        if (voucherTypeValue) requestBody.voucherType = voucherPicklist;
        if (custCodeValue) requestBody.customerCode = custCodeValue;
        if (custNameValue) requestBody.customerName = custNameValue;
        requestBody.approvalStatus = approvalStatus;

        saveDraftcndnApplication(JSON.stringify(requestBody)).then(function (json) {
            delete json['actions'];
            delete json['creator'];
            delete json['dateCreated'];
            delete json['dateModified'];

            if (json.id) {
                if (voucherTypeValue === "cndndebit") {
                    setDocNumberValue("DN" + json.id);
                    json.documentNumber = "DN" + json.id;
                    setCndnEntity(json);
                }
                if (voucherTypeValue === "cndncredit") {
                    setDocNumberValue("CN" + json.id);
                    json.documentNumber = "CN" + json.id;
                    setCndnEntity(json);
                }
            }
        });

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
                    {voucherTypeMap.map(voucher => {
                        return <option key={voucher.key}
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
                        return <option key={requestor.id}
                                       value={requestor.id}>{requestor.name}</option>
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
                        onChange={(event) => handleCustomerNameChange(event)}>
                    <option value={defaultSelectValue} selected={true}>{defaultSelectOption}</option>
                    {custNameMap.map(customer => {
                        return <option key={customer.id}
                                       value={customer.id}>{customer.customerName}</option>
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
            <ContainerDivMD6>
                <label className="form-label">
                    Document Number
                </label>
                <input className="form-control" ref={docNumberRef} type="text" readOnly={true} name="Customer Code"
                       value={docNumberValue}
                       onChange={event => setDocNumberValue(event.target.value)}/>
            </ContainerDivMD6>

            <div className="col-12">
                <button className="btn btn-primary" id={"draftButton"} type={"button"} onClick={handleInitialSave}>Save
                    Draft
                </button>
            </div>

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
                                                <option value={"CSA"}
                                                        selected={true}>{"CSA"}</option>
                                                {/*{categoryValueMap.map(cat => {*/}
                                                {/*    return <option key={cat.key}*/}
                                                {/*                   value={cat.name}>{cat.name}</option>*/}
                                                {/*})}*/}
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
                                                   onChange={event => handlePriceChange(event)}/>
                                        </ContainerDivMD6>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Total Price
                                            </label>
                                            <input className="form-control" ref={totalPriceRef} type="number"
                                                   name="Total Price"
                                                   value={totalPriceValue}
                                                   readOnly={true}
                                                   onChange={event => setTotalPriceValue(event.target.value)}/>
                                        </ContainerDivMD6>
                                    </div>
                                    <div className={"row digitus-padded-div"}>
                                        <ContainerDivMD6>
                                            <label className="form-label">
                                                Remarks
                                            </label>
                                            <input className="form-control" ref={remarksRef} type="text"
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
                                    <Button variant="primary" onClick={handleItemSave}>
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
                            {csaItemsMap.map((item, index) => (
                                <tr key={index}>
                                    <td><input type={"checkbox"}/></td>
                                    <td>{item.itemNumber}</td>
                                    <td>{item.customerPartNumber}</td>
                                    <td>{item.customerPONumber}</td>
                                    <td>{item.invoiceNumber}</td>
                                    <td>{item.invoiceDate}</td>
                                    <td>{item.quantity}</td>
                                    <td>{item.unitPrice}</td>
                                    <td>{item.totalPrice}</td>
                                </tr>
                            ))}
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
                                return <option key={verBy.id}
                                               value={verBy.id}>{verBy.name}</option>
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
                                return <option key={dir.salesDirectorUserId}
                                               value={dir.salesDirectorUserId}>{dir.salesDirectorEmail}</option>
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
                                return <option key={con.financeControllerUserId}
                                               value={con.financeControllerUserId}>{con.financeControllerEmail}</option>
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
                                return <option key={man.generalManagerUserId}
                                               value={man.generalManagerUserId}>{man.generalManagerEmail}</option>
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
                            <Modal className={"modal-width"} show={isItemModalValue} onHide={isModalClose}
                                   centered={true}>
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
                                                <option value={"IS"}
                                                        selected={true}>{"IS"}</option>
                                                {/*{categoryValueMap.map(cat => {*/}
                                                {/*    return <option key={cat.key}*/}
                                                {/*                   value={cat.key}>{cat.name}</option>*/}
                                                {/*})}*/}
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
                                                   onChange={event => handlePriceChange(event)}/>
                                        </ContainerDivMD4>
                                        <ContainerDivMD4>
                                            <label className="form-label">
                                                Total Price
                                            </label>
                                            <input className="form-control" ref={totalPriceRef} type="number"
                                                   name="Total Price"
                                                   readOnly={true}
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
                                    <Button variant="primary" onClick={handleItemSave}>
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
                        {isItemsMap.map((item, index) => (
                            <tr key={index}>
                                <td><input type={"checkbox"}/></td>
                                <td>{item.description}</td>
                                <td>{item.quantity}</td>
                                <td>{item.unitPrice}</td>
                                <td>{item.totalPrice}</td>
                            </tr>
                        ))}
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