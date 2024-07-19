package com.na.panelcategory;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;


@Component(immediate = true, property = {
		
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
		"panel.category.order:Integer=300"
}, service = PanelCategory.class)



public class CustomSiteAdministratorPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return "Object";
	}

	@Override
	public String getLabel(Locale locale) {
		// TODO Auto-generated method stub
		return LanguageUtil.get(locale,"NLA" );
	}

}
