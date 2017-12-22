package com.uit.server.bean;

import java.util.Date;

public class LikerBean {
  private int UserID;
  private String UserFullName;
  private int IDLike;



  public String getUserFullName() {
    return UserFullName;
  }

  public void setUserFullName(String userFullName) {
    UserFullName = userFullName;
  }

  public int getIDLike() {
    return IDLike;
  }

  public void setIDLike(int iDLike) {
    IDLike = iDLike;
  }

  public void setUserID(int userID) {
    UserID = userID;
  }
}
