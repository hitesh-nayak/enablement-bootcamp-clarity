package com.clsa.staffconnect.headless.document.upload.util;

public class DocumentAPIConstants {
  public static final String DOCUMENT_API_MESSAGE_DESTINATION = "/headlessDocument/audit";
  public static final String KEY_DESTINATION_NAME = "destination.name";
  public static final String CLSA_UNIQUE_LOG_IDENTIFIER_API = "[POLICY-CENTRAL-API]: ";
  public static final String CLSA_UNIQUE_LOG_IDENTIFIER_ADMIN = "[POLICY-CENTRAL-ADMIN]: ";
  public static final String USER_POST_DOCUMENT_REQUEST = "USER_POST_DOCUMENT_REQUEST";
  public static final String USER_PUT_DOCUMENT_REQUEST = "USER_PUT_DOCUMENT_REQUEST";
  public static final String USER_DELETE_DOCUMENT_REQUEST = "USER_DELETE_DOCUMENT_REQUEST";
  public static final String KEY_FILE = "file";
  public static final String KEY_BREADCRUMB = "breadcrumb";
  public static final String KEY_NAME = "name";
  public static final String KEY_ERC = "externalReferenceCode";
  public static final String KEY_USER_DETAILS = "userDetails";
  public static final String KEY_USER_ACTION = "userAction";
  public static final String KEY_ENDPOINT = "endPoint";
  public static final String KEY_REQUEST_DATE = "requestDate";
  public static final String KEY_CLIENT_ADDRESS = "clientAddress";
  public static final String KEY_FILE_NAME = "fileName";
  public static final String KEY_FILE_SIZE = "fileSize";
  public static final String KEY_OBJECT_ENTRY_UUID = "objectEntryUuid";
  public static final String KEY_USER_ID = "userId";
  public static final String KEY_OBJECT_DEFINITION_ID = "objectDefinitionId";
  public static final String KEY_AUDIT_MAP = "auditMap";
  public static final String KEY_SERVICE_CONTEXT = "serviceContext";
  public static final String KEY_ADDITIONAL_INFORMATION = "additionalInformation";
  public static final String KEY_STATUS_CODE = "statusCode";
  public static final String KEY_RESPONSE_MESSAGE = "responseMessage";
  public static final String KEY_RELATIONSHIP_BREADCRUMBFOLDER_APIAUDIT = "r_mappingAPI_c_breadcrumbFolderId";
  public static final String KEY_FOLDER_ID = "folderId";
  public static final String KEY_ACTIVE = "active";
  public static final String KEY_ENABLED = "enabled";
  public static final String KEY_DISABLED= "disabled";
  public static final String KEY_NOT_APPLICABLE = "NA";
  public static final String KEY_PREVIOUS_FOLDER_ID = "previousFolderId";
  public static final String KEY_CURRENT_FOLDER_ID = "currentFolderId";
  public static final String KEY_CURRENT_STATUS = "currentStatus";
  public static final String KEY_PREVIOUS_STATUS = "previousStatus";
  public static final String KEY_ACTION_DATE = "actionDate";
  public static final String KEY_LAYOUT_PLID = "layoutPlid";
  public static final String KEY_LAYOUT_BREADCRUMB = "layoutBreadCrumb";
  public static final String KEY_ID = "c_breadcrumbFolderId";
  public static final String KEY_RELATIONSHIP_BREADCRUMBFOLDER_ADD_EDIT = "r_mappingAddEdit_c_breadcrumbFolderId";
  public static final String KEY_PAGES_GREP = "public-pages >";
  public static final String OBJECT_NAME_BREADCRUMB_FOLDER = "C_BreadcrumbFolder";
  public static final String OBJECT_NAME_DOCUMENT_API_AUDIT = "C_DocumentAPIAudit";
  public static final String OBJECT_NAME_BREADCRUMB_FOLDER_MAPPING_AUDIT = "C_BreadcrumbFolderMappingAudit";
  public static final String OBJECT_DEFINITION_NOT_FOUND = "No object definition with name ";
  public static final String OBJECT_ENTRY_NOT_FOUND = "No object entry found with breadcrumb value(ERC) ";
  public static final String PAGE_SELECTOR_URL = "PAGE_SELECTOR_URL";
  public static final String FOLDER_BREADCRUMB_MAPPING_BACKGROUND_TASK_NAME = "DLFolder_Layout_Breadcrumb_Mapping_Background_Task";
  public static final String BACKGROUND_TASK_EXECUTOR_CLASS_NAME = "com.clsa.staffconnect.headless.document.upload.util.DLFolderBreadcrumbMapperExecutor";
  public static final String URL_IDENTIFIER_FOLDER = "folderSelected";
  public static final String URL_IDENTIFIER_LAYOUT = "selectPage";
  public static final String USER_ACTION_ENABLE_MAPPING = "USER_ACTION_ENABLE_MAPPING";
  public static final String USER_ACTION_DISABLE_MAPPING = "USER_ACTION_DISABLE_MAPPING";
  public static final String USER_ACTION_ADD_MAPPING = "USER_ACTION_ADD_MAPPING";
  public static final String USER_ACTION_EDIT_MAPPING = "USER_ACTION_EDIT_MAPPING";
  public static final String USER_ACTION_AUTO_MAPPING = "USER_ACTION_AUTO_MAPPING";

  public static final String MESSAGE_SUCCESSFUL_UPLOAD = "Document was successfully uploaded.";
  public static final String MESSAGE_SUCCESSFUL_UPDATE = "Document was successfully updated.";
  public static final String MESSAGE_SUCCESSFUL_DELETE = "Document was successfully deleted.";
  public static final String MESSAGE_FOLDER_NOT_FOUND = "No folder exists for the provided breadcrumb path.";


}
