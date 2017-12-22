package com.uit.server.Action;

import com.uit.server.BLM.TypeFeelBLM;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;

public class FeelAction extends BaseAction {

  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ProcessTxn() {
    TypeFeelBLM mvFeelBLm =  new TypeFeelBLM();
    
    ResultBean Result = new ResultBean(1, "Danh sách feel", mvFeelBLm.AllTypeFeel());
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(Result));
  }
}
