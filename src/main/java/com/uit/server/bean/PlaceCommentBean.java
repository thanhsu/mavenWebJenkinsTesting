package com.uit.server.bean;

import java.util.Date;

public class PlaceCommentBean {
  private int ID;
  private String Detail;
  private Date DateCreate;
  private String State;
  private int ImageID;
  private int UserID;
  private String FirstName;
  private String LastName;
  private LikerBean[] listLike;
  public int getID() {
    return ID;
  }
  public void setID(int iD) {
    ID = iD;
  }
  public String getDetail() {
    return Detail;
  }
  public void setDetail(String detail) {
    Detail = detail;
  }
  public Date getDateCreate() {
    return DateCreate;
  }
  public void setDateCreate(Date dateCreate) {
    DateCreate = dateCreate;
  }
  public String getState() {
    return State;
  }
  public void setState(String state) {
    State = state;
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
  public void setUserID(int userID) {
    UserID = userID;
  }
  public String getFirstName() {
    return FirstName;
  }
  public void setFirstName(String firstName) {
    FirstName = firstName;
  }
  public String getLastName() {
    return LastName;
  }
  public void setLastName(String lastName) {
    LastName = lastName;
  }
  public LikerBean[] getListLike() {
    return listLike;
  }
  public void setListLike(LikerBean[] listLike) {
    this.listLike = listLike;
  }
  
}
