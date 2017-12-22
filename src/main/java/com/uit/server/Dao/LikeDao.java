package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class LikeDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreparedStatement;

  public List AllLikeCommentPlace(int CommentPlaceId) {
    List Result =  new Vector();
    
    String strSql = "SELECT DISTINCT CML.ID, "
        + "CML.IDUSER,"
        + "CML.IDPLACECOMMENT,"
        + " US.FIRSTNAME,"
        + " US.LASTNAME"
        + " FROM PLACECOMMENT_LIKE CML INNER JOIN SOUSERINFO US ON (CML.IDUSER = US.IDUSER) "
        + "WHERE CML.IDPLACECOMMENT=?";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement  = mvConn.prepareStatement(strSql);
      
      ResultSet mvResultSet = mvPreparedStatement.executeQuery();
      if(mvResultSet!=null) {
        while(mvResultSet.next()) {
          HashMap lvModel = new HashMap();
          
          lvModel.put("ID",mvResultSet.getInt("ID"));
          lvModel.put("IDUSER",mvResultSet.getInt("IDUSER"));
          lvModel.put("IDPLACECOMMENT",mvResultSet.getInt("IDPLACECOMMENT"));
          lvModel.put("FIRSTNAME",mvResultSet.getObject("FIRSTNAME").toString());
          lvModel.put("LASTNAME",mvResultSet.getObject("LASTNAME").toString());
          
          Result.add(lvModel);
        }
      return Result;
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
