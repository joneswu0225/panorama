package com.jones.panorama.model;

import java.util.Date;

/**
 * Created by jones on 18-1-16.
 */
public class Comment {
    private Integer commentId;
    private User user = new User();
    private Hotspot hotspot = new Hotspot();
    private Date inserttime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotspot getHotspot() {
        return hotspot;
    }

    public void setHotspot(Hotspot hotspot) {
        this.hotspot = hotspot;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}
