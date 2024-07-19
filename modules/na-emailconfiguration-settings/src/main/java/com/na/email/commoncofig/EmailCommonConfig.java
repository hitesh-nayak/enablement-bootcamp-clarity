package com.na.email.commoncofig;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "na-configuration", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)

@Meta.OCD(id = "com.na.email.commoncofig.EmailCommonConfig", name = "Email Settings")

public interface EmailCommonConfig {

	@Meta.AD(required = false, description = "Provide email for HR Admin.", name = "HR Admin Email")

	public String hrAdminEmailConfig();

	@Meta.AD(required = false, description = "Provide email for Internship Admin.", name = "Internship Admin Email")

	public String internshipAdminEmailConfig();

	@Meta.AD(required = false, description = "Provide email for Procurement Admin.", name = "Procurement Admin Email")

	public String procurementAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Oral History Admin.", name = "Oral History Admin Email")

	public String oralHistoryAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Research Admin.", name = "Research Admin Email")

	public String researchAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Liwa Admin.", name = "Liwa Admin Email")

	public String liwaAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Outreach Admin.", name = "Outreach Admin Email")

	public String outreachAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Education Admin.", name = "Education Admin Email")

	public String educationAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Communication Admin.", name = "Communication Admin Email")

	public String communicationAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Archiving and Documentation Admin.", name = "Archiving and Documentation Admin Email")

	public String archAndDocAdminEmailConfig();
	
	@Meta.AD(required = false, description = "Provide email for Archive Admin.", name = "Archive Admin Email")

	public String archiveAdminEmailConfig();

	

}
