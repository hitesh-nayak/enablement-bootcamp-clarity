import React, {useEffect, useRef, useState} from 'react'
import ClayButton from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import {Text} from '@clayui/core';
import {docsGet} from './docsGet';
import {docsDelete} from './docsDelete';
import {docsPost} from './docsPost';
import {docsUpdate} from './docsUpdate';


const Documents = () => {

    const body = new FormData();
    let updateVal;
    let data = [];
    const [items, setItems] = useState([]);
    const [uId, setUId] = useState('');
    var fileRef = useRef(null);

    const getDocs = () => {
        docsGet()
            .then(function (json) {
                data = json.items;
                console.log('hi')
                setItems(data);
            })
    }

    const deleteDoc = (e) => {
        docsDelete(e)
            .then(Response => console.log(Response.status))
    }

    const uploadDoc = () => {
        if (uId && updateVal == 'update') {
            docsUpdate(uId, body)
                .then(json => console.log(json))
            setUId('');

        } else if (updateVal == 'submit') {

            docsPost(body)
                .then(json => console.log(json))
            setUId('')

        }
    }

    useEffect(() => {
        getDocs();
    }, data)

    useEffect(() => {
        uploadDoc();
    }, data)


    return (<div style={{marginLeft: '2px'}}>
        <h1 style={{marginBottom: '1rem'}}>Documents and Media</h1>
        <form action="" id='formm' onSubmit={(e) => {


        }}>
            <ClayForm.Group>
                <ClayInput
                    id="basicInputText"
                    placeholder="DO NOT ENTER IF YOU ARE NOT UPDATING A DOCUMENT"
                    type="text"
                    value={uId}
                    onChange={(e) => {
                        setUId(e.target.value)
                    }}

                />

                <ClayInput
                    type="file"
                    ref={fileRef}
                    onChange={(e) => {
                        body.append('file', fileRef.current.files[0])
                        body.append('title', fileRef.current.value)
                    }}
                />
            </ClayForm.Group>

            <ClayButton displayType="primary" type='submit'
                        name='submit'
                        onClick={(e) => {
                            updateVal = e.target.name
                            uploadDoc();

                            setTimeout(() => {
                                getDocs();
                            }, 1000);
                        }}
            >
                Upload
            </ClayButton>

            <ClayButton displayType="primary" type='submit'
                        style={{marginLeft: '1rem'}}
                        name='update'
                        onClick={(e) => {
                            updateVal = e.target.name
                            uploadDoc();

                            setTimeout(() => {
                                getDocs();
                            }, 1000);
                        }}
            >
                Update Doc
            </ClayButton>


        </form>

        <div style={{marginTop: '4rem', marginBottom: '5rem'}}>
            <ClayButton displayType="primary"
                        onClick={getDocs}>
                Refresh Docs
            </ClayButton>
        </div>

        {items.map((doc) => {
            if (doc.encodingFormat == 'image/png' || doc.encodingFormat == 'image/jpg' || doc.encodingFormat == 'image/jpeg') {

                return <div className='docshitesh' key={doc.id}>
                    <h6>ID: {doc.id}</h6>

                    <div style={{position: 'relative'}}>
                        <img className='docimghitesh' src={doc.adaptedImages[1].contentUrl} alt=""/>
                    </div>

                    <div style={{borderTop: '2px solid', borderColor: '#0b5fff'}}>
                        <Text truncate>{doc.title}</Text>

                        <ClayButton displayType="primary"
                                    style={{float: 'right', marginTop: '2px', marginRight: '2px'}}
                                    name={doc.id}
                                    onClick={(e) => {

                                        deleteDoc(e.target.name);
                                        setTimeout(() => {
                                            getDocs();

                                        }, 1000);
                                    }}
                        >
                            Delete
                        </ClayButton>
                    </div>

                </div>
            } else {
                return <div className='docshitesh' key={doc.id}>
                    <h6>ID: {doc.id}</h6>

                    <div style={{position: 'relative'}}>
                        <img className='docimghitesh'
                             src="https://thumbs.dreamstime.com/b/document-icon-vector-stack-paper-sheets-illustration-131104983.jpg"
                             alt=""/>
                    </div>

                    <div style={{borderTop: '2px solid', borderColor: '#0b5fff'}}>
                        <Text truncate>{doc.title}</Text>

                        <ClayButton displayType="primary"
                                    style={{float: 'right', marginTop: '2px', marginRight: '2px'}}
                                    name={doc.id}
                                    onClick={(e) => {
                                        deleteDoc(e.target.name);
                                        setTimeout(() => {
                                            getDocs();

                                        }, 1000);

                                    }}
                        >
                            Delete
                        </ClayButton>
                    </div>
                </div>
            }

        })

        }

    </div>)
}

export default Documents
