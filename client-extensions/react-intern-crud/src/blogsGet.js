export function blogsGet() {
    

    return Liferay.Util.fetch(
		`/o/headless-delivery/v1.0/sites/${Liferay.ThemeDisplay.getSiteGroupId()}/blog-postings`,
		{method: 'GET'}
	).then(res => res.json());
        


};