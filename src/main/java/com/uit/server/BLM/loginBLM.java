package com.uit.server.BLM;

import com.uit.server.Dao.loginDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.UserBean;

public class loginBLM extends BaseBLM {
  int UserID;
  String username;
  String password;

  public loginBLM(String user, String pass) {
    this.username = user;
    this.password = pass;

  }

  @Override
  public void DoDao() {
    loginDao lvLoginDao = new loginDao();

    UserID = lvLoginDao.checkLogin(username, password);
  }

  public int getResult() {
    return this.UserID;
  }

}
