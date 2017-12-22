package com.uit.server.bean;

public class PlaceRequestBean extends BaseRequestBean {
  private String NamePlace;
  private String SessionID;
  private int IDTypePlace;
  private float LocationX;
  private float LocationY;

  public String getNamePlace() {
    return NamePlace;
  }

  public void setNamePlace(String namePlace) {
    NamePlace = namePlace;
  }

  public String getSessionID() {
    return SessionID;
  }

  public void setSessionID(String sessionID) {
    SessionID = sessionID;
  }

  public int getIDTypePlace() {
    return IDTypePlace;
  }

  public void setIDTypePlace(int iDTypePlace) {
    IDTypePlace = iDTypePlace;
  }

  public float getLocationX() {
    return LocationX;
  }

  public void setLocationX(float locationX) {
    LocationX = locationX;
  }

  public float getLocationY() {
    return LocationY;
  }

  public void setLocationY(float locationY) {
    LocationY = locationY;
  }

}
