package com.na.webcontent.remote.client.serdes.v1_0;

import com.na.webcontent.remote.client.dto.v1_0.WebContent;
import com.na.webcontent.remote.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
public class WebContentSerDes {

	public static WebContent toDTO(String json) {
		WebContentJSONParser webContentJSONParser = new WebContentJSONParser();

		return webContentJSONParser.parseToDTO(json);
	}

	public static WebContent[] toDTOs(String json) {
		WebContentJSONParser webContentJSONParser = new WebContentJSONParser();

		return webContentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(WebContent webContent) {
		if (webContent == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (webContent.getArticleIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleIdwc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getArticleIdwc()));

			sb.append("\"");
		}

		if (webContent.getClassNameIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classNameIdwc\": ");

			sb.append(webContent.getClassNameIdwc());
		}

		if (webContent.getClassPKwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPKwc\": ");

			sb.append(webContent.getClassPKwc());
		}

		if (webContent.getContentPrimarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getContentPrimarywc()));

			sb.append("\"");
		}

		if (webContent.getContentSecondarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getContentSecondarywc()));

			sb.append("\"");
		}

		if (webContent.getDdmStructureIDwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureIDwc\": ");

			sb.append(webContent.getDdmStructureIDwc());
		}

		if (webContent.getDdmStructureKeywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureKeywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getDdmStructureKeywc()));

			sb.append("\"");
		}

		if (webContent.getDdmTemplateKeywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmTemplateKeywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getDdmTemplateKeywc()));

			sb.append("\"");
		}

		if (webContent.getDefLang() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"defLang\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getDefLang()));

			sb.append("\"");
		}

		if (webContent.getDescLangPrimarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getDescLangPrimarywc()));

			sb.append("\"");
		}

		if (webContent.getDescLangSecondarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getDescLangSecondarywc()));

			sb.append("\"");
		}

		if (webContent.getDispDatewc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dispDatewc\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(webContent.getDispDatewc()));

			sb.append("\"");
		}

		if (webContent.getExtReferenceCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"extReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getExtReferenceCode()));

			sb.append("\"");
		}

		if (webContent.getFUrlLangPrimarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getFUrlLangPrimarywc()));

			sb.append("\"");
		}

		if (webContent.getFUrlLangSecondarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getFUrlLangSecondarywc()));

			sb.append("\"");
		}

		if (webContent.getFileClassNameId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNameId\": ");

			sb.append(webContent.getFileClassNameId());
		}

		if (webContent.getFileClassNamePk() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNamePk\": ");

			sb.append(webContent.getFileClassNamePk());
		}

		if (webContent.getFileDescs() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileDescs\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileDescs().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getFileDescs()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getFileDescs().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFileEntryIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryIds\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileEntryIds().length; i++) {
				sb.append(webContent.getFileEntryIds()[i]);

				if ((i + 1) < webContent.getFileEntryIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFileEntryUuids() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryUuids\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileEntryUuids().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getFileEntryUuids()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getFileEntryUuids().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFileMimes() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileMimes\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileMimes().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getFileMimes()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getFileMimes().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFileNames() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileNames\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileNames().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getFileNames()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getFileNames().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFileTitles() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileTitles\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getFileTitles().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getFileTitles()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getFileTitles().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getFolderIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderIdwc\": ");

			sb.append(webContent.getFolderIdwc());
		}

		if (webContent.getGroupIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupIdwc\": ");

			sb.append(webContent.getGroupIdwc());
		}

		if (webContent.getIdPK() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"idPK\": ");

			sb.append(webContent.getIdPK());
		}

		if (webContent.getImagesB64Encoded() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"imagesB64Encoded\": ");

			sb.append("[");

			for (int i = 0; i < webContent.getImagesB64Encoded().length; i++) {
				sb.append("\"");

				sb.append(_escape(webContent.getImagesB64Encoded()[i]));

				sb.append("\"");

				if ((i + 1) < webContent.getImagesB64Encoded().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (webContent.getIndexablewc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"indexablewc\": ");

			sb.append(webContent.getIndexablewc());
		}

		if (webContent.getLayoutUuidwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"layoutUuidwc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getLayoutUuidwc()));

			sb.append("\"");
		}

		if (webContent.getLocalePrimarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localePrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getLocalePrimarywc()));

			sb.append("\"");
		}

		if (webContent.getLocaleSecondarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localeSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getLocaleSecondarywc()));

			sb.append("\"");
		}

		if (webContent.getModDatewc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modDatewc\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(webContent.getModDatewc()));

			sb.append("\"");
		}

		if (webContent.getNeverReviewwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"neverReviewwc\": ");

			sb.append(webContent.getNeverReviewwc());
		}

		if (webContent.getSmallImagewc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"smallImagewc\": ");

			sb.append(webContent.getSmallImagewc());
		}

		if (webContent.getTitleLangPrimarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getTitleLangPrimarywc()));

			sb.append("\"");
		}

		if (webContent.getTitleLangSecondarywc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getTitleLangSecondarywc()));

			sb.append("\"");
		}

		if (webContent.getUserIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userIdwc\": ");

			sb.append(webContent.getUserIdwc());
		}

		if (webContent.getUuIdwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uuIdwc\": ");

			sb.append("\"");

			sb.append(_escape(webContent.getUuIdwc()));

			sb.append("\"");
		}

		if (webContent.getVersionwc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"versionwc\": ");

			sb.append(webContent.getVersionwc());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		WebContentJSONParser webContentJSONParser = new WebContentJSONParser();

		return webContentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(WebContent webContent) {
		if (webContent == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ssXX");

		if (webContent.getArticleIdwc() == null) {
			map.put("articleIdwc", null);
		}
		else {
			map.put("articleIdwc", String.valueOf(webContent.getArticleIdwc()));
		}

		if (webContent.getClassNameIdwc() == null) {
			map.put("classNameIdwc", null);
		}
		else {
			map.put(
				"classNameIdwc", String.valueOf(webContent.getClassNameIdwc()));
		}

		if (webContent.getClassPKwc() == null) {
			map.put("classPKwc", null);
		}
		else {
			map.put("classPKwc", String.valueOf(webContent.getClassPKwc()));
		}

		if (webContent.getContentPrimarywc() == null) {
			map.put("contentPrimarywc", null);
		}
		else {
			map.put(
				"contentPrimarywc",
				String.valueOf(webContent.getContentPrimarywc()));
		}

		if (webContent.getContentSecondarywc() == null) {
			map.put("contentSecondarywc", null);
		}
		else {
			map.put(
				"contentSecondarywc",
				String.valueOf(webContent.getContentSecondarywc()));
		}

		if (webContent.getDdmStructureIDwc() == null) {
			map.put("ddmStructureIDwc", null);
		}
		else {
			map.put(
				"ddmStructureIDwc",
				String.valueOf(webContent.getDdmStructureIDwc()));
		}

		if (webContent.getDdmStructureKeywc() == null) {
			map.put("ddmStructureKeywc", null);
		}
		else {
			map.put(
				"ddmStructureKeywc",
				String.valueOf(webContent.getDdmStructureKeywc()));
		}

		if (webContent.getDdmTemplateKeywc() == null) {
			map.put("ddmTemplateKeywc", null);
		}
		else {
			map.put(
				"ddmTemplateKeywc",
				String.valueOf(webContent.getDdmTemplateKeywc()));
		}

		if (webContent.getDefLang() == null) {
			map.put("defLang", null);
		}
		else {
			map.put("defLang", String.valueOf(webContent.getDefLang()));
		}

		if (webContent.getDescLangPrimarywc() == null) {
			map.put("descLangPrimarywc", null);
		}
		else {
			map.put(
				"descLangPrimarywc",
				String.valueOf(webContent.getDescLangPrimarywc()));
		}

		if (webContent.getDescLangSecondarywc() == null) {
			map.put("descLangSecondarywc", null);
		}
		else {
			map.put(
				"descLangSecondarywc",
				String.valueOf(webContent.getDescLangSecondarywc()));
		}

		if (webContent.getDispDatewc() == null) {
			map.put("dispDatewc", null);
		}
		else {
			map.put(
				"dispDatewc",
				liferayToJSONDateFormat.format(webContent.getDispDatewc()));
		}

		if (webContent.getExtReferenceCode() == null) {
			map.put("extReferenceCode", null);
		}
		else {
			map.put(
				"extReferenceCode",
				String.valueOf(webContent.getExtReferenceCode()));
		}

		if (webContent.getFUrlLangPrimarywc() == null) {
			map.put("fUrlLangPrimarywc", null);
		}
		else {
			map.put(
				"fUrlLangPrimarywc",
				String.valueOf(webContent.getFUrlLangPrimarywc()));
		}

		if (webContent.getFUrlLangSecondarywc() == null) {
			map.put("fUrlLangSecondarywc", null);
		}
		else {
			map.put(
				"fUrlLangSecondarywc",
				String.valueOf(webContent.getFUrlLangSecondarywc()));
		}

		if (webContent.getFileClassNameId() == null) {
			map.put("fileClassNameId", null);
		}
		else {
			map.put(
				"fileClassNameId",
				String.valueOf(webContent.getFileClassNameId()));
		}

		if (webContent.getFileClassNamePk() == null) {
			map.put("fileClassNamePk", null);
		}
		else {
			map.put(
				"fileClassNamePk",
				String.valueOf(webContent.getFileClassNamePk()));
		}

		if (webContent.getFileDescs() == null) {
			map.put("fileDescs", null);
		}
		else {
			map.put("fileDescs", String.valueOf(webContent.getFileDescs()));
		}

		if (webContent.getFileEntryIds() == null) {
			map.put("fileEntryIds", null);
		}
		else {
			map.put(
				"fileEntryIds", String.valueOf(webContent.getFileEntryIds()));
		}

		if (webContent.getFileEntryUuids() == null) {
			map.put("fileEntryUuids", null);
		}
		else {
			map.put(
				"fileEntryUuids",
				String.valueOf(webContent.getFileEntryUuids()));
		}

		if (webContent.getFileMimes() == null) {
			map.put("fileMimes", null);
		}
		else {
			map.put("fileMimes", String.valueOf(webContent.getFileMimes()));
		}

		if (webContent.getFileNames() == null) {
			map.put("fileNames", null);
		}
		else {
			map.put("fileNames", String.valueOf(webContent.getFileNames()));
		}

		if (webContent.getFileTitles() == null) {
			map.put("fileTitles", null);
		}
		else {
			map.put("fileTitles", String.valueOf(webContent.getFileTitles()));
		}

		if (webContent.getFolderIdwc() == null) {
			map.put("folderIdwc", null);
		}
		else {
			map.put("folderIdwc", String.valueOf(webContent.getFolderIdwc()));
		}

		if (webContent.getGroupIdwc() == null) {
			map.put("groupIdwc", null);
		}
		else {
			map.put("groupIdwc", String.valueOf(webContent.getGroupIdwc()));
		}

		if (webContent.getIdPK() == null) {
			map.put("idPK", null);
		}
		else {
			map.put("idPK", String.valueOf(webContent.getIdPK()));
		}

		if (webContent.getImagesB64Encoded() == null) {
			map.put("imagesB64Encoded", null);
		}
		else {
			map.put(
				"imagesB64Encoded",
				String.valueOf(webContent.getImagesB64Encoded()));
		}

		if (webContent.getIndexablewc() == null) {
			map.put("indexablewc", null);
		}
		else {
			map.put("indexablewc", String.valueOf(webContent.getIndexablewc()));
		}

		if (webContent.getLayoutUuidwc() == null) {
			map.put("layoutUuidwc", null);
		}
		else {
			map.put(
				"layoutUuidwc", String.valueOf(webContent.getLayoutUuidwc()));
		}

		if (webContent.getLocalePrimarywc() == null) {
			map.put("localePrimarywc", null);
		}
		else {
			map.put(
				"localePrimarywc",
				String.valueOf(webContent.getLocalePrimarywc()));
		}

		if (webContent.getLocaleSecondarywc() == null) {
			map.put("localeSecondarywc", null);
		}
		else {
			map.put(
				"localeSecondarywc",
				String.valueOf(webContent.getLocaleSecondarywc()));
		}

		if (webContent.getModDatewc() == null) {
			map.put("modDatewc", null);
		}
		else {
			map.put(
				"modDatewc",
				liferayToJSONDateFormat.format(webContent.getModDatewc()));
		}

		if (webContent.getNeverReviewwc() == null) {
			map.put("neverReviewwc", null);
		}
		else {
			map.put(
				"neverReviewwc", String.valueOf(webContent.getNeverReviewwc()));
		}

		if (webContent.getSmallImagewc() == null) {
			map.put("smallImagewc", null);
		}
		else {
			map.put(
				"smallImagewc", String.valueOf(webContent.getSmallImagewc()));
		}

		if (webContent.getTitleLangPrimarywc() == null) {
			map.put("titleLangPrimarywc", null);
		}
		else {
			map.put(
				"titleLangPrimarywc",
				String.valueOf(webContent.getTitleLangPrimarywc()));
		}

		if (webContent.getTitleLangSecondarywc() == null) {
			map.put("titleLangSecondarywc", null);
		}
		else {
			map.put(
				"titleLangSecondarywc",
				String.valueOf(webContent.getTitleLangSecondarywc()));
		}

		if (webContent.getUserIdwc() == null) {
			map.put("userIdwc", null);
		}
		else {
			map.put("userIdwc", String.valueOf(webContent.getUserIdwc()));
		}

		if (webContent.getUuIdwc() == null) {
			map.put("uuIdwc", null);
		}
		else {
			map.put("uuIdwc", String.valueOf(webContent.getUuIdwc()));
		}

		if (webContent.getVersionwc() == null) {
			map.put("versionwc", null);
		}
		else {
			map.put("versionwc", String.valueOf(webContent.getVersionwc()));
		}

		return map;
	}

	public static class WebContentJSONParser
		extends BaseJSONParser<WebContent> {

		@Override
		protected WebContent createDTO() {
			return new WebContent();
		}

		@Override
		protected WebContent[] createDTOArray(int size) {
			return new WebContent[size];
		}

		@Override
		protected void setField(
			WebContent webContent, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "articleIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setArticleIdwc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classNameIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setClassNameIdwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "classPKwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setClassPKwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "contentPrimarywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setContentPrimarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "contentSecondarywc")) {

				if (jsonParserFieldValue != null) {
					webContent.setContentSecondarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ddmStructureIDwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setDdmStructureIDwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ddmStructureKeywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setDdmStructureKeywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ddmTemplateKeywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setDdmTemplateKeywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "defLang")) {
				if (jsonParserFieldValue != null) {
					webContent.setDefLang((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "descLangPrimarywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setDescLangPrimarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "descLangSecondarywc")) {

				if (jsonParserFieldValue != null) {
					webContent.setDescLangSecondarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "dispDatewc")) {
				if (jsonParserFieldValue != null) {
					webContent.setDispDatewc(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "extReferenceCode")) {
				if (jsonParserFieldValue != null) {
					webContent.setExtReferenceCode(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fUrlLangPrimarywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setFUrlLangPrimarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "fUrlLangSecondarywc")) {

				if (jsonParserFieldValue != null) {
					webContent.setFUrlLangSecondarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileClassNameId")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileClassNameId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileClassNamePk")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileClassNamePk(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileDescs")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileDescs(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileEntryIds")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileEntryIds(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileEntryUuids")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileEntryUuids(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileMimes")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileMimes(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileNames")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileNames(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fileTitles")) {
				if (jsonParserFieldValue != null) {
					webContent.setFileTitles(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "folderIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setFolderIdwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "groupIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setGroupIdwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "idPK")) {
				if (jsonParserFieldValue != null) {
					webContent.setIdPK(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "imagesB64Encoded")) {
				if (jsonParserFieldValue != null) {
					webContent.setImagesB64Encoded(
						toStrings((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "indexablewc")) {
				if (jsonParserFieldValue != null) {
					webContent.setIndexablewc((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "layoutUuidwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setLayoutUuidwc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "localePrimarywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setLocalePrimarywc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "localeSecondarywc")) {
				if (jsonParserFieldValue != null) {
					webContent.setLocaleSecondarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modDatewc")) {
				if (jsonParserFieldValue != null) {
					webContent.setModDatewc(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "neverReviewwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setNeverReviewwc((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "smallImagewc")) {
				if (jsonParserFieldValue != null) {
					webContent.setSmallImagewc((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "titleLangPrimarywc")) {

				if (jsonParserFieldValue != null) {
					webContent.setTitleLangPrimarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "titleLangSecondarywc")) {

				if (jsonParserFieldValue != null) {
					webContent.setTitleLangSecondarywc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setUserIdwc(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "uuIdwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setUuIdwc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "versionwc")) {
				if (jsonParserFieldValue != null) {
					webContent.setVersionwc(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}