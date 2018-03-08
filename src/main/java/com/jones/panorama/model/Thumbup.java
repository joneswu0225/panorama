package com.jones.panorama.model;

import java.util.Date;

/**
 * Created by jones on 18-1-16.
 */
public class Thumbup {
    private Integer userId;
    private Integer thumbupId;
    private String hotspotCode;
    private String sceneCode;
    private Date insertTime;


    public Integer getThumbupId() {
        return thumbupId;
    }

    public void setThumbupId(Integer thumbupId) {
        this.thumbupId = thumbupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHotspotCode() {
        return hotspotCode;
    }

    public void setHotspotCode(String hotspotCode) {
        this.hotspotCode = hotspotCode;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
