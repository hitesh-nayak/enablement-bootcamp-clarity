package com.na.email.commonconfig.component;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.na.email.commoncofig.EmailCommonConfig;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(immediate = true, service = EmailConfigProvider.class, configurationPid = "com.na.email.commoncofig.EmailCommonConfig")

public class EmailConfigComponent implements EmailConfigProvider {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {

		emailConfig = ConfigurableUtil.createConfigurable(EmailCommonConfig.class, properties);
	}

	private volatile EmailCommonConfig emailConfig;

	@Override
	public String hrAdminEmailConfig() {
		
		return emailConfig.hrAdminEmailConfig();
	}

	@Override
	public String internshipAdminEmailConfig() {
		
		return emailConfig.internshipAdminEmailConfig();
	}

	@Override
	public String procurementAdminEmailConfig() {
		
		return emailConfig.procurementAdminEmailConfig();
	}

	@Override
	public String oralHistoryAdminEmailConfig() {
		
		return emailConfig.oralHistoryAdminEmailConfig();
	}

	@Override
	public String researchAdminEmailConfig() {
		
		return emailConfig.researchAdminEmailConfig();
	}

	@Override
	public String liwaAdminEmailConfig() {
	
		return emailConfig.liwaAdminEmailConfig();
	}

	@Override
	public String outreachAdminEmailConfig() {
		
		return emailConfig.outreachAdminEmailConfig();
	}

	@Override
	public String educationAdminEmailConfig() {
		
		return emailConfig.educationAdminEmailConfig();
	}

	@Override
	public String communicationAdminEmailConfig() {
		
		return emailConfig.communicationAdminEmailConfig();
	}

	@Override
	public String archAndDocAdminEmailConfig() {
		
		return emailConfig.archAndDocAdminEmailConfig();
	}

	@Override
	public String archiveAdminEmailConfig() {
		
		return emailConfig.archiveAdminEmailConfig();
	}

}
