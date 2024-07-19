package com.na.remote.webcontent.portlet.portlet;

import com.na.remote.webcontent.portlet.constants.RemoteWebContentPortletKeys;
import com.na.rwc.util.RWCUtil;
import com.na.webcontent.remote.resource.v1_0.WebContentResource;

import java.io.IOException;

import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author untodawn035
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RemoteWebContent", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RemoteWebContentPortletKeys.REMOTEWEBCONTENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class RemoteWebContentPortlet extends MVCPortlet {
	Log log = LogFactoryUtil.getLog(RemoteWebContentPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.render(renderRequest, renderResponse);
	}

//	private  List<JournalArticle> getArticlesByQuery(String articleId) {
//
//		List<JournalArticle> articleList = new ArrayList<>();
//		try {
//			Order order = OrderFactoryUtil.desc("createDate");
//
//			ClassLoader classLoader = getClass().getClassLoader();
//			DynamicQuery query = DynamicQueryFactoryUtil.forClass(JournalArticle.class, classLoader)
//					.add(RestrictionsFactoryUtil.eq("articleId", articleId)).addOrder(order);
//
//			articleList = JournalArticleLocalServiceUtil.dynamicQuery(query);
//			if (articleList.isEmpty())
//				throw new NoSuchCollectionException();
//		} catch (NoSuchCollectionException e) {
//
//			
//		}
//
//		return articleList;
//
//	}

	@ProcessAction(name = "apiCall")
	public void apiCall(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, Exception {

//		String fieldValue = ParamUtil.getString(actionRequest, "articleTitle");
//
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//		WebContentResource.Builder builder = WebContentResource.builder().user(themeDisplay.getUser());
//
//		WebContentResource webres = builder.build();
//
//		RWCUtil.getWebContentDtoByJournalArticleAticleId(fieldValue);

//		System.out.println(webres.getWebContent(fieldValue));

//		$.ajax({
//		    url: 'http://192.168.122.1:8080/o/na-webContent-remote-REST/v1.0/webContent',
//		    headers:{
//		        "Content-Type": "application/json",
//		        "Authorization": `Bearer ${''}`
//		     },
//		    method: 'POST',
//		    dataType: 'json',
//		    data: JSON.stringify(jsonObj),
//		    success: function(data){
//		      console.log('succes: '+data);
//		    }
//		  });

//		System.out.println(RWCUtil.getWebContentDtoByJournalArticleAticleId(getArticlesByQuery(fieldValue)));
//		System.out.println(webres.postWebContent(RWCUtil.getWebContentDtoByJournalArticleAticleId(getArticlesByQuery(fieldValue))));

//		System.out.println(RWCUtil.getWebContentDtoByJournalArticleAticleId(fieldValue));

//		String fieldValue = ParamUtil.getString(actionRequest, "articleTitle");
//		JournalArticle articlePrime = null;
//		WebContent wcprime = new WebContent();
//		Double articleVersion = 0.0;
//		System.out.println("SUCCESS");
//		System.out.println(fieldValue);
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		try {
//			List<JournalArticle> articleList = this.getArticlesByQuery(fieldValue);
//			for (JournalArticle article : articleList) {
//
//				if (articleVersion < article.getVersion()) {
//					articlePrime = article;
//				}
//				articleVersion = article.getVersion() > articleVersion ? article.getVersion() : articleVersion;
//
//				System.out.println(articlePrime.getContent());
//				System.out.println("****************************");
//				System.out.println(articlePrime.getTitle("ar_SA"));
//				System.out.println("****************************");
//				System.out.println(articlePrime.getTitle("en_US"));
//				System.out.println("****************************");
//				System.out.println(articlePrime.getTitle());
////				System.out.println(articlePrime.getContentByLocale("en_US"));
//				System.out.println(articleVersion);
//
//				if (Validator.isNotNull(articlePrime)) {
//					wcprime.setClassNameIdwc(articlePrime.getClassNameId());
//					wcprime.setClassPKwc(articlePrime.getClassPK());
//					wcprime.setUuIdwc(articlePrime.getUuid() + StringUtil.randomString(5));
//					wcprime.setContentPrimarywc(articlePrime.getContent());
//					wcprime.setContentSecondarywc(article.getContentByLocale("en_US"));
//					wcprime.setDdmStructureIDwc(articlePrime.getDDMStructure().getStructureId());
//					wcprime.setDdmTemplateKeywc(articlePrime.getDDMTemplateKey());
//
//					wcprime.setDescLangPrimarywc(articlePrime.getDescription(LocaleUtil.fromLanguageId("ar_SA")));
//					wcprime.setDescLangSecondarywc(articlePrime.getDescription(LocaleUtil.fromLanguageId("en_US")));
//
//					wcprime.setDispDatewc(articlePrime.getDisplayDate());
//
//					wcprime.setModDatewc(articlePrime.getModifiedDate());
//
//					wcprime.setFolderIdwc(articlePrime.getFolderId());
//					wcprime.setFUrlLangPrimarywc(
//							articlePrime.getFriendlyURLMap().get(LocaleUtil.fromLanguageId("ar_SA"))+StringUtil.randomString(10));
//					wcprime.setFUrlLangSecondarywc(
//							articlePrime.getFriendlyURLMap().get(LocaleUtil.fromLanguageId("en_US"))+StringUtil.randomString(10));
//					wcprime.setGroupIdwc(articlePrime.getGroupId());
//					wcprime.setUserIdwc(articlePrime.getUserId());
//					wcprime.setNeverReviewwc(true);
//					wcprime.setIndexablewc(articlePrime.getIndexable());
//					wcprime.setSmallImagewc(articlePrime.getSmallImage());
//					wcprime.setDefLang(articlePrime.getDefaultLanguageId());
//
//					wcprime.setTitleLangPrimarywc(articlePrime.getTitle("ar_SA"));
//					wcprime.setTitleLangSecondarywc(articlePrime.getTitle("en_US"));
//				
//
//				}
//
//			}
//			WebContentResource.Builder builder = WebContentResource.builder().user(themeDisplay.getUser());
//
//			WebContentResource webres = builder.build();
//
//			webres.postWebContent(wcprime);
//
//		} catch (Exception e) {
//
//			log.error(e);
//		}

//		HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(actionResponse);
//		httpRes.addHeader(javax.ws.rs.core.HttpHeaders.CONTENT_LANGUAGE, LocaleUtil.toW3cLanguageId(Locale.US));

//		String [] localeArray = new String [] {LocaleUtil.US.toString(), LocaleUtil.fromLanguageId("ar_SA").toString()};
//		System.out.println(LocaleUtil.fromLanguageId("ar_SA").getCountry().toString());

//		ContentLanguageUtil.addContentLanguageHeader(localeArray, themeDisplay.getLocale().toString(), PortalUtil.getHttpServletResponse(actionResponse), LocaleUtil.US);

//		StructuredContentResource.Builder structuredContentBuilder = _structuredContentResourceFactory.create();
//		StructuredContentResource contentResource = structuredContentBuilder.user(themeDisplay.getUser()).build();
//
//		BlogPostingResource.Builder blogpoBuilder = _blogFactory.create();
//		BlogPostingResource blogPostingResource = blogpoBuilder.user(themeDisplay.getUser()).httpServletRequest(PortalUtil.getHttpServletRequest(actionRequest).authenticate(PortalUtil.getHttpServletResponse(actionResponse)));

//		contentResource.setContextHttpServletResponse(PortalUtil.getHttpServletResponse(actionResponse));
//		StructuredContentResource.Builder strBuilder = StructuredContentResource.builder();
//		JournalArticle article = JournalArticleLocalServiceUtil.getJournalArticle(structuredContentId);
//		StructuredContent d=null;
//		d.set
//		Creator c=null;
//		c.set

//		DToCo
//		ContentLanguageUtil

//		DTOConverter converter=null;
//		com.liferay.portal.vulcan.dto.converter.DTOConverterRegistry
//		DTOConverter converter = c.getDTOConverter("StructuredContent");

//		JournalArticle journalArticle = JournalArticleLocalServiceUtil.getJournalArticle(structuredContentId);
//		StructuredContent structuredContent = (StructuredContent) converter.toDTO(journalArticle);
//		StructuredContentResource.Builder builder = StructuredContentResource.builder().user(themeDisplay.getUser()).preferredLocale(LocaleUtil.US);
//		StructuredContentResource contentRes = builder.build();

//		contentRes.setContextHttpServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
//		contentRes.setContextHttpServletResponse(PortalUtil.getHttpServletResponse(actionResponse));
//
//				Sort [] sortarr = new Sort[] {new Sort("dateModified",true)};
//		Page<StructuredContent> articlePage = contentRes.getSiteStructuredContentsPage(20121L,true,fieldValue, null, null, Pagination.of(1, 10), null);
//			
//		Collection<StructuredContent> list = articlePage.getItems();
//		
//		for(StructuredContent content: list) {
//			System.out.println("---------------");

//			String [] lang = new String [] {"ar-SA", "en-US"};
//			content.setAvailableLanguages(lang);

//			System.out.println(content);
//			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(content.toDTO(json));

//			System.out.println("**********************");
//			System.out.println(JSONFactoryUtil.createJSONArray(content.toString()).toString());
//			System.out.println("*******************");

//			contentRes.postSiteStructuredContentBatch(20121L, "https://facebook.com", JSONFactoryUtil.createJSONArray(content.toString()));
//			contentRes.postSiteStructuredContent(20121L, content.toDTO(content.toString()));
//			System.out.println(contentRes.postSiteStructuredContent(20121L, content));
//		}
//		
//		try {
//			List<JournalArticle> list = getArticlesByQuery(fieldValue);
//			for (JournalArticle j : list) {
//				j.setId(CounterLocalServiceUtil.increment());
//				j.setArticleId(CounterLocalServiceUtil.increment() + "");
//				j.setUuid(CounterLocalServiceUtil.increment("uuId", 20) + "");
//				JournalArticleLocalServiceUtil.addJournalArticle(j);
//			}
//		System.out.println(blogPostingResource.getBlogPosting(structuredContentId));
//		System.out.println(JournalArticleLocalServiceUtil.getJournalArticle(structuredContentId));
//		System.out.println(this.getArticlesByQuery(structuredContentId.toString()));
//		System.out.println(contentResource.getStructuredContent(structuredContentId));
//			StructuredContent content = (StructuredContent) converterRegistry.getDTOConverter("StructuredContent").toDTO(article);
//			System.out.println(content);
//			System.out.println(); 
//			System.out.println(articlePage.getItems());
//			
//			WebContentResource.Builder builder = 	 WebContentResource.builder().user(themeDisplay.getUser())
//					.preferredLocale(LocaleUtil.fromLanguageId("ar-SA"));
//			WebContentResource webres = builder.build();
//			WebContent webContent = new WebContent();
//			webres.setContextHttpServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
//			webres.setContextHttpServletResponse(PortalUtil.getHttpServletResponse(actionResponse));
//			webres.postWebContent(webContent);

//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
	
	

	@Reference
	private WebContentResource.Factory webContentResourceFactory;

}