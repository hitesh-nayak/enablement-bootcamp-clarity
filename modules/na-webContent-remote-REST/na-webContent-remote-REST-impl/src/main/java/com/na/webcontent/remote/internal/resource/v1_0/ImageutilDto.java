package com.na.webcontent.remote.internal.resource.v1_0;

import java.io.Serializable;

public class ImageutilDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1445637778903L;
//	public long classPK;
	public String groupId;
	public String name;
	public String alt;
	public String title;
	public String type;
	public String uuid;
	public String fileEntryId;
//	public String resourcePrimKey;
//	public long getClassPK() {
//		return classPK;
//	}
//	public void setClassPK(long classPK) {
//		this.classPK = classPK;
//	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileEntryId() {
		return fileEntryId;
	}
	public void setFileEntryId(String fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
//	public String getResourcePrimKey() {
//		return resourcePrimKey;
//	}
//	public void setResourcePrimKey(String resourcePrimKey) {
//		this.resourcePrimKey = resourcePrimKey;
//	}
	

}
