package com.clsa.staffconnect.breadcrumb.folder.mapping.web.dto;

import java.io.Serializable;

/**
 * @author Hitesh Nayak
 */
public class BCFMappingDTO implements Serializable {

	private long id;
	private String objectERC;
	private Long folderId;
	private Long layoutPlid;
	private Long layoutGroupId;
	private String layoutBreadCrumb;
	private Boolean isActive;

	public BCFMappingDTO(long id, String objectERC, Long folderId, Long layoutPlid, String layoutBreadCrumb,
			Boolean enabled, Long layoutGroupId) {
		this.id = id;
		this.objectERC = objectERC;
		this.folderId = folderId;
		this.layoutPlid = layoutPlid;
		this.layoutBreadCrumb = layoutBreadCrumb;
		this.isActive = enabled;
		this.layoutGroupId = layoutGroupId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getLayoutGroupId() {
		return layoutGroupId;
	}

	public void setLayoutGroupId(Long layoutGroupId) {
		this.layoutGroupId = layoutGroupId;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setIsActive(Boolean enabled) {
		this.isActive = enabled;
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
		return "LayoutFolderDTO{" + "folderId='" + folderId + '\'' + ", layoutPlid='" + layoutPlid + '\''
				+ ", layoutBreadCrumb='" + layoutBreadCrumb + '\'' + '}';
	}
}
