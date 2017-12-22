package com.uit.server.bean;

public class ResultBean {
  
  public ResultBean(int code, String message, Object[] data) {
    this.mvCode=code;
    this.mvMessage=message;
    this.mvData = data;
  }
  public ResultBean() {}
  public int getMvCode() {
    return mvCode;
  }
  public void setMvCode(int mvCode) {
    this.mvCode = mvCode;
  }
  public String getMvMessage() {
    return mvMessage;
  }
  public void setMvMessage(String mvMessage) {
    this.mvMessage = mvMessage;
  }
  public Object[] getMvData() {
    return mvData;
  }
  public void setMvData(Object[] mvData) {
    this.mvData = mvData;
  }
  private int mvCode;
  private String mvMessage;
  private Object[] mvData;
  
  
}
