package com.na.remotewc.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.na.email.commoncofig.EmailCommonConfig;
import com.na.remotewc.headless.rest.dto.v1_0.WebContent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class RWCUtil {
	private final static Log log = LogFactoryUtil.getLog(RWCUtil.class);
	

	
	private final static String ARICLE_NOT_FOUND_ERROR = "Article doesn't exist with the particular articleId";
	private final static String FORMATTING_FAILED_ERROR = "Formatting failed";
	private final static String ID_NOT_RECEIVED_ERROR = "articleId not received.";
	private final static String DEFAULT_JOURNAL_ARTICLE_TREE_PATH = "/";
	private final static long DEFAULT_GROUP_ID = 20119L;
	private final static long DEFAULT_COMPANY_ID = 20096L;
	private final static boolean NEVER_REVIEW = true;
	private final static long DEFAULT_CLASS_NAME_ID_OF_WC_RELATED_TO_IMAGES = 20132L;
	private final static String EMPTY_STRING = "";
	private final static long DEFAULT_IMAGE_REPOSITORY = 20119L;
	private final static long DEFAULT_IMAGE_FOLDER = 0L;
	private final static String DEFAULT_DOCUMENT_TYPE = "document";
	private final static String SAXREADERUTIL_XPATH_TYPE_IMAGES = "//dynamic-element[@type='image']";
	private final static String XML_ELEMENT_TYPE_DYNAMIC_CONTENT = "dynamic-content";
	
	public final static String LANGUAGE_ID_ARABIC = "ar_SA";
	public final static String LANGUAGE_ID_ENGLISH_US = "en_US";
	public final static String REQUEST_TYPE_POST = "POST";
	public final static String CONTENT_TYPE = "application/json";
	public final static String AUTHORIZATION_PROPERTY = "Authorization";
	public final static String CONTENT_TYPE_PROPERTY = "Content-Type";
	public final static String CHARACTER_ENCODING_UTF8 = "UTF-8";

	public final static String URL_LOCAL_UBUNTU = "";
	private final static String BEARER_TOKEN_LOCAL_UBUNTU = "";
	
	
	

	public static String getBearerTokenUbuntu() {

		return BEARER_TOKEN_LOCAL_UBUNTU;
	}

	public final static String URL_LOCAL_FEDORA = "http://192.168.61.102:8082/o/na-remotewcpublishing-REST/v1.0/webContent";
	private final static String BEARER_TOKEN_LOCAL_FEDORA = "Bearer eyJ0eXAiOiJhdCtqd3QiLCJhbGciOiJSUzI1NiJ9.eyJqdGkiOiJlZCIsImNsaWVudF9pZCI6ImlkLTQyMTM1ZDk3LTA0ZDUtY2VmMy0xMTgzLTJlMWM0NjhiNGVhIiwiaWF0IjoxNzE5NTcxNjA4LCJleHAiOjE3MTk1OTE2MDgsInN1YiI6IjIwMTIzIiwidXNlcm5hbWUiOiJ0ZXN0IiwiaXNzIjoiMTkyLjE2OC42MS4xMDIiLCJzY29wZSI6Ik5hUmVtb3Rld2NwdWJsaXNoaW5nUkVTVC5ldmVyeXRoaW5nLnJlYWQgTmFSZW1vdGV3Y3B1Ymxpc2hpbmdSRVNULmV2ZXJ5dGhpbmcud3JpdGUgTmFSZW1vdGV3Y3B1Ymxpc2hpbmdSRVNULmV2ZXJ5dGhpbmciLCJncmFudF90eXBlIjoiY2xpZW50X2NyZWRlbnRpYWxzIn0.ZDSbfUaWnH0ikhCOl-rKBsQLdTwaoyMxgnPPWQUkYf4qj1iZMyXWSz5xoKgUa97V7gNeZtLbGccZaLw_v04tSzUuzr5_FgbsTF40kFVhtCK631UjP5siCtiI2F5NC5vKqGGuxk3gh1j3MFEf9YTj4qRBDG-GnL4jBCkf7ayy1ruCL640uEn9RJZx5hhpPowc1dSyOG7NkjQUQTCJLC5rbmmTrTBG9SOHQ8HeCgTILCqTBoT2lyyc-vKEh2OdDV1XMD5BfZO9V7jJCTghB4SfH8zS5V4mYGXZm1BIjzXc-hkhAtflo5NYuWVFhndzNUOVy5p8qRdQbMO1KLQWkHNygA";

	public static String getBearerTokenFedora() {

		return BEARER_TOKEN_LOCAL_FEDORA;
	}

	public final static String URL_STAGING = "";
	private final static String BEARER_TOKEN_STAGING = "Bearer ";

	public static String getBearerTokenStaging() {

		return BEARER_TOKEN_STAGING;
	}

	public final static String URL_PROD = "";
	private final static String BEARER_TOKEN_PROD = "";
	
	public static String getBearerTokenProd() {

		return BEARER_TOKEN_PROD;
	}

	public static String getHttpRequestBody(String articleId) throws PortletException {

		String requestBody = EMPTY_STRING;
		if (articleId.equals(EMPTY_STRING) || articleId.equals(null))
			throw new PortletException(ID_NOT_RECEIVED_ERROR);

		WebContent wcPrime = new WebContent();
		WebContentDtoUtil contentDtoUtil = new WebContentDtoUtil();

		try {
			wcPrime = getWebContentDtoByJournalArticleAticleId(articleId);
			contentDtoUtil = getWCUtilDtoFromWC(wcPrime);

			JSONObject jsonObject = new JSONObject(
					new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(contentDtoUtil));

			requestBody = jsonObject.toString();
			log.info(
					"This is your JSON body--> start---> " + jsonObject + " <---end <-- End of your JSON body");

		} catch (Exception e) {
			log.error(e);

		}
		return requestBody;

	}

	public static List<FileEntry> addFileEntries(WebContent wcprime) {

		ServiceContext context = new ServiceContext();
		context.setCompanyId(DEFAULT_COMPANY_ID);
		context.setScopeGroupId(DEFAULT_GROUP_ID);
		context.setAddGuestPermissions(true);
		context.setAddGroupPermissions(true);
		List<FileEntry> fileEntries = new ArrayList<FileEntry>();

		try {

			for (int i = 0; i < wcprime.getFileEntryIds().length; i++) {

				String[] b64Arr = wcprime.getImagesB64Encoded();
				byte[] imageArr = Base64.decode(b64Arr[i]);
				String[] fileNames = wcprime.getFileNames();
				String[] fileMimes = wcprime.getFileMimes();
				String[] fileTitles = wcprime.getFileTitles();
				String[] fileDescs = wcprime.getFileDescs();
				File file = new File(fileNames[i]);
				Path op = Paths.get(file.getPath());
				Files.write(op,imageArr);
				FileEntry entryPrime = DLAppLocalServiceUtil.addFileEntry(wcprime.getUserIdwc(),
						DEFAULT_IMAGE_REPOSITORY, DEFAULT_IMAGE_FOLDER, fileNames[i], fileMimes[i],
						fileTitles[i] + StringUtil.randomString(), fileDescs[i], EMPTY_STRING, file, context);
				fileEntries.add(entryPrime);

				System.out.println(imageArr.length);
				System.out.println(entryPrime);

				System.out.println(DLAppLocalServiceUtil.getFileEntry(entryPrime.getFileEntryId()));

			}

		} catch (Exception e) {

			log.error(e.getMessage());
		}

		return fileEntries;

	}

	public static String getModifiedContent(String originalContent, List<FileEntry> fileEntryList) throws Exception {

		String formattedString = EMPTY_STRING;

		try {

			List<ImageDtoUtil> imagedtoList = new ArrayList<>();

			for (FileEntry entry : fileEntryList) {
				ImageDtoUtil imageutilDto = new ImageDtoUtil();
				imageutilDto.setFileEntryId(entry.getFileEntryId() + EMPTY_STRING);
				imageutilDto.setGroupId(20119L + EMPTY_STRING);
				imageutilDto.setName(entry.getFileName());
				imageutilDto.setType(DEFAULT_DOCUMENT_TYPE);
				imageutilDto.setUuid(entry.getUuid());
				imageutilDto.setAlt(EMPTY_STRING);
				imageutilDto.setTitle(entry.getTitle());
				imagedtoList.add(imageutilDto);

			}
			log.info(originalContent);
			Document contentDoc = SAXReaderUtil.read(originalContent);
			if(ListUtil.isNotEmpty(imagedtoList)){
				List<JSONObject> jsonList = new ArrayList<>();
				for (ImageDtoUtil imageutilDto : imagedtoList) {
					JSONObject jsonObject = new JSONObject(
							new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(imageutilDto));
					jsonList.add(jsonObject);
				}



				contentDoc = contentDoc.clone();

				XPath xPath = SAXReaderUtil.createXPath(SAXREADERUTIL_XPATH_TYPE_IMAGES);

				List<Node> imageNodes = xPath.selectNodes(contentDoc);

				for (Node imageNode : imageNodes) {
					Element imageEl = (Element) imageNode;
					List<Element> dynamicContentEls = imageEl.elements(XML_ELEMENT_TYPE_DYNAMIC_CONTENT);
					int conCount = 0;
					for (Element dynamicContentEl : dynamicContentEls) {
						String data = jsonList.get(conCount).toString();

						dynamicContentEl.clearContent();
						dynamicContentEl.addCDATA(data);
					}
				}
			}

			formattedString = contentDoc.formattedString();

			log.info("This is formatted content " + formattedString);
			log.info("Original content " + originalContent);

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		if (!formattedString.isEmpty())
			return formattedString;
		else
			throw new Exception(FORMATTING_FAILED_ERROR);
	}

	public static WebContent getWebContentDtoByJournalArticleAticleId(String articleId) throws Exception {
		WebContent wcprime = new WebContent();

		JournalArticle articlePrime = JournalArticleLocalServiceUtil.getLatestArticle(RWCUtil.DEFAULT_GROUP_ID,
				articleId);

		if (Validator.isNotNull(articlePrime)) {

			// Getting and setting documents related to the wc.

			log.info("There is/are " + articlePrime.getImagesFileEntriesCount() + " image(s) related to the wc.");

			String[] imagesBase64Encoded = new String[articlePrime.getImagesFileEntriesCount()];
			Long[] fileEntryIds = new Long[articlePrime.getImagesFileEntriesCount()];
			String[] fileDescs = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileEntryUuids = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileNames = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileMimes = new String[articlePrime.getImagesFileEntriesCount()];
			String[] fileTitles = new String[articlePrime.getImagesFileEntriesCount()];

			List<FileEntry> fileEntries = articlePrime.getImagesFileEntries();
			log.info("There are " + fileEntries.size() + " file entries.");

			if (!fileEntries.isEmpty()) {
				int fleCount = 0;

				for (FileEntry entry : fileEntries) {

					InputStream fileInp = entry.getContentStream();
					byte[] fileBytes = IOUtils.toByteArray(fileInp);

					log.info("The file size is " + fileBytes.length + " bytes.");

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

			wcprime.setFileClassNameId(RWCUtil.DEFAULT_CLASS_NAME_ID_OF_WC_RELATED_TO_IMAGES);
			wcprime.setFileClassNamePk(articlePrime.getResourcePrimKey());
			wcprime.setImagesB64Encoded(imagesBase64Encoded);
			wcprime.setFileEntryIds(fileEntryIds);
			wcprime.setFileDescs(fileDescs);
			wcprime.setFileEntryUuids(fileEntryUuids);
			wcprime.setFileNames(fileNames);
			wcprime.setFileMimes(fileMimes);
			wcprime.setFileTitles(fileTitles);

			// Getting and setting the JournalArticle properties of the wc.

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

		// Getting and setting the documents related to the wc.

		wcprime.setFileClassNameId(articlePrime.getFileClassNameId());
		wcprime.setFileClassNamePk(articlePrime.getFileClassNamePk());
		wcprime.setImagesB64Encoded(articlePrime.getImagesB64Encoded());
		wcprime.setFileEntryIds(articlePrime.getFileEntryIds());
		wcprime.setFileDescs(articlePrime.getFileDescs());
		wcprime.setFileEntryUuids(articlePrime.getFileEntryUuids());
		wcprime.setFileNames(articlePrime.getFileNames());
		wcprime.setFileMimes(articlePrime.getFileMimes());
		wcprime.setFileTitles(articlePrime.getFileTitles());

		// Getting and setting the JournalArticle properties.
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

			log.info(wcprime.getContentPrimarywc());
			log.info(SAXReaderUtil.read(wcprime.getContentPrimarywc()).getStringValue());

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
				/**
				 * 
				 */
				private static final long serialVersionUID = 133647588903L;

				{
					put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getTitleLangPrimarywc());
					put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US), wcprime.getTitleLangSecondarywc());
				}
			});

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		articlePrime = JournalArticleLocalServiceUtil.addJournalArticle(articlePrime);
		log.info(JournalArticleLocalServiceUtil.updateJournalArticle(articlePrime));
		return articlePrime;
	}

}
