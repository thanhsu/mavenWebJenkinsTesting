package com.uit.server.bean;

public class PostBean {
  private int IDUser;
  private String FullName;
  private int IDStatus;
  private String Detail;
  private int IDFeel;
  private int[] lstImage;
  private java.util.Date DateCreate;
  public int getIDStatus() {
    return IDStatus;
  }
  public void setIDStatus(int iDStatus) {
    IDStatus = iDStatus;
  }
  public String getDetail() {
    return Detail;
  }
  public void setDetail(String detail) {
    Detail = detail;
  }
  public int getIDFeel() {
    return IDFeel;
  }
  public void setIDFeel(int iDFeel) {
    IDFeel = iDFeel;
  }
  public int[] getLstImage() {
    return lstImage;
  }
  public void setLstImage(int[] lstImage) {
    this.lstImage = lstImage;
  }
  public String getFullName() {
    return FullName;
  }
  public void setFullName(String fullName) {
    FullName = fullName;
  }
  public int getIDUser() {
    return IDUser;
  }
  public void setIDUser(int iDUser) {
    IDUser = iDUser;
  }
  public java.util.Date getDateCreate() {
    return DateCreate;
  }
  public void setDateCreate(java.util.Date dateCreate) {
    DateCreate = dateCreate;
  }
  
  
  
}
