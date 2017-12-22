package com.uit.server.bean;

public class PlaceBean {
  private String LocationX;
  private String LocationY;
  private int IDTypeLocation;
  private String TypeLocation;
  private String PhoneNumber;
  private String Email;
  private int IDTypePlace;
  private int IDPlace;
  private String TypePlace;
  private String NamePace;
  private PlaceCommentBean[] lstComment;
  private ReviewBean[] lstReview;
  private LikerBean[] lstLike;
  private ImageBean[] lstImage;


  public String getLocationX() {
    return LocationX;
  }

  public void setLocationX(String locationX) {
    LocationX = locationX;
  }

  public String getLocationY() {
    return LocationY;
  }

  public void setLocationY(String locationY) {
    LocationY = locationY;
  }

  public String getTypePlace() {
    return TypePlace;
  }

  public void setTypePlace(String typePlace) {
    TypePlace = typePlace;
  }

  public PlaceCommentBean[] getLstComment() {
    return lstComment;
  }

  public void setLstComment(PlaceCommentBean[] lstComment) {
    this.lstComment = lstComment;
  }

  public ReviewBean[] getLstReview() {
    return lstReview;
  }

  public void setLstReview(ReviewBean[] lstReview) {
    this.lstReview = lstReview;
  }

  public LikerBean[] getLstLike() {
    return lstLike;
  }

  public void setLstLike(LikerBean[] lstLike) {
    this.lstLike = lstLike;
  }

  public ImageBean[] getLstImage() {
    return lstImage;
  }

  public void setLstImage(ImageBean[] lstImage) {
    this.lstImage = lstImage;
  }

  public String getNamePace() {
    return NamePace;
  }

  public void setNamePace(String namePace) {
    NamePace = namePace;
  }

  public int getIDTypePlace() {
    return IDTypePlace;
  }

  public void setIDTypePlace(int iDTypePlace) {
    IDTypePlace = iDTypePlace;
  }

  public int getIDPlace() {
    return IDPlace;
  }

  public void setIDPlace(int iDPlace) {
    IDPlace = iDPlace;
  }

  public String getTypeLocation() {
    return TypeLocation;
  }

  public void setTypeLocation(String typeLocation) {
    TypeLocation = typeLocation;
  }

  public int getIDTypeLocation() {
    return IDTypeLocation;
  }

  public void setIDTypeLocation(int iDTypeLocation) {
    IDTypeLocation = iDTypeLocation;
  }

  public String getPhoneNumber() {
    return PhoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    PhoneNumber = phoneNumber;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }
}
