package com.na.email.commonconfig.component;



import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface EmailConfigProvider {

	
	public String hrAdminEmailConfig();

	
	public String internshipAdminEmailConfig();

	
	public String procurementAdminEmailConfig();

	
	public String oralHistoryAdminEmailConfig() ;

	
	public String researchAdminEmailConfig();

	
	public String liwaAdminEmailConfig();
	
	public String outreachAdminEmailConfig();
	
	public String educationAdminEmailConfig();

	
	public String communicationAdminEmailConfig();

	
	public String archAndDocAdminEmailConfig();

	
	public String archiveAdminEmailConfig();
	
	

}
