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
import com.uit.server.bean.CommentBean;

public class CommentDao extends BaseDao {
  Connection mvconn;
  PreparedStatement mvPreparedStatement;

  public List AllCommentPlace(int idPlace) {
    List Result = new Vector();
    String strSql =
        "SELECT DISTINCT PC.ID , PC.VALUE AS DETAILCOMMENT, PC.DATECREATE AS DATECOMMENT, PC.STATE ,IM.IDIMAGE,US.IDUSER ,US.FIRSTNAME, US.LASTNAME\r\n"
            + "\r\n"
            + "FROM PLACECOMMENT PC  INNER JOIN PLACECOMMENT_IMAGE IM ON (IM.IDPLACECOMMENT = PC.ID) INNER JOIN SOUSERINFO US ON (PC.IDUSER = US.IDUSER) \r\n"
            + " WHERE PC.IDPLACE = ?";

    try {
      mvconn = BASEConnection();
      mvPreparedStatement = mvconn.prepareStatement(strSql);
      mvPreparedStatement.setInt(1, idPlace);

      ResultSet mvResultSet = mvPreparedStatement.executeQuery();
      if (mvResultSet != null) {
        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();

          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("DETAILCOMMENT", mvResultSet.getString("DETAILCOMMENT"));
          lvModel.put("DATECOMMENT", mvResultSet.getDate("DATECOMMENT"));
          lvModel.put("STATE", mvResultSet.getString("STATE"));
          lvModel.put("IDIMAGE", mvResultSet.getInt("IDIMAGE"));
          lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));
          lvModel.put("FIRSTNAME", mvResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", mvResultSet.getString("LASTNAME"));

          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.closeConnection(mvconn);
      this.closeStatement(mvPreparedStatement);
    }
    return null;
  }

  public boolean CreateCommentPlace(int idUser, String cmt, int IdImage, int idPlace) {
    CommentBean[] Result;
    String strSql = "INSERT INTO `placecomment`( `IDUSER`, `VALUE`, `STATE`, `IDPLACE`) VALUES (?,?,'A',?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);

      mvPreparedStatement.setInt(1, idUser);
      mvPreparedStatement.setString(2, cmt);
      mvPreparedStatement.setInt(3, idPlace);

      if (mvPreparedStatement.executeUpdate() > 0) {
        try (ResultSet generatedKeys = mvPreparedStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            int idPlacecomment = generatedKeys.getInt(1);
            if (IdImage > 0) {
              strSql = "INSERT INTO `placecomment_image`" + "(`IDPLACECOMMENT`, `IDIMAGE`) VALUES (?,?)";

              PreparedStatement lvPreparedStatement = BASEConnection().prepareStatement(strSql);
              lvPreparedStatement.setInt(1, idPlacecomment);
              lvPreparedStatement.setInt(2, IdImage);
              lvPreparedStatement.executeUpdate();
            }
          }
        }
        return true;
      }
    } catch (SQLException e) {

    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return false;

  }

  public boolean CreateCommentPost(int idUser, int idpost, String detail) {
    String strSql = "INSERT " + "INTO `commentpost`( `IDUSER`, `IDPOST`, `DETAIL`) " + "VALUES (?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setInt(1, idUser);
      mvPreparedStatement.setInt(2, idpost);
      mvPreparedStatement.setString(3, detail);
      if (mvPreparedStatement.executeUpdate() > 0) {
        return true;
      }
    } catch (SQLException e) {

    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return false;
  }
  
  public boolean CreateCommentReviewPlace(int idReviewPlace, int idUser, String Detail, int idImage) {
    String strSql = "IINSERT INTO "
        + "`usercomment`( `IDUSER`, `VALUE`, `STATE`,  `IDREVIEW`, `IDIMAGE`) "
        + "VALUES (?,?,?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setInt(1, idUser);
      mvPreparedStatement.setString(2, Detail);
      mvPreparedStatement.setString(3, "A");
      mvPreparedStatement.setInt(4, idReviewPlace);
      mvPreparedStatement.setInt(5, idImage);
      if (mvPreparedStatement.executeUpdate() > 0) {
        return true;
      }
    } catch (SQLException e) {

    } finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return false;
  }
  
}
