package com.uit.server.bean;

import java.util.Date;

public class ReviewBean {
  private int ReviewID;
  private int IDUser;
  private String UserFullName;
  private Date ReviewDate;
  private String ReviewCaption;
  private String ReviewDetail;
  private CommentBean[] lstComment;
  private LikerBean[] lstLikeReview;
  private ImageBean[] lstImage;

  public int getReviewID() {
    return ReviewID;
  }

  public void setReviewID(int reviewID) {
    ReviewID = reviewID;
  }

  public int getIDUser() {
    return IDUser;
  }

  public void setIDUser(int iDUser) {
    IDUser = iDUser;
  }

  public String getUserFullName() {
    return UserFullName;
  }

  public void setUserFullName(String userFullName) {
    UserFullName = userFullName;
  }

  public Date getReviewDate() {
    return ReviewDate;
  }

  public void setReviewDate(Date reviewDate) {
    ReviewDate = reviewDate;
  }

  public String getReviewCaption() {
    return ReviewCaption;
  }

  public void setReviewCaption(String reviewCaption) {
    ReviewCaption = reviewCaption;
  }

  public String getReviewDetail() {
    return ReviewDetail;
  }

  public void setReviewDetail(String reviewDetail) {
    ReviewDetail = reviewDetail;
  }


  public CommentBean[] getLstComment() {
    return lstComment;
  }

  public void setLstComment(CommentBean[] lstComment) {
    this.lstComment = lstComment;
  }

  public LikerBean[] getLstLikeReview() {
    return lstLikeReview;
  }

  public void setLstLikeReview(LikerBean[] lstLikeReview) {
    this.lstLikeReview = lstLikeReview;
  }

  public ImageBean[] getLstImage() {
    return lstImage;
  }

  public void setLstImage(ImageBean[] lstImage) {
    this.lstImage = lstImage;
  }


}
