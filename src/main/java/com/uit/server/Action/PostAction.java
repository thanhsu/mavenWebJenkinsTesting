package com.uit.server.Action;

import io.vertx.core.json.JsonObject;

public class PostAction extends BaseAction {
  private int UserID;
  private String PostDetail;
  private int FeelID;
  private String ListImage; //1-2-3-4-5-6
  
  @Override
  public void ParseRequestBean() {
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    this.UserID = json.getInteger("UserID");
    this.PostDetail = json.getString("PostDetail");
    this.FeelID = json.getInteger("FeelID");
    this.ListImage = json.getString("ListImage");
    
  }

  @Override
  public void ProcessTxn() {
    
    
  }
}
