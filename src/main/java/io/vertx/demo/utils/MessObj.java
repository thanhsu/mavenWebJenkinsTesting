package io.vertx.demo.utils;

import io.vertx.ext.web.RoutingContext;

public class MessObj {
    private String mess;
    private String key;
    private String value;
    private RoutingContext routingContext;

    public RoutingContext getRoutingContext() {
      return routingContext;
    }

    public void setRoutingContext(RoutingContext routingContext) {
      this.routingContext = routingContext;
    }

    public MessObj(String mess, String receiver, String sender) {
        this.mess = mess;
        this.key = receiver;
        this.value = sender;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }


    public void setReceiver(String receiver) {
        this.key = receiver;
    }

    public String getValue() {
        return value;
    }

    public void setSender(String sender) {
        this.value = sender;
    }

	public String getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
}
