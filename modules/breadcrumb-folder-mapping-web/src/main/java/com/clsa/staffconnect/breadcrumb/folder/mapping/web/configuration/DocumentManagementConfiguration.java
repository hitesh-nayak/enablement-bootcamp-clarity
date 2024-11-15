package com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "DOCUMENTMANAGEMENT", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration.DocumentManagementConfiguration", name = "doc-mng-settings")
public interface DocumentManagementConfiguration {


    @Meta.AD(deflt = "false", description = "doc-mng-desc", name = "doc-mng-enable-field")
    boolean enableAutoMapping();


}
