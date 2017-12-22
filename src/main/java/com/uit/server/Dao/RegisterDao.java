package com.uit.server.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.uit.server.bean.UserBean;

public class RegisterDao extends BaseDao {
  public boolean checkUsername(String Username) {
    String strSql = "SELECT COUNT( *) AS TOTAL FROM SOUSERRIGISTER SO WHERE SO.USERNAME = ?";
    try {
      this.mvConn = BASEConnection();
      this.mvPreparedStatement = mvConn.prepareStatement(strSql);
      this.mvPreparedStatement.setString(1, Username);
      
      ResultSet resultSet = this.mvPreparedStatement.executeQuery();
      while (resultSet.next()) {
        if(resultSet.getInt("TOTAL")>0) {
          return false;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return true;
  }
  
  public int CreateUserRigister(String userName, String password) {
    String strSql = "INSERT INTO SOUSERRIGISTER('USERNAME','PASSWORD') VALUES(?,?)";
    try {
     this.mvConn =  BASEConnection();
     this.mvPreparedStatement = mvConn.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS );
     this.mvPreparedStatement.setString(1, userName);
     this.mvPreparedStatement.setString(2, password);
     
     if(mvPreparedStatement.executeUpdate()>0) {
       try(ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()){
         if(generatedKeys.next()) {
           return generatedKeys.getInt(1);
         }else {
           throw new SQLException();
         }
       }
     }
     
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return -1;
  }
  public int RegisterUserInfo(int Iduser, String firstname, String lastname, String born, String email, String PhoneNumber) {
    String strSql = "INSERT INTO `souserinfo`(`FIRSTNAME`, `LASTNAME`,"
        + " `IDUSER`, `STATUS`, `EMAIL`, `PHONENUMBER`) VALUES (?,?,?,?,?,?)";
    try {
      this.mvConn = BASEConnection();
      this.mvPreparedStatement = this.mvConn.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
      this.mvPreparedStatement.setString(1, firstname);
      this.mvPreparedStatement.setString(2,lastname);
      this.mvPreparedStatement.setInt(3, Iduser);
      this.mvPreparedStatement.setString(4, "A");
      this.mvPreparedStatement.setString(5, email);
      this.mvPreparedStatement.setString(6, PhoneNumber);
      if(mvPreparedStatement.executeUpdate()>0) {
        try(ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()){
          if(generatedKeys.next()) {
            return generatedKeys.getInt(1);
          }else {
            throw new SQLException();
          }
        }
      }
      
    }catch(SQLException e) {
      e.printStackTrace();
   
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return -1;
  }
  
  public int updateUserAvatar(int Iduser, int idAvatar) {
    UserBean Result =new UserBean();
    String strSql = "UPDATE SOUSERINFO SET IDAVATAR = ? WHERE IDUSER=?";
    try {
      this.mvConn = BASEConnection();
      this.mvPreparedStatement = this.mvConn.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
      
      this.mvPreparedStatement.setInt(1, idAvatar);
      this.mvPreparedStatement.setInt(2, Iduser);
      return this.mvPreparedStatement.executeUpdate();
      
    }catch(SQLException e) {
      e.printStackTrace();
   
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return -1;
  }
}
