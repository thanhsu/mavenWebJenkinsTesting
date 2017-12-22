package com.uit.server.bean;

public class ImageBean {
  private int ImageID;
  private String Caption;
  private String Discription;

  public int getImageID() {
    return ImageID;
  }

  public void setImageID(int imageID) {
    ImageID = imageID;
  }

  public String getCaption() {
    return Caption;
  }

  public void setCaption(String caption) {
    Caption = caption;
  }

  public String getDiscription() {
    return Discription;
  }

  public void setDiscription(String discription) {
    Discription = discription;
  }
}
