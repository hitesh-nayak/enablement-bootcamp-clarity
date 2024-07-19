export function knowledgePost(body) {
    
        
    return Liferay.Util.fetch(
		`/o/headless-delivery/v1.0/sites/${Liferay.ThemeDisplay.getSiteGroupId()}/knowledge-base-articles`,
		{method: 'POST',
         headers:{
         'Content-Type':'application/json'
         },
         body
        }
	).then(res => res.json());


};