package com.na.rwc.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.xml.SecureXMLFactoryProviderUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;


import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.na.webcontent.remote.dto.v1_0.WebContent;


import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;

import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import org.xml.sax.InputSource;

@Component(immediate = true,

		service = Portlet.class)
public class RWCUtil extends MVCPortlet {

//	@Reference
//	private static RWCUtil utilObject;
	private final static Log log = LogFactoryUtil.getLog(RWCUtil.class);
	public final static String LANGUAGE_ID_ARABIC = "ar_SA";
	public final static String LANGUAGE_ID_ENGLISH_US = "en_US";
	private final static String ARICLE_NOT_FOUND_ERROR = "Article doesn't exist with the particular articleId";
	private final static String DEFAULT_JOURNAL_ARTICLE_TREE_PATH = "/";
	private final static long DEFAULT_GROUP_ID = 20119L;
	private final static boolean NEVER_REVIEW = true;

//	private static List<JournalArticle> getArticlesByQuery(String articleId) {
//
//		List<JournalArticle> articleList = new ArrayList<>();
//		try {
//			Order order = OrderFactoryUtil.desc(RWCUtil.FIELD_CREATE_DATE);
//
//			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//			DynamicQuery query = DynamicQueryFactoryUtil.forClass(JournalArticle.class, classLoader)
//					.add(RestrictionsFactoryUtil.eq(RWCUtil.FIELD_ARTICLE_ID, articleId)).addOrder(order);
//
//			articleList = JournalArticleLocalServiceUtil.dynamicQuery(query);
//			if (articleList.isEmpty())
//				throw new NoSuchCollectionException();
//		} catch (NoSuchCollectionException e) {
//			
//		}
//
//		return articleList;
//
//	}

//	private static JournalArticle getLatestVersionJournalArticleByArticleId(List<JournalArticle> list) throws Exception {
//		JournalArticle articlePrime = null;
//		Double articleVersion = 0.0;
//
//		try {
//			List<JournalArticle> articleList = list;
//			for (JournalArticle article : articleList) {
//
//				if (articleVersion <= article.getVersion()) {
//					articlePrime = article;
//				}
//				articleVersion = article.getVersion() > articleVersion ? article.getVersion() : articleVersion;
//
//			}
//		} catch (Exception e) {
//			
//			
//		}
//
//		if (Validator.isNull(articlePrime))
//			throw new Exception(RWCUtil.ARICLE_NOT_FOUND_ERROR);
//		else
//			return articlePrime;
//
//	}

	public static WebContent getWebContentDtoByJournalArticleAticleId(String articleId) throws Exception {
		WebContent wcprime = new WebContent();

		JournalArticle articlePrime = JournalArticleLocalServiceUtil.getLatestArticle(RWCUtil.DEFAULT_GROUP_ID,
				articleId);

		if (Validator.isNotNull(articlePrime)) {

			// Getting and setting documents related to the wc.
			System.out.println("There are "+articlePrime.getImagesFileEntriesCount()+ " images.");
			
			String[] imagesBase64Encoded = new String[articlePrime.getImagesFileEntriesCount()];
			Long[] fileEntryIds = new Long[articlePrime.getImagesFileEntriesCount()];
			String[] fileDescs = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileEntryUuids = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileNames = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileMimes = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileTitles = new String[articlePrime.getImagesFileEntriesCount()];

			

			List<FileEntry> fileEntries = articlePrime.getImagesFileEntries();
			System.out.println(fileEntries.size());

			if (!fileEntries.isEmpty()) {
				int fleCount = 0;

				for (FileEntry entry : fileEntries) {

					InputStream fileInp = entry.getContentStream();
					byte[] fileBytes = IOUtils.toByteArray(fileInp);
					System.out.println(fileBytes.length);
					String encodedString = Base64.encode(fileBytes);
					imagesBase64Encoded[fleCount] = encodedString;
					fileEntryIds[fleCount] = entry.getFileEntryId();
					fileDescs[fleCount] = entry.getDescription();
					fileEntryUuids[fleCount] = entry.getUuid();
					fileNames[fleCount] = entry.getFileName();
					fileMimes[fleCount] = entry.getMimeType();
					fileTitles[fleCount] = entry.getTitle();
					fleCount++;

				}
			}
			
			wcprime.setFileClassNameId(20132L);
			wcprime.setFileClassNamePk(articlePrime.getResourcePrimKey());
			wcprime.setImagesB64Encoded(imagesBase64Encoded);
			wcprime.setFileEntryIds(fileEntryIds);
			wcprime.setFileDescs(fileDescs);
			wcprime.setFileEntryUuids(fileEntryUuids);
			wcprime.setFileNames(fileNames);
			wcprime.setFileMimes(fileMimes);
			wcprime.setFileTitles(fileTitles);

			wcprime.setArticleIdwc(articlePrime.getArticleId());
			wcprime.setIdPK(articlePrime.getPrimaryKey());
			wcprime.setClassNameIdwc(articlePrime.getClassNameId());
			wcprime.setClassPKwc(articlePrime.getClassPK());
			wcprime.setUuIdwc(articlePrime.getUuid());
			wcprime.setContentPrimarywc(articlePrime.getContent());
			wcprime.setContentSecondarywc(articlePrime.getContentByLocale(RWCUtil.LANGUAGE_ID_ENGLISH_US));

			wcprime.setDdmStructureKeywc(articlePrime.getDDMStructure().getStructureKey());
			wcprime.setDdmTemplateKeywc(articlePrime.getDDMTemplateKey());

			wcprime.setDescLangPrimarywc(
					articlePrime.getDescription(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC)));
			wcprime.setDescLangSecondarywc(
					articlePrime.getDescription(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US)));

