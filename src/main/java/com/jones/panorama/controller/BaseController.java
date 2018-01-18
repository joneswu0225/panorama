package com.jones.panorama.controller;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.User;
import com.jones.panorama.util.LoginUtil;

/**
 * Created by qiong.wu.
 */


public class BaseController
{
    protected int size = 20;
    protected int page = 1;

    protected User getLoginUser(){
        return LoginUtil.getInstance().getUser();
    }

    protected void setLoginUser(User user){
        LoginUtil.getInstance().setUser(user);
    }

    protected void removeLoginUser(){
        LoginUtil.getInstance().removeUser();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Query getQuery(int pageNum, int pageSize, Object param){
        Query query = new Query(pageNum, pageSize);
        query.setQuery(param);
        return query;
    }

    public Query getQuery(Object param){
        return getQuery(page, size, param);
    }

    public Query getQuery(int pageNum, int pageSize){
        return getQuery(pageNum, pageSize, null);
    }

}
