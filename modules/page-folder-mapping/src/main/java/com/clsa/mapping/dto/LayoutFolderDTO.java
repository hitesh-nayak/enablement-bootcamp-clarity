package com.clsa.mapping.dto;

import java.io.Serializable;

/**
 * @author Hitesh Nayak
 */
public class LayoutFolderDTO implements Serializable {

    private String objectERC;
    private Long folderId;
    private Long layoutPlid;
    private Long layoutGroupId;
    private String layoutBreadCrumb;
    private Boolean enabled;

    public LayoutFolderDTO(String objectERC, Long folderId, Long layoutPlid, String layoutBreadCrumb, Boolean enabled, Long layoutGroupId) {
        this.objectERC = objectERC;
        this.folderId = folderId;
        this.layoutPlid = layoutPlid;
        this.layoutBreadCrumb = layoutBreadCrumb;
        this.enabled = enabled;
        this.layoutGroupId = layoutGroupId;
    }

    public Long getLayoutGroupId() {
        return layoutGroupId;
    }

    public void setLayoutGroupId(Long layoutGroupId) {
        this.layoutGroupId = layoutGroupId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getObjectERC() {
        return objectERC;
    }

    public void setObjectERC(String objectERC) {
        this.objectERC = objectERC;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Long getLayoutPlid() {
        return layoutPlid;
    }

    public void setLayoutPlid(Long layoutPlid) {
        this.layoutPlid = layoutPlid;
    }


    public String getLayoutBreadCrumb() {
        return layoutBreadCrumb;
    }

    public void setLayoutBreadCrumb(String layoutBreadCrumb) {
        this.layoutBreadCrumb = layoutBreadCrumb;
    }

    @Override
    public String toString() {
        return "LayoutFolderDTO{" +
                "folderId='" + folderId + '\'' +
                ", layoutPlid='" + layoutPlid + '\'' +
                ", layoutBreadCrumb='" + layoutBreadCrumb + '\'' +
                '}';
    }
}
