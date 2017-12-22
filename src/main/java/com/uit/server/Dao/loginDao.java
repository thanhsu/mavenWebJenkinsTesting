package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import com.uit.server.bean.ResultBean;

public class loginDao extends BaseDao {
  static String USERINFOTABLE = "SOUSERINFO";
  static String USERLOGGINTABLE = "SOUSERRIGISTER";

  public int CheckExistUser(String lvUserName) {


    Connection lvConnection = null;
    PreparedStatement lvStatement = null;

    try {
      String lvStrSql = "SELECT COUNT(*) FROM " + USERLOGGINTABLE;

      lvConnection = this.BASEConnection();

      lvStatement = lvConnection.prepareStatement(lvStrSql);

      return lvStatement.executeQuery().getInt(0);
    } catch (SQLException e) {
      return 0;
    } finally {
      this.closeStatement(lvStatement);
      this.closeConnection(lvConnection);
    }
  }

  public boolean checkLogin(String pvUserName, String Password) {
    Connection lvConnection = null;
    PreparedStatement lvStatement = null;
    int i = 0;
    try {
      String lvStrSql = "SELECT COUNT(*) FROM " + USERLOGGINTABLE;

      lvConnection = this.BASEConnection();

      lvStatement = lvConnection.prepareStatement(lvStrSql);

      i = lvStatement.executeQuery().getInt(0);
    } catch (SQLException e) {
      i = 0;
    } finally {
      this.closeStatement(lvStatement);
      this.closeConnection(lvConnection);
    }
    return i > 0 ? true : false;
  }


  public ResultBean createNewUser(String pvUserName, String pvPassword, String pvFirstName, String pvLastName, String pvEmailAddress,
      String pvPhoneNumber, String localPositionX, String localPositionY) {
    ResultBean mvresult;
    if (this.CheckExistUser(pvUserName) > 0) {
      return new ResultBean(0, "Username is existing!", null);
    }

    // do create userLogin
    int idLoginTable = 0;
    Connection lvConnection = null;
    PreparedStatement lvStatement = null;
    try {
      String lvStrSql = "SELECT ID FROM (INSERT INTO " + USERLOGGINTABLE + "(USERNAME,PASSWORD,DATECREATE,STATE) VALUES('" + pvUserName
          + "','" + pvPassword + "',CURRENT_DATE,'A'))";
      lvConnection = this.BASEConnection();
      lvStatement = lvConnection.prepareStatement(lvStrSql);
      idLoginTable = lvStatement.executeQuery().getInt("ID");
      this.closeStatement(lvStatement);

      lvStrSql =
          "SELECT ID FROM (INSERT INTO SOUSERINFO(IDUSER,FIRSTNAME,LASTNAME,PHONENUMBER,EMAIL,LOCATIONX,LOCATIONY,CREATEDATE,STATE) VALUES ("
              + idLoginTable + ",'" + pvFirstName + "','" + pvLastName + "','" + pvPhoneNumber + "','" + pvEmailAddress + "','"
              + localPositionX + "','" + localPositionY + "','CURRENT_DATE','A'))";
      lvStatement = lvConnection.prepareStatement(lvStrSql);

      int i = lvStatement.executeQuery().getInt("ID");
      return new ResultBean(1, "Success register", null);

    } catch (Exception e) {
      return new ResultBean(-1, "Working Exception: " + e.toString(), null);
    } finally {
      this.closeStatement(lvStatement);
      this.closeConnection(lvConnection);
    }
  }

  public ResultBean ChangePassword(String username, String oldpassword, String newpasss) {
    Connection lvConnection = null;
    PreparedStatement lvStatement = null;
    try {
      lvConnection = this.BASEConnection();

      String lvCheckOldLoggin = "SELECT ID AS COUNTLG FROM " + USERLOGGINTABLE + " WHERE USERNAME='" + username + "' AND PASSWORD = '"
          + oldpassword + "' AND STATE='A'";
      lvStatement = lvConnection.prepareStatement(lvCheckOldLoggin);
      int i = lvStatement.executeQuery().getInt("COUNTLG");
      if (i < 1) {
        return new ResultBean(0, "Account Not Found", null);
      }
      this.closeStatement(lvStatement);
      String lvUpdatePassword =
          "SELECT USERNAME FROM ( UPDATE SOUSERRIGISTER SET PASSWORD = '" + newpasss + "' WHERE ID=" + i + " AND 1=1)";
      lvStatement = lvConnection.prepareStatement(lvUpdatePassword);
      return new ResultBean(1, lvStatement.executeQuery().getString("USERNAME"), null);

    } catch (Exception e) {
      return new ResultBean(-1, "Working on Exception: " + e.toString(), null);
    }
  }

  public List getUserInfo(String username) {
    List lvReturnVector = new Vector();
    Connection lvConnection = null;
    PreparedStatement lvStatement = null;
    try {
      lvConnection = this.BASEConnection();
      String lvGetUserInfo =
          "SELECT SUBID,FIRSTNAME,LASTNAME,IDAVATAR,STATUS,EMAIL,PHONENUMBER FROM SOUSERINFO S, SOUSERRIGISTER R WHERE S.IDUSER = R.ID AND R.USERNAME = ?";
      lvStatement = lvConnection.prepareStatement(lvGetUserInfo);
      lvStatement.setString(0, username);
      ResultSet rs = lvStatement.executeQuery();
      try {
        HashMap lvModel = new HashMap();
        lvModel.put("SUBID", rs.getString("SUBID").trim());
        lvModel.put("FIRSTNAME", rs.getString("FIRSTNAME").trim());
        lvModel.put("LASTNAME", rs.getString("LASTNAME").trim());
        lvModel.put("IDAVATAR", rs.getString("IDAVATAR").trim());
        lvModel.put("STATUS", rs.getString("STATUS").trim());
        lvModel.put("EMAIL", rs.getString("EMAIL").trim());
        lvModel.put("PHONENUMBER", rs.getString("PHONENUMBER").trim());
        lvModel.put("BALCF", rs.getString("BALCF").trim());
        lvReturnVector.add(lvModel);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      // TODO: handle exception
    }

    return lvReturnVector;


  }



}
