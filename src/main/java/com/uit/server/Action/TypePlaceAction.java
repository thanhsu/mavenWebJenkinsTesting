package com.uit.server.Action;

import com.uit.server.BLM.TypePlaceBLM;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;

public class TypePlaceAction extends BaseAction {

  @Override
  public void ParseRequestBean() {
    
    
  }

  @Override
  public void ProcessTxn() {
    TypePlaceBLM mvTypePlaceBLM = new TypePlaceBLM();
    ResultBean Result = new ResultBean(1, "Danh sách loại địa điểm.", mvTypePlaceBLM.AllTypePlace());
    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(Result));    
  }

    
  
}
