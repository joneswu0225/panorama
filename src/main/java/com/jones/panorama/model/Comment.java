 package com.jones.panorama.model;

 import java.util.Date;

 public class Comment
 {
   private Integer commentId;
  private User user = new User();
  private Hotspot hotspot = new Hotspot();
   private Date inserttime;

   public Integer getCommentId()
   {
    return this.commentId;
   }

   public void setCommentId(Integer commentId) {
    this.commentId = commentId;
   }

   public User getUser() {
    return this.user;
   }

   public void setUser(User user) {
    this.user = user;
   }

   public Hotspot getHotspot() {
    return this.hotspot;
   }

   public void setHotspot(Hotspot hotspot) {
    this.hotspot = hotspot;
   }

   public Date getInserttime() {
    return this.inserttime;
   }

   public void setInserttime(Date inserttime) {
    this.inserttime = inserttime;
   }
 }

