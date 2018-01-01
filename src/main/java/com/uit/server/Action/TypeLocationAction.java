package com.uit.server.Action;

import com.uit.server.BLM.TypeLocationBLM;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;

public class TypeLocationAction extends BaseAction {

  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ProcessTxn() {
    TypeLocationBLM mvTypeLocationBLM  = new TypeLocationBLM(this.mvRequestBean);
    ResultBean Result = new ResultBean(1, "Danh sách loại vị trí.", mvTypeLocationBLM.AllTypeLocation());
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(Result));
  }
  
}
