package io.vertx.demo.utils;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.Set;

public class WTradeRequest implements IDefaultRequest {
    private String mvAction = null;
    private RoutingContext mvRouteCtx = null;
    private String mvImageID = null;
    
    private JsonObject mvParams = null;

    public WTradeRequest(String pvAction, JsonObject pvParams, RoutingContext pvRouteCtx, String pvClientID) {
        this.setMvAction(pvAction);
        
        this.setMvParams(pvParams);
        this.setMvRouteCtx(pvRouteCtx);
        this.setMvClientID(pvClientID);
    }

    public boolean validate() {
        if (this.mvImageID == null || this.mvAction == null || this.mvParams == null) {
            return false;
        }
        return true;
    }

    public String getMvClientID() {
        return mvImageID;
    }

    public void setMvClientID(String mvClientID) {
        this.mvImageID = mvClientID;
    }

  

    public JsonObject getMvParams() {
        return mvParams;
    }

    public void setMvParams(JsonObject mvParams) {
        this.mvParams = mvParams;
    }

    public RoutingContext getMvRouteCtx() {
        return mvRouteCtx;
    }

    public void setMvRouteCtx(RoutingContext mvRouteCtx) {
        this.mvRouteCtx = mvRouteCtx;
    }

    public String getMvAction() {
        return mvAction;
    }

    public void setMvAction(String mvAction) {
        this.mvAction = mvAction;
    }

    public String getParameter(String pvParamName) {
        return this.mvParams.getString(pvParamName);
    }

    public WTradeResponse getReponse() {
        return new WTradeResponse(mvRouteCtx, mvImageID);
    }

    public String printContent() {
       return String.format("\n +Action: %s\n +Params: %s\n +mvImageID: %s",mvAction, mvParams.toString(), mvImageID);
    }
}
