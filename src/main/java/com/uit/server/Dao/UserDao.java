package com.uit.server.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.uit.server.bean.UserBean;

public class UserDao extends BaseDao {
  public UserBean GetUserInfo(int iduser) {
    UserBean Result = new UserBean();
    String strSql = "SELECT SO.ID, SO.IDUSER, SO.IDAVATAR, SO.FIRSTNAME, SO.LASTNAME, SO.EMAIL, SO.PHONENUMBER FROM SOUSERINFO SO"
        + " WHERE SO.IDUSER= ?";
    try {
      mvConn= BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet resultSet = mvPreparedStatement.executeQuery();
      if(resultSet!= null) {
        while(resultSet.next()) {
          Result.setMvUserID(resultSet.getInt("IDUSER"));
          Result.setMvAvartarID(resultSet.getInt("IDAVATAR"));
          Result.setMvFirstName(resultSet.getString("FIRSTNAME"));
          Result.setMvLastName(resultSet.getString("LASTNAME"));
          Result.setMvEmail(resultSet.getString("EMAIL"));
          Result.setMvPhoneNumber(resultSet.getString("PHONENUMBER"));
          
          return Result;
        }
        
      }
      
    }catch(SQLException e) {
      
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    
    return Result;
  }
  
}
