package com.uit.server.bean;

public class NewPlaceRequestBean extends BaseRequestBean {
  private float LocationX;
  private float LocationY;
  private String NamePlace;
  private int IDGroupPlace;
  private String NameGroupPlace;
  private int IDTypePlace;
  private String NameTypePlace;
  private String Note;
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
  public String getNamePlace() {
    return NamePlace;
  }
  public void setNamePlace(String namePlace) {
    NamePlace = namePlace;
  }
  public int getIDGroupPlace() {
    return IDGroupPlace;
  }
  public void setIDGroupPlace(int iDGroupPlace) {
    IDGroupPlace = iDGroupPlace;
  }
  public String getNameGroupPlace() {
    return NameGroupPlace;
  }
  public void setNameGroupPlace(String nameGroupPlace) {
    NameGroupPlace = nameGroupPlace;
  }
  public int getIDTypePlace() {
    return IDTypePlace;
  }
  public void setIDTypePlace(int iDTypePlace) {
    IDTypePlace = iDTypePlace;
  }
  public String getNameTypePlace() {
    return NameTypePlace;
  }
  public void setNameTypePlace(String nameTypePlace) {
    NameTypePlace = nameTypePlace;
  }
  public String getNote() {
    return Note;
  }
  public void setNote(String note) {
    Note = note;
  }
  
}
