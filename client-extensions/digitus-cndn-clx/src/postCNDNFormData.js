export function saveDraftcndnApplication(body){


    return fetch("http://localhost:8082/o/c/creditdebitnotes/",
        {method: 'POST',
            headers:{
                'Content-Type':'application/json',
                'Authorization': `Basic ${btoa('test@liferay.com:learn')}`
            },
            body
        })
        .then(Response => Response.json())
}

export function saveAttachments(body){

    return fetch("http://localhost:8082/o/headless-delivery/v1.0/sites/20117/documents",
        {method: 'POST',
            headers:{
                'Authorization': `Basic ${btoa('test@liferay.com:learn')}`
            },
            body
        })
        .then(Response => Response.json())
}

export function createAttachments(body){

    return fetch("http://localhost:8082/o/c/cndnattachments/",
        {method: 'POST',
            headers:{
                'Content-Type':'application/json',
                'Authorization': `Basic ${btoa('test@liferay.com:learn')}`
            },
            body
        })
        .then(Response => Response.json())
}

export function saveCNDNItems(body){
    console.log("checking body")
    console.log(body);

    return fetch("http://localhost:8082/o/c/creditdebititems/",
        {method: 'POST',
            headers:{
                'Content-Type':'application/json',
                'Authorization': `Basic ${btoa('test@liferay.com:learn')}`
            },
            body
        })
        .then(Response => Response.json())
}



export function saveCNDNNote(body){

    return fetch("http://localhost:8082/o/c/creditdebitnotes/",
        {method: 'POST',
            headers:{
                'Content-Type':'application/json',
                'Authorization': `Basic ${btoa('test@liferay.com:learn')}`
            },
            body
        })
        .then(Response => Response.json())
}

