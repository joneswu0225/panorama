package com.jones.panorama.model;

import com.alibaba.fastjson.JSONObject;

public class GeneralResponse {
    private boolean suc;
    private String msg;

    public GeneralResponse() {
    }

    public GeneralResponse(boolean suc, String msg) {
        setSuc(suc);
        setMsg(msg);
    }

    public boolean isSuc() {
        return this.suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

