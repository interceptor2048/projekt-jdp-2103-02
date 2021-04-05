package com.kodilla.ecommercee.dto;

public class GroupDto {
    private Long groupId;
    private String groupName;

    public GroupDto(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public GroupDto() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
