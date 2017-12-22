package com.uit.server.bean;

import io.vertx.ext.web.RoutingContext;

public abstract class BaseRequestBean {
  RoutingContext mvRoutingContext;
  
  public BaseRequestBean(RoutingContext pvRoutingContext) {
    this.mvRoutingContext = pvRoutingContext;
    
  }

  public BaseRequestBean() {
    // TODO Auto-generated constructor stub
  }
  
}
