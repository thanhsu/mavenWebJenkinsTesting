package com.uit.server.Action;

import com.uit.server.BLM.PostBLM;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class PostAction extends BaseAction {
  private int UserID;
  private String PostDetail;
  private int FeelID;
  private String ListImage; // 1-2-3-4-5-6
  PostBLM mvPostBLM;

  @Override
  public void ParseRequestBean() {
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    this.UserID = json.getInteger("UserID");
    this.PostDetail = json.getString("PostDetail");
    this.FeelID = json.getInteger("FeelID");
    this.ListImage = json.getString("ListImage");

    String[] lst = ListImage.split("-");
    int[] lstImage = new int[lst.length];
    for (int i = 0; i < lstImage.length; i++) {
      try {
        lstImage[i] = Integer.parseInt(lst[i]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    mvPostBLM = new PostBLM();
    Object[] result = new Object[1];
   result[0]= mvPostBLM.PostStatus(UserID, PostDetail, lstImage, this.FeelID);
   this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(new ResultBean(1, "Lưu Status Thành Công",  result)));
  }
  
  @Override
  public void ProcessTxn() {


  }


}
