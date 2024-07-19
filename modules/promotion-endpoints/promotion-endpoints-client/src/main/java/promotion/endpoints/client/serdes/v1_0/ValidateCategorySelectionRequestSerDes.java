package promotion.endpoints.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import promotion.endpoints.client.dto.v1_0.ValidateCategorySelectionRequest;
import promotion.endpoints.client.json.BaseJSONParser;

/**
 * @author me
 * @generated
 */
@Generated("")
public class ValidateCategorySelectionRequestSerDes {

	public static ValidateCategorySelectionRequest toDTO(String json) {
		ValidateCategorySelectionRequestJSONParser
			validateCategorySelectionRequestJSONParser =
				new ValidateCategorySelectionRequestJSONParser();

		return validateCategorySelectionRequestJSONParser.parseToDTO(json);
	}

	public static ValidateCategorySelectionRequest[] toDTOs(String json) {
		ValidateCategorySelectionRequestJSONParser
			validateCategorySelectionRequestJSONParser =
				new ValidateCategorySelectionRequestJSONParser();

		return validateCategorySelectionRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ValidateCategorySelectionRequest validateCategorySelectionRequest) {

		if (validateCategorySelectionRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (validateCategorySelectionRequest.getFirstCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstCategory\": ");

			sb.append(validateCategorySelectionRequest.getFirstCategory());
		}

		if (validateCategorySelectionRequest.getFourthCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fourthCategory\": ");

			sb.append(validateCategorySelectionRequest.getFourthCategory());
		}

		if (validateCategorySelectionRequest.getRootCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rootCategory\": ");

			sb.append(validateCategorySelectionRequest.getRootCategory());
		}

		if (validateCategorySelectionRequest.getSecondCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"secondCategory\": ");

			sb.append(validateCategorySelectionRequest.getSecondCategory());
		}

		if (validateCategorySelectionRequest.getThirdCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"thirdCategory\": ");

			sb.append(validateCategorySelectionRequest.getThirdCategory());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ValidateCategorySelectionRequestJSONParser
			validateCategorySelectionRequestJSONParser =
				new ValidateCategorySelectionRequestJSONParser();

		return validateCategorySelectionRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ValidateCategorySelectionRequest validateCategorySelectionRequest) {

		if (validateCategorySelectionRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (validateCategorySelectionRequest.getFirstCategory() == null) {
			map.put("firstCategory", null);
		}
		else {
			map.put(
				"firstCategory",
				String.valueOf(
					validateCategorySelectionRequest.getFirstCategory()));
		}

		if (validateCategorySelectionRequest.getFourthCategory() == null) {
			map.put("fourthCategory", null);
		}
		else {
			map.put(
				"fourthCategory",
				String.valueOf(
					validateCategorySelectionRequest.getFourthCategory()));
		}

		if (validateCategorySelectionRequest.getRootCategory() == null) {
			map.put("rootCategory", null);
		}
		else {
			map.put(
				"rootCategory",
				String.valueOf(
					validateCategorySelectionRequest.getRootCategory()));
		}

		if (validateCategorySelectionRequest.getSecondCategory() == null) {
			map.put("secondCategory", null);
		}
		else {
			map.put(
				"secondCategory",
				String.valueOf(
					validateCategorySelectionRequest.getSecondCategory()));
		}

		if (validateCategorySelectionRequest.getThirdCategory() == null) {
			map.put("thirdCategory", null);
		}
		else {
			map.put(
				"thirdCategory",
				String.valueOf(
					validateCategorySelectionRequest.getThirdCategory()));
		}

		return map;
	}

	public static class ValidateCategorySelectionRequestJSONParser
		extends BaseJSONParser<ValidateCategorySelectionRequest> {

		@Override
		protected ValidateCategorySelectionRequest createDTO() {
			return new ValidateCategorySelectionRequest();
		}

		@Override
		protected ValidateCategorySelectionRequest[] createDTOArray(int size) {
			return new ValidateCategorySelectionRequest[size];
		}

		@Override
		protected void setField(
			ValidateCategorySelectionRequest validateCategorySelectionRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "firstCategory")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionRequest.setFirstCategory(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fourthCategory")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionRequest.setFourthCategory(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "rootCategory")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionRequest.setRootCategory(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "secondCategory")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionRequest.setSecondCategory(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "thirdCategory")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionRequest.setThirdCategory(
						Long.valueOf((String)jsonParserFieldValue));
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