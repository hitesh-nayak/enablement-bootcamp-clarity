package promotion.endpoints.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import promotion.endpoints.client.dto.v1_0.PromotionCategory;
import promotion.endpoints.client.json.BaseJSONParser;

/**
 * @author me
 * @generated
 */
@Generated("")
public class PromotionCategorySerDes {

	public static PromotionCategory toDTO(String json) {
		PromotionCategoryJSONParser promotionCategoryJSONParser =
			new PromotionCategoryJSONParser();

		return promotionCategoryJSONParser.parseToDTO(json);
	}

	public static PromotionCategory[] toDTOs(String json) {
		PromotionCategoryJSONParser promotionCategoryJSONParser =
			new PromotionCategoryJSONParser();

		return promotionCategoryJSONParser.parseToDTOs(json);
	}

	public static String toJSON(PromotionCategory promotionCategory) {
		if (promotionCategory == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (promotionCategory.getCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryId\": ");

			sb.append(promotionCategory.getCategoryId());
		}

		if (promotionCategory.getDesc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"desc\": ");

			sb.append("\"");

			sb.append(_escape(promotionCategory.getDesc()));

			sb.append("\"");
		}

		if (promotionCategory.getHasSubCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hasSubCategories\": ");

			sb.append(promotionCategory.getHasSubCategories());
		}

		if (promotionCategory.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(promotionCategory.getName()));

			sb.append("\"");
		}

		if (promotionCategory.getSubCategoriesIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"subCategoriesIds\": ");

			sb.append("[");

			for (int i = 0; i < promotionCategory.getSubCategoriesIds().length;
				 i++) {

				sb.append(promotionCategory.getSubCategoriesIds()[i]);

				if ((i + 1) < promotionCategory.getSubCategoriesIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (promotionCategory.getSuperCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"superCategoryId\": ");

			sb.append(promotionCategory.getSuperCategoryId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PromotionCategoryJSONParser promotionCategoryJSONParser =
			new PromotionCategoryJSONParser();

		return promotionCategoryJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		PromotionCategory promotionCategory) {

		if (promotionCategory == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (promotionCategory.getCategoryId() == null) {
			map.put("categoryId", null);
		}
		else {
			map.put(
				"categoryId",
				String.valueOf(promotionCategory.getCategoryId()));
		}

		if (promotionCategory.getDesc() == null) {
			map.put("desc", null);
		}
		else {
			map.put("desc", String.valueOf(promotionCategory.getDesc()));
		}

		if (promotionCategory.getHasSubCategories() == null) {
			map.put("hasSubCategories", null);
		}
		else {
			map.put(
				"hasSubCategories",
				String.valueOf(promotionCategory.getHasSubCategories()));
		}

		if (promotionCategory.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(promotionCategory.getName()));
		}

		if (promotionCategory.getSubCategoriesIds() == null) {
			map.put("subCategoriesIds", null);
		}
		else {
			map.put(
				"subCategoriesIds",
				String.valueOf(promotionCategory.getSubCategoriesIds()));
		}

		if (promotionCategory.getSuperCategoryId() == null) {
			map.put("superCategoryId", null);
		}
		else {
			map.put(
				"superCategoryId",
				String.valueOf(promotionCategory.getSuperCategoryId()));
		}

		return map;
	}

	public static class PromotionCategoryJSONParser
		extends BaseJSONParser<PromotionCategory> {

		@Override
		protected PromotionCategory createDTO() {
			return new PromotionCategory();
		}

		@Override
		protected PromotionCategory[] createDTOArray(int size) {
			return new PromotionCategory[size];
		}

		@Override
		protected void setField(
			PromotionCategory promotionCategory, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categoryId")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setCategoryId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "desc")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setDesc((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "hasSubCategories")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setHasSubCategories(
						(Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "subCategoriesIds")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setSubCategoriesIds(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "superCategoryId")) {
				if (jsonParserFieldValue != null) {
					promotionCategory.setSuperCategoryId(
						Integer.valueOf((String)jsonParserFieldValue));
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