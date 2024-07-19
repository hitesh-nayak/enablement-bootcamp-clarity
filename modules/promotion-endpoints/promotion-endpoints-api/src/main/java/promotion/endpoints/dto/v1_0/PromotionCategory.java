package promotion.endpoints.dto.v1_0;

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

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author me
 * @generated
 */
@Generated("")
@GraphQLName("PromotionCategory")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "PromotionCategory")
public class PromotionCategory implements Serializable {

	public static PromotionCategory toDTO(String json) {
		return ObjectMapperUtil.readValue(PromotionCategory.class, json);
	}

	public static PromotionCategory unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(PromotionCategory.class, json);
	}

	@Schema
	public Long getCategoryId() {
		if (_categoryIdSupplier != null) {
			categoryId = _categoryIdSupplier.get();

			_categoryIdSupplier = null;
		}

		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;

		_categoryIdSupplier = null;
	}

	@JsonIgnore
	public void setCategoryId(
		UnsafeSupplier<Long, Exception> categoryIdUnsafeSupplier) {

		_categoryIdSupplier = () -> {
			try {
				return categoryIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long categoryId;

	@JsonIgnore
	private Supplier<Long> _categoryIdSupplier;

	@Schema
	public String getDesc() {
		if (_descSupplier != null) {
			desc = _descSupplier.get();

			_descSupplier = null;
		}

		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;

		_descSupplier = null;
	}

	@JsonIgnore
	public void setDesc(UnsafeSupplier<String, Exception> descUnsafeSupplier) {
		_descSupplier = () -> {
			try {
				return descUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String desc;

	@JsonIgnore
	private Supplier<String> _descSupplier;

	@Schema
	public Boolean getHasSubCategories() {
		if (_hasSubCategoriesSupplier != null) {
			hasSubCategories = _hasSubCategoriesSupplier.get();

			_hasSubCategoriesSupplier = null;
		}

		return hasSubCategories;
	}

	public void setHasSubCategories(Boolean hasSubCategories) {
		this.hasSubCategories = hasSubCategories;

		_hasSubCategoriesSupplier = null;
	}

	@JsonIgnore
	public void setHasSubCategories(
		UnsafeSupplier<Boolean, Exception> hasSubCategoriesUnsafeSupplier) {

		_hasSubCategoriesSupplier = () -> {
			try {
				return hasSubCategoriesUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Boolean hasSubCategories;

	@JsonIgnore
	private Supplier<Boolean> _hasSubCategoriesSupplier;

	@Schema
	public String getName() {
		if (_nameSupplier != null) {
			name = _nameSupplier.get();

			_nameSupplier = null;
		}

		return name;
	}

	public void setName(String name) {
		this.name = name;

		_nameSupplier = null;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		_nameSupplier = () -> {
			try {
				return nameUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@JsonIgnore
	private Supplier<String> _nameSupplier;

	@Schema
	public Long[] getSubCategoriesIds() {
		if (_subCategoriesIdsSupplier != null) {
			subCategoriesIds = _subCategoriesIdsSupplier.get();

			_subCategoriesIdsSupplier = null;
		}

		return subCategoriesIds;
	}

	public void setSubCategoriesIds(Long[] subCategoriesIds) {
		this.subCategoriesIds = subCategoriesIds;

		_subCategoriesIdsSupplier = null;
	}

	@JsonIgnore
	public void setSubCategoriesIds(
		UnsafeSupplier<Long[], Exception> subCategoriesIdsUnsafeSupplier) {

		_subCategoriesIdsSupplier = () -> {
			try {
				return subCategoriesIdsUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] subCategoriesIds;

	@JsonIgnore
	private Supplier<Long[]> _subCategoriesIdsSupplier;

	@Schema
	@Valid
	public Number getSuperCategoryId() {
		if (_superCategoryIdSupplier != null) {
			superCategoryId = _superCategoryIdSupplier.get();

			_superCategoryIdSupplier = null;
		}

		return superCategoryId;
	}

	public void setSuperCategoryId(Number superCategoryId) {
		this.superCategoryId = superCategoryId;

		_superCategoryIdSupplier = null;
	}

	@JsonIgnore
	public void setSuperCategoryId(
		UnsafeSupplier<Number, Exception> superCategoryIdUnsafeSupplier) {

		_superCategoryIdSupplier = () -> {
			try {
				return superCategoryIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Number superCategoryId;

	@JsonIgnore
	private Supplier<Number> _superCategoryIdSupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PromotionCategory)) {
			return false;
		}

		PromotionCategory promotionCategory = (PromotionCategory)object;

		return Objects.equals(toString(), promotionCategory.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		Long categoryId = getCategoryId();

		if (categoryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryId\": ");

			sb.append(categoryId);
		}

		String desc = getDesc();

		if (desc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"desc\": ");

			sb.append("\"");

			sb.append(_escape(desc));

			sb.append("\"");
		}

		Boolean hasSubCategories = getHasSubCategories();

		if (hasSubCategories != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hasSubCategories\": ");

			sb.append(hasSubCategories);
		}

		String name = getName();

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		Long[] subCategoriesIds = getSubCategoriesIds();

		if (subCategoriesIds != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subCategoriesIds\": ");

			sb.append("[");

			for (int i = 0; i < subCategoriesIds.length; i++) {
				sb.append(subCategoriesIds[i]);

				if ((i + 1) < subCategoriesIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		Number superCategoryId = getSuperCategoryId();

		if (superCategoryId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"superCategoryId\": ");

			sb.append(superCategoryId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "promotion.endpoints.dto.v1_0.PromotionCategory",
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