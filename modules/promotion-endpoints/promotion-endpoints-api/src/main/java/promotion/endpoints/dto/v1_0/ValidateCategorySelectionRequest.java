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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author me
 * @generated
 */
@Generated("")
@GraphQLName("ValidateCategorySelectionRequest")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ValidateCategorySelectionRequest")
public class ValidateCategorySelectionRequest implements Serializable {

	public static ValidateCategorySelectionRequest toDTO(String json) {
		return ObjectMapperUtil.readValue(
			ValidateCategorySelectionRequest.class, json);
	}

	public static ValidateCategorySelectionRequest unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			ValidateCategorySelectionRequest.class, json);
	}

	@Schema
	public Long getFirstCategory() {
		if (_firstCategorySupplier != null) {
			firstCategory = _firstCategorySupplier.get();

			_firstCategorySupplier = null;
		}

		return firstCategory;
	}

	public void setFirstCategory(Long firstCategory) {
		this.firstCategory = firstCategory;

		_firstCategorySupplier = null;
	}

	@JsonIgnore
	public void setFirstCategory(
		UnsafeSupplier<Long, Exception> firstCategoryUnsafeSupplier) {

		_firstCategorySupplier = () -> {
			try {
				return firstCategoryUnsafeSupplier.get();
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
	protected Long firstCategory;

	@JsonIgnore
	private Supplier<Long> _firstCategorySupplier;

	@Schema
	public Long getFourthCategory() {
		if (_fourthCategorySupplier != null) {
			fourthCategory = _fourthCategorySupplier.get();

			_fourthCategorySupplier = null;
		}

		return fourthCategory;
	}

	public void setFourthCategory(Long fourthCategory) {
		this.fourthCategory = fourthCategory;

		_fourthCategorySupplier = null;
	}

	@JsonIgnore
	public void setFourthCategory(
		UnsafeSupplier<Long, Exception> fourthCategoryUnsafeSupplier) {

		_fourthCategorySupplier = () -> {
			try {
				return fourthCategoryUnsafeSupplier.get();
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
	protected Long fourthCategory;

	@JsonIgnore
	private Supplier<Long> _fourthCategorySupplier;

	@Schema
	public Long getRootCategory() {
		if (_rootCategorySupplier != null) {
			rootCategory = _rootCategorySupplier.get();

			_rootCategorySupplier = null;
		}

		return rootCategory;
	}

	public void setRootCategory(Long rootCategory) {
		this.rootCategory = rootCategory;

		_rootCategorySupplier = null;
	}

	@JsonIgnore
	public void setRootCategory(
		UnsafeSupplier<Long, Exception> rootCategoryUnsafeSupplier) {

		_rootCategorySupplier = () -> {
			try {
				return rootCategoryUnsafeSupplier.get();
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
	protected Long rootCategory;

	@JsonIgnore
	private Supplier<Long> _rootCategorySupplier;

	@Schema
	public Long getSecondCategory() {
		if (_secondCategorySupplier != null) {
			secondCategory = _secondCategorySupplier.get();

			_secondCategorySupplier = null;
		}

		return secondCategory;
	}

	public void setSecondCategory(Long secondCategory) {
		this.secondCategory = secondCategory;

		_secondCategorySupplier = null;
	}

	@JsonIgnore
	public void setSecondCategory(
		UnsafeSupplier<Long, Exception> secondCategoryUnsafeSupplier) {

		_secondCategorySupplier = () -> {
			try {
				return secondCategoryUnsafeSupplier.get();
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
	protected Long secondCategory;

	@JsonIgnore
	private Supplier<Long> _secondCategorySupplier;

	@Schema
	public Long getThirdCategory() {
		if (_thirdCategorySupplier != null) {
			thirdCategory = _thirdCategorySupplier.get();

			_thirdCategorySupplier = null;
		}

		return thirdCategory;
	}

	public void setThirdCategory(Long thirdCategory) {
		this.thirdCategory = thirdCategory;

		_thirdCategorySupplier = null;
	}

	@JsonIgnore
	public void setThirdCategory(
		UnsafeSupplier<Long, Exception> thirdCategoryUnsafeSupplier) {

		_thirdCategorySupplier = () -> {
			try {
				return thirdCategoryUnsafeSupplier.get();
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
	protected Long thirdCategory;

	@JsonIgnore
	private Supplier<Long> _thirdCategorySupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValidateCategorySelectionRequest)) {
			return false;
		}

		ValidateCategorySelectionRequest validateCategorySelectionRequest =
			(ValidateCategorySelectionRequest)object;

		return Objects.equals(
			toString(), validateCategorySelectionRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		Long firstCategory = getFirstCategory();

		if (firstCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstCategory\": ");

			sb.append(firstCategory);
		}

		Long fourthCategory = getFourthCategory();

		if (fourthCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fourthCategory\": ");

			sb.append(fourthCategory);
		}

		Long rootCategory = getRootCategory();

		if (rootCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rootCategory\": ");

			sb.append(rootCategory);
		}

		Long secondCategory = getSecondCategory();

		if (secondCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"secondCategory\": ");

			sb.append(secondCategory);
		}

		Long thirdCategory = getThirdCategory();

		if (thirdCategory != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"thirdCategory\": ");

			sb.append(thirdCategory);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "promotion.endpoints.dto.v1_0.ValidateCategorySelectionRequest",
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