package com.jones.panorama.model;

import java.util.Date;

public class UserVisit {
    private Integer id;
    private String username = "Anonymous";
    private String path;
    private String srcIp;
    private Integer roleId;
    private Date insertTime;

    public UserVisit() {
    }

    public UserVisit(String path, String srcIp) {
        this.path = path;
        this.srcIp = srcIp;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSrcIp() {
        return this.srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}

