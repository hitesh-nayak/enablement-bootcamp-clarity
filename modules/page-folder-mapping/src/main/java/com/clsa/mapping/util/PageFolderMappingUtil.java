package com.clsa.mapping.util;

import com.clsa.mapping.constants.PageFolderMappingPanelCategoryKeys;
import com.liferay.depot.model.DepotEntry;
import com.liferay.depot.service.DepotEntryLocalServiceUtil;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.criteria.FolderItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.item.selector.criteria.folder.criterion.FolderItemSelectorCriterion;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RepositoryLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.RepositoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


public class PageFolderMappingUtil {

    private static final Log log = LogFactoryUtil.getLog(PageFolderMappingUtil.class);

    public static boolean isRepositoryRoot(Folder folder) {
        if (folder.isMountPoint() ||
                (folder.isRoot() &&
                        RepositoryUtil.isExternalRepository(folder.getRepositoryId()))) {

            return true;
        }

        return false;
    }

    public static void validateDepotFolder(
            long folderId, long groupId, long scopeGroupId)
            throws PortalException {

        if (groupId == scopeGroupId) {
            return;
        }

        Group group = GroupLocalServiceUtil.getGroup(groupId);

        if (!group.isDepot()) {
            return;
        }

        List<Long> groupConnectedDepotEntries = ListUtil.toList(
                DepotEntryLocalServiceUtil.getGroupConnectedDepotEntries(
                        scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS),
                DepotEntry::getGroupId);

        if (!groupConnectedDepotEntries.contains(groupId)) {
            throw new NoSuchFolderException("{folderId=" + folderId + "}");
        }
    }

    public static PortletURL getSelectFolderURL(HttpServletRequest httpServletRequest, long repositoryId, long rootFolderId) throws PortalException {
        ThemeDisplay _themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ItemSelector itemSelector =
                (ItemSelector) httpServletRequest.getAttribute(
                        ItemSelector.class.getName());

        FolderItemSelectorCriterion folderItemSelectorCriterion =
                new FolderItemSelectorCriterion();

        folderItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new FolderItemSelectorReturnType());
        folderItemSelectorCriterion.setFolderId(rootFolderId);
        folderItemSelectorCriterion.setIgnoreRootFolder(true);
        folderItemSelectorCriterion.setRepositoryId(repositoryId);
        folderItemSelectorCriterion.setSelectedFolderId(rootFolderId);
        folderItemSelectorCriterion.setSelectedRepositoryId(
                repositoryId);
        folderItemSelectorCriterion.setShowGroupSelector(true);
        folderItemSelectorCriterion.setShowMountFolder(false);

        PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();

        long groupId = repositoryId;

        Repository repository = RepositoryLocalServiceUtil.fetchRepository(
                repositoryId);

        if (repository != null) {
            groupId = repository.getGroupId();
        }

        return itemSelector.getItemSelectorURL(
                RequestBackedPortletURLFactoryUtil.create(httpServletRequest),
                GroupLocalServiceUtil.getGroup(
                        GetterUtil.getLong(groupId, _themeDisplay.getScopeGroupId())),
                _themeDisplay.getScopeGroupId(),
                portletDisplay.getNamespace() + "folderSelected",
                folderItemSelectorCriterion);
    }

    public static PortletURL getSelectPageURL(ItemSelector itemSelector, RenderRequest renderRequest, RenderResponse renderResponse) {

        ItemSelectorCriterion itemSelectorCriterion =
                new LayoutItemSelectorCriterion();

        itemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new UUIDItemSelectorReturnType());

        return itemSelector.getItemSelectorURL(
                RequestBackedPortletURLFactoryUtil.create(renderRequest),
                renderResponse.getNamespace() + "selectPage",
                itemSelectorCriterion);


    }

    public static String getDLFolderTree(Long folderId) {
        DLFolder dlFolder = DLFolderLocalServiceUtil.fetchDLFolder(folderId);

        StringBuilder stringPath = new StringBuilder();
        String folderTree = dlFolder.getTreePath();
        List<Number> folders = getParentFolderIdsFromTreePath(folderTree);
        Iterator<Number> folderItr = folders.iterator();
        while (folderItr.hasNext()) {
            Long id = (Long) folderItr.next();
            if (id > 0) stringPath.append(DLFolderLocalServiceUtil.fetchDLFolder(id).getName());
            if (id > 0 && folderItr.hasNext()) stringPath.append("/");
        }

        return stringPath.toString();
    }

    public static List<Number> getParentFolderIdsFromTreePath(String treePath) {

        String[] folderIds = treePath.split("/");
        return Arrays.stream(folderIds).mapToLong(id -> {
            if (!id.equalsIgnoreCase(StringPool.BLANK)) return Long.parseLong(id);
            return 0;
        }).boxed().collect(Collectors.toList());
    }

    public static void addAuditDetails(ServiceContext serviceContext, long userId, ObjectEntry objectEntry, ObjectEntry objectEntryNew, Map<String, Serializable> auditMap, ObjectDefinition objectDefinitionAudit, Exception throwable) throws PortalException {
        auditMap.put("userDetails", userId);
        auditMap.put("additionalInformation", Validator.isNotNull(throwable) ? throwable.getMessage() : "NA");
        auditMap.put("previousFolderId", Validator.isNotNull(objectEntry) ? objectEntry.getValues().get("folderId") : 0L);
        auditMap.put("currentFolderId", Validator.isNotNull(objectEntryNew) ? objectEntryNew.getValues().get("folderId") : 0L);
        auditMap.put("previousStatus", Validator.isNotNull(objectEntry) ? ((Boolean) objectEntry.getValues().get("active") ? "Enabled" : "Disabled") : "NA");
        auditMap.put("currentStatus", Validator.isNotNull(objectEntryNew) ? ((Boolean) objectEntryNew.getValues().get("active") ? "Enabled" : "Disabled") : "NA");
        auditMap.put("r_mappingAddEdit_c_breadcrumbFolderId", Validator.isNotNull(objectEntryNew) ? objectEntryNew.getObjectEntryId() : 0L);
        auditMap.put("actionDate", new Date());

        ObjectEntry audit = ObjectEntryLocalServiceUtil.addOrUpdateObjectEntry(String.valueOf(System.currentTimeMillis()), userId, 0L, objectDefinitionAudit.getObjectDefinitionId(), auditMap, serviceContext);
        log.info(audit);
    }

}