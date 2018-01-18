package com.jones.panorama.util;

import com.jones.panorama.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by qiong.wu.
 */
public class LoginUtil {
    public static final String CUR_USER = "cur_user";
    public static final int SESSION_MAX_INACTIVE_INTERVAL = 60 * 60 * 12; // 12 hours
    public static LoginUtil INSTANCE = null;

    private LoginUtil(){
    }

    /**
     * 获取实例
     * @return
     */
    public static LoginUtil getInstance(){
        if(INSTANCE == null){
            synchronized (LoginUtil.class) {
                if(INSTANCE == null) {
                    INSTANCE = new LoginUtil();
                }
            }
        }

        return INSTANCE;
    }
    /**
     * 获取当前Request
     * @return
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 获取当前Session
     * @return
     */
    private HttpSession getSession() {
        HttpSession session = getRequest().getSession(true);
        session.setMaxInactiveInterval(SESSION_MAX_INACTIVE_INTERVAL);
        return session;
    }

    /**
     * 获取当前session里面放置的User对象
     * @return
     */
    public User getUser(){
        return (User)getSession().getAttribute(CUR_USER);
    }

    /**
     * 移除当前session里面放置的User对象
     */
    public void removeUser(){
        getSession().removeAttribute(CUR_USER);
    }

    /**
     * 把当前User对象放置到session里面
     * @param user
     */
    public void setUser(User user){
        getSession().setAttribute(CUR_USER, user);
    }
}
