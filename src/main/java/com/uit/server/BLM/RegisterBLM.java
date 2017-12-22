package com.uit.server.BLM;

import com.uit.server.Dao.RegisterDao;
import com.uit.server.bean.UserBean;
import io.vertx.core.json.JsonObject;

public class RegisterBLM extends BaseBLM {
  private UserBean userBean;
  private RegisterDao mvRigisterDao;
  public void setUserBean(UserBean pu) {
    this.userBean = pu;
  }
  public int result;
  
  @Override
  public void DoDao() {
     mvRigisterDao = new RegisterDao();
     int iduser = mvRigisterDao.CreateUserRigister(userBean.getMvUsername(), userBean.getMvPassword());
     if(iduser!=0) {
       result = mvRigisterDao.RegisterUserInfo(iduser, userBean.getMvFirstName(), userBean.getMvLastName(), userBean.getMvYearBorn(), userBean.getMvEmail(), userBean.getMvPhoneNumber());
     }else {
       result=-1;
     }
  }
  
  public int UpdateAvatar(int idUser, int IdAvatar) {
    mvRigisterDao = new RegisterDao();
    return mvRigisterDao.updateUserAvatar(idUser, IdAvatar);
  }
  
  public String checkUsername(String username) {
    mvRigisterDao = new RegisterDao();
    if( mvRigisterDao.checkUsername(username)) {
      return "TRUE";// đồng ý
    }
    return "FALSE"; // bị trùng
  }
}
