package promotion.endpoints.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import promotion.endpoints.client.dto.v1_0.PromotionCategory;
import promotion.endpoints.client.http.HttpInvoker;
import promotion.endpoints.client.pagination.Page;
import promotion.endpoints.client.resource.v1_0.PromotionCategoryResource;
import promotion.endpoints.client.serdes.v1_0.PromotionCategorySerDes;

/**
 * @author me
 * @generated
 */
@Generated("")
public abstract class BasePromotionCategoryResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_promotionCategoryResource.setContextCompany(testCompany);

		PromotionCategoryResource.Builder builder =
			PromotionCategoryResource.builder();

		promotionCategoryResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		PromotionCategory promotionCategory1 = randomPromotionCategory();

		String json = objectMapper.writeValueAsString(promotionCategory1);

		PromotionCategory promotionCategory2 = PromotionCategorySerDes.toDTO(
			json);

		Assert.assertTrue(equals(promotionCategory1, promotionCategory2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		PromotionCategory promotionCategory = randomPromotionCategory();

		String json1 = objectMapper.writeValueAsString(promotionCategory);
		String json2 = PromotionCategorySerDes.toJSON(promotionCategory);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		PromotionCategory promotionCategory = randomPromotionCategory();

		promotionCategory.setDesc(regex);
		promotionCategory.setName(regex);

		String json = PromotionCategorySerDes.toJSON(promotionCategory);

		Assert.assertFalse(json.contains(regex));

		promotionCategory = PromotionCategorySerDes.toDTO(json);

		Assert.assertEquals(regex, promotionCategory.getDesc());
		Assert.assertEquals(regex, promotionCategory.getName());
	}

	@Test
	public void testGetGetPromotionCategoriesByNameCategoryNameGroupPage()
		throws Exception {

		String categoryName =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getCategoryName();
		String irrelevantCategoryName =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getIrrelevantCategoryName();
		Long groupId =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getGroupId();
		Long irrelevantGroupId =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getIrrelevantGroupId();

		Page<PromotionCategory> page =
			promotionCategoryResource.
				getGetPromotionCategoriesByNameCategoryNameGroupPage(
					categoryName, groupId);

		long totalCount = page.getTotalCount();

		if ((irrelevantCategoryName != null) && (irrelevantGroupId != null)) {
			PromotionCategory irrelevantPromotionCategory =
				testGetGetPromotionCategoriesByNameCategoryNameGroupPage_addPromotionCategory(
					irrelevantCategoryName, irrelevantGroupId,
					randomIrrelevantPromotionCategory());

			page =
				promotionCategoryResource.
					getGetPromotionCategoriesByNameCategoryNameGroupPage(
						irrelevantCategoryName, irrelevantGroupId);

			Assert.assertEquals(totalCount + 1, page.getTotalCount());

			assertContains(
				irrelevantPromotionCategory,
				(List<PromotionCategory>)page.getItems());
			assertValid(
				page,
				testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getExpectedActions(
					irrelevantCategoryName, irrelevantGroupId));
		}

		PromotionCategory promotionCategory1 =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_addPromotionCategory(
				categoryName, groupId, randomPromotionCategory());

		PromotionCategory promotionCategory2 =
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_addPromotionCategory(
				categoryName, groupId, randomPromotionCategory());

		page =
			promotionCategoryResource.
				getGetPromotionCategoriesByNameCategoryNameGroupPage(
					categoryName, groupId);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			promotionCategory1, (List<PromotionCategory>)page.getItems());
		assertContains(
			promotionCategory2, (List<PromotionCategory>)page.getItems());
		assertValid(
			page,
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getExpectedActions(
				categoryName, groupId));
	}

	protected Map<String, Map<String, String>>
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getExpectedActions(
				String categoryName, Long groupId)
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected PromotionCategory
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_addPromotionCategory(
				String categoryName, Long groupId,
				PromotionCategory promotionCategory)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getCategoryName()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getIrrelevantCategoryName()
		throws Exception {

		return null;
	}

	protected Long
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getGroupId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetGetPromotionCategoriesByNameCategoryNameGroupPage_getIrrelevantGroupId()
		throws Exception {

		return null;
	}

	@Test
	public void testGetGetPromotionCategoryByIdCategory() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetGetPromotionCategoryByIdCategory()
		throws Exception {

		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetGetPromotionCategoryByIdCategoryNotFound()
		throws Exception {

		Assert.assertTrue(true);
	}

	@Test
	public void testGetGetPromotionSubCategoriesByIdCategoryPage()
		throws Exception {

		Long categoryId =
			testGetGetPromotionSubCategoriesByIdCategoryPage_getCategoryId();
		Long irrelevantCategoryId =
			testGetGetPromotionSubCategoriesByIdCategoryPage_getIrrelevantCategoryId();

		Page<PromotionCategory> page =
			promotionCategoryResource.
				getGetPromotionSubCategoriesByIdCategoryPage(categoryId);

		long totalCount = page.getTotalCount();

		if (irrelevantCategoryId != null) {
			PromotionCategory irrelevantPromotionCategory =
				testGetGetPromotionSubCategoriesByIdCategoryPage_addPromotionCategory(
					irrelevantCategoryId, randomIrrelevantPromotionCategory());

			page =
				promotionCategoryResource.
					getGetPromotionSubCategoriesByIdCategoryPage(
						irrelevantCategoryId);

			Assert.assertEquals(totalCount + 1, page.getTotalCount());

			assertContains(
				irrelevantPromotionCategory,
				(List<PromotionCategory>)page.getItems());
			assertValid(
				page,
				testGetGetPromotionSubCategoriesByIdCategoryPage_getExpectedActions(
					irrelevantCategoryId));
		}

		PromotionCategory promotionCategory1 =
			testGetGetPromotionSubCategoriesByIdCategoryPage_addPromotionCategory(
				categoryId, randomPromotionCategory());

		PromotionCategory promotionCategory2 =
			testGetGetPromotionSubCategoriesByIdCategoryPage_addPromotionCategory(
				categoryId, randomPromotionCategory());

		page =
			promotionCategoryResource.
				getGetPromotionSubCategoriesByIdCategoryPage(categoryId);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			promotionCategory1, (List<PromotionCategory>)page.getItems());
		assertContains(
			promotionCategory2, (List<PromotionCategory>)page.getItems());
		assertValid(
			page,
			testGetGetPromotionSubCategoriesByIdCategoryPage_getExpectedActions(
				categoryId));
	}

	protected Map<String, Map<String, String>>
			testGetGetPromotionSubCategoriesByIdCategoryPage_getExpectedActions(
				Long categoryId)
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected PromotionCategory
			testGetGetPromotionSubCategoriesByIdCategoryPage_addPromotionCategory(
				Long categoryId, PromotionCategory promotionCategory)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetGetPromotionSubCategoriesByIdCategoryPage_getCategoryId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetGetPromotionSubCategoriesByIdCategoryPage_getIrrelevantCategoryId()
		throws Exception {

		return null;
	}

	protected void assertContains(
		PromotionCategory promotionCategory,
		List<PromotionCategory> promotionCategories) {

		boolean contains = false;

		for (PromotionCategory item : promotionCategories) {
			if (equals(promotionCategory, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			promotionCategories + " does not contain " + promotionCategory,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		PromotionCategory promotionCategory1,
		PromotionCategory promotionCategory2) {

		Assert.assertTrue(
			promotionCategory1 + " does not equal " + promotionCategory2,
			equals(promotionCategory1, promotionCategory2));
	}

	protected void assertEquals(
		List<PromotionCategory> promotionCategories1,
		List<PromotionCategory> promotionCategories2) {

		Assert.assertEquals(
			promotionCategories1.size(), promotionCategories2.size());

		for (int i = 0; i < promotionCategories1.size(); i++) {
			PromotionCategory promotionCategory1 = promotionCategories1.get(i);
			PromotionCategory promotionCategory2 = promotionCategories2.get(i);

			assertEquals(promotionCategory1, promotionCategory2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<PromotionCategory> promotionCategories1,
		List<PromotionCategory> promotionCategories2) {

		Assert.assertEquals(
			promotionCategories1.size(), promotionCategories2.size());

		for (PromotionCategory promotionCategory1 : promotionCategories1) {
			boolean contains = false;

			for (PromotionCategory promotionCategory2 : promotionCategories2) {
				if (equals(promotionCategory1, promotionCategory2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				promotionCategories2 + " does not contain " +
					promotionCategory1,
				contains);
		}
	}

	protected void assertValid(PromotionCategory promotionCategory)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("categoryId", additionalAssertFieldName)) {
				if (promotionCategory.getCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("desc", additionalAssertFieldName)) {
				if (promotionCategory.getDesc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("hasSubCategories", additionalAssertFieldName)) {
				if (promotionCategory.getHasSubCategories() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (promotionCategory.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("subCategoriesIds", additionalAssertFieldName)) {
				if (promotionCategory.getSubCategoriesIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("superCategoryId", additionalAssertFieldName)) {
				if (promotionCategory.getSuperCategoryId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<PromotionCategory> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<PromotionCategory> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<PromotionCategory> promotionCategories =
			page.getItems();

		int size = promotionCategories.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		assertValid(page.getActions(), expectedActions);
	}

	protected void assertValid(
		Map<String, Map<String, String>> actions1,
		Map<String, Map<String, String>> actions2) {

		for (String key : actions2.keySet()) {
			Map action = actions1.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map<String, String> expectedAction = actions2.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					promotion.endpoints.dto.v1_0.PromotionCategory.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		PromotionCategory promotionCategory1,
		PromotionCategory promotionCategory2) {

		if (promotionCategory1 == promotionCategory2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("categoryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getCategoryId(),
						promotionCategory2.getCategoryId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("desc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getDesc(),
						promotionCategory2.getDesc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("hasSubCategories", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getHasSubCategories(),
						promotionCategory2.getHasSubCategories())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getName(),
						promotionCategory2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("subCategoriesIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getSubCategoriesIds(),
						promotionCategory2.getSubCategoriesIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("superCategoryId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						promotionCategory1.getSuperCategoryId(),
						promotionCategory2.getSuperCategoryId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		if (clazz.getClassLoader() == null) {
			return new java.lang.reflect.Field[0];
		}

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_promotionCategoryResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_promotionCategoryResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		PromotionCategory promotionCategory) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("categoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("desc")) {
			Object object = promotionCategory.getDesc();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("hasSubCategories")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			Object object = promotionCategory.getName();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("subCategoriesIds")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("superCategoryId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected PromotionCategory randomPromotionCategory() throws Exception {
		return new PromotionCategory() {
			{
				categoryId = RandomTestUtil.randomLong();
				desc = StringUtil.toLowerCase(RandomTestUtil.randomString());
				hasSubCategories = RandomTestUtil.randomBoolean();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected PromotionCategory randomIrrelevantPromotionCategory()
		throws Exception {

		PromotionCategory randomIrrelevantPromotionCategory =
			randomPromotionCategory();

		return randomIrrelevantPromotionCategory;
	}

	protected PromotionCategory randomPatchPromotionCategory()
		throws Exception {

		return randomPromotionCategory();
	}

	protected PromotionCategoryResource promotionCategoryResource;
	protected com.liferay.portal.kernel.model.Group irrelevantGroup;
	protected com.liferay.portal.kernel.model.Company testCompany;
	protected com.liferay.portal.kernel.model.Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BasePromotionCategoryResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private promotion.endpoints.resource.v1_0.PromotionCategoryResource
		_promotionCategoryResource;

}