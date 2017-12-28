package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import com.uit.server.Action.BaseAction;

public class PostDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreparedStatement;


  public int PostStatus(int iduser, String detail, int idfeel) {
    String strSql = "INSERT INTO STATUS(IDUSER,DETAIL, IDFELL) VALUES (?, ?, ?) ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }

    return 0;
  }

  public boolean MapImageToStatus(int idStatus, int idImage) {
    String strSql = "INSERT INTO STATUS_IMAGE(IDSTATUS,IDIMAGE) VALUES (?, ?) ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }

    return false;
  }

  public List AllPostOfUser(int userID) {
    List Result = new Vector();

    String strSql = "SELECT DISTINCT ID , IDUSER, DETAIL, DATECREATE, IDFELL " + " FROM STATUS " + "WHERE IDUSER=? " + "GROUP BY IDUSER"
        + "ORDER BY DATECREATE ASC ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if (result != null) {
        while (result.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("ID", result.getInt("ID"));
          lvModel.put("DETAIL", result.getString("DETAIL"));
          lvModel.put("IDFEEL", result.getInt("IDFELL"));
          lvModel.put("DATECREATE", result.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }

  public List ALLPostUserFollow(int IDUser) {

    List Result = new Vector();

    String strSql = "SELECT STT.ID AS IDSTATUS," + " STT.IDUSER , " + "US.FIRSTNAME, " + "US.LASTNAME," + " STT.DATECREATE,"
        + " STT.IDFELL " + "FROM STATUS STT INNER JOIN SOUSERINFO US ON (STT.IDUSER = US.IDUSER) "
        + "WHERE STT.IDUSER IN(SELECT UF.BEIDUSER FROM USERFOLLOW UF WHERE UF.IDUSER = ? )" + " GROUP BY STT.ID "
        + " ORDER BY STT.DATECREATE ASC ";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if (result != null) {
        while (result.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDSTATUS", result.getInt("IDSTATUS"));
          lvModel.put("IDUSER", result.getInt("IDUSER"));
          lvModel.put("FIRSTNAME", result.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", result.getString("LASTNAME"));
          lvModel.put("DETAIL", result.getString("DETAIL"));
          lvModel.put("IDFEEL", result.getInt("IDFELL"));
          lvModel.put("DATECREATE", result.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }

  public List ListAllImagePost(int idStatus) {
    List Result = new Vector();
    String strSql = "SELECT STI.ID," + " STI.IDSTATUS," + " STI.IDIMAGE " + "FROM STATUS_IMAGE STI" + " WHERE STI.IDSTATUS = ?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      ResultSet result = mvPreparedStatement.executeQuery();
      if (result != null) {
        while (result.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDIMAGE", result.getInt("IDIMAGE"));
          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;

  }

  public List AllPostComment(int idPost) {
    List Result = new Vector();
    String strSql = "SELECT `ID`, `IDUSER`, `IDPOST`, `DETAIL`, `DATECREATE` FROM `commentpost` WHERE ID=?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      mvPreparedStatement.setInt(1, idPost);
      ResultSet resultSet = mvPreparedStatement.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("ID", resultSet.getInt("ID"));
          lvModel.put("IDUSER", resultSet.getInt("IDUSER"));
          lvModel.put("IDPOST", resultSet.getInt("IDPOST"));
          lvModel.put("DATECREATE", resultSet.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }
  
  public List AllLikePost(int idpost) {
    List Result = new Vector();
    String strSql = "SELECT `ID`, `IDSTATUS`, `IDUSER` FROM `status_like` WHERE IDSTATUS=?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      mvPreparedStatement.setInt(1, idpost);
      ResultSet resultSet = mvPreparedStatement.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("ID", resultSet.getInt("ID"));
          lvModel.put("IDUSER", resultSet.getInt("IDUSER"));
          lvModel.put("IDSTATUS", resultSet.getInt("IDSTATUS"));
    
          Result.add(lvModel);
        }
        return Result;
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }
  
  public boolean DolikePost(int idstatus, int iduser) {
    String strSql = "SELECT COUNT(*) AS TOTAL FROM `status_like` WHERE IDSTATUS = ? AND IDUSER =?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql);
      mvPreparedStatement.setInt(1, idstatus);
      mvPreparedStatement.setInt(2, iduser);
      
      ResultSet resultSet = mvPreparedStatement.executeQuery();
      if (resultSet != null) {
        while (resultSet.next()) {
          if(resultSet.getInt("TOTAL")>0) {
            strSql = "DELETE FROM STATUS_LIKE WHERE IDSTATUS ="+idstatus +" AND IDUSER = "+iduser;
            PreparedStatement lvPreparedStatement = BASEConnection().prepareStatement(strSql);
            lvPreparedStatement.executeUpdate();
          }else {
            strSql = "INSERT INTO STATUS_LIKE(IDUSER, IDSTATUS) VALUES(?,?)";
            PreparedStatement lvPreparedStatement = BASEConnection().prepareStatement(strSql);
            lvPreparedStatement.setInt(1, iduser);
            lvPreparedStatement.setInt(2, idstatus);
            lvPreparedStatement.executeUpdate();
            
          }
               
        }
        return true;
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return false;
  }
 
  
}
