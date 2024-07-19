package com.na.webcontent.remote.internal.resource.v1_0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.journal.service.persistence.JournalArticleUtil;
import com.liferay.journal.service.persistence.JournalFolderUtil;
import com.liferay.portal.kernel.exception.NoSuchResourceException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Permission;
import com.liferay.portal.kernel.model.Resource;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.PermissionService;
import com.liferay.portal.kernel.service.PermissionServiceUtil;
import com.liferay.portal.kernel.service.ResourceLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.CDATA;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Entity;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.vulcan.permission.ModelPermissionsUtil;
import com.liferay.portal.xml.CDATAImpl;
import com.na.rwc.util.RWCUtil;
import com.na.webcontent.remote.dto.v1_0.WebContent;
import com.na.webcontent.remote.resource.v1_0.WebContentResource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author untodawn035
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/web-content.properties", scope = ServiceScope.PROTOTYPE, service = WebContentResource.class)
public class WebContentResourceImpl extends BaseWebContentResourceImpl {
	private static final Log log = LogFactoryUtil.getLog(WebContentResourceImpl.class);

	private static List<FileEntry> addFileEntries(WebContent wcprime) {

		ServiceContext context = new ServiceContext();
		context.setCompanyId(20096L);
		context.setScopeGroupId(20119L);
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
						20119L, 0L, fileNames[i], fileMimes[i],
						fileTitles[i] + StringUtil.randomString(), fileDescs[i], "", file, context);
				fileEntries.add(entryPrime);
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

	@Override
	public WebContent postWebContent(WebContent wcprime) throws PortalException {
		
		String content =  "";
		

		JournalArticle articlePrime = RWCUtil.getJournalArticleFromWebContentDto(wcprime);

		JournalArticle responseArticle = null;

		ServiceContext context = new ServiceContext();
		context.setCompanyId(20096L);
		context.setScopeGroupId(20119L);
		context.setAddGuestPermissions(true);
		context.setAddGroupPermissions(true);
		List<FileEntry> fileEntries = new ArrayList<FileEntry>();

		try {

			fileEntries = addFileEntries(wcprime);

		} catch (Exception e) {

			log.error(e.getMessage());
		}

		// <------------------Content Modification--------------------->

		try {

			List<ImageutilDto> imagedtoList = new ArrayList<ImageutilDto>();

			for (FileEntry entry : fileEntries) {
				ImageutilDto imageutilDto = new ImageutilDto();
				imageutilDto.setFileEntryId(entry.getFileEntryId() + "");
				imageutilDto.setGroupId(20119L + "");
				imageutilDto.setName(entry.getFileName());
				imageutilDto.setType("document");
				imageutilDto.setUuid(entry.getUuid());
				imageutilDto.setAlt("");
				imageutilDto.setTitle(entry.getTitle());
				imagedtoList.add(imageutilDto);

			}

			List<JSONObject> jsonList = new ArrayList<JSONObject>();
			for (ImageutilDto imageutilDto : imagedtoList) {
				JSONObject jsonObject = new JSONObject(
						new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(imageutilDto));
				jsonList.add(jsonObject);
			}

			Document contentDoc = SAXReaderUtil.read(articlePrime.getContent());

			contentDoc = contentDoc.clone();

			XPath xPath = SAXReaderUtil.createXPath("//dynamic-element[@type='image']");

			List<Node> imageNodes = xPath.selectNodes(contentDoc);
			
			for (Node imageNode : imageNodes) {
			    Element imageEl = (Element)imageNode;
			    List<Element> dynamicContentEls = imageEl.elements(
			      "dynamic-content");
			    int conCount=0;
			    for (Element dynamicContentEl : dynamicContentEls) {
			      String data = jsonList.get(conCount).toString();
			      
			        
			      dynamicContentEl.clearContent();
			      dynamicContentEl.addCDATA(data);
			    }
			  }
			content = contentDoc.formattedString();
			
			
			System.out.println("This is formatted string "+ content);
			System.out.println("Original content "+ articlePrime.getContent());
			

//			Element rootEle = contentDoc.getRootElement();
//			List<Element> dynContent = rootEle.elements();
//			StringBuilder sb = new StringBuilder();
//
//			System.out.println(sb);
//
//			for (Element ele : dynContent) {
//				if (ele.attributeValue("type").equalsIgnoreCase("image")) {
//
//					String reqContent = ele.element("dynamic-content").getText();
//
//					System.out.println("Hello from hitesh" + reqContent);
//
//				}
//
//			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		// <-----------------------content modification end---------------------------------->
		
		

		try {

			responseArticle = JournalArticleLocalServiceUtil.addArticle(StringUtil.randomString(20),articlePrime.getUserId(),
					articlePrime.getGroupId(), articlePrime.getFolderId(), new HashMap<Locale, String>() {
						{
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getTitleLangPrimarywc());
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US),
									wcprime.getTitleLangSecondarywc());
						}
					}, new HashMap<Locale, String>() {
						{
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ARABIC), wcprime.getDescLangPrimarywc());
							put(LocaleUtil.fromLanguageId(RWCUtil.LANGUAGE_ID_ENGLISH_US),
									wcprime.getDescLangSecondarywc());
						}
					}, content, articlePrime.getDDMStructureId(), articlePrime.getDDMTemplateKey(),
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