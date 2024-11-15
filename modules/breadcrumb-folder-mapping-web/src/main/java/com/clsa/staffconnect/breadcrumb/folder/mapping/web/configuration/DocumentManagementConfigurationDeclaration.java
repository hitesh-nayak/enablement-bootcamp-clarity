package com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

public class DocumentManagementConfigurationDeclaration implements ConfigurationPidMapping {

    @Override
    public Class getConfigurationBeanClass() {

        return DocumentManagementConfiguration.class;
    }

    @Override
    public String getConfigurationPid() {

        return "com.clsa.staffconnect.breadcrumb.folder.mapping.web.configuration.DocumentManagementConfiguration";
    }
}
