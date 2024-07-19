package com.na.common.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import javax.validation.metadata.ReturnValueDescriptor;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)


public class NaSiteCategory implements ConfigurationCategory {
	
	
	 private static final String CATEGORY_KEY = "na-configuration";
	 private static final String CATEGORY_SECTION= "nla";
	
	@Override
	public String getCategoryKey() {
		return CATEGORY_KEY;
		
	}
	@Override
	public String getCategorySection() {
		return CATEGORY_SECTION;
	}
	
	@Override
	public String getCategoryIcon() {
		return "envelope-closed";
	}
	
	

}
