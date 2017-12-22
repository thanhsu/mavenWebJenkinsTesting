package com.uit.server.Action;

import com.uit.server.BLM.loginBLM;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.UserBean;

public class LoginAction extends BaseAction {

  public LoginAction() {
    super();
    
  }


  @Override
  public void ProcessTxn() {
    this.mvRequestBean = new UserBean(this.mvRoutinContext).getBodyLoginRequest();
    loginBLM mvBLM = new loginBLM(this.mvRequestBean);
    mvBLM.DoDao();

    if (mvBLM.getResult() == true) {
      this.mvResultBean.setMvCode(1);
      this.mvResultBean.setMvMessage("LOGIN SUCCESS");
      UserBean[] lst = new UserBean[1];
      lst[0] = (UserBean)this.mvRequestBean;
      lst[0].setMvToken(this.mvRoutinContext.session().id());
      lst[0].setMvPassword("***********");
      this.mvResultBean.setMvData(lst);
      SessionCenter.getInstance().RegisterSession(lst[0].getMvUsername(), this.mvRoutinContext.session().id());
      this.DoResponse();
    } else {
      this.mvResultBean.setMvCode(0);
      this.mvResultBean.setMvMessage("LOGIN FAIL TRY AGAIN");
      this.DoResponse();
    }

  }


  @Override
  public void ParseRequestBean() {
    mvRequestBean = new UserBean(this.mvRoutinContext).getBodyLoginRequest();

  }
  


}
