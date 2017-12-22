package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class CommentDao extends BaseDao {
  Connection mvconn;
  PreparedStatement mvPreparedStatement;
  public List AllCommentPlace(int idPlace) {
    List Result = new Vector();
    String strSql = "SELECT DISTINCT PC.ID , PC.VALUE AS DETAILCOMMENT, PC.DATECREATE AS DATECOMMENT, PC.STATE ,IM.IDIMAGE,US.IDUSER ,US.FIRSTNAME, US.LASTNAME\r\n" + 
        "\r\n" + 
        "FROM PLACECOMMENT PC  INNER JOIN PLACECOMMENT_IMAGE IM ON (IM.IDPLACECOMMENT = PC.ID) INNER JOIN SOUSERINFO US ON (PC.IDUSER = US.IDUSER) \r\n" + 
        " WHERE PC.IDPLACE = ?";
    
    try {
      mvconn = BASEConnection();
      mvPreparedStatement = mvconn.prepareStatement(strSql);
      mvPreparedStatement.setInt(1, idPlace);
      
      ResultSet mvResultSet = mvPreparedStatement.executeQuery();
      if(mvResultSet!= null) {
        while(mvResultSet.next()) {
          HashMap lvModel = new HashMap();
          
          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("DETAILCOMMENT", mvResultSet.getString("DETAILCOMMENT"));
          lvModel.put("DATECOMMENT",mvResultSet.getDate("DATECOMMENT"));
          lvModel.put("STATE", mvResultSet.getString("STATE"));
          lvModel.put("IDIMAGE",mvResultSet.getInt("IDIMAGE"));
          lvModel.put("IDUSER",mvResultSet.getInt("IDUSER"));
          lvModel.put("FIRSTNAME",mvResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", mvResultSet.getString("LASTNAME"));
          
          Result.add(lvModel);
        }
        return Result;
      }
      
    }catch(SQLException e) {
      e.printStackTrace();
    }
    finally {
      
    }
    return null;
  }
  
  //public List AllSubComment(int CommentId) {}
}
