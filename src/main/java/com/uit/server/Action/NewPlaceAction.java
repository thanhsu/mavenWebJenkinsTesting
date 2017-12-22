package com.uit.server.Action;

import com.uit.server.bean.NewPlaceRequestBean;
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
    this.mvRequestBean = lvNewPlaceRequestBean;
  }

  @Override
  public void ProcessTxn() {
    NewPlaceRequestBean lvNewPlaceRequestBean = (NewPlaceRequestBean) this.mvRequestBean;
    if (lvNewPlaceRequestBean.getIDGroupPlace() == 0) {
      
    }
    if (lvNewPlaceRequestBean.getIDTypePlace() == 0) {
      
    }



  }

}