			wcprime.setDispDatewc(articlePrime.getDisplayDate());

			wcprime.setModDatewc(articlePrime.getModifiedDate());

			wcprime.setFolderIdwc(articlePrime.getFolderId());
			wcprime.setFUrlLangPrimarywc(
					articlePrime.getFriendlyURLMap().get(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC)));
			wcprime.setFUrlLangSecondarywc(
					articlePrime.getFriendlyURLMap().get(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US)));
			wcprime.setGroupIdwc(articlePrime.getGroupId());
			wcprime.setUserIdwc(articlePrime.getUserId());
			wcprime.setNeverReviewwc(RWCUtil.NEVER_REVIEW);
			wcprime.setIndexablewc(articlePrime.getIndexable());
			wcprime.setSmallImagewc(articlePrime.getSmallImage());
			wcprime.setDefLang(articlePrime.getDefaultLanguageId());
			wcprime.setVersionwc(articlePrime.getVersion());

			wcprime.setTitleLangPrimarywc(articlePrime.getTitle(RWCUtil.LANGUAGE_ID_ARABIC));
			wcprime.setTitleLangSecondarywc(articlePrime.getTitle(RWCUtil.LANGUAGE_ID_ENGLISH_US));

		} else
			throw new Exception(RWCUtil.ARICLE_NOT_FOUND_ERROR);

		return wcprime;

	}

	public static WebContentDtoUtil getWCUtilDtoFromWC(WebContent articlePrime) {

		WebContentDtoUtil wcprime = new WebContentDtoUtil();
		
		
		wcprime.setFileClassNameId(articlePrime.getFileClassNameId());
		wcprime.setFileClassNamePk(articlePrime.getFileClassNamePk());
		wcprime.setImagesB64Encoded(articlePrime.getImagesB64Encoded());
		wcprime.setFileEntryIds(articlePrime.getFileEntryIds());
		wcprime.setFileDescs(articlePrime.getFileDescs());
		wcprime.setFileEntryUuids(articlePrime.getFileEntryUuids());
		wcprime.setFileNames(articlePrime.getFileNames());
		wcprime.setFileMimes(articlePrime.getFileMimes());
		wcprime.setFileTitles(articlePrime.getFileTitles());

		wcprime.setArticleIdwc(articlePrime.getArticleIdwc());
		wcprime.setIdPK(articlePrime.getIdPK());
		wcprime.setClassNameIdwc(articlePrime.getClassNameIdwc());
		wcprime.setClassPKwc(articlePrime.getClassPKwc());
		wcprime.setUuIdwc(articlePrime.getUuIdwc());
		wcprime.setContentPrimarywc(articlePrime.getContentPrimarywc());
		wcprime.setContentSecondarywc(articlePrime.getContentSecondarywc());

		wcprime.setDdmStructureKeywc(articlePrime.getDdmStructureKeywc());
		wcprime.setDdmTemplateKeywc(articlePrime.getDdmTemplateKeywc());

		wcprime.setDescLangPrimarywc(articlePrime.getDescLangPrimarywc());
		wcprime.setDescLangSecondarywc(articlePrime.getDescLangSecondarywc());

		wcprime.setDispDatewc(articlePrime.getDispDatewc());

		wcprime.setModDatewc(articlePrime.getModDatewc());

		wcprime.setFolderIdwc(articlePrime.getFolderIdwc());
		wcprime.setfUrlLangPrimarywc(articlePrime.getFUrlLangPrimarywc());
		wcprime.setfUrlLangSecondarywc(articlePrime.getFUrlLangSecondarywc());
		
		wcprime.setGroupIdwc(articlePrime.getGroupIdwc());
		wcprime.setUserIdwc(articlePrime.getUserIdwc());
		wcprime.setNeverReviewwc(RWCUtil.NEVER_REVIEW);
		wcprime.setIndexablewc(articlePrime.getIndexablewc());
		wcprime.setSmallImagewc(articlePrime.getSmallImagewc());
		wcprime.setDefLang(articlePrime.getDefLang());
		wcprime.setVersionwc(articlePrime.getVersionwc());

		wcprime.setTitleLangPrimarywc(articlePrime.getTitleLangPrimarywc());
		wcprime.setTitleLangSecondarywc(articlePrime.getTitleLangSecondarywc());

		return wcprime;

	}

	public static JournalArticle getJournalArticleFromWebContentDto(WebContent wcprime) {
		JournalArticle articlePrime = JournalArticleLocalServiceUtil
				.createJournalArticle(CounterLocalServiceUtil.increment());
		try {

			articlePrime.setPrimaryKey(wcprime.getIdPK());
			articlePrime.setClassNameId(wcprime.getClassNameIdwc());
			articlePrime.setClassPK(wcprime.getClassPKwc());
			articlePrime.setResourcePrimKey(CounterLocalServiceUtil.increment());
			articlePrime.setArticleId(wcprime.getArticleIdwc());
			articlePrime.setUuid(wcprime.getUuIdwc());

			if (wcprime.getFolderIdwc() == 0)
				articlePrime.setTreePath(RWCUtil.DEFAULT_JOURNAL_ARTICLE_TREE_PATH);
			else
				articlePrime
						.setTreePath(JournalFolderLocalServiceUtil.getFolder(wcprime.getFolderIdwc()).buildTreePath());


			articlePrime.setDocument(SAXReaderUtil.read(wcprime.getContentPrimarywc()));

			articlePrime.setDisplayDate(wcprime.getDispDatewc());
			articlePrime.setModifiedDate(wcprime.getModDatewc());

			articlePrime.setDDMStructureId(Long.parseLong(wcprime.getDdmStructureKeywc()));
			articlePrime.setDDMTemplateKey(wcprime.getDdmTemplateKeywc());

			articlePrime.setDefaultLanguageId(wcprime.getDefLang());

			articlePrime.setFolderId(wcprime.getFolderIdwc());

			articlePrime.setUrlTitle(wcprime.getFUrlLangPrimarywc());
			articlePrime.setGroupId(wcprime.getGroupIdwc());
			articlePrime.setUserId(wcprime.getUserIdwc());
			articlePrime.setUserName(UserLocalServiceUtil.getUserById(wcprime.getUserIdwc()).getFullName());

			articlePrime.setIndexable(wcprime.getIndexablewc());

			articlePrime.setSmallImage(wcprime.getSmallImagewc());
			articlePrime.setVersion(wcprime.getVersionwc());

			articlePrime.setStatusByUserId(wcprime.getUserIdwc());
			articlePrime.setStatusByUserName(UserLocalServiceUtil.getUserById(wcprime.getUserIdwc()).getFullName());
			articlePrime.setStatusDate(wcprime.getModDatewc());

			articlePrime.setTitleMap(new HashMap<Locale, String>() {
				{
					put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getTitleLangPrimarywc());
					put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US), wcprime.getTitleLangSecondarywc());
				}
			});

		} catch (Exception e) {

		}

		return articlePrime;
	}

}
