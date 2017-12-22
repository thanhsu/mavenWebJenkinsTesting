package com.uit.server.Action;

import com.uit.server.BLM.BaseBLM;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.ResultBean;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public abstract class BaseAction {
  BaseBLM mvBaseBLM;
  ResultBean mvResultBean;
  RoutingContext mvRoutinContext;
  public void setMvRoutinContext(RoutingContext mvRoutinContext) {
    this.mvRoutinContext = mvRoutinContext;
    ParseRequestBean();
  }

  BaseRequestBean mvRequestBean;

  public BaseAction() {
    mvResultBean = new ResultBean();
  }
  
  public abstract void ParseRequestBean() ;

  public abstract void ProcessTxn();

  public void DoResponse() {
    mvRoutinContext.response().putHeader("content-type", "application/json; charset=utf-8").end(Json.encode(mvResultBean));
  }
  
}
