package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TypeFeelDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreparedStatement;

  public List AllFeel() {
    List Result = new Vector();
    String strSql = "SELECT DISTINCT FL.ID, FL.NAME, FL.DESCRIPTION FROM FELLING FL";

    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet resultSet = mvPreparedStatement.executeQuery();
      if(resultSet!=null) {
        while(resultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDFEEL", resultSet.getInt("ID"));
          lvModel.put("NAME", resultSet.getString("NAME"));
          lvModel.put("DESCRIPTION",resultSet.getString("DESCRIPTION"));
          Result.add(lvModel);
        }
        return Result;
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }
}
