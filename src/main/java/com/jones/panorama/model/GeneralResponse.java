package com.jones.panorama.model;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by mayaming on 10/10/17.
 */
public class GeneralResponse {
    private boolean suc;
    private String msg;

    public GeneralResponse() {
        super();
    }

    public GeneralResponse(boolean suc, String msg) {
        setSuc(suc);
        setMsg(msg);
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
