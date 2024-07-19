package com.na.remotewc.headless.rest.internal.resource.v1_0;


import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;

import com.liferay.portal.kernel.util.StringUtil;
import com.na.remotewc.headless.rest.dto.v1_0.WebContent;
import com.na.remotewc.headless.rest.resource.v1_0.WebContentResource;
import com.na.remotewc.web.util.RWCUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author untodawn035
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/web-content.properties",
	scope = ServiceScope.PROTOTYPE, service = WebContentResource.class
)
public class WebContentResourceImpl extends BaseWebContentResourceImpl {
	private static final Log log = LogFactoryUtil.getLog(WebContentResourceImpl.class);
	
	@Override
	public WebContent postWebContent(WebContent wcprime) throws PortalException {
		
		String formattedContent =  "";
		

		JournalArticle articlePrime = RWCUtil.getJournalArticleFromWebContentDto(wcprime);

		JournalArticle responseArticle = null;

		ServiceContext context = new ServiceContext();
		context.setCompanyId(20096L);
		context.setScopeGroupId(20119L);
		context.setAddGuestPermissions(true);
		context.setAddGroupPermissions(true);
		
		List<FileEntry> fileEntries = new ArrayList<FileEntry>();

		try {

			fileEntries = RWCUtil.addFileEntries(wcprime);

		} catch (Exception e) {

			log.error(e.getMessage());
		}

		// <------------------Content Modification--------------------->
		try {
			 formattedContent = RWCUtil.getModifiedContent(articlePrime.getContent(), fileEntries);
		}
		catch(Exception e) {

			log.error(e.getMessage());
		}

		try {

			responseArticle = JournalArticleLocalServiceUtil.addArticle(StringUtil.randomString(20),articlePrime.getUserId(),
					articlePrime.getGroupId(), articlePrime.getFolderId(),  new HashMap<Locale, String>() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1234523631L;

						{
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getTitleLangPrimarywc());
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US),
									wcprime.getTitleLangSecondarywc());
						}
					}, new HashMap<Locale, String>() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1562778345L;

						{
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getDescLangPrimarywc());
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US),
									wcprime.getDescLangSecondarywc());
						}
					}, formattedContent , Long.parseLong(articlePrime.getDDMStructureKey()), articlePrime.getDDMTemplateKey(),
					context);

			return RWCUtil.getWebContentDtoByJournalArticleAticleId(responseArticle.getArticleId());

		} catch (Exception e) {
			log.error(e.getMessage());
			throw new PortalException("Addition Failed");
		}

	}

	@Override
	public WebContent getWebContent(String articleId) {
		WebContent wcprime = new WebContent();

		try {
			wcprime = RWCUtil.getWebContentDtoByJournalArticleAticleId(articleId);
			System.out.println(JournalArticleLocalServiceUtil.getArticle(20119L, articleId).getContent());
		} catch (Exception e) {
			log.error(e);

		}
		return wcprime;
	}

}