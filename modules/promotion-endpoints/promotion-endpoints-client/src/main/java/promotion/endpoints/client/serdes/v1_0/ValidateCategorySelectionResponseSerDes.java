package promotion.endpoints.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import promotion.endpoints.client.dto.v1_0.ValidateCategorySelectionResponse;
import promotion.endpoints.client.json.BaseJSONParser;

/**
 * @author me
 * @generated
 */
@Generated("")
public class ValidateCategorySelectionResponseSerDes {

	public static ValidateCategorySelectionResponse toDTO(String json) {
		ValidateCategorySelectionResponseJSONParser
			validateCategorySelectionResponseJSONParser =
				new ValidateCategorySelectionResponseJSONParser();

		return validateCategorySelectionResponseJSONParser.parseToDTO(json);
	}

	public static ValidateCategorySelectionResponse[] toDTOs(String json) {
		ValidateCategorySelectionResponseJSONParser
			validateCategorySelectionResponseJSONParser =
				new ValidateCategorySelectionResponseJSONParser();

		return validateCategorySelectionResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ValidateCategorySelectionResponse validateCategorySelectionResponse) {

		if (validateCategorySelectionResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (validateCategorySelectionResponse.getIsValid() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"isValid\": ");

			sb.append(validateCategorySelectionResponse.getIsValid());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ValidateCategorySelectionResponseJSONParser
			validateCategorySelectionResponseJSONParser =
				new ValidateCategorySelectionResponseJSONParser();

		return validateCategorySelectionResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ValidateCategorySelectionResponse validateCategorySelectionResponse) {

		if (validateCategorySelectionResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (validateCategorySelectionResponse.getIsValid() == null) {
			map.put("isValid", null);
		}
		else {
			map.put(
				"isValid",
				String.valueOf(validateCategorySelectionResponse.getIsValid()));
		}

		return map;
	}

	public static class ValidateCategorySelectionResponseJSONParser
		extends BaseJSONParser<ValidateCategorySelectionResponse> {

		@Override
		protected ValidateCategorySelectionResponse createDTO() {
			return new ValidateCategorySelectionResponse();
		}

		@Override
		protected ValidateCategorySelectionResponse[] createDTOArray(int size) {
			return new ValidateCategorySelectionResponse[size];
		}

		@Override
		protected void setField(
			ValidateCategorySelectionResponse validateCategorySelectionResponse,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "isValid")) {
				if (jsonParserFieldValue != null) {
					validateCategorySelectionResponse.setIsValid(
						(Boolean)jsonParserFieldValue);
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