package com.uit.server.bean;

import java.util.Date;

public class SubComment {
  private String UserID;
  private String UserFullName;
  private String Detail;
  private LikerBean[] lstLike;
  private Date DateComment;
  private ImageBean ImageSubComment;

  public String getUserID() {
    return UserID;
  }

  public void setUserID(String userID) {
    UserID = userID;
  }

  public String getDetail() {
    return Detail;
  }

  public void setDetail(String detail) {
    Detail = detail;
  }

  public LikerBean[] getLstLike() {
    return lstLike;
  }

  public void setLstLike(LikerBean[] lstLike) {
    this.lstLike = lstLike;
  }

  public Date getDateComment() {
    return DateComment;
  }

  public void setDateComment(Date dateComment) {
    DateComment = dateComment;
  }

  public String getUserFullName() {
    return UserFullName;
  }

  public void setUserFullName(String userFullName) {
    UserFullName = userFullName;
  }

  public ImageBean getImageSubComment() {
    return ImageSubComment;
  }

  public void setImageSubComment(ImageBean imageSubComment) {
    ImageSubComment = imageSubComment;
  }
}
