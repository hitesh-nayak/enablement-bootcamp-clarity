export function blogsPost(body) {
    
        
    return Liferay.Util.fetch(
		`/o/headless-delivery/v1.0/sites/${Liferay.ThemeDisplay.getSiteGroupId()}/blog-postings`,
		{method: 'POST',
         headers:{
         'Content-Type':'application/json'
         },
         body
        }
	).then(res => res.json());


};