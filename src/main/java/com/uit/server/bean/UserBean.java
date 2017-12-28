package com.uit.server.bean;

import io.vertx.ext.web.RoutingContext;

public class UserBean {
  public static String USERNAME = "UserName";
  public static String PASSWORD = "Password";
  public static String TOKEN = "Token";
  public static String FIRSTNAME = "FirstName";
  public static String LASTNAME = "LastName";
  public static String YEARBORN = "BirthYear";
  public static String EMAIL = "Email";
  public static String AVATARID = "Avatar";
  public static String USERID = "UserID";
  public static String PHONENUMBER = "PhoneNumber";

  private String mvUsername;
  private String mvPassword;
  private String mvToken;
  private String mvFirstName;
  private String mvLastName;
  private String mvYearBorn;
  private String mvEmail;
  private int mvAvartarID;
  private int mvUserID;
  private String mvPhoneNumber;


  public String getMvUsername() {
    return mvUsername;
  }

  public void setMvUsername(String mvUsername) {
    this.mvUsername = mvUsername;
  }

  public String getMvPassword() {
    return mvPassword;
  }

  public void setMvPassword(String mvPassword) {
    this.mvPassword = mvPassword;
  }

  public String getMvToken() {
    return mvToken;
  }

  public void setMvToken(String mvToken) {
    this.mvToken = mvToken;
  }



  public UserBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public String getMvFirstName() {
    return mvFirstName;
  }

  public void setMvFirstName(String mvFirstName) {
    this.mvFirstName = mvFirstName;
  }

  public String getMvLastName() {
    return mvLastName;
  }

  public void setMvLastName(String mvLastName) {
    this.mvLastName = mvLastName;
  }

  public String getMvYearBorn() {
    return mvYearBorn;
  }

  public void setMvYearBorn(String mvYearBorn) {
    this.mvYearBorn = mvYearBorn;
  }

  public String getMvEmail() {
    return mvEmail;
  }

  public void setMvEmail(String mvEmail) {
    this.mvEmail = mvEmail;
  }

  public int getMvAvartarID() {
    return mvAvartarID;
  }

  public void setMvAvartarID(int mvAvartarID) {
    this.mvAvartarID = mvAvartarID;
  }

  public int getMvUserID() {
    return mvUserID;
  }

  public void setMvUserID(int mvUserID) {
    this.mvUserID = mvUserID;
  }

  public String getMvPhoneNumber() {
    return mvPhoneNumber;
  }

  public void setMvPhoneNumber(String mvPhoneNumber) {
    this.mvPhoneNumber = mvPhoneNumber;
  }



}
