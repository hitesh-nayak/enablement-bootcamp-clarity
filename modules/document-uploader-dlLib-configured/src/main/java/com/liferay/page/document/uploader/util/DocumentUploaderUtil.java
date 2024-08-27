package com.liferay.page.document.uploader.util;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentUploaderUtil {

    public static Map<Long,String> getDLFolderTrees(List<DLFolder> dlFolders) {
        Map<Long,String> dlFolderTreeMap = new HashMap<Long,String>();
        for (DLFolder dlFolder : dlFolders) {
            StringBuilder stringPath = new StringBuilder();
            String folderTree = dlFolder.getTreePath();
            List<Number> folders = getParentFolderIdsFromTreePath(folderTree);
            Iterator<Number> folderItr = folders.iterator();
            while (folderItr.hasNext()) {
                Long id = (Long) folderItr.next();
                if(id>0) stringPath.append(DLFolderLocalServiceUtil.fetchDLFolder(id).getName());
                if(id>0 && folderItr.hasNext()) stringPath.append("  >  ");
            }
            dlFolderTreeMap.put(dlFolder.getFolderId(), stringPath.toString());
        }
        return dlFolderTreeMap;
    }

    public static List<Number> getParentFolderIdsFromTreePath(String treePath) {

        String [] folderIds= treePath.split("/");
        return Arrays.stream(folderIds).mapToLong(id -> {
            if(!id.equalsIgnoreCase(StringPool.BLANK)) return Long.parseLong(id);
            return 0;
        }).boxed().collect(Collectors.toList());
    }
}
