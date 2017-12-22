package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TypeLocationDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreparedStatement;
  public int NewTypeLocation(String NameTypeLocation, String Description, String KeyWord) {
   
    String strSql = "INSERT INTO `grouplocation`( `NAMEGR`, `DECRIPSION`, `KEYWORD`) VALUES (?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setString(1, NameTypeLocation);
      mvPreparedStatement.setString(2, Description);
      mvPreparedStatement.setString(3, KeyWord);
      
      if (mvPreparedStatement.executeUpdate() > 0) {
        try (ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
          } else {
            throw new SQLException("Create new Type Location Fail");
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
  
  public List AllTypeLocation() {
    List Result = new Vector();
    
    String strSql = "SELECT DISTINCT GL.ID,"
        + " GL.NAMEGR AS NAMETYPELOCATION,"
        + " GL.DESCRIPTION,"
        + " GL.KEYWORD "
        + "FROM GROUPLOCATION GL WHERE 1";
        try {
          mvConn = BASEConnection();
          mvPreparedStatement =mvConn.prepareStatement(strSql);
          
          ResultSet mvResultSet = mvPreparedStatement.executeQuery();
          if(mvResultSet!= null) {
            while(mvResultSet.next()) {
              HashMap lvModel = new HashMap();
              
              lvModel.put("ID", mvResultSet.getInt("ID"));
              lvModel.put("NAMETYPELOCATION", mvResultSet.getString("NAMETYPELOCATION"));
              lvModel.put("DESCRIPTION",mvResultSet.getString("DESCRIPTION"));
              lvModel.put("KEYWORD",mvResultSet.getString("KEYWORD"));
              Result.add(lvModel);
            }
            return Result;
          }
        }catch(SQLException e) {
          
        }finally{
          this.closeConnection(mvConn);
          this.closeStatement(mvPreparedStatement);
        }
    return null;
  }

}
