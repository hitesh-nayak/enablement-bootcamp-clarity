export function knowledgeGet() {
    
	
    return Liferay.Util.fetch(
		`/o/headless-delivery/v1.0/sites/${Liferay.ThemeDisplay.getSiteGroupId()}/knowledge-base-articles`,
		{method: 'GET'}
	).then(res => res.json());
        


};