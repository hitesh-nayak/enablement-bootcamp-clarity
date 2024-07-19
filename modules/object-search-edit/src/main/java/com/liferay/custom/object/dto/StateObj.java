package com.liferay.custom.object.dto;

/**
 * @author Hitesh Nayak
 *
 * This custom DTO class is used to map the fields and data in a liferay object so that it can be represented in a custom format to the end user.
 */
public class StateObj {

    private long stateId;


    private long stateObjectDefId;


    private String name;

    private long pinCode;
    private String extRefId;

    public StateObj(long stateId) {
        this.stateId = stateId;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getStateObjectDefId() {
        return stateObjectDefId;
    }

    public void setStateObjectDefId(long stateObjectDefId) {
        this.stateObjectDefId = stateObjectDefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StateObj{" +
                "stateId=" + stateId +
                ", stateObjectDefId=" + stateObjectDefId +
                ", name='" + name + '\'' +
                ", pinCode=" + pinCode +
                ", extRefId='" + extRefId + '\'' +
                '}';
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public String getExtRefId() {
        return extRefId;
    }

    public void setExtRefId(String extRefId) {
        this.extRefId = extRefId;
    }


}
