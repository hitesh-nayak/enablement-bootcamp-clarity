package com.na.remotewc.headless.rest.resource.v1_0.test;

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
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.TransformUtil;

import com.na.remotewc.headless.rest.client.dto.v1_0.WebContent;
import com.na.remotewc.headless.rest.client.http.HttpInvoker;
import com.na.remotewc.headless.rest.client.pagination.Page;
import com.na.remotewc.headless.rest.client.resource.v1_0.WebContentResource;
import com.na.remotewc.headless.rest.client.serdes.v1_0.WebContentSerDes;

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

/**
 * @author untodawn035
 * @generated
 */
@Generated("")
public abstract class BaseWebContentResourceTestCase {

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

		_webContentResource.setContextCompany(testCompany);

		WebContentResource.Builder builder = WebContentResource.builder();

		webContentResource = builder.authentication(
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

		WebContent webContent1 = randomWebContent();

		String json = objectMapper.writeValueAsString(webContent1);

		WebContent webContent2 = WebContentSerDes.toDTO(json);

		Assert.assertTrue(equals(webContent1, webContent2));
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

		WebContent webContent = randomWebContent();

		String json1 = objectMapper.writeValueAsString(webContent);
		String json2 = WebContentSerDes.toJSON(webContent);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		WebContent webContent = randomWebContent();

		webContent.setArticleIdwc(regex);
		webContent.setContentPrimarywc(regex);
		webContent.setContentSecondarywc(regex);
		webContent.setDdmStructureKeywc(regex);
		webContent.setDdmTemplateKeywc(regex);
		webContent.setDefLang(regex);
		webContent.setDescLangPrimarywc(regex);
		webContent.setDescLangSecondarywc(regex);
		webContent.setExtReferenceCode(regex);
		webContent.setFUrlLangPrimarywc(regex);
		webContent.setFUrlLangSecondarywc(regex);
		webContent.setLayoutUuidwc(regex);
		webContent.setLocalePrimarywc(regex);
		webContent.setLocaleSecondarywc(regex);
		webContent.setTitleLangPrimarywc(regex);
		webContent.setTitleLangSecondarywc(regex);
		webContent.setUuIdwc(regex);

		String json = WebContentSerDes.toJSON(webContent);

		Assert.assertFalse(json.contains(regex));

		webContent = WebContentSerDes.toDTO(json);

		Assert.assertEquals(regex, webContent.getArticleIdwc());
		Assert.assertEquals(regex, webContent.getContentPrimarywc());
		Assert.assertEquals(regex, webContent.getContentSecondarywc());
		Assert.assertEquals(regex, webContent.getDdmStructureKeywc());
		Assert.assertEquals(regex, webContent.getDdmTemplateKeywc());
		Assert.assertEquals(regex, webContent.getDefLang());
		Assert.assertEquals(regex, webContent.getDescLangPrimarywc());
		Assert.assertEquals(regex, webContent.getDescLangSecondarywc());
		Assert.assertEquals(regex, webContent.getExtReferenceCode());
		Assert.assertEquals(regex, webContent.getFUrlLangPrimarywc());
		Assert.assertEquals(regex, webContent.getFUrlLangSecondarywc());
		Assert.assertEquals(regex, webContent.getLayoutUuidwc());
		Assert.assertEquals(regex, webContent.getLocalePrimarywc());
		Assert.assertEquals(regex, webContent.getLocaleSecondarywc());
		Assert.assertEquals(regex, webContent.getTitleLangPrimarywc());
		Assert.assertEquals(regex, webContent.getTitleLangSecondarywc());
		Assert.assertEquals(regex, webContent.getUuIdwc());
	}

	@Test
	public void testPostWebContent() throws Exception {
		WebContent randomWebContent = randomWebContent();

		WebContent postWebContent = testPostWebContent_addWebContent(
			randomWebContent);

		assertEquals(randomWebContent, postWebContent);
		assertValid(postWebContent);
	}

