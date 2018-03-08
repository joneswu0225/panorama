package com.jones.panorama.model;

import java.util.Date;

/**
 * Created by jones on 18-1-16.
 */
public class Comment {
    private Integer commentId;
    private User user;
    private Hotspot hotSpot;
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

    public Hotspot getHotSpot() {
        return hotSpot;
    }

    public void setHotSpot(Hotspot hotSpot) {
        this.hotSpot = hotSpot;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}
