package com.uit.server.Action;

import com.uit.server.BLM.UserInfoBLM;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;

public class UserInfoAction extends BaseAction {
  int UserID;
  UserInfoBLM mvUserInfoBLm;
  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ProcessTxn() {
    mvUserInfoBLm = new UserInfoBLM();
    UserID = this.mvRoutinContext.getBodyAsJson().getInteger("UserID");
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(mvUserInfoBLm.Userinfo(UserID)));
    
  }
  
  public void UpdateAvatar(int idAvatar, int IdUser) {
    mvUserInfoBLm = new UserInfoBLM();
    mvUserInfoBLm.
  }
  

}
