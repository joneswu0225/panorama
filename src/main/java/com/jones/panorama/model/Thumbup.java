package com.jones.panorama.model;

import java.util.Date;

public class Thumbup {
    private Integer userId;
    private Integer thumbupId;
    private String hotspotCode;
    private String sceneCode;
    private Date insertTime;

    public Integer getThumbupId() {
        return this.thumbupId;
    }

    public void setThumbupId(Integer thumbupId) {
        this.thumbupId = thumbupId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHotspotCode() {
        return this.hotspotCode;
    }

    public void setHotspotCode(String hotspotCode) {
        this.hotspotCode = hotspotCode;
    }

    public String getSceneCode() {
        return this.sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}