	protected WebContent testPostWebContent_addWebContent(WebContent webContent)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetWebContent() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetWebContent() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetWebContentNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertContains(
		WebContent webContent, List<WebContent> webContents) {

		boolean contains = false;

		for (WebContent item : webContents) {
			if (equals(webContent, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			webContents + " does not contain " + webContent, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		WebContent webContent1, WebContent webContent2) {

		Assert.assertTrue(
			webContent1 + " does not equal " + webContent2,
			equals(webContent1, webContent2));
	}

	protected void assertEquals(
		List<WebContent> webContents1, List<WebContent> webContents2) {

		Assert.assertEquals(webContents1.size(), webContents2.size());

		for (int i = 0; i < webContents1.size(); i++) {
			WebContent webContent1 = webContents1.get(i);
			WebContent webContent2 = webContents2.get(i);

			assertEquals(webContent1, webContent2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<WebContent> webContents1, List<WebContent> webContents2) {

		Assert.assertEquals(webContents1.size(), webContents2.size());

		for (WebContent webContent1 : webContents1) {
			boolean contains = false;

			for (WebContent webContent2 : webContents2) {
				if (equals(webContent1, webContent2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				webContents2 + " does not contain " + webContent1, contains);
		}
	}

	protected void assertValid(WebContent webContent) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleIdwc", additionalAssertFieldName)) {
				if (webContent.getArticleIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("classNameIdwc", additionalAssertFieldName)) {
				if (webContent.getClassNameIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("classPKwc", additionalAssertFieldName)) {
				if (webContent.getClassPKwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("contentPrimarywc", additionalAssertFieldName)) {
				if (webContent.getContentPrimarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"contentSecondarywc", additionalAssertFieldName)) {

				if (webContent.getContentSecondarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("ddmStructureIDwc", additionalAssertFieldName)) {
				if (webContent.getDdmStructureIDwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"ddmStructureKeywc", additionalAssertFieldName)) {

				if (webContent.getDdmStructureKeywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("ddmTemplateKeywc", additionalAssertFieldName)) {
				if (webContent.getDdmTemplateKeywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("defLang", additionalAssertFieldName)) {
				if (webContent.getDefLang() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"descLangPrimarywc", additionalAssertFieldName)) {

				if (webContent.getDescLangPrimarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"descLangSecondarywc", additionalAssertFieldName)) {

				if (webContent.getDescLangSecondarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("dispDatewc", additionalAssertFieldName)) {
				if (webContent.getDispDatewc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("extReferenceCode", additionalAssertFieldName)) {
				if (webContent.getExtReferenceCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"fUrlLangPrimarywc", additionalAssertFieldName)) {

				if (webContent.getFUrlLangPrimarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"fUrlLangSecondarywc", additionalAssertFieldName)) {

				if (webContent.getFUrlLangSecondarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileClassNameId", additionalAssertFieldName)) {
				if (webContent.getFileClassNameId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileClassNamePk", additionalAssertFieldName)) {
				if (webContent.getFileClassNamePk() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileDescs", additionalAssertFieldName)) {
				if (webContent.getFileDescs() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileEntryIds", additionalAssertFieldName)) {
				if (webContent.getFileEntryIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileEntryUuids", additionalAssertFieldName)) {
				if (webContent.getFileEntryUuids() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileMimes", additionalAssertFieldName)) {
				if (webContent.getFileMimes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileNames", additionalAssertFieldName)) {
				if (webContent.getFileNames() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fileTitles", additionalAssertFieldName)) {
				if (webContent.getFileTitles() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("folderIdwc", additionalAssertFieldName)) {
				if (webContent.getFolderIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("groupIdwc", additionalAssertFieldName)) {
				if (webContent.getGroupIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("idPK", additionalAssertFieldName)) {
				if (webContent.getIdPK() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("imagesB64Encoded", additionalAssertFieldName)) {
				if (webContent.getImagesB64Encoded() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("indexablewc", additionalAssertFieldName)) {
				if (webContent.getIndexablewc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("layoutUuidwc", additionalAssertFieldName)) {
				if (webContent.getLayoutUuidwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("localePrimarywc", additionalAssertFieldName)) {
				if (webContent.getLocalePrimarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"localeSecondarywc", additionalAssertFieldName)) {

				if (webContent.getLocaleSecondarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modDatewc", additionalAssertFieldName)) {
				if (webContent.getModDatewc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("neverReviewwc", additionalAssertFieldName)) {
				if (webContent.getNeverReviewwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("smallImagewc", additionalAssertFieldName)) {
				if (webContent.getSmallImagewc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"titleLangPrimarywc", additionalAssertFieldName)) {

				if (webContent.getTitleLangPrimarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"titleLangSecondarywc", additionalAssertFieldName)) {

				if (webContent.getTitleLangSecondarywc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userIdwc", additionalAssertFieldName)) {
				if (webContent.getUserIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("uuIdwc", additionalAssertFieldName)) {
				if (webContent.getUuIdwc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("versionwc", additionalAssertFieldName)) {
				if (webContent.getVersionwc() == null) {
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

	protected void assertValid(Page<WebContent> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<WebContent> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<WebContent> webContents = page.getItems();

		int size = webContents.size();

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
					com.na.remotewc.headless.rest.dto.v1_0.WebContent.class)) {

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

	protected boolean equals(WebContent webContent1, WebContent webContent2) {
		if (webContent1 == webContent2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("articleIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getArticleIdwc(),
						webContent2.getArticleIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("classNameIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getClassNameIdwc(),
						webContent2.getClassNameIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("classPKwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getClassPKwc(),
						webContent2.getClassPKwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("contentPrimarywc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getContentPrimarywc(),
						webContent2.getContentPrimarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"contentSecondarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getContentSecondarywc(),
						webContent2.getContentSecondarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("ddmStructureIDwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getDdmStructureIDwc(),
						webContent2.getDdmStructureIDwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"ddmStructureKeywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getDdmStructureKeywc(),
						webContent2.getDdmStructureKeywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("ddmTemplateKeywc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getDdmTemplateKeywc(),
						webContent2.getDdmTemplateKeywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("defLang", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getDefLang(), webContent2.getDefLang())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"descLangPrimarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getDescLangPrimarywc(),
						webContent2.getDescLangPrimarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"descLangSecondarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getDescLangSecondarywc(),
						webContent2.getDescLangSecondarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dispDatewc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getDispDatewc(),
						webContent2.getDispDatewc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("extReferenceCode", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getExtReferenceCode(),
						webContent2.getExtReferenceCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"fUrlLangPrimarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getFUrlLangPrimarywc(),
						webContent2.getFUrlLangPrimarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"fUrlLangSecondarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getFUrlLangSecondarywc(),
						webContent2.getFUrlLangSecondarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileClassNameId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileClassNameId(),
						webContent2.getFileClassNameId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileClassNamePk", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileClassNamePk(),
						webContent2.getFileClassNamePk())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileDescs", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileDescs(),
						webContent2.getFileDescs())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileEntryIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileEntryIds(),
						webContent2.getFileEntryIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileEntryUuids", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileEntryUuids(),
						webContent2.getFileEntryUuids())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileMimes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileMimes(),
						webContent2.getFileMimes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileNames", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileNames(),
						webContent2.getFileNames())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fileTitles", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFileTitles(),
						webContent2.getFileTitles())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("folderIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getFolderIdwc(),
						webContent2.getFolderIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("groupIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getGroupIdwc(),
						webContent2.getGroupIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("idPK", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getIdPK(), webContent2.getIdPK())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("imagesB64Encoded", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getImagesB64Encoded(),
						webContent2.getImagesB64Encoded())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("indexablewc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getIndexablewc(),
						webContent2.getIndexablewc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("layoutUuidwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getLayoutUuidwc(),
						webContent2.getLayoutUuidwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("localePrimarywc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getLocalePrimarywc(),
						webContent2.getLocalePrimarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"localeSecondarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getLocaleSecondarywc(),
						webContent2.getLocaleSecondarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modDatewc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getModDatewc(),
						webContent2.getModDatewc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("neverReviewwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getNeverReviewwc(),
						webContent2.getNeverReviewwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("smallImagewc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getSmallImagewc(),
						webContent2.getSmallImagewc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"titleLangPrimarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getTitleLangPrimarywc(),
						webContent2.getTitleLangPrimarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"titleLangSecondarywc", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						webContent1.getTitleLangSecondarywc(),
						webContent2.getTitleLangSecondarywc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getUserIdwc(), webContent2.getUserIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("uuIdwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getUuIdwc(), webContent2.getUuIdwc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("versionwc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						webContent1.getVersionwc(),
						webContent2.getVersionwc())) {

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

		if (!(_webContentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_webContentResource;

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
		EntityField entityField, String operator, WebContent webContent) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("articleIdwc")) {
			Object object = webContent.getArticleIdwc();

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

		if (entityFieldName.equals("classNameIdwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("classPKwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("contentPrimarywc")) {
			Object object = webContent.getContentPrimarywc();

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

		if (entityFieldName.equals("contentSecondarywc")) {
			Object object = webContent.getContentSecondarywc();

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

		if (entityFieldName.equals("ddmStructureIDwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("ddmStructureKeywc")) {
			Object object = webContent.getDdmStructureKeywc();

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

		if (entityFieldName.equals("ddmTemplateKeywc")) {
			Object object = webContent.getDdmTemplateKeywc();

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

		if (entityFieldName.equals("defLang")) {
			Object object = webContent.getDefLang();

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

		if (entityFieldName.equals("descLangPrimarywc")) {
			Object object = webContent.getDescLangPrimarywc();

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

		if (entityFieldName.equals("descLangSecondarywc")) {
			Object object = webContent.getDescLangSecondarywc();

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

		if (entityFieldName.equals("dispDatewc")) {
			if (operator.equals("between")) {
				Date date = webContent.getDispDatewc();

				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(date.getTime() - (2 * Time.SECOND)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(date.getTime() + (2 * Time.SECOND)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(webContent.getDispDatewc()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("extReferenceCode")) {
			Object object = webContent.getExtReferenceCode();

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

		if (entityFieldName.equals("fUrlLangPrimarywc")) {
			Object object = webContent.getFUrlLangPrimarywc();

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

		if (entityFieldName.equals("fUrlLangSecondarywc")) {
			Object object = webContent.getFUrlLangSecondarywc();

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

		if (entityFieldName.equals("fileClassNameId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileClassNamePk")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileDescs")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileEntryIds")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileEntryUuids")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileMimes")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileNames")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("fileTitles")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("folderIdwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("groupIdwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("idPK")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("imagesB64Encoded")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("indexablewc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("layoutUuidwc")) {
			Object object = webContent.getLayoutUuidwc();

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

		if (entityFieldName.equals("localePrimarywc")) {
			Object object = webContent.getLocalePrimarywc();

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

		if (entityFieldName.equals("localeSecondarywc")) {
			Object object = webContent.getLocaleSecondarywc();

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

		if (entityFieldName.equals("modDatewc")) {
			if (operator.equals("between")) {
				Date date = webContent.getModDatewc();

				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(date.getTime() - (2 * Time.SECOND)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(date.getTime() + (2 * Time.SECOND)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(webContent.getModDatewc()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("neverReviewwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("smallImagewc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("titleLangPrimarywc")) {
			Object object = webContent.getTitleLangPrimarywc();

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

		if (entityFieldName.equals("titleLangSecondarywc")) {
			Object object = webContent.getTitleLangSecondarywc();

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

		if (entityFieldName.equals("userIdwc")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("uuIdwc")) {
			Object object = webContent.getUuIdwc();

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

		if (entityFieldName.equals("versionwc")) {
			sb.append(String.valueOf(webContent.getVersionwc()));

			return sb.toString();
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

	protected WebContent randomWebContent() throws Exception {
		return new WebContent() {
			{
				articleIdwc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				classNameIdwc = RandomTestUtil.randomLong();
				classPKwc = RandomTestUtil.randomLong();
				contentPrimarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				contentSecondarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				ddmStructureIDwc = RandomTestUtil.randomLong();
				ddmStructureKeywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				ddmTemplateKeywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				defLang = StringUtil.toLowerCase(RandomTestUtil.randomString());
				descLangPrimarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				descLangSecondarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				dispDatewc = RandomTestUtil.nextDate();
				extReferenceCode = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fUrlLangPrimarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fUrlLangSecondarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fileClassNameId = RandomTestUtil.randomLong();
				fileClassNamePk = RandomTestUtil.randomLong();
				folderIdwc = RandomTestUtil.randomLong();
				groupIdwc = RandomTestUtil.randomLong();
				idPK = RandomTestUtil.randomLong();
				indexablewc = RandomTestUtil.randomBoolean();
				layoutUuidwc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				localePrimarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				localeSecondarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				modDatewc = RandomTestUtil.nextDate();
				neverReviewwc = RandomTestUtil.randomBoolean();
				smallImagewc = RandomTestUtil.randomBoolean();
				titleLangPrimarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				titleLangSecondarywc = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				userIdwc = RandomTestUtil.randomLong();
				uuIdwc = StringUtil.toLowerCase(RandomTestUtil.randomString());
				versionwc = RandomTestUtil.randomDouble();
			}
		};
	}

	protected WebContent randomIrrelevantWebContent() throws Exception {
		WebContent randomIrrelevantWebContent = randomWebContent();

		return randomIrrelevantWebContent;
	}

	protected WebContent randomPatchWebContent() throws Exception {
		return randomWebContent();
	}

	protected WebContentResource webContentResource;
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
		LogFactoryUtil.getLog(BaseWebContentResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private com.na.remotewc.headless.rest.resource.v1_0.WebContentResource
		_webContentResource;

}