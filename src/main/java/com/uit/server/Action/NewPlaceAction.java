package com.uit.server.Action;

import com.uit.server.BLM.PlaceBLM;
import com.uit.server.bean.NewPlaceRequestBean;
import com.uit.server.bean.ResultBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class NewPlaceAction extends BaseAction {

  public NewPlaceAction(RoutingContext rtContext) {
    this.setMvRoutinContext(rtContext);
  }

  @Override
  public void ParseRequestBean() {
    NewPlaceRequestBean lvNewPlaceRequestBean = new NewPlaceRequestBean();
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    lvNewPlaceRequestBean.setNamePlace(json.getString("NamePlace"));
    lvNewPlaceRequestBean.setLocationX(json.getFloat("LocationX"));
    lvNewPlaceRequestBean.setLocationY(json.getFloat("LocationY"));
    lvNewPlaceRequestBean.setIDGroupPlace(json.getInteger("IDGroupLocation"));
    lvNewPlaceRequestBean.setNameGroupPlace(json.getString("NameGroupLocation"));
    lvNewPlaceRequestBean.setIDTypePlace(json.getInteger("IDTypePlace"));
    lvNewPlaceRequestBean.setNameTypePlace(json.getString("NameTypePlace"));
    lvNewPlaceRequestBean.setNote(json.getString("Description"));
    lvNewPlaceRequestBean.setPhoneNumber(json.getString("PhoneNumber"));
    lvNewPlaceRequestBean.setEmail(json.getString("Email"));
    this.mvRequestBean = lvNewPlaceRequestBean;
  }

  @Override
  public void ProcessTxn() {
    NewPlaceRequestBean lvNewPlaceRequestBean = (NewPlaceRequestBean) this.mvRequestBean;
    PlaceBLM mvPlaceBLM = new PlaceBLM(lvNewPlaceRequestBean);
    int idlo= mvPlaceBLM.CreateNewLocation(lvNewPlaceRequestBean.getLocationX(), lvNewPlaceRequestBean.getLocationY(),lvNewPlaceRequestBean.getIDTypePlace());
    int idPlace = mvPlaceBLM.CreateNewPlace( idlo,lvNewPlaceRequestBean.getIDGroupPlace(), lvNewPlaceRequestBean.getNamePlace(),lvNewPlaceRequestBean.getNote(), lvNewPlaceRequestBean.getPhoneNumber(), lvNewPlaceRequestBean.getEmail());
    if(idPlace!=0) {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(new ResultBean(1, "Place", mvPlaceBLM.getListPlace(null, idPlace))));
    }
  }

}
