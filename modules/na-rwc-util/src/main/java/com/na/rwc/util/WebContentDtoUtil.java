package com.na.rwc.util;

import com.liferay.petra.string.StringBundler;

import com.na.webcontent.remote.dto.v1_0.WebContent;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;

public class WebContentDtoUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 17768554976889L;

	public String articleIdwc;

	public Long classNameIdwc;

	public Long classPKwc;

	public String contentPrimarywc;

	public String contentSecondarywc;

	public Long ddmStructureIDwc;

	public String ddmStructureKeywc;

	public String ddmTemplateKeywc;

	public String defLang;

	public String descLangPrimarywc;

	public String descLangSecondarywc;

	public Date dispDatewc;

	public String extReferenceCode;

	public String fUrlLangPrimarywc;

	public String fUrlLangSecondarywc;

	public Long folderIdwc;

	public Long groupIdwc;

	public Long idPK;

	

	public Boolean indexablewc;

	public String layoutUuidwc;

	public String localePrimarywc;

	public String localeSecondarywc;

	public Date modDatewc;

	public Boolean neverReviewwc;

	public Boolean smallImagewc;

	public String titleLangPrimarywc;

	public String titleLangSecondarywc;

	public Long userIdwc;

	public String uuIdwc;

	public Double versionwc;

	protected Long fileClassNameId;

	protected Long fileClassNamePk;

	protected String[] fileDescs;

	protected Long[] fileEntryIds;

	protected String[] fileEntryUuids;

	protected String[] fileMimes;

	protected String[] fileNames;

	protected String[] fileTitles;

	protected String[] imagesB64Encoded;

	public String getArticleIdwc() {
		return articleIdwc;
	}

	public void setArticleIdwc(String articleIdwc) {
		this.articleIdwc = articleIdwc;
	}

	public Long getClassNameIdwc() {
		return classNameIdwc;
	}

	public void setClassNameIdwc(Long classNameIdwc) {
		this.classNameIdwc = classNameIdwc;
	}

	public Long getClassPKwc() {
		return classPKwc;
	}

	public void setClassPKwc(Long classPKwc) {
		this.classPKwc = classPKwc;
	}

	public String getContentPrimarywc() {
		return contentPrimarywc;
	}

	public void setContentPrimarywc(String contentPrimarywc) {
		this.contentPrimarywc = contentPrimarywc;
	}

	public String getContentSecondarywc() {
		return contentSecondarywc;
	}

	public void setContentSecondarywc(String contentSecondarywc) {
		this.contentSecondarywc = contentSecondarywc;
	}

	public Long getDdmStructureIDwc() {
		return ddmStructureIDwc;
	}

	public void setDdmStructureIDwc(Long ddmStructureIDwc) {
		this.ddmStructureIDwc = ddmStructureIDwc;
	}

	public String getDdmStructureKeywc() {
		return ddmStructureKeywc;
	}

	public void setDdmStructureKeywc(String ddmStructureKeywc) {
		this.ddmStructureKeywc = ddmStructureKeywc;
	}

	public String getDdmTemplateKeywc() {
		return ddmTemplateKeywc;
	}

	public void setDdmTemplateKeywc(String ddmTemplateKeywc) {
		this.ddmTemplateKeywc = ddmTemplateKeywc;
	}

	public String getDefLang() {
		return defLang;
	}

	public void setDefLang(String defLang) {
		this.defLang = defLang;
	}

	public String getDescLangPrimarywc() {
		return descLangPrimarywc;
	}

	public void setDescLangPrimarywc(String descLangPrimarywc) {
		this.descLangPrimarywc = descLangPrimarywc;
	}

	public String getDescLangSecondarywc() {
		return descLangSecondarywc;
	}

	public void setDescLangSecondarywc(String descLangSecondarywc) {
		this.descLangSecondarywc = descLangSecondarywc;
	}

	public Date getDispDatewc() {
		return dispDatewc;
	}

	public void setDispDatewc(Date dispDatewc) {
		this.dispDatewc = dispDatewc;
	}

	public String getExtReferenceCode() {
		return extReferenceCode;
	}

	public void setExtReferenceCode(String extReferenceCode) {
		this.extReferenceCode = extReferenceCode;
	}

	public String getfUrlLangPrimarywc() {
		return fUrlLangPrimarywc;
	}

	public void setfUrlLangPrimarywc(String fUrlLangPrimarywc) {
		this.fUrlLangPrimarywc = fUrlLangPrimarywc;
	}

	public String getfUrlLangSecondarywc() {
		return fUrlLangSecondarywc;
	}

	public void setfUrlLangSecondarywc(String fUrlLangSecondarywc) {
		this.fUrlLangSecondarywc = fUrlLangSecondarywc;
	}

	public Long getFolderIdwc() {
		return folderIdwc;
	}

	public void setFolderIdwc(Long folderIdwc) {
		this.folderIdwc = folderIdwc;
	}

	public Long getGroupIdwc() {
		return groupIdwc;
	}

	public void setGroupIdwc(Long groupIdwc) {
		this.groupIdwc = groupIdwc;
	}

	public Long getIdPK() {
		return idPK;
	}

	public void setIdPK(Long idPK) {
		this.idPK = idPK;
	}

	

	public Boolean getIndexablewc() {
		return indexablewc;
	}

	public void setIndexablewc(Boolean indexablewc) {
		this.indexablewc = indexablewc;
	}

	public String getLayoutUuidwc() {
		return layoutUuidwc;
	}

	public void setLayoutUuidwc(String layoutUuidwc) {
		this.layoutUuidwc = layoutUuidwc;
	}

	public String getLocalePrimarywc() {
		return localePrimarywc;
	}

	public void setLocalePrimarywc(String localePrimarywc) {
		this.localePrimarywc = localePrimarywc;
	}

	public String getLocaleSecondarywc() {
		return localeSecondarywc;
	}

	public void setLocaleSecondarywc(String localeSecondarywc) {
		this.localeSecondarywc = localeSecondarywc;
	}

	public Date getModDatewc() {
		return modDatewc;
	}

	public void setModDatewc(Date modDatewc) {
		this.modDatewc = modDatewc;
	}

	public Boolean getNeverReviewwc() {
		return neverReviewwc;
	}

	public void setNeverReviewwc(Boolean neverReviewwc) {
		this.neverReviewwc = neverReviewwc;
	}

	public Boolean getSmallImagewc() {
		return smallImagewc;
	}

	public void setSmallImagewc(Boolean smallImagewc) {
		this.smallImagewc = smallImagewc;
	}

	public String getTitleLangPrimarywc() {
		return titleLangPrimarywc;
	}

	public void setTitleLangPrimarywc(String titleLangPrimarywc) {
		this.titleLangPrimarywc = titleLangPrimarywc;
	}

	public String getTitleLangSecondarywc() {
		return titleLangSecondarywc;
	}

	public void setTitleLangSecondarywc(String titleLangSecondarywc) {
		this.titleLangSecondarywc = titleLangSecondarywc;
	}

	public Long getUserIdwc() {
		return userIdwc;
	}

	public void setUserIdwc(Long userIdwc) {
		this.userIdwc = userIdwc;
	}

	public String getUuIdwc() {
		return uuIdwc;
	}

	public void setUuIdwc(String uuIdwc) {
		this.uuIdwc = uuIdwc;
	}

	public Double getVersionwc() {
		return versionwc;
	}

	public void setVersionwc(Double versionwc) {
		this.versionwc = versionwc;
	}

	public Long getFileClassNameId() {
		return fileClassNameId;
	}

	public void setFileClassNameId(Long fileClassNameId) {
		this.fileClassNameId = fileClassNameId;
	}

	public Long getFileClassNamePk() {
		return fileClassNamePk;
	}

	public void setFileClassNamePk(Long fileClassNamePk) {
		this.fileClassNamePk = fileClassNamePk;
	}

	public String[] getFileDescs() {
		return fileDescs;
	}

	public void setFileDescs(String[] fileDescs) {
		this.fileDescs = fileDescs;
	}

	public Long[] getFileEntryIds() {
		return fileEntryIds;
	}

	public void setFileEntryIds(Long[] fileEntryIds) {
		this.fileEntryIds = fileEntryIds;
	}

	public String[] getFileEntryUuids() {
		return fileEntryUuids;
	}

	public void setFileEntryUuids(String[] fileEntryUuids) {
		this.fileEntryUuids = fileEntryUuids;
	}

	public String[] getFileMimes() {
		return fileMimes;
	}

	public void setFileMimes(String[] fileMimes) {
		this.fileMimes = fileMimes;
	}

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	public String[] getFileTitles() {
		return fileTitles;
	}

	public void setFileTitles(String[] fileTitles) {
		this.fileTitles = fileTitles;
	}

	public String[] getImagesB64Encoded() {
		return imagesB64Encoded;
	}

	public void setImagesB64Encoded(String[] imagesB64Encoded) {
		this.imagesB64Encoded = imagesB64Encoded;
	}

	public String getxClassName() {
		return xClassName;
	}

	public void setxClassName(String xClassName) {
		this.xClassName = xClassName;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WebContent)) {
			return false;
		}

		WebContent webContent = (WebContent) object;

		return Objects.equals(toString(), webContent.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (articleIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleIdwc\": ");

			sb.append("\"");

			sb.append(_escape(articleIdwc));

			sb.append("\"");
		}

		if (classNameIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classNameIdwc\": ");

			sb.append(classNameIdwc);
		}

		if (classPKwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPKwc\": ");

			sb.append(classPKwc);
		}

		if (contentPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(contentPrimarywc));

			sb.append("\"");
		}

		if (contentSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(contentSecondarywc));

			sb.append("\"");
		}

		if (ddmStructureIDwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureIDwc\": ");

			sb.append(ddmStructureIDwc);
		}

		if (ddmStructureKeywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureKeywc\": ");

			sb.append("\"");

			sb.append(_escape(ddmStructureKeywc));

			sb.append("\"");
		}

		if (ddmTemplateKeywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmTemplateKeywc\": ");

			sb.append("\"");

			sb.append(_escape(ddmTemplateKeywc));

			sb.append("\"");
		}

		if (defLang != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"defLang\": ");

			sb.append("\"");

			sb.append(_escape(defLang));

			sb.append("\"");
		}

		if (descLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(descLangPrimarywc));

			sb.append("\"");
		}

		if (descLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(descLangSecondarywc));

			sb.append("\"");
		}

		if (dispDatewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dispDatewc\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dispDatewc));

			sb.append("\"");
		}

		if (extReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"extReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(extReferenceCode));

			sb.append("\"");
		}

		if (fUrlLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(fUrlLangPrimarywc));

			sb.append("\"");
		}

		if (fUrlLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(fUrlLangSecondarywc));

			sb.append("\"");
		}

		if (fileClassNameId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNameId\": ");

			sb.append(fileClassNameId);
		}

		if (fileClassNamePk != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNamePk\": ");

			sb.append(fileClassNamePk);
		}

		if (fileDescs != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileDescs\": ");

			sb.append("[");

			for (int i = 0; i < fileDescs.length; i++) {
				sb.append("\"");

				sb.append(_escape(fileDescs[i]));

				sb.append("\"");

				if ((i + 1) < fileDescs.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (fileEntryIds != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryIds\": ");

			sb.append("[");

			for (int i = 0; i < fileEntryIds.length; i++) {
				sb.append(fileEntryIds[i]);

				if ((i + 1) < fileEntryIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (fileEntryUuids != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileEntryUuids\": ");

			sb.append("[");

			for (int i = 0; i < fileEntryUuids.length; i++) {
				sb.append("\"");

				sb.append(_escape(fileEntryUuids[i]));

				sb.append("\"");

				if ((i + 1) < fileEntryUuids.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (fileMimes != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileMimes\": ");

			sb.append("[");

			for (int i = 0; i < fileMimes.length; i++) {
				sb.append("\"");

				sb.append(_escape(fileMimes[i]));

				sb.append("\"");

				if ((i + 1) < fileMimes.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (fileNames != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileNames\": ");

			sb.append("[");

			for (int i = 0; i < fileNames.length; i++) {
				sb.append("\"");

				sb.append(_escape(fileNames[i]));

				sb.append("\"");

				if ((i + 1) < fileNames.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (fileTitles != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileTitles\": ");

			sb.append("[");

			for (int i = 0; i < fileTitles.length; i++) {
				sb.append("\"");

				sb.append(_escape(fileTitles[i]));

				sb.append("\"");

				if ((i + 1) < fileTitles.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (folderIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderIdwc\": ");

			sb.append(folderIdwc);
		}

		if (groupIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupIdwc\": ");

			sb.append(groupIdwc);
		}

		if (idPK != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"idPK\": ");

			sb.append(idPK);
		}

		if (imagesB64Encoded != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"imagesB64Encoded\": ");

			sb.append("[");

			for (int i = 0; i < imagesB64Encoded.length; i++) {
				sb.append("\"");

				sb.append(_escape(imagesB64Encoded[i]));

				sb.append("\"");

				if ((i + 1) < imagesB64Encoded.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (indexablewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"indexablewc\": ");

			sb.append(indexablewc);
		}

		if (layoutUuidwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"layoutUuidwc\": ");

			sb.append("\"");

			sb.append(_escape(layoutUuidwc));

			sb.append("\"");
		}

		if (localePrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localePrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(localePrimarywc));

			sb.append("\"");
		}

		if (localeSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localeSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(localeSecondarywc));

			sb.append("\"");
		}

		if (modDatewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modDatewc\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modDatewc));

			sb.append("\"");
		}

		if (neverReviewwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"neverReviewwc\": ");

			sb.append(neverReviewwc);
		}

		if (smallImagewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"smallImagewc\": ");

			sb.append(smallImagewc);
		}

		if (titleLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(titleLangPrimarywc));

			sb.append("\"");
		}

		if (titleLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(titleLangSecondarywc));

			sb.append("\"");
		}

		if (userIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userIdwc\": ");

			sb.append(userIdwc);
		}

		if (uuIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uuIdwc\": ");

			sb.append("\"");

			sb.append(_escape(uuIdwc));

			sb.append("\"");
		}

		if (versionwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"versionwc\": ");

			sb.append(versionwc);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(accessMode = Schema.AccessMode.READ_ONLY, defaultValue = "com.na.webcontent.remote.dto.v1_0.WebContent", name = "x-class-name")
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[]) value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					} else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			} else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>) value));
			} else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			} else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}
