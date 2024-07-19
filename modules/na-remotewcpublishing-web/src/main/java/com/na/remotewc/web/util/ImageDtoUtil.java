package com.na.remotewc.web.util;

import java.io.Serializable;

public class ImageDtoUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1334562783776L;
	
	public String groupId;
	public String name;
	public String alt;
	public String title;
	public String type;
	public String uuid;
	public String fileEntryId;
	
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

}
