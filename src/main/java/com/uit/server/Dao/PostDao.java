package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class PostDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreparedStatement;
  
  
  public int PostStatus(int iduser, String detail, int idfeel) {
    String strSql = "INSERT INTO STATUS(IDUSER,DETAIL, IDFELL) VALUES (?, ?, ?) ";
    try {
      mvConn =  BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setInt(1, iduser);
      mvPreparedStatement.setString(2, detail);
      mvPreparedStatement.setInt(3, idfeel);
      
      if (mvPreparedStatement.executeUpdate() > 0)
        try (ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            int result = generatedKeys.getInt(1);
            return result;
          } else {
            throw new SQLException("Creating imagepic failed, no ID obtained.");
          }
        }
      return -1;
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    
    return 0;
  }
  
  public boolean MapImageToStatus(int idStatus, int idImage) {
    String strSql = "INSERT INTO STATUS_IMAGE(IDSTATUS,IDIMAGE) VALUES (?, ?) ";
    try {
      mvConn =  BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql,Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setInt(1, idStatus);
      mvPreparedStatement.setInt(2, idImage);
      
      if (mvPreparedStatement.executeUpdate() > 0)
        try (ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            return true;
          } else {
            throw new SQLException("Creating imagepic failed, no ID obtained.");
          }
        }
      return false;
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    
    return false;
  }
  
  public List AllPostOfUser(int userID) {
    List Result =  new Vector();
    
    String strSql = "SELECT ID , IDUSER, DETAIL, DATECREATE, IDFELL  FROM STATUS WHERE IDUSER=? ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if(result!=null) {
        while(result.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("ID", result.getInt("ID"));
          lvModel.put("DETAIL",result.getString("DETAIL"));
          lvModel.put("IDFEEL",result.getInt("IDFELL"));
          lvModel.put("DATECREATE",result.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }
      
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }
  
  public List ALLPostUserFollow(int IDUser) {

    List Result =  new Vector();
    
    String strSql = "SELECT STT.ID AS IDSTATUS,"
        + " STT.IDUSER , "
        + "US.FIRSTNAME, "
        + "US.LASTNAME,"
        + " STT.DATECREATE,"
        + " STT.IDFELL "
        + "FROM STATUS STT INNER JOIN SOUSERINFO US ON (STT.IDUSER = US.IDUSER) "
        + "WHERE STT.IDUSER IN(SELECT UF.BEIDUSER FROM USERFOLLOW UF WHERE UF.IDUSER = ? ) ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if(result!=null) {
        while(result.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDSTATUS", result.getInt("IDSTATUS"));
          lvModel.put("IDUSER",result.getInt("IDUSER"));
          lvModel.put("FIRSTNAME",result.getString("FIRSTNAME"));
          lvModel.put("LASTNAME",result.getString("LASTNAME"));
          lvModel.put("DETAIL",result.getString("DETAIL"));
          lvModel.put("IDFEEL",result.getInt("IDFELL"));
          lvModel.put("DATECREATE",result.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }
      
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }
  
  public List ListAllImagePost(int idStatus) {
    List Result = new Vector();
    String strSql = "SELECT STI.ID,"
        + " STI.IDSTATUS,"
        + " STI.IDIMAGE "
        + "FROM STATUS_IMAGE STI"
        + " WHERE STI.IDSTATUS = ?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if(result!=null) {
        while(result.next()) {
         HashMap lvModel = new HashMap();
         lvModel.put("IDIMAGE", result.getInt("IDIMAGE"));
         Result.add(lvModel);
        }
        return Result;
      }
      
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
    
  }
}
