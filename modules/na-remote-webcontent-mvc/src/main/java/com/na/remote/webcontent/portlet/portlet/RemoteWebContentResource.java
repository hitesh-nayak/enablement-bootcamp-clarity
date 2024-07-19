package com.na.remote.webcontent.portlet.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.na.remote.webcontent.portlet.constants.RemoteWebContentPortletKeys;
import com.na.rwc.util.RWCUtil;
import com.na.rwc.util.WebContentDtoUtil;

import com.na.webcontent.remote.dto.v1_0.WebContent;

import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + RemoteWebContentPortletKeys.REMOTEWEBCONTENT,
		"mvc.command.name=/serve/webcontentjson" }, service = MVCResourceCommand.class)
public class RemoteWebContentResource implements MVCResourceCommand {

	private static Log log = LogFactoryUtil.getLog(RemoteWebContentResource.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		String fieldValue = ParamUtil.getString(resourceRequest, "articleTitle");
		System.out.println(fieldValue);
		
		if(fieldValue.equals("") || fieldValue.equals(null)) throw new PortletException("articleId not received.");
		
		WebContent wcPrime = new WebContent();
		WebContentDtoUtil contentDtoUtil = new WebContentDtoUtil();
		
		try {
			wcPrime = RWCUtil.getWebContentDtoByJournalArticleAticleId(fieldValue);
			contentDtoUtil = RWCUtil.getWCUtilDtoFromWC(wcPrime);

			JSONObject jsonObject = new JSONObject(
					new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(contentDtoUtil));
//			JSONObject jsonObject = new JSONObject(WebContentSerDes.toJSON(wcPrime));
			
			System.out.println("This is your JSON body--> start---> "+jsonObject+" <---end <-- End of your JSON body");
//
//			resourceRequest.setAttribute("WebContentDTOJSON", jsonObject.toString());
			
			PrintWriter printWriter = resourceResponse.getWriter();
			printWriter.println(jsonObject.toString());
			
			
			
		} catch (Exception e) {
			log.error(e);

			return true;
		}

		return false;
	}

	// your resource handling code
}