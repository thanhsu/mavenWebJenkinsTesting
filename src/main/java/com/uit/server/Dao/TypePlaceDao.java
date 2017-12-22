package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TypePlaceDao extends BaseDao {

  Connection mvConn;
  PreparedStatement mvPreparedStatement;
  public int NewTypePlace(String NameTypePlace, String Description, String KeyWord) {
   
    String strSql = "INSERT INTO `groupplace`( `NAMEGR`, `DESCRIPTION`, `KEYWORK`) VALUES (?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setString(1, NameTypePlace);
      mvPreparedStatement.setString(2, Description);
      mvPreparedStatement.setString(3, KeyWord);
      
      if (mvPreparedStatement.executeUpdate() > 0) {
        try (ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
          } else {
            throw new SQLException("Create new Type Place Fail");
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return 0;
  }
  
  public List AllTypePlace() {
    List Result = new Vector();
    
    String strSql = "SELECT `ID`, "
        + "`NAMEGR`,"
        + " `DESCRIPTION`,"
        + " `KEYWORD`"
        + " FROM `groupplace` WHERE 1";
        try {
          mvConn = BASEConnection();
          mvPreparedStatement =mvConn.prepareStatement(strSql);
          
          ResultSet mvResultSet = mvPreparedStatement.executeQuery();
          if(mvResultSet!= null) {
            while(mvResultSet.next()) {
              HashMap lvModel = new HashMap();
              lvModel.put("ID", mvResultSet.getInt("ID"));
              lvModel.put("NAMETYPEPLACE", mvResultSet.getString("NAMEGR"));
              lvModel.put("DESCRIPTION",mvResultSet.getString("DESCRIPTION"));
              lvModel.put("KEYWORD",mvResultSet.getString("KEYWORD"));
              Result.add(lvModel);
            }
            return Result;
          }
        }catch(SQLException e) {
          e.printStackTrace();
        }finally{
          this.closeConnection(mvConn);
          this.closeStatement(mvPreparedStatement);
        }
    return null;
  }



}
