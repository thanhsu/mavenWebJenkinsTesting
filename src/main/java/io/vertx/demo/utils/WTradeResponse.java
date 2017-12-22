package io.vertx.demo.utils;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Cookie;
import io.vertx.ext.web.RoutingContext;

import java.util.HashSet;
import java.util.Set;

public class WTradeResponse implements IDefaultResponse {
    private RoutingContext mvRouteCtx;
   
    private JsonObject mvResJson = null;
    private String mvClientID = null;

    public WTradeResponse(RoutingContext mvRouteCtx, String mvClientID) {
        this.mvRouteCtx = mvRouteCtx;
        this.mvClientID = mvClientID;
        
    }

    @Override
    public boolean validate() {
        return mvResJson != null && mvRouteCtx != null;
    }

    @Override
    public void send() {
        if (validate()) {
            //Add cookie to response message
           
            //Send ResBean as Json to user
            HttpServerResponse res = mvRouteCtx.response();
            res.end(Json.encodePrettily(mvResJson));

            WTradeLogger.print(String.format("WTradeResponse | %s", mvClientID), String.format("Response: %s", mvResJson.toString()));
        }else {
            WTradeLogger.print(String.format("WTradeResponse | %s", mvClientID), "Null JSON");
        }
    }

    public RoutingContext getMvRouteCtx() {
        return mvRouteCtx;
    }

    public void setMvRouteCtx(RoutingContext mvRouteCtx) {
        this.mvRouteCtx = mvRouteCtx;
    }

   

    public JsonObject getMvResJson() {
        return mvResJson;
    }

    public void setMvResJson(JsonObject mvResJson) {
        this.mvResJson = mvResJson;
    }

   
}
