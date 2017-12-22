package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ReviewDao extends BaseDao {
  Connection mvConn;
  PreparedStatement mvPreParedStatement;

  public List AllReviewPlace(int idPlace) {
    List Result = new Vector();

    String strSql = "SELECT DISTINCT PL.ID," + " PL.IDPLACE," + " PL.IDUSER," + "US.FIRSTNAME, " + "US.LASTNAME, "
        + "PL.CAPTION, PL.DESCRIPTION, PL.DATECREATE" + ", PL.IDFELLING, " + "FL.NAME AS FELLNAME"
        + " FROM PLACEREVIEW PL INNER JOIN SOUSERINFO US  ON (PL.IDUSER = US.IDUSER) INNER JOIN FELLING FL ON (PL.IDFELLING = FL.ID)"
        + " WHERE PL.IDPLACE = ?";

    try {
      mvConn = BASEConnection();
      mvPreParedStatement = mvConn.prepareStatement(strSql);
      mvPreParedStatement.setInt(1, idPlace);

      ResultSet mvResultSet = mvPreParedStatement.executeQuery();
      if (mvResultSet != null) {
        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();

          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("IDPLACE", mvResultSet.getInt("IDPLACE"));
          lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));
          lvModel.put("FIRSTNAME", mvResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", mvResultSet.getString("LASTNAME"));
          lvModel.put("CAPTION", mvResultSet.getString("CAPTION"));
          lvModel.put("DESCRIPTION", mvResultSet.getString("DESCRIPTION"));
          lvModel.put("DATECREATE", mvResultSet.getDate("DATECREATE"));
          lvModel.put("FELLNAME", mvResultSet.getString("FELLNAME"));

          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List AllLikeReviewPlace(int idReview) {

    List Result = new Vector();

    String strSql = "SELECT RL.ID, " + 
    "RL.IDPLACEREVIEW," +
        " RL.DATECREATE," +
    "RL.IDUSER " + "FROM PLACEREVIEW_LIKE RL "
        + "WHERE RL.IDPLACEREVIEW = ?";
    try {
      mvConn = BASEConnection();
      mvPreParedStatement = mvConn.prepareStatement(strSql);
      mvPreParedStatement.setInt(1, idReview);

      ResultSet mvResultSet = mvPreParedStatement.executeQuery();
      if (mvResultSet != null) {
        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();

          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("IDPLACEREVIEW", mvResultSet.getInt("IDPLACEREVIEW"));

          lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));

          lvModel.put("DATECREATE", mvResultSet.getDate("DATECREATE"));

          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }

  public List AllCommentReview(int idReview) {
    List Result = new Vector();

    String strSql = "SELECT CMT.ID," + "CMT.IDIMAGE," + " CMT.IDUSER," + "US.FIRSTNAMEM," + "US.LASTNAME, " + "CMT.IDREVIEW,"
        + " CMT.VALUE AS DETAILCOMMENT," + "CMT.DATECREATE " + "FROM USERCOMMENT CMT INNER JOIN SOUSERINFO US ON (US.IDUSER = CMT.IDUSER)"
        + " WHERE CMT.IDREVIEW = ?";

    try {
      mvConn = BASEConnection();
      mvPreParedStatement = mvConn.prepareStatement(strSql);
      mvPreParedStatement.setInt(1, idReview);

      ResultSet mvResultSet = mvPreParedStatement.executeQuery();
      if (mvResultSet != null) {
        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();

          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("IDREVIEW", mvResultSet.getInt("IDREVIEW"));
          lvModel.put("IDIMAGE", mvResultSet.getInt("IDIMAGE"));
          lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));
          lvModel.put("FIRSTNAME", mvResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", mvResultSet.getString("LASTNAME"));
          lvModel.put("DETAILCOMMENT", mvResultSet.getString("DETAILCOMMENT"));
          lvModel.put("DATECREATE", mvResultSet.getDate("DATECREATE"));

          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List AllImageReview(int IDReviewComment) {
    List Result = new Vector();

    String strSql = "SELECT DISTINCT IMG.IDIMAGE, IMG.DATECREATE " + "FROM PLACEREVIEW_IMAGE IMG" + " WHERE IMG.IDPLACEREVIEW = ?";
    try {
      mvConn = BASEConnection();
      mvPreParedStatement = mvConn.prepareStatement(strSql);

      mvPreParedStatement.setInt(1, IDReviewComment);

      ResultSet ResultSet = mvPreParedStatement.executeQuery();
      if (ResultSet != null) {
        while (ResultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDIMAGE", ResultSet.getInt("IDIMAGE"));
          lvModel.put("DATECREATE", ResultSet.getDate("DATECREATE"));

          Result.add(lvModel);
        }
        return Result;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return null;
  }

  public List AllLikeReviewCommment(int IDReviewComment) {

    List Result = new Vector();

    String strSql = "SELECT DISTINCT PRL.ID," + "US.FIRSTNAME," + "US.LASTNAME," + " PRL.IDPLACEREVIEW, " + "PRL.IDUSER,"
        + " PRL.DATECREATE "
        + "FROM PLACEREVIEW_LIKE PRL INNER JOIN SOUSERINFO US ON(PRL.IDUSER = US.IDUSER) INNER JOIN PLACEREVIEW PR ON (PRL.IDPLACEREVIEW = PR.ID) "
        + "WHERE PRL.IDPLACEREVIEW = ?";

    try {
      mvConn = BASEConnection();
      mvPreParedStatement = mvConn.prepareStatement(strSql);
      mvPreParedStatement.setInt(1, IDReviewComment);

      ResultSet mvResultSet = mvPreParedStatement.executeQuery();
      if (mvResultSet != null) {
        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();

          lvModel.put("ID", mvResultSet.getInt("ID"));
          lvModel.put("IDPLACEREVIEW", mvResultSet.getInt("IDPLACEREVIEW"));
          lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));
          lvModel.put("FIRSTNAME", mvResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", mvResultSet.getString("LASTNAME"));
          lvModel.put("DETAILCOMMENT", mvResultSet.getString("DETAILCOMMENT"));
          lvModel.put("DATECREATE", mvResultSet.getDate("DATECREATE"));

          Result.add(lvModel);
        }
        return Result;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }
  /*
   * public List AllSubCommentReview(int IdcommentReview) { List Result = new Vector();
   * 
   * String strSql = "SELECT DISTINCT PRL.ID," + "US.FIRSTNAME," + "US.LASTNAME," +
   * " PRL.IDPLACEREVIEW, " + "PRL.IDUSER," + " PRL.DATECREATE " +
   * "FROM PLACEREVIEW_LIKE PRL INNER JOIN SOUSERINFO US ON(PRL.IDUSER = US.IDUSER) INNER JOIN PLACEREVIEW PR ON (PRL.IDPLACEREVIEW = PR.ID) "
   * + "WHERE PRL.IDPLACEREVIEW = ?";
   * 
   * try { mvConn = BASEConnection(); mvPreParedStatement = mvConn.prepareStatement(strSql);
   * mvPreParedStatement.setInt(1, IdcommentReview);
   * 
   * ResultSet mvResultSet = mvPreParedStatement.executeQuery(); if (mvResultSet != null) { while
   * (mvResultSet.next()) { HashMap lvModel = new HashMap();
   * 
   * lvModel.put("ID", mvResultSet.getInt("ID")); lvModel.put("IDPLACEREVIEW",
   * mvResultSet.getInt("IDPLACEREVIEW")); lvModel.put("IDUSER", mvResultSet.getInt("IDUSER"));
   * lvModel.put("FIRSTNAME", mvResultSet.getString("FIRSTNAME")); lvModel.put("LASTNAME",
   * mvResultSet.getString("LASTNAME")); lvModel.put("DETAILCOMMENT",
   * mvResultSet.getString("DETAILCOMMENT")); lvModel.put("DATECREATE",
   * mvResultSet.getDate("DATECREATE"));
   * 
   * Result.add(lvModel); } return Result; }
   * 
   * } catch (SQLException e) { e.printStackTrace(); } return null;
   * 
   * 
   * }
   */

}
