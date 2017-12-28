package com.uit.server.Action;

import com.uit.server.BLM.RegisterBLM;
import com.uit.server.BLM.UserInfoBLM;
import com.uit.server.bean.ResultNonDataBean;
import com.uit.server.bean.UserBean;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

public class RegisterAction extends BaseAction {
  UserBean userBean;
  RegisterBLM mvRegisterBLM;
  
  @Override
  public void ParseRequestBean() {
    userBean = new UserBean();
    JsonObject json = this.mvRoutinContext.getBodyAsJson();
    userBean.setMvEmail(json.getString(userBean.EMAIL));
    userBean.setMvFirstName(json.getString(userBean.FIRSTNAME));
    userBean.setMvLastName(json.getString(userBean.LASTNAME));
    userBean.setMvUsername(json.getString(userBean.USERNAME));
    userBean.setMvPassword(json.getString(userBean.PASSWORD));
    userBean.setMvYearBorn(json.getString(userBean.YEARBORN));
    userBean.setMvPhoneNumber(json.getString(userBean.PHONENUMBER));
  }

  @Override
  public void ProcessTxn() {
    ParseRequestBean();
    mvRegisterBLM = new RegisterBLM();
    mvRegisterBLM.setUserBean(userBean);
    mvRegisterBLM.DoDao();
    if(mvRegisterBLM.result>0) {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(new ResultNonDataBean(1, "Thành Công", "OK")));
    }else {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8").end(Json.encodePrettily(new ResultNonDataBean(0, "Lỗi", "Try Again")));
    }
  }
  
  public void checkUsername(String username) {
    mvRegisterBLM = new RegisterBLM();
    this.mvRoutinContext.response().end(mvRegisterBLM.checkUsername(username));
  }
  
}
