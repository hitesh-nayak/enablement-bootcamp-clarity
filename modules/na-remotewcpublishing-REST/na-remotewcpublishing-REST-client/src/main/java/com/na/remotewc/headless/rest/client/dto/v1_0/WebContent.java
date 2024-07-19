package com.na.remotewc.headless.rest.client.dto.v1_0;

import com.na.remotewc.headless.rest.client.function.UnsafeSupplier;
import com.na.remotewc.headless.rest.client.serdes.v1_0.WebContentSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
public class WebContent implements Cloneable, Serializable {

	public static WebContent toDTO(String json) {
		return WebContentSerDes.toDTO(json);
	}

	public String getArticleIdwc() {
		return articleIdwc;
	}

	public void setArticleIdwc(String articleIdwc) {
		this.articleIdwc = articleIdwc;
	}

	public void setArticleIdwc(
		UnsafeSupplier<String, Exception> articleIdwcUnsafeSupplier) {

		try {
			articleIdwc = articleIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String articleIdwc;

	public Long getClassNameIdwc() {
		return classNameIdwc;
	}

	public void setClassNameIdwc(Long classNameIdwc) {
		this.classNameIdwc = classNameIdwc;
	}

	public void setClassNameIdwc(
		UnsafeSupplier<Long, Exception> classNameIdwcUnsafeSupplier) {

		try {
			classNameIdwc = classNameIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long classNameIdwc;

	public Long getClassPKwc() {
		return classPKwc;
	}

	public void setClassPKwc(Long classPKwc) {
		this.classPKwc = classPKwc;
	}

	public void setClassPKwc(
		UnsafeSupplier<Long, Exception> classPKwcUnsafeSupplier) {

		try {
			classPKwc = classPKwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long classPKwc;

	public String getContentPrimarywc() {
		return contentPrimarywc;
	}

	public void setContentPrimarywc(String contentPrimarywc) {
		this.contentPrimarywc = contentPrimarywc;
	}

	public void setContentPrimarywc(
		UnsafeSupplier<String, Exception> contentPrimarywcUnsafeSupplier) {

		try {
			contentPrimarywc = contentPrimarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String contentPrimarywc;

	public String getContentSecondarywc() {
		return contentSecondarywc;
	}

	public void setContentSecondarywc(String contentSecondarywc) {
		this.contentSecondarywc = contentSecondarywc;
	}

	public void setContentSecondarywc(
		UnsafeSupplier<String, Exception> contentSecondarywcUnsafeSupplier) {

		try {
			contentSecondarywc = contentSecondarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String contentSecondarywc;

	public Long getDdmStructureIDwc() {
		return ddmStructureIDwc;
	}

	public void setDdmStructureIDwc(Long ddmStructureIDwc) {
		this.ddmStructureIDwc = ddmStructureIDwc;
	}

	public void setDdmStructureIDwc(
		UnsafeSupplier<Long, Exception> ddmStructureIDwcUnsafeSupplier) {

		try {
			ddmStructureIDwc = ddmStructureIDwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long ddmStructureIDwc;

	public String getDdmStructureKeywc() {
		return ddmStructureKeywc;
	}

	public void setDdmStructureKeywc(String ddmStructureKeywc) {
		this.ddmStructureKeywc = ddmStructureKeywc;
	}

	public void setDdmStructureKeywc(
		UnsafeSupplier<String, Exception> ddmStructureKeywcUnsafeSupplier) {

		try {
			ddmStructureKeywc = ddmStructureKeywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String ddmStructureKeywc;

	public String getDdmTemplateKeywc() {
		return ddmTemplateKeywc;
	}

	public void setDdmTemplateKeywc(String ddmTemplateKeywc) {
		this.ddmTemplateKeywc = ddmTemplateKeywc;
	}

	public void setDdmTemplateKeywc(
		UnsafeSupplier<String, Exception> ddmTemplateKeywcUnsafeSupplier) {

		try {
			ddmTemplateKeywc = ddmTemplateKeywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String ddmTemplateKeywc;

	public String getDefLang() {
		return defLang;
	}

	public void setDefLang(String defLang) {
		this.defLang = defLang;
	}

	public void setDefLang(
		UnsafeSupplier<String, Exception> defLangUnsafeSupplier) {

		try {
			defLang = defLangUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String defLang;

	public String getDescLangPrimarywc() {
		return descLangPrimarywc;
	}

	public void setDescLangPrimarywc(String descLangPrimarywc) {
		this.descLangPrimarywc = descLangPrimarywc;
	}

	public void setDescLangPrimarywc(
		UnsafeSupplier<String, Exception> descLangPrimarywcUnsafeSupplier) {

		try {
			descLangPrimarywc = descLangPrimarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String descLangPrimarywc;

	public String getDescLangSecondarywc() {
		return descLangSecondarywc;
	}

	public void setDescLangSecondarywc(String descLangSecondarywc) {
		this.descLangSecondarywc = descLangSecondarywc;
	}

	public void setDescLangSecondarywc(
		UnsafeSupplier<String, Exception> descLangSecondarywcUnsafeSupplier) {

		try {
			descLangSecondarywc = descLangSecondarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String descLangSecondarywc;

	public Date getDispDatewc() {
		return dispDatewc;
	}

	public void setDispDatewc(Date dispDatewc) {
		this.dispDatewc = dispDatewc;
	}

	public void setDispDatewc(
		UnsafeSupplier<Date, Exception> dispDatewcUnsafeSupplier) {

		try {
			dispDatewc = dispDatewcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dispDatewc;

	public String getExtReferenceCode() {
		return extReferenceCode;
	}

	public void setExtReferenceCode(String extReferenceCode) {
		this.extReferenceCode = extReferenceCode;
	}

	public void setExtReferenceCode(
		UnsafeSupplier<String, Exception> extReferenceCodeUnsafeSupplier) {

		try {
			extReferenceCode = extReferenceCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String extReferenceCode;

	public String getFUrlLangPrimarywc() {
		return fUrlLangPrimarywc;
	}

	public void setFUrlLangPrimarywc(String fUrlLangPrimarywc) {
		this.fUrlLangPrimarywc = fUrlLangPrimarywc;
	}

	public void setFUrlLangPrimarywc(
		UnsafeSupplier<String, Exception> fUrlLangPrimarywcUnsafeSupplier) {

		try {
			fUrlLangPrimarywc = fUrlLangPrimarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fUrlLangPrimarywc;

	public String getFUrlLangSecondarywc() {
		return fUrlLangSecondarywc;
	}

	public void setFUrlLangSecondarywc(String fUrlLangSecondarywc) {
		this.fUrlLangSecondarywc = fUrlLangSecondarywc;
	}

	public void setFUrlLangSecondarywc(
		UnsafeSupplier<String, Exception> fUrlLangSecondarywcUnsafeSupplier) {

		try {
			fUrlLangSecondarywc = fUrlLangSecondarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fUrlLangSecondarywc;

	public Long getFileClassNameId() {
		return fileClassNameId;
	}

	public void setFileClassNameId(Long fileClassNameId) {
		this.fileClassNameId = fileClassNameId;
	}

	public void setFileClassNameId(
		UnsafeSupplier<Long, Exception> fileClassNameIdUnsafeSupplier) {

		try {
			fileClassNameId = fileClassNameIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileClassNameId;

	public Long getFileClassNamePk() {
		return fileClassNamePk;
	}

	public void setFileClassNamePk(Long fileClassNamePk) {
		this.fileClassNamePk = fileClassNamePk;
	}

	public void setFileClassNamePk(
		UnsafeSupplier<Long, Exception> fileClassNamePkUnsafeSupplier) {

		try {
			fileClassNamePk = fileClassNamePkUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long fileClassNamePk;

	public String[] getFileDescs() {
		return fileDescs;
	}

	public void setFileDescs(String[] fileDescs) {
		this.fileDescs = fileDescs;
	}

	public void setFileDescs(
		UnsafeSupplier<String[], Exception> fileDescsUnsafeSupplier) {

		try {
			fileDescs = fileDescsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fileDescs;

	public Long[] getFileEntryIds() {
		return fileEntryIds;
	}

	public void setFileEntryIds(Long[] fileEntryIds) {
		this.fileEntryIds = fileEntryIds;
	}

	public void setFileEntryIds(
		UnsafeSupplier<Long[], Exception> fileEntryIdsUnsafeSupplier) {

		try {
			fileEntryIds = fileEntryIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] fileEntryIds;

	public String[] getFileEntryUuids() {
		return fileEntryUuids;
	}

	public void setFileEntryUuids(String[] fileEntryUuids) {
		this.fileEntryUuids = fileEntryUuids;
	}

	public void setFileEntryUuids(
		UnsafeSupplier<String[], Exception> fileEntryUuidsUnsafeSupplier) {

		try {
			fileEntryUuids = fileEntryUuidsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fileEntryUuids;

	public String[] getFileMimes() {
		return fileMimes;
	}

	public void setFileMimes(String[] fileMimes) {
		this.fileMimes = fileMimes;
	}

	public void setFileMimes(
		UnsafeSupplier<String[], Exception> fileMimesUnsafeSupplier) {

		try {
			fileMimes = fileMimesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fileMimes;

	public String[] getFileNames() {
		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	public void setFileNames(
		UnsafeSupplier<String[], Exception> fileNamesUnsafeSupplier) {

		try {
			fileNames = fileNamesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fileNames;

	public String[] getFileTitles() {
		return fileTitles;
	}

	public void setFileTitles(String[] fileTitles) {
		this.fileTitles = fileTitles;
	}

	public void setFileTitles(
		UnsafeSupplier<String[], Exception> fileTitlesUnsafeSupplier) {

		try {
			fileTitles = fileTitlesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] fileTitles;

	public Long getFolderIdwc() {
		return folderIdwc;
	}

	public void setFolderIdwc(Long folderIdwc) {
		this.folderIdwc = folderIdwc;
	}

	public void setFolderIdwc(
		UnsafeSupplier<Long, Exception> folderIdwcUnsafeSupplier) {

		try {
			folderIdwc = folderIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long folderIdwc;

	public Long getGroupIdwc() {
		return groupIdwc;
	}

	public void setGroupIdwc(Long groupIdwc) {
		this.groupIdwc = groupIdwc;
	}

	public void setGroupIdwc(
		UnsafeSupplier<Long, Exception> groupIdwcUnsafeSupplier) {

		try {
			groupIdwc = groupIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long groupIdwc;

	public Long getIdPK() {
		return idPK;
	}

	public void setIdPK(Long idPK) {
		this.idPK = idPK;
	}

	public void setIdPK(UnsafeSupplier<Long, Exception> idPKUnsafeSupplier) {
		try {
			idPK = idPKUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long idPK;

	public String[] getImagesB64Encoded() {
		return imagesB64Encoded;
	}

	public void setImagesB64Encoded(String[] imagesB64Encoded) {
		this.imagesB64Encoded = imagesB64Encoded;
	}

	public void setImagesB64Encoded(
		UnsafeSupplier<String[], Exception> imagesB64EncodedUnsafeSupplier) {

		try {
			imagesB64Encoded = imagesB64EncodedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] imagesB64Encoded;

	public Boolean getIndexablewc() {
		return indexablewc;
	}

	public void setIndexablewc(Boolean indexablewc) {
		this.indexablewc = indexablewc;
	}

	public void setIndexablewc(
		UnsafeSupplier<Boolean, Exception> indexablewcUnsafeSupplier) {

		try {
			indexablewc = indexablewcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean indexablewc;

	public String getLayoutUuidwc() {
		return layoutUuidwc;
	}

	public void setLayoutUuidwc(String layoutUuidwc) {
		this.layoutUuidwc = layoutUuidwc;
	}

	public void setLayoutUuidwc(
		UnsafeSupplier<String, Exception> layoutUuidwcUnsafeSupplier) {

		try {
			layoutUuidwc = layoutUuidwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String layoutUuidwc;

	public String getLocalePrimarywc() {
		return localePrimarywc;
	}

	public void setLocalePrimarywc(String localePrimarywc) {
		this.localePrimarywc = localePrimarywc;
	}

	public void setLocalePrimarywc(
		UnsafeSupplier<String, Exception> localePrimarywcUnsafeSupplier) {

		try {
			localePrimarywc = localePrimarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String localePrimarywc;

	public String getLocaleSecondarywc() {
		return localeSecondarywc;
	}

	public void setLocaleSecondarywc(String localeSecondarywc) {
		this.localeSecondarywc = localeSecondarywc;
	}

	public void setLocaleSecondarywc(
		UnsafeSupplier<String, Exception> localeSecondarywcUnsafeSupplier) {

		try {
			localeSecondarywc = localeSecondarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String localeSecondarywc;

	public Date getModDatewc() {
		return modDatewc;
	}

	public void setModDatewc(Date modDatewc) {
		this.modDatewc = modDatewc;
	}

	public void setModDatewc(
		UnsafeSupplier<Date, Exception> modDatewcUnsafeSupplier) {

		try {
			modDatewc = modDatewcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date modDatewc;

	public Boolean getNeverReviewwc() {
		return neverReviewwc;
	}

	public void setNeverReviewwc(Boolean neverReviewwc) {
		this.neverReviewwc = neverReviewwc;
	}

	public void setNeverReviewwc(
		UnsafeSupplier<Boolean, Exception> neverReviewwcUnsafeSupplier) {

		try {
			neverReviewwc = neverReviewwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean neverReviewwc;

	public Boolean getSmallImagewc() {
		return smallImagewc;
	}

	public void setSmallImagewc(Boolean smallImagewc) {
		this.smallImagewc = smallImagewc;
	}

	public void setSmallImagewc(
		UnsafeSupplier<Boolean, Exception> smallImagewcUnsafeSupplier) {

		try {
			smallImagewc = smallImagewcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean smallImagewc;

	public String getTitleLangPrimarywc() {
		return titleLangPrimarywc;
	}

	public void setTitleLangPrimarywc(String titleLangPrimarywc) {
		this.titleLangPrimarywc = titleLangPrimarywc;
	}

	public void setTitleLangPrimarywc(
		UnsafeSupplier<String, Exception> titleLangPrimarywcUnsafeSupplier) {

		try {
			titleLangPrimarywc = titleLangPrimarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String titleLangPrimarywc;

	public String getTitleLangSecondarywc() {
		return titleLangSecondarywc;
	}

	public void setTitleLangSecondarywc(String titleLangSecondarywc) {
		this.titleLangSecondarywc = titleLangSecondarywc;
	}

	public void setTitleLangSecondarywc(
		UnsafeSupplier<String, Exception> titleLangSecondarywcUnsafeSupplier) {

		try {
			titleLangSecondarywc = titleLangSecondarywcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String titleLangSecondarywc;

	public Long getUserIdwc() {
		return userIdwc;
	}

	public void setUserIdwc(Long userIdwc) {
		this.userIdwc = userIdwc;
	}

	public void setUserIdwc(
		UnsafeSupplier<Long, Exception> userIdwcUnsafeSupplier) {

		try {
			userIdwc = userIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userIdwc;

	public String getUuIdwc() {
		return uuIdwc;
	}

	public void setUuIdwc(String uuIdwc) {
		this.uuIdwc = uuIdwc;
	}

	public void setUuIdwc(
		UnsafeSupplier<String, Exception> uuIdwcUnsafeSupplier) {

		try {
			uuIdwc = uuIdwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String uuIdwc;

	public Double getVersionwc() {
		return versionwc;
	}

	public void setVersionwc(Double versionwc) {
		this.versionwc = versionwc;
	}

	public void setVersionwc(
		UnsafeSupplier<Double, Exception> versionwcUnsafeSupplier) {

		try {
			versionwc = versionwcUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double versionwc;

	@Override
	public WebContent clone() throws CloneNotSupportedException {
		return (WebContent)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WebContent)) {
			return false;
		}

		WebContent webContent = (WebContent)object;

		return Objects.equals(toString(), webContent.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return WebContentSerDes.toJSON(this);
	}

}