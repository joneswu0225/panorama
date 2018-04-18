package com.jones.panorama.model;

import java.util.Date;

public class Hotspot {
    private Integer hotspotId;
    private String code;
    private String catalogName;
    private String title;
    private String content;
    private float ath;
    private float atv;
    private String onclick = "";
    private String onload = "";
    private String hover = "";
    private String out = "";
    private String styleName;
    private String sceneCode;
    private String pHotspotCode;
    private Date insertTime;

    public Integer getHotspotId() {
        return this.hotspotId;
    }

    public void setHotspotId(Integer hotspotId) {
        this.hotspotId = hotspotId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCatalogName() {
        return this.catalogName;
    }

    public void setCatelogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getOnclick() {
        return this.onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public String getOnload() {
        return this.onload;
    }

    public void setOnload(String onload) {
        this.onload = onload;
    }

    public String getHover() {
        return this.hover;
    }

    public void setHover(String hover) {
        this.hover = hover;
    }

    public String getOut() {
        return this.out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getStyleName() {
        return this.styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getSceneCode() {
        return this.sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getpHotspotCode() {
        return pHotspotCode;
    }

    public void setpHotspotCode(String pHotspotCode) {
        this.pHotspotCode = pHotspotCode;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}

