package com.uit.server.bean;

import java.util.Date;

public class CommentBean {
  private int CommentID;
  private int UserID;
  private String UserFullName;
  private String Detail;
  private Date CommentDate;
  private int ImageID;
  private LikerBean[] lstLikeComment;
  private SubComment[] lstSubComment;

  

  public String getUserFullName() {
    return UserFullName;
  }

  public void setUserFullName(String userFullName) {
    UserFullName = userFullName;
  }

  public String getDetail() {
    return Detail;
  }

  public void setDetail(String detail) {
    Detail = detail;
  }

  public Date getCommentDate() {
    return CommentDate;
  }

  public void setCommentDate(Date commentDate) {
    CommentDate = commentDate;
  }

  public LikerBean[] getLstLikeComment() {
    return lstLikeComment;
  }

  public void setLstLikeComment(LikerBean[] lstLikeComment) {
    this.lstLikeComment = lstLikeComment;
  }

  public SubComment[] getLstSubComment() {
    return lstSubComment;
  }

  public void setLstSubComment(SubComment[] lstSubComment) {
    this.lstSubComment = lstSubComment;
  }



  public int getCommentID() {
    return CommentID;
  }

  public void setCommentID(int commentID) {
    CommentID = commentID;
  }

  public void setUserID(int userID) {
    UserID = userID;
  }

  public int getImageID() {
    return ImageID;
  }

  public void setImageID(int imageID) {
    ImageID = imageID;
  }

  public int getUserID() {
    return UserID;
  }
}
