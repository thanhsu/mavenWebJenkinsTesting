package com.uit.server.BLM;

import com.uit.server.Dao.loginDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.UserBean;

public class loginBLM extends BaseBLM {
  boolean mvLoginStatus = false;
  public loginBLM(BaseRequestBean pvBaseRequestBean) {
    super(pvBaseRequestBean);
    
  } 
  @Override
  public void DoDao() {
    loginDao lvLoginDao = new loginDao();
    UserBean user = (UserBean)mvBaseRequestBean;
    mvLoginStatus = lvLoginDao.checkLogin(user.getMvUsername(), user.getMvPassword());
  }
  
  public boolean getResult() {
    return this.mvLoginStatus;
  }
  
}
