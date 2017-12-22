package com.uit.server.Action;

import com.uit.server.BLM.PlaceBLM;
import com.uit.server.bean.PlaceBean;
import com.uit.server.bean.PlaceRequestBean;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class SearchPlaceAction extends BaseAction {

  PlaceBLM mvPlaceBlm;

  public SearchPlaceAction() {
    super();
    
  }


  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub

  }

  @Override
  public void ProcessTxn() {
    String mvPlaceName;
    String mvSessionID;
    int mvIDTypePlace;
    float mvLocationX;
    float mvLocationY;

    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    mvPlaceName = json.getString("KeyWord") != null ? json.getString("KeyWord") : "";
    mvSessionID = json.getString("SessionID");
    mvIDTypePlace = json.getInteger("IDTypePlace") != null ? json.getInteger("IDTypePlace") : 0;
    mvLocationX = json.getFloat("LocationX") != null ? json.getFloat("LocationX") : 0;
    mvLocationY = json.getFloat("LocationY") != null ? json.getFloat("LocationY") : 0;

    PlaceRequestBean request = new PlaceRequestBean();
    request.setIDTypePlace(mvIDTypePlace);
    request.setLocationX(mvLocationX);
    request.setLocationY(mvLocationY);
    request.setNamePlace(mvPlaceName);
    request.setSessionID(mvSessionID);
    mvPlaceBlm = new PlaceBLM(request);
    PlaceBean[] result = mvPlaceBlm.getListPlace(request);
    ResultBean ReturnValue = new ResultBean();
    if (result == null) {
      ReturnValue = new ResultBean(0, "Không tìm thấy dữ liệu được yêu cầu. Vui lòng thử lại với những dữ liệu khác", null);
    } else {
      ReturnValue = new ResultBean(0, "Những địa điểm phù hợp", result);
    }

    this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(ReturnValue));
  }

}
