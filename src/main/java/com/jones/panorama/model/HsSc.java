package com.jones.panorama.model;

import java.util.Date;

public class HsSc {
    private Integer hsScId;
    private String hotspotCode;
    private Hotspot hotspot;
    private String sceneCode;
    private float ath;
    private float atv;
    private Integer roleId;
    private Date insertTime;

    public Integer getHsScId() {
        return this.hsScId;
    }

    public void setHsScId(Integer hsScId) {
        this.hsScId = hsScId;
    }

    public String getHotspotCode() {
        return this.hotspotCode;
    }

    public void setHotspotCode(String hotspotCode) {
        this.hotspotCode = hotspotCode;
    }

    public Hotspot getHotspot() {
        return this.hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public String getSceneCode() {
        return this.sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public float getAth() {
        return this.ath;
    }

    public void setAth(float ath) {
        this.ath = ath;
    }

    public float getAtv() {
        return this.atv;
    }

    public void setAtv(float atv) {
        this.atv = atv;
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

