package com.uit.server.BLM;

import com.uit.server.Dao.UserDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.UserBean;

public class UserInfoBLM extends BaseBLM {
  UserBean mvUserBean = new UserBean();
  UserDao mvuserDao; 
  public UserInfoBLM() {}
  public UserInfoBLM(BaseRequestBean pvBaseRequestBean) {
    super(pvBaseRequestBean);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void DoDao() {
    
    
  }
  
  public UserBean Userinfo(int idUser) {
    mvuserDao =new UserDao();
    return mvuserDao.GetUserInfo(idUser);
  }
  

}
