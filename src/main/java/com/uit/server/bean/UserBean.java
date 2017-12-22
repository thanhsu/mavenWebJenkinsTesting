package com.uit.server.bean;

import io.vertx.ext.web.RoutingContext;

public class UserBean extends BaseRequestBean {
  static String USERNAME = "UserName";
  static String PASSWORD = "Password";
  static String TOKEN = "Token";
  static String FIRSTNAME = "FirstName";
  static String LASTNAME = "LastName";
  static String YEARBORN = "BirthYear";
  static String EMAIL = "EMAIL";
  
  private String mvUsername;
  private String mvPassword;
  private String mvToken;
  private String mvFirstName;
  private String mvLastName;
  private String mvYearBorn;
  private String mvEmail;
  
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

  

  public UserBean(RoutingContext pvRoutingContext) {
    super(pvRoutingContext);
    // TODO Auto-generated constructor stub
  }

  public UserBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public UserBean getBodyLoginRequest() {
    mvUsername = this.mvRoutingContext.getBodyAsJson().getString(USERNAME);
    mvPassword = this.mvRoutingContext.getBodyAsJson().getString(PASSWORD);
    mvToken = this.mvRoutingContext.getBodyAsJson().getString(TOKEN);
    return this;
  }
  
  public UserBean getRegisterRequest() {
    mvUsername = this.mvRoutingContext.getBodyAsJson().getString(USERNAME);
    mvPassword = this.mvRoutingContext.getBodyAsJson().getString(PASSWORD);
    mvFirstName = this.mvRoutingContext.getBodyAsJson().getString(FIRSTNAME);
    mvLastName =  this.mvRoutingContext.getBodyAsJson().getString(LASTNAME);
    mvYearBorn = this.mvRoutingContext.getBodyAsJson().getString(YEARBORN);
    mvEmail = this.mvRoutingContext.getBodyAsJson().getString(EMAIL);
    
    return this;
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
}
