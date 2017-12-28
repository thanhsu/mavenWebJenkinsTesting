package com.uit.server.Action;

import com.uit.server.BLM.PostBLM;
import com.uit.server.bean.PostBean;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class GetPostAction extends BaseAction {
  PostBLM mvPostBLM;
  public int UserID;
  int code;
  
  public GetPostAction setCode(int pc) {
    this.code = pc;
    return this;
  }
  
  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub

  }

  @Override
  public void ProcessTxn() {
    if(code==1)
      this.GetAllPostUser();
    else
      this.GetAllPostFollow();

  }

  public void GetAllPostUser() {
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    UserID = json.getInteger("UserID");
    mvPostBLM = new PostBLM();
    PostBean[] lstResult = mvPostBLM.ALLPostMyUser(UserID);
    
    ResultBean Result = new ResultBean(1,"All user status", lstResult);
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8").end(Json.encodePrettily(Result));    
    
  }

  public void GetAllPostFollow() {
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    UserID = json.getInteger("UserID");
    mvPostBLM = new PostBLM();
    PostBean[] lstResult = mvPostBLM.AllPostFollow(UserID);
    
    ResultBean Result = new ResultBean(1,"All user status", lstResult);
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8").end(Json.encodePrettily(Result));
  }

}
