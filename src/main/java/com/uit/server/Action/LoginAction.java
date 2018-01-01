package com.uit.server.Action;

import com.uit.server.BLM.loginBLM;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.UserBean;

public class LoginAction extends BaseAction {
  String  mvUsername ;
  String mvPassword ;
  String mvToken ;
  
  public LoginAction() {
    super();
    
  }


  @Override
  public void ProcessTxn() {
    mvUsername = this.mvRoutinContext.getBodyAsJson().getString("UserName");
    mvPassword = this.mvRoutinContext.getBodyAsJson().getString("Password");
    mvToken = "876876786";
    
    loginBLM mvBLM = new loginBLM(mvUsername, mvPassword);
      mvBLM.DoDao();

    if (mvBLM.getResult() > 0) {
      this.mvResultBean.setMvCode(1);
      this.mvResultBean.setMvMessage("LOGIN SUCCESS");
      UserBean[] lst = new UserBean[1];
      lst[0] = new UserBean();
      lst[0].setMvUserID(mvBLM.getResult());
      lst[0].setMvPassword("***********");
      this.mvResultBean.setMvData(lst);
      //SessionCenter.getInstance().RegisterSession(lst[0].getMvUsername(), this.mvRoutinContext.session().id());
      this.DoResponse();
    } else {
      this.mvResultBean.setMvCode(0);
      this.mvResultBean.setMvMessage("LOGIN FAIL TRY AGAIN");
      this.DoResponse();
    }

  }


  @Override
  public void ParseRequestBean() {
  

  }
  


}
