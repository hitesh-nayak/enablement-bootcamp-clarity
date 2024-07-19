package com.na.remotewc.web.portlet;

import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.na.email.commoncofig.EmailCommonConfig;
import com.na.email.commonconfig.component.EmailConfigProvider;
import com.na.remotewc.web.constants.RWCPortletKeys;
import com.na.remotewc.web.util.RWCUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;


/**
 * @author untodawn035
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RWC", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + RWCPortletKeys.RWC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class,
		configurationPid="com.na.email.commoncofig.EmailCommonConfig")
public class RWCPortlet extends MVCPortlet {

	Log log = LogFactoryUtil.getLog(RWCPortlet.class);
	
	
//	@Activate
//	@Modified
//	protected void activate(Map<String, Object> properties) {
//		
//		emailConfig = ConfigurableUtil.createConfigurable(EmailCommonConfig.class, properties);
//	}
//	
//	private volatile EmailCommonConfig emailConfig;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		log.info("Inside render method");
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
//			log.info("email is "+ emailConfig.emailConfig());
		
		log.info(configProvider.hrAdminEmailConfig());

		System.out.println(themeDisplay.getScopeGroupId());
//		String emailIs = getEmailConfig(themeDisplay.getCompanyId()).emailConfig();
		
		

		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = RWCPortletKeys.API_CALL_ACTION_NAME)
	public void apiCall(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, Exception {

		String fieldValue = ParamUtil.getString(actionRequest, RWCPortletKeys.ARTICLE_TITLE_NAMESPACE);
		
		
		try {

			URL url = new URL(RWCUtil.URL_LOCAL_FEDORA);
			// URL url = new URL(RWCUtil.URL_LOCAL_UBUNTU);
			// URL url = new URL(RWCUtil.URL_PROD);
			//URL url = new URL(RWCUtil.URL_STAGING);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(RWCUtil.REQUEST_TYPE_POST);
			connection.setRequestProperty(RWCUtil.CONTENT_TYPE_PROPERTY, RWCUtil.CONTENT_TYPE);
			connection.setRequestProperty(RWCUtil.AUTHORIZATION_PROPERTY, RWCUtil.getBearerTokenFedora());
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			String requestBody = RWCUtil.getHttpRequestBody(fieldValue);
			outputStream.write(requestBody.getBytes(RWCUtil.CHARACTER_ENCODING_UTF8));
			outputStream.close();

			int responseCode = connection.getResponseCode();
			InputStream inputStream;
			if (responseCode >= 200 && responseCode < 400) {

				inputStream = connection.getInputStream();
			} else {

				inputStream = connection.getErrorStream();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder responseBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				responseBuilder.append(line);
			}
			reader.close();
			String response = responseBuilder.toString();

			log.info("Response code: " + responseCode);
			log.info("Response body: " + response);

			connection.disconnect();
		} catch (Exception e) {
			log.error(e.getMessage());

		}

	}

	public EmailCommonConfig getEmailConfig(long groupId) throws ConfigurationException {
		
	return configurationProvider.getSystemConfiguration(EmailCommonConfig.class);
		
		
		
	}
@Reference
ConfigurationProvider configurationProvider;

@Reference
EmailConfigProvider configProvider;


}