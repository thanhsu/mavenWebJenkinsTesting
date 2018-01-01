package com.uit.server.Action;

import com.uit.server.BLM.CreateReviewBLM;
import com.uit.server.bean.ResultNonDataBean;
import com.uit.server.utils.ParseImageList;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class PostReviewAction extends BaseAction {
  int idUser;
  int idPlace;
  int idFeel;
  String Caption;
  String Detail;
  String ListImage;
  
  
  @Override
  public void ParseRequestBean() {
    JsonObject json=  this.mvRoutinContext.getBodyAsJson();
    idUser = json.getInteger("UserID");
    idPlace =json.getInteger("PlaceID");
    idFeel =  json.getInteger("FeelID");
    Caption = json.getString("Caption");
    Detail = json.getString("Detail");
    ListImage = json.getString("ListImage");
    
  }

  @Override
  public void ProcessTxn() {
    CreateReviewBLM mvCreateReviewBLM =new CreateReviewBLM();
    int[] listImage = new ParseImageList().ListImageID(ListImage);
    
   int result= mvCreateReviewBLM.CreateNewReview(idUser, idPlace, idFeel, listImage, Caption, Detail);
    if(result!=0) {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(new ResultNonDataBean(1, "Create New Review Sucess", result+"")));
    }else {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(new ResultNonDataBean(1, "Create New Review Fail", "Error")));
    }
  }
  

}
