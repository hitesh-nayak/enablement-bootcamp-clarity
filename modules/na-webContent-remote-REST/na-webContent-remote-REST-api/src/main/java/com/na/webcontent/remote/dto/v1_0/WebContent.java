package com.na.webcontent.remote.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "Retrieves a journal article from the database based on a parameter.",
	value = "WebContent"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "WebContent")
public class WebContent implements Serializable {

	public static WebContent toDTO(String json) {
		return ObjectMapperUtil.readValue(WebContent.class, json);
	}

	public static WebContent unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(WebContent.class, json);
	}

	@Schema(
		description = "The primary key of the wc article(may be same for diff ver.)."
	)
	public String getArticleIdwc() {
		if (_articleIdwcSupplier != null) {
			articleIdwc = _articleIdwcSupplier.get();

			_articleIdwcSupplier = null;
		}

		return articleIdwc;
	}

	public void setArticleIdwc(String articleIdwc) {
		this.articleIdwc = articleIdwc;

		_articleIdwcSupplier = null;
	}

	@JsonIgnore
	public void setArticleIdwc(
		UnsafeSupplier<String, Exception> articleIdwcUnsafeSupplier) {

		_articleIdwcSupplier = () -> {
			try {
				return articleIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "The primary key of the wc article(may be same for diff ver.)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String articleIdwc;

	@JsonIgnore
	private Supplier<String> _articleIdwcSupplier;

	@Schema(description = "PK of DDMStr class IF wc is asscociated.")
	public Long getClassNameIdwc() {
		if (_classNameIdwcSupplier != null) {
			classNameIdwc = _classNameIdwcSupplier.get();

			_classNameIdwcSupplier = null;
		}

		return classNameIdwc;
	}

	public void setClassNameIdwc(Long classNameIdwc) {
		this.classNameIdwc = classNameIdwc;

		_classNameIdwcSupplier = null;
	}

	@JsonIgnore
	public void setClassNameIdwc(
		UnsafeSupplier<Long, Exception> classNameIdwcUnsafeSupplier) {

		_classNameIdwcSupplier = () -> {
			try {
				return classNameIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "PK of DDMStr class IF wc is asscociated.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long classNameIdwc;

	@JsonIgnore
	private Supplier<Long> _classNameIdwcSupplier;

	@Schema(description = "PK of DDMStr IF wc is asscociated.")
	public Long getClassPKwc() {
		if (_classPKwcSupplier != null) {
			classPKwc = _classPKwcSupplier.get();

			_classPKwcSupplier = null;
		}

		return classPKwc;
	}

	public void setClassPKwc(Long classPKwc) {
		this.classPKwc = classPKwc;

		_classPKwcSupplier = null;
	}

	@JsonIgnore
	public void setClassPKwc(
		UnsafeSupplier<Long, Exception> classPKwcUnsafeSupplier) {

		_classPKwcSupplier = () -> {
			try {
				return classPKwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "PK of DDMStr IF wc is asscociated.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long classPKwc;

	@JsonIgnore
	private Supplier<Long> _classPKwcSupplier;

	@Schema(description = "HTML content wrapped in XML.")
	public String getContentPrimarywc() {
		if (_contentPrimarywcSupplier != null) {
			contentPrimarywc = _contentPrimarywcSupplier.get();

			_contentPrimarywcSupplier = null;
		}

		return contentPrimarywc;
	}

	public void setContentPrimarywc(String contentPrimarywc) {
		this.contentPrimarywc = contentPrimarywc;

		_contentPrimarywcSupplier = null;
	}

	@JsonIgnore
	public void setContentPrimarywc(
		UnsafeSupplier<String, Exception> contentPrimarywcUnsafeSupplier) {

		_contentPrimarywcSupplier = () -> {
			try {
				return contentPrimarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "HTML content wrapped in XML.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String contentPrimarywc;

	@JsonIgnore
	private Supplier<String> _contentPrimarywcSupplier;

	@Schema(description = "HTML content wrapped in XML.")
	public String getContentSecondarywc() {
		if (_contentSecondarywcSupplier != null) {
			contentSecondarywc = _contentSecondarywcSupplier.get();

			_contentSecondarywcSupplier = null;
		}

		return contentSecondarywc;
	}

	public void setContentSecondarywc(String contentSecondarywc) {
		this.contentSecondarywc = contentSecondarywc;

		_contentSecondarywcSupplier = null;
	}

	@JsonIgnore
	public void setContentSecondarywc(
		UnsafeSupplier<String, Exception> contentSecondarywcUnsafeSupplier) {

		_contentSecondarywcSupplier = () -> {
			try {
				return contentSecondarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "HTML content wrapped in XML.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String contentSecondarywc;

	@JsonIgnore
	private Supplier<String> _contentSecondarywcSupplier;

	@Schema(description = "ID of the PK of DDMStr if the wc is assoc. or '0'")
	public Long getDdmStructureIDwc() {
		if (_ddmStructureIDwcSupplier != null) {
			ddmStructureIDwc = _ddmStructureIDwcSupplier.get();

			_ddmStructureIDwcSupplier = null;
		}

		return ddmStructureIDwc;
	}

	public void setDdmStructureIDwc(Long ddmStructureIDwc) {
		this.ddmStructureIDwc = ddmStructureIDwc;

		_ddmStructureIDwcSupplier = null;
	}

	@JsonIgnore
	public void setDdmStructureIDwc(
		UnsafeSupplier<Long, Exception> ddmStructureIDwcUnsafeSupplier) {

		_ddmStructureIDwcSupplier = () -> {
			try {
				return ddmStructureIDwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "ID of the PK of DDMStr if the wc is assoc. or '0'"
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long ddmStructureIDwc;

	@JsonIgnore
	private Supplier<Long> _ddmStructureIDwcSupplier;

	@Schema(description = "Key of the DDMStruc of the wc")
	public String getDdmStructureKeywc() {
		if (_ddmStructureKeywcSupplier != null) {
			ddmStructureKeywc = _ddmStructureKeywcSupplier.get();

			_ddmStructureKeywcSupplier = null;
		}

		return ddmStructureKeywc;
	}

	public void setDdmStructureKeywc(String ddmStructureKeywc) {
		this.ddmStructureKeywc = ddmStructureKeywc;

		_ddmStructureKeywcSupplier = null;
	}

	@JsonIgnore
	public void setDdmStructureKeywc(
		UnsafeSupplier<String, Exception> ddmStructureKeywcUnsafeSupplier) {

		_ddmStructureKeywcSupplier = () -> {
			try {
				return ddmStructureKeywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Key of the DDMStruc of the wc")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String ddmStructureKeywc;

	@JsonIgnore
	private Supplier<String> _ddmStructureKeywcSupplier;

	@Schema(description = "PK of the wc's DDMTemp.")
	public String getDdmTemplateKeywc() {
		if (_ddmTemplateKeywcSupplier != null) {
			ddmTemplateKeywc = _ddmTemplateKeywcSupplier.get();

			_ddmTemplateKeywcSupplier = null;
		}

		return ddmTemplateKeywc;
	}

	public void setDdmTemplateKeywc(String ddmTemplateKeywc) {
		this.ddmTemplateKeywc = ddmTemplateKeywc;

		_ddmTemplateKeywcSupplier = null;
	}

	@JsonIgnore
	public void setDdmTemplateKeywc(
		UnsafeSupplier<String, Exception> ddmTemplateKeywcUnsafeSupplier) {

		_ddmTemplateKeywcSupplier = () -> {
			try {
				return ddmTemplateKeywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "PK of the wc's DDMTemp.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String ddmTemplateKeywc;

	@JsonIgnore
	private Supplier<String> _ddmTemplateKeywcSupplier;

	@Schema(description = "Default Lang of the wc.")
	public String getDefLang() {
		if (_defLangSupplier != null) {
			defLang = _defLangSupplier.get();

			_defLangSupplier = null;
		}

		return defLang;
	}

	public void setDefLang(String defLang) {
		this.defLang = defLang;

		_defLangSupplier = null;
	}

	@JsonIgnore
	public void setDefLang(
		UnsafeSupplier<String, Exception> defLangUnsafeSupplier) {

		_defLangSupplier = () -> {
			try {
				return defLangUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Default Lang of the wc.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String defLang;

	@JsonIgnore
	private Supplier<String> _defLangSupplier;

	@Schema(description = "Desc of wc in default language.")
	public String getDescLangPrimarywc() {
		if (_descLangPrimarywcSupplier != null) {
			descLangPrimarywc = _descLangPrimarywcSupplier.get();

			_descLangPrimarywcSupplier = null;
		}

		return descLangPrimarywc;
	}

	public void setDescLangPrimarywc(String descLangPrimarywc) {
		this.descLangPrimarywc = descLangPrimarywc;

		_descLangPrimarywcSupplier = null;
	}

	@JsonIgnore
	public void setDescLangPrimarywc(
		UnsafeSupplier<String, Exception> descLangPrimarywcUnsafeSupplier) {

		_descLangPrimarywcSupplier = () -> {
			try {
				return descLangPrimarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Desc of wc in default language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String descLangPrimarywc;

	@JsonIgnore
	private Supplier<String> _descLangPrimarywcSupplier;

	@Schema(description = "Desc of wc in secondary language.")
	public String getDescLangSecondarywc() {
		if (_descLangSecondarywcSupplier != null) {
			descLangSecondarywc = _descLangSecondarywcSupplier.get();

			_descLangSecondarywcSupplier = null;
		}

		return descLangSecondarywc;
	}

	public void setDescLangSecondarywc(String descLangSecondarywc) {
		this.descLangSecondarywc = descLangSecondarywc;

		_descLangSecondarywcSupplier = null;
	}

	@JsonIgnore
	public void setDescLangSecondarywc(
		UnsafeSupplier<String, Exception> descLangSecondarywcUnsafeSupplier) {

		_descLangSecondarywcSupplier = () -> {
			try {
				return descLangSecondarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Desc of wc in secondary language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String descLangSecondarywc;

	@JsonIgnore
	private Supplier<String> _descLangSecondarywcSupplier;

	@Schema(description = "Date the wc is set to display.")
	public Date getDispDatewc() {
		if (_dispDatewcSupplier != null) {
			dispDatewc = _dispDatewcSupplier.get();

			_dispDatewcSupplier = null;
		}

		return dispDatewc;
	}

	public void setDispDatewc(Date dispDatewc) {
		this.dispDatewc = dispDatewc;

		_dispDatewcSupplier = null;
	}

	@JsonIgnore
	public void setDispDatewc(
		UnsafeSupplier<Date, Exception> dispDatewcUnsafeSupplier) {

		_dispDatewcSupplier = () -> {
			try {
				return dispDatewcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Date the wc is set to display.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date dispDatewc;

	@JsonIgnore
	private Supplier<Date> _dispDatewcSupplier;

	@Schema(description = "The ext ref code.")
	public String getExtReferenceCode() {
		if (_extReferenceCodeSupplier != null) {
			extReferenceCode = _extReferenceCodeSupplier.get();

			_extReferenceCodeSupplier = null;
		}

		return extReferenceCode;
	}

	public void setExtReferenceCode(String extReferenceCode) {
		this.extReferenceCode = extReferenceCode;

		_extReferenceCodeSupplier = null;
	}

	@JsonIgnore
	public void setExtReferenceCode(
		UnsafeSupplier<String, Exception> extReferenceCodeUnsafeSupplier) {

		_extReferenceCodeSupplier = () -> {
			try {
				return extReferenceCodeUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "The ext ref code.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String extReferenceCode;

	@JsonIgnore
	private Supplier<String> _extReferenceCodeSupplier;

	@Schema(description = "Desc of wc in default language.")
	public String getFUrlLangPrimarywc() {
		if (_fUrlLangPrimarywcSupplier != null) {
			fUrlLangPrimarywc = _fUrlLangPrimarywcSupplier.get();

			_fUrlLangPrimarywcSupplier = null;
		}

		return fUrlLangPrimarywc;
	}

	public void setFUrlLangPrimarywc(String fUrlLangPrimarywc) {
		this.fUrlLangPrimarywc = fUrlLangPrimarywc;

		_fUrlLangPrimarywcSupplier = null;
	}

	@JsonIgnore
	public void setFUrlLangPrimarywc(
		UnsafeSupplier<String, Exception> fUrlLangPrimarywcUnsafeSupplier) {

		_fUrlLangPrimarywcSupplier = () -> {
			try {
				return fUrlLangPrimarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Desc of wc in default language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String fUrlLangPrimarywc;

	@JsonIgnore
	private Supplier<String> _fUrlLangPrimarywcSupplier;

	@Schema(description = "Desc of wc in secondary language.")
	public String getFUrlLangSecondarywc() {
		if (_fUrlLangSecondarywcSupplier != null) {
			fUrlLangSecondarywc = _fUrlLangSecondarywcSupplier.get();

			_fUrlLangSecondarywcSupplier = null;
		}

		return fUrlLangSecondarywc;
	}

	public void setFUrlLangSecondarywc(String fUrlLangSecondarywc) {
		this.fUrlLangSecondarywc = fUrlLangSecondarywc;

		_fUrlLangSecondarywcSupplier = null;
	}

	@JsonIgnore
	public void setFUrlLangSecondarywc(
		UnsafeSupplier<String, Exception> fUrlLangSecondarywcUnsafeSupplier) {

		_fUrlLangSecondarywcSupplier = () -> {
			try {
				return fUrlLangSecondarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Desc of wc in secondary language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String fUrlLangSecondarywc;

	@JsonIgnore
	private Supplier<String> _fUrlLangSecondarywcSupplier;

	@Schema(description = "cnid of the content the files are assoc. with.")
	public Long getFileClassNameId() {
		if (_fileClassNameIdSupplier != null) {
			fileClassNameId = _fileClassNameIdSupplier.get();

			_fileClassNameIdSupplier = null;
		}

		return fileClassNameId;
	}

	public void setFileClassNameId(Long fileClassNameId) {
		this.fileClassNameId = fileClassNameId;

		_fileClassNameIdSupplier = null;
	}

	@JsonIgnore
	public void setFileClassNameId(
		UnsafeSupplier<Long, Exception> fileClassNameIdUnsafeSupplier) {

		_fileClassNameIdSupplier = () -> {
			try {
				return fileClassNameIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "cnid of the content the files are assoc. with."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileClassNameId;

	@JsonIgnore
	private Supplier<Long> _fileClassNameIdSupplier;

	@Schema(
		description = "resprimkey of the web-content the files are assoc. with."
	)
	public Long getFileClassNamePk() {
		if (_fileClassNamePkSupplier != null) {
			fileClassNamePk = _fileClassNamePkSupplier.get();

			_fileClassNamePkSupplier = null;
		}

		return fileClassNamePk;
	}

	public void setFileClassNamePk(Long fileClassNamePk) {
		this.fileClassNamePk = fileClassNamePk;

		_fileClassNamePkSupplier = null;
	}

	@JsonIgnore
	public void setFileClassNamePk(
		UnsafeSupplier<Long, Exception> fileClassNamePkUnsafeSupplier) {

		_fileClassNamePkSupplier = () -> {
			try {
				return fileClassNamePkUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "resprimkey of the web-content the files are assoc. with."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long fileClassNamePk;

	@JsonIgnore
	private Supplier<Long> _fileClassNamePkSupplier;

	@Schema(description = "file descs.")
	public String[] getFileDescs() {
		if (_fileDescsSupplier != null) {
			fileDescs = _fileDescsSupplier.get();

			_fileDescsSupplier = null;
		}

		return fileDescs;
	}

	public void setFileDescs(String[] fileDescs) {
		this.fileDescs = fileDescs;

		_fileDescsSupplier = null;
	}

	@JsonIgnore
	public void setFileDescs(
		UnsafeSupplier<String[], Exception> fileDescsUnsafeSupplier) {

		_fileDescsSupplier = () -> {
			try {
				return fileDescsUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "file descs.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] fileDescs;

	@JsonIgnore
	private Supplier<String[]> _fileDescsSupplier;

	@Schema(description = "Ids of associated files.")
	public Long[] getFileEntryIds() {
		if (_fileEntryIdsSupplier != null) {
			fileEntryIds = _fileEntryIdsSupplier.get();

			_fileEntryIdsSupplier = null;
		}

		return fileEntryIds;
	}

	public void setFileEntryIds(Long[] fileEntryIds) {
		this.fileEntryIds = fileEntryIds;

		_fileEntryIdsSupplier = null;
	}

	@JsonIgnore
	public void setFileEntryIds(
		UnsafeSupplier<Long[], Exception> fileEntryIdsUnsafeSupplier) {

		_fileEntryIdsSupplier = () -> {
			try {
				return fileEntryIdsUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Ids of associated files.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] fileEntryIds;

	@JsonIgnore
	private Supplier<Long[]> _fileEntryIdsSupplier;

	@Schema(description = "fileEntry uuids.")
	public String[] getFileEntryUuids() {
		if (_fileEntryUuidsSupplier != null) {
			fileEntryUuids = _fileEntryUuidsSupplier.get();

			_fileEntryUuidsSupplier = null;
		}

		return fileEntryUuids;
	}

	public void setFileEntryUuids(String[] fileEntryUuids) {
		this.fileEntryUuids = fileEntryUuids;

		_fileEntryUuidsSupplier = null;
	}

	@JsonIgnore
	public void setFileEntryUuids(
		UnsafeSupplier<String[], Exception> fileEntryUuidsUnsafeSupplier) {

		_fileEntryUuidsSupplier = () -> {
			try {
				return fileEntryUuidsUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "fileEntry uuids.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] fileEntryUuids;

	@JsonIgnore
	private Supplier<String[]> _fileEntryUuidsSupplier;

	@Schema(description = "file mime types.")
	public String[] getFileMimes() {
		if (_fileMimesSupplier != null) {
			fileMimes = _fileMimesSupplier.get();

			_fileMimesSupplier = null;
		}

		return fileMimes;
	}

	public void setFileMimes(String[] fileMimes) {
		this.fileMimes = fileMimes;

		_fileMimesSupplier = null;
	}

	@JsonIgnore
	public void setFileMimes(
		UnsafeSupplier<String[], Exception> fileMimesUnsafeSupplier) {

		_fileMimesSupplier = () -> {
			try {
				return fileMimesUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "file mime types.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] fileMimes;

	@JsonIgnore
	private Supplier<String[]> _fileMimesSupplier;

	@Schema(description = "file names.")
	public String[] getFileNames() {
		if (_fileNamesSupplier != null) {
			fileNames = _fileNamesSupplier.get();

			_fileNamesSupplier = null;
		}

		return fileNames;
	}

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;

		_fileNamesSupplier = null;
	}

	@JsonIgnore
	public void setFileNames(
		UnsafeSupplier<String[], Exception> fileNamesUnsafeSupplier) {

		_fileNamesSupplier = () -> {
			try {
				return fileNamesUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "file names.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] fileNames;

	@JsonIgnore
	private Supplier<String[]> _fileNamesSupplier;

	@Schema(description = "file titles.")
	public String[] getFileTitles() {
		if (_fileTitlesSupplier != null) {
			fileTitles = _fileTitlesSupplier.get();

			_fileTitlesSupplier = null;
		}

		return fileTitles;
	}

	public void setFileTitles(String[] fileTitles) {
		this.fileTitles = fileTitles;

		_fileTitlesSupplier = null;
	}

	@JsonIgnore
	public void setFileTitles(
		UnsafeSupplier<String[], Exception> fileTitlesUnsafeSupplier) {

		_fileTitlesSupplier = () -> {
			try {
				return fileTitlesUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "file titles.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] fileTitles;

	@JsonIgnore
	private Supplier<String[]> _fileTitlesSupplier;

	@Schema(description = "PK of wc article folder.")
	public Long getFolderIdwc() {
		if (_folderIdwcSupplier != null) {
			folderIdwc = _folderIdwcSupplier.get();

			_folderIdwcSupplier = null;
		}

		return folderIdwc;
	}

	public void setFolderIdwc(Long folderIdwc) {
		this.folderIdwc = folderIdwc;

		_folderIdwcSupplier = null;
	}

	@JsonIgnore
	public void setFolderIdwc(
		UnsafeSupplier<Long, Exception> folderIdwcUnsafeSupplier) {

		_folderIdwcSupplier = () -> {
			try {
				return folderIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "PK of wc article folder.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long folderIdwc;

	@JsonIgnore
	private Supplier<Long> _folderIdwcSupplier;

	@Schema(description = "aka site ID.")
	public Long getGroupIdwc() {
		if (_groupIdwcSupplier != null) {
			groupIdwc = _groupIdwcSupplier.get();

			_groupIdwcSupplier = null;
		}

		return groupIdwc;
	}

	public void setGroupIdwc(Long groupIdwc) {
		this.groupIdwc = groupIdwc;

		_groupIdwcSupplier = null;
	}

	@JsonIgnore
	public void setGroupIdwc(
		UnsafeSupplier<Long, Exception> groupIdwcUnsafeSupplier) {

		_groupIdwcSupplier = () -> {
			try {
				return groupIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "aka site ID.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long groupIdwc;

	@JsonIgnore
	private Supplier<Long> _groupIdwcSupplier;

	@Schema(
		description = "Unique id of the journal article. PK of JournalArticle table."
	)
	public Long getIdPK() {
		if (_idPKSupplier != null) {
			idPK = _idPKSupplier.get();

			_idPKSupplier = null;
		}

		return idPK;
	}

	public void setIdPK(Long idPK) {
		this.idPK = idPK;

		_idPKSupplier = null;
	}

	@JsonIgnore
	public void setIdPK(UnsafeSupplier<Long, Exception> idPKUnsafeSupplier) {
		_idPKSupplier = () -> {
			try {
				return idPKUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(
		description = "Unique id of the journal article. PK of JournalArticle table."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long idPK;

	@JsonIgnore
	private Supplier<Long> _idPKSupplier;

	@Schema(description = "Images in Base64.")
	public String[] getImagesB64Encoded() {
		if (_imagesB64EncodedSupplier != null) {
			imagesB64Encoded = _imagesB64EncodedSupplier.get();

			_imagesB64EncodedSupplier = null;
		}

		return imagesB64Encoded;
	}

	public void setImagesB64Encoded(String[] imagesB64Encoded) {
		this.imagesB64Encoded = imagesB64Encoded;

		_imagesB64EncodedSupplier = null;
	}

	@JsonIgnore
	public void setImagesB64Encoded(
		UnsafeSupplier<String[], Exception> imagesB64EncodedUnsafeSupplier) {

		_imagesB64EncodedSupplier = () -> {
			try {
				return imagesB64EncodedUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Images in Base64.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String[] imagesB64Encoded;

	@JsonIgnore
	private Supplier<String[]> _imagesB64EncodedSupplier;

	@Schema(description = "Is the wc searchable.")
	public Boolean getIndexablewc() {
		if (_indexablewcSupplier != null) {
			indexablewc = _indexablewcSupplier.get();

			_indexablewcSupplier = null;
		}

		return indexablewc;
	}

	public void setIndexablewc(Boolean indexablewc) {
		this.indexablewc = indexablewc;

		_indexablewcSupplier = null;
	}

	@JsonIgnore
	public void setIndexablewc(
		UnsafeSupplier<Boolean, Exception> indexablewcUnsafeSupplier) {

		_indexablewcSupplier = () -> {
			try {
				return indexablewcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Is the wc searchable.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean indexablewc;

	@JsonIgnore
	private Supplier<Boolean> _indexablewcSupplier;

	@Schema(description = "Unique string of the wc's disp page.")
	public String getLayoutUuidwc() {
		if (_layoutUuidwcSupplier != null) {
			layoutUuidwc = _layoutUuidwcSupplier.get();

			_layoutUuidwcSupplier = null;
		}

		return layoutUuidwc;
	}

	public void setLayoutUuidwc(String layoutUuidwc) {
		this.layoutUuidwc = layoutUuidwc;

		_layoutUuidwcSupplier = null;
	}

	@JsonIgnore
	public void setLayoutUuidwc(
		UnsafeSupplier<String, Exception> layoutUuidwcUnsafeSupplier) {

		_layoutUuidwcSupplier = () -> {
			try {
				return layoutUuidwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Unique string of the wc's disp page.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String layoutUuidwc;

	@JsonIgnore
	private Supplier<String> _layoutUuidwcSupplier;

	@Schema(description = "Default locale of the wc.")
	public String getLocalePrimarywc() {
		if (_localePrimarywcSupplier != null) {
			localePrimarywc = _localePrimarywcSupplier.get();

			_localePrimarywcSupplier = null;
		}

		return localePrimarywc;
	}

	public void setLocalePrimarywc(String localePrimarywc) {
		this.localePrimarywc = localePrimarywc;

		_localePrimarywcSupplier = null;
	}

	@JsonIgnore
	public void setLocalePrimarywc(
		UnsafeSupplier<String, Exception> localePrimarywcUnsafeSupplier) {

		_localePrimarywcSupplier = () -> {
			try {
				return localePrimarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Default locale of the wc.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String localePrimarywc;

	@JsonIgnore
	private Supplier<String> _localePrimarywcSupplier;

	@Schema(description = "Secondary locale of the wc.")
	public String getLocaleSecondarywc() {
		if (_localeSecondarywcSupplier != null) {
			localeSecondarywc = _localeSecondarywcSupplier.get();

			_localeSecondarywcSupplier = null;
		}

		return localeSecondarywc;
	}

	public void setLocaleSecondarywc(String localeSecondarywc) {
		this.localeSecondarywc = localeSecondarywc;

		_localeSecondarywcSupplier = null;
	}

	@JsonIgnore
	public void setLocaleSecondarywc(
		UnsafeSupplier<String, Exception> localeSecondarywcUnsafeSupplier) {

		_localeSecondarywcSupplier = () -> {
			try {
				return localeSecondarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Secondary locale of the wc.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String localeSecondarywc;

	@JsonIgnore
	private Supplier<String> _localeSecondarywcSupplier;

	@Schema(description = "Date the wc was last modified.")
	public Date getModDatewc() {
		if (_modDatewcSupplier != null) {
			modDatewc = _modDatewcSupplier.get();

			_modDatewcSupplier = null;
		}

		return modDatewc;
	}

	public void setModDatewc(Date modDatewc) {
		this.modDatewc = modDatewc;

		_modDatewcSupplier = null;
	}

	@JsonIgnore
	public void setModDatewc(
		UnsafeSupplier<Date, Exception> modDatewcUnsafeSupplier) {

		_modDatewcSupplier = () -> {
			try {
				return modDatewcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Date the wc was last modified.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Date modDatewc;

	@JsonIgnore
	private Supplier<Date> _modDatewcSupplier;

	@Schema(description = "Is the wc set to never review.")
	public Boolean getNeverReviewwc() {
		if (_neverReviewwcSupplier != null) {
			neverReviewwc = _neverReviewwcSupplier.get();

			_neverReviewwcSupplier = null;
		}

		return neverReviewwc;
	}

	public void setNeverReviewwc(Boolean neverReviewwc) {
		this.neverReviewwc = neverReviewwc;

		_neverReviewwcSupplier = null;
	}

	@JsonIgnore
	public void setNeverReviewwc(
		UnsafeSupplier<Boolean, Exception> neverReviewwcUnsafeSupplier) {

		_neverReviewwcSupplier = () -> {
			try {
				return neverReviewwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Is the wc set to never review.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean neverReviewwc;

	@JsonIgnore
	private Supplier<Boolean> _neverReviewwcSupplier;

	@Schema(description = "Does the wc have a small image.")
	public Boolean getSmallImagewc() {
		if (_smallImagewcSupplier != null) {
			smallImagewc = _smallImagewcSupplier.get();

			_smallImagewcSupplier = null;
		}

		return smallImagewc;
	}

	public void setSmallImagewc(Boolean smallImagewc) {
		this.smallImagewc = smallImagewc;

		_smallImagewcSupplier = null;
	}

	@JsonIgnore
	public void setSmallImagewc(
		UnsafeSupplier<Boolean, Exception> smallImagewcUnsafeSupplier) {

		_smallImagewcSupplier = () -> {
			try {
				return smallImagewcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Does the wc have a small image.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean smallImagewc;

	@JsonIgnore
	private Supplier<Boolean> _smallImagewcSupplier;

	@Schema(description = "Title of wc in default language.")
	public String getTitleLangPrimarywc() {
		if (_titleLangPrimarywcSupplier != null) {
			titleLangPrimarywc = _titleLangPrimarywcSupplier.get();

			_titleLangPrimarywcSupplier = null;
		}

		return titleLangPrimarywc;
	}

	public void setTitleLangPrimarywc(String titleLangPrimarywc) {
		this.titleLangPrimarywc = titleLangPrimarywc;

		_titleLangPrimarywcSupplier = null;
	}

	@JsonIgnore
	public void setTitleLangPrimarywc(
		UnsafeSupplier<String, Exception> titleLangPrimarywcUnsafeSupplier) {

		_titleLangPrimarywcSupplier = () -> {
			try {
				return titleLangPrimarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Title of wc in default language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String titleLangPrimarywc;

	@JsonIgnore
	private Supplier<String> _titleLangPrimarywcSupplier;

	@Schema(description = "Title of wc in secondary language.")
	public String getTitleLangSecondarywc() {
		if (_titleLangSecondarywcSupplier != null) {
			titleLangSecondarywc = _titleLangSecondarywcSupplier.get();

			_titleLangSecondarywcSupplier = null;
		}

		return titleLangSecondarywc;
	}

	public void setTitleLangSecondarywc(String titleLangSecondarywc) {
		this.titleLangSecondarywc = titleLangSecondarywc;

		_titleLangSecondarywcSupplier = null;
	}

	@JsonIgnore
	public void setTitleLangSecondarywc(
		UnsafeSupplier<String, Exception> titleLangSecondarywcUnsafeSupplier) {

		_titleLangSecondarywcSupplier = () -> {
			try {
				return titleLangSecondarywcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Title of wc in secondary language.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String titleLangSecondarywc;

	@JsonIgnore
	private Supplier<String> _titleLangSecondarywcSupplier;

	@Schema(description = "PK of the wc owner.")
	public Long getUserIdwc() {
		if (_userIdwcSupplier != null) {
			userIdwc = _userIdwcSupplier.get();

			_userIdwcSupplier = null;
		}

		return userIdwc;
	}

	public void setUserIdwc(Long userIdwc) {
		this.userIdwc = userIdwc;

		_userIdwcSupplier = null;
	}

	@JsonIgnore
	public void setUserIdwc(
		UnsafeSupplier<Long, Exception> userIdwcUnsafeSupplier) {

		_userIdwcSupplier = () -> {
			try {
				return userIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "PK of the wc owner.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userIdwc;

	@JsonIgnore
	private Supplier<Long> _userIdwcSupplier;

	@Schema(description = "The unique uuId string of the wc.")
	public String getUuIdwc() {
		if (_uuIdwcSupplier != null) {
			uuIdwc = _uuIdwcSupplier.get();

			_uuIdwcSupplier = null;
		}

		return uuIdwc;
	}

	public void setUuIdwc(String uuIdwc) {
		this.uuIdwc = uuIdwc;

		_uuIdwcSupplier = null;
	}

	@JsonIgnore
	public void setUuIdwc(
		UnsafeSupplier<String, Exception> uuIdwcUnsafeSupplier) {

		_uuIdwcSupplier = () -> {
			try {
				return uuIdwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "The unique uuId string of the wc.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String uuIdwc;

	@JsonIgnore
	private Supplier<String> _uuIdwcSupplier;

	@Schema(description = "Version of the wc.")
	public Double getVersionwc() {
		if (_versionwcSupplier != null) {
			versionwc = _versionwcSupplier.get();

			_versionwcSupplier = null;
		}

		return versionwc;
	}

	public void setVersionwc(Double versionwc) {
		this.versionwc = versionwc;

		_versionwcSupplier = null;
	}

	@JsonIgnore
	public void setVersionwc(
		UnsafeSupplier<Double, Exception> versionwcUnsafeSupplier) {

		_versionwcSupplier = () -> {
			try {
				return versionwcUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField(description = "Version of the wc.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double versionwc;

	@JsonIgnore
	private Supplier<Double> _versionwcSupplier;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		String articleIdwc = getArticleIdwc();

		if (articleIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"articleIdwc\": ");

			sb.append("\"");

			sb.append(_escape(articleIdwc));

			sb.append("\"");
		}

		Long classNameIdwc = getClassNameIdwc();

		if (classNameIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classNameIdwc\": ");

			sb.append(classNameIdwc);
		}

		Long classPKwc = getClassPKwc();

		if (classPKwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"classPKwc\": ");

			sb.append(classPKwc);
		}

		String contentPrimarywc = getContentPrimarywc();

		if (contentPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(contentPrimarywc));

			sb.append("\"");
		}

		String contentSecondarywc = getContentSecondarywc();

		if (contentSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"contentSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(contentSecondarywc));

			sb.append("\"");
		}

		Long ddmStructureIDwc = getDdmStructureIDwc();

		if (ddmStructureIDwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureIDwc\": ");

			sb.append(ddmStructureIDwc);
		}

		String ddmStructureKeywc = getDdmStructureKeywc();

		if (ddmStructureKeywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmStructureKeywc\": ");

			sb.append("\"");

			sb.append(_escape(ddmStructureKeywc));

			sb.append("\"");
		}

		String ddmTemplateKeywc = getDdmTemplateKeywc();

		if (ddmTemplateKeywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ddmTemplateKeywc\": ");

			sb.append("\"");

			sb.append(_escape(ddmTemplateKeywc));

			sb.append("\"");
		}

		String defLang = getDefLang();

		if (defLang != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"defLang\": ");

			sb.append("\"");

			sb.append(_escape(defLang));

			sb.append("\"");
		}

		String descLangPrimarywc = getDescLangPrimarywc();

		if (descLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(descLangPrimarywc));

			sb.append("\"");
		}

		String descLangSecondarywc = getDescLangSecondarywc();

		if (descLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"descLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(descLangSecondarywc));

			sb.append("\"");
		}

		Date dispDatewc = getDispDatewc();

		if (dispDatewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dispDatewc\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dispDatewc));

			sb.append("\"");
		}

		String extReferenceCode = getExtReferenceCode();

		if (extReferenceCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"extReferenceCode\": ");

			sb.append("\"");

			sb.append(_escape(extReferenceCode));

			sb.append("\"");
		}

		String fUrlLangPrimarywc = getFUrlLangPrimarywc();

		if (fUrlLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(fUrlLangPrimarywc));

			sb.append("\"");
		}

		String fUrlLangSecondarywc = getFUrlLangSecondarywc();

		if (fUrlLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fUrlLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(fUrlLangSecondarywc));

			sb.append("\"");
		}

		Long fileClassNameId = getFileClassNameId();

		if (fileClassNameId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNameId\": ");

			sb.append(fileClassNameId);
		}

		Long fileClassNamePk = getFileClassNamePk();

		if (fileClassNamePk != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fileClassNamePk\": ");

			sb.append(fileClassNamePk);
		}

		String[] fileDescs = getFileDescs();

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

		Long[] fileEntryIds = getFileEntryIds();

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

		String[] fileEntryUuids = getFileEntryUuids();

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

		String[] fileMimes = getFileMimes();

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

		String[] fileNames = getFileNames();

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

		String[] fileTitles = getFileTitles();

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

		Long folderIdwc = getFolderIdwc();

		if (folderIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderIdwc\": ");

			sb.append(folderIdwc);
		}

		Long groupIdwc = getGroupIdwc();

		if (groupIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"groupIdwc\": ");

			sb.append(groupIdwc);
		}

		Long idPK = getIdPK();

		if (idPK != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"idPK\": ");

			sb.append(idPK);
		}

		String[] imagesB64Encoded = getImagesB64Encoded();

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

		Boolean indexablewc = getIndexablewc();

		if (indexablewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"indexablewc\": ");

			sb.append(indexablewc);
		}

		String layoutUuidwc = getLayoutUuidwc();

		if (layoutUuidwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"layoutUuidwc\": ");

			sb.append("\"");

			sb.append(_escape(layoutUuidwc));

			sb.append("\"");
		}

		String localePrimarywc = getLocalePrimarywc();

		if (localePrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localePrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(localePrimarywc));

			sb.append("\"");
		}

		String localeSecondarywc = getLocaleSecondarywc();

		if (localeSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"localeSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(localeSecondarywc));

			sb.append("\"");
		}

		Date modDatewc = getModDatewc();

		if (modDatewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modDatewc\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(modDatewc));

			sb.append("\"");
		}

		Boolean neverReviewwc = getNeverReviewwc();

		if (neverReviewwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"neverReviewwc\": ");

			sb.append(neverReviewwc);
		}

		Boolean smallImagewc = getSmallImagewc();

		if (smallImagewc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"smallImagewc\": ");

			sb.append(smallImagewc);
		}

		String titleLangPrimarywc = getTitleLangPrimarywc();

		if (titleLangPrimarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangPrimarywc\": ");

			sb.append("\"");

			sb.append(_escape(titleLangPrimarywc));

			sb.append("\"");
		}

		String titleLangSecondarywc = getTitleLangSecondarywc();

		if (titleLangSecondarywc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"titleLangSecondarywc\": ");

			sb.append("\"");

			sb.append(_escape(titleLangSecondarywc));

			sb.append("\"");
		}

		Long userIdwc = getUserIdwc();

		if (userIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userIdwc\": ");

			sb.append(userIdwc);
		}

		String uuIdwc = getUuIdwc();

		if (uuIdwc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"uuIdwc\": ");

			sb.append("\"");

			sb.append(_escape(uuIdwc));

			sb.append("\"");
		}

		Double versionwc = getVersionwc();

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

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.na.webcontent.remote.dto.v1_0.WebContent",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

	private Map<String, Serializable> _extendedProperties;

}