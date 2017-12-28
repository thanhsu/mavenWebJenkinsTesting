package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import com.uit.server.bean.PlaceRequestBean;

public class PlaceDao extends BaseDao {
  public static String PLACETABLE = "PLACE";
  public static String GROUPPLACE = "GROUPPLACE";


  public List SearchPlaceByName(PlaceRequestBean pvPlaceRequestBean, int idplace) {
    List Result = new Vector();

    String strSql = "SELECT PL.ID AS IDPLACE," + " PL.NAME AS NAMEPLACE, PL.IDTYPEPLACE, " + "PL.DECRIPSION,PL.PHONENUMBER, PL.EMAIL, LO.LOCATIONX, "
        + "LO.ID AS IDLOCATION, GR.DESCRIPTION AS NAMETYPEPLACE, " + "LO.LOCATIONY, LO.IDTYPEPLACE AS IDTYPELOCATION ,"
        + " LO.IDGROUP AS IDGROUPLOCATION , " + "GRLO.NAMEGR AS NAMEGROUPLOCATION" + "  FROM "
        + "PLACE PL INNER JOIN groupplace GR ON (PL.IDGROUPPLACE = GR.ID) " + " INNER JOIN LOCATION LO ON (PL.IDLOCATION = LO.ID) "
        + " INNER JOIN GROUPLOCATION GRLO ON (LO.IDGROUP = GRLO.ID) " + "" + " WHERE  ";
    if (!pvPlaceRequestBean.getNamePlace().equals("")) {
      strSql += " AND PL.NAME LIKE '%" + pvPlaceRequestBean.getNamePlace() + "%' ";
    }
    if (pvPlaceRequestBean.getIDTypePlace() != 0) {
      strSql += " AND LO.IDTYPEPLACE = " + pvPlaceRequestBean.getIDTypePlace();
    }
    if (pvPlaceRequestBean.getLocationX() != 0 || pvPlaceRequestBean.getLocationY() != 0) {
      strSql += " AND (LO.LOCATIONX BETWEEN " + (pvPlaceRequestBean.getLocationX() - 50) + " AND "
          + (pvPlaceRequestBean.getLocationX() + 50) + " ) AND (LO.LOCATIONY BETWEEN " + (pvPlaceRequestBean.getLocationY() - 50) + " AND  "
          + (pvPlaceRequestBean.getLocationY() + 50) + " )";

    } if(idplace!=0) {
      strSql +=" AND (PL.ID = "+idplace+" ) ";
    }
    try {
      Connection conn = BASEConnection();
      PreparedStatement lvStatement;
      lvStatement = conn.prepareStatement(strSql);

      ResultSet mvResultSet = lvStatement.executeQuery();
      if (mvResultSet != null) {

        while (mvResultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDPLACE", mvResultSet.getInt("IDPLACE"));
          lvModel.put("NAMEPLACE", mvResultSet.getString("NAMEPLACE"));
          lvModel.put("IDTYPEPLACE", mvResultSet.getInt("IDTYPEPLACE"));
          lvModel.put("NAMETYPEPLACE", mvResultSet.getString("NAMETYPEPLACE"));
          lvModel.put("PHONENUMBER", mvResultSet.getString("PHONENUMBER"));
          lvModel.put("EMAIL", mvResultSet.getString("EMAIL"));
          lvModel.put("DESCRIPTION", mvResultSet.getString("DESCRIPTION"));
          lvModel.put("IDLOCATION", mvResultSet.getString("IDLOCATION"));
          lvModel.put("LOCATIONX", mvResultSet.getString("LOCATIONX"));
          lvModel.put("LOCATIONY", mvResultSet.getString("LOCATIONY"));
          lvModel.put("IDTYPELOCATION", mvResultSet.getInt("IDTYPELOCATION"));
          lvModel.put("IDGROUPLOCATION", mvResultSet.getInt("IDGROUPLOCATION"));
          lvModel.put("NAMEGROUPLOCATION", mvResultSet.getString("NAMEGROUPLOCATION"));

          Result.add(lvModel);
        }
        return Result;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Result;
  }

  public List AllImagePlace(int idPlace) {
    List Result = new Vector();

    String strSql = "SELECT DISTINCT PI.IDPLACE, " + "PI.IDIMAGE," + " PI.DATECREATE," + " PI.STATE," + " IMG.CAPTION"
        + " FROM PLACE_IMAGE PI INNER JOIN IMAGEPIC IMG ON (PI.IDIMAGE = IMG.ID) " + "WHERE PI.IDPLACE = ?";
    try {
      Connection conn = BASEConnection();
      PreparedStatement lvPreparedStatement = conn.prepareStatement(strSql);
      lvPreparedStatement.setInt(1, idPlace);
      ResultSet ResultSet = lvPreparedStatement.executeQuery();
      if (ResultSet != null) {
        while (ResultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("IDPLACE", ResultSet.getInt("IDPLACE"));
          lvModel.put("IDIMAGE", ResultSet.getInt("IDIMAGE"));
          lvModel.put("CAPTION", ResultSet.getString("CAPTION"));
          lvModel.put("DATECREATE", ResultSet.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public List AllLikePlace(int PlaceId) {

    List Result = new Vector();

    String strSql = "SELECT DISTINCT PL.ID,"
        + " PL.IDUSER ,"
        + "US.FIRSTNAME, "
        + "US.LASTNAME, "
        + "PL.IDPLACE,"
        + "PL.DATECREATE  "
        + "FROM PLACE_LIKE PL INNER JOIN SOUSERINFO US ON (PL.IDUSER = US.IDUSER) "
        + "WHERE PL.IDPLACE=?"; 
    try {
      Connection conn = BASEConnection();
      PreparedStatement lvPreparedStatement = conn.prepareStatement(strSql);
      lvPreparedStatement.setInt(1, PlaceId);
      ResultSet ResultSet = lvPreparedStatement.executeQuery();
      if (ResultSet != null) {
        while (ResultSet.next()) {
          HashMap lvModel = new HashMap();
          lvModel.put("ID", ResultSet.getInt("ID"));
          lvModel.put("IDUSER", ResultSet.getInt("IDUSER"));
          lvModel.put("IDPLACE", ResultSet.getInt("IDPLACE"));
          lvModel.put("FIRSTNAME", ResultSet.getString("FIRSTNAME"));
          lvModel.put("LASTNAME", ResultSet.getString("LASTNAME"));
          lvModel.put("DATECREATE", ResultSet.getDate("DATECREATE"));
          Result.add(lvModel);
        }
        return Result;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  
  }
  
  public int createNewLocation(float x, float y, int idtypelocation) {
    String strSQL = "INSERT INTO `location`( `LOCATIONX`, `LOCATIONY`, `NOTE`, `IDGROUP`) VALUES (?,?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setFloat(1, x);
      mvPreparedStatement.setFloat(2, y);
      mvPreparedStatement.setString(3, Calendar.getInstance().toString());
      mvPreparedStatement.setInt(4, idtypelocation);
      
      if(mvPreparedStatement.executeUpdate()>0) {
        try(ResultSet rs =  mvPreparedStatement.getGeneratedKeys()){
          if(rs.next()) {
            return rs.getInt(1);
          }
        }
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return 0;
  }

  public int CreateNewPlace(String nameplace, int idTypePlace, int idlocation, String decripsion, String phoneNumber, String Email) {
    String strSQL=" INSERT INTO `place`(`NAME`, `DECRIPSION`, "
        + "`IDLOCATION`, `IDGROUPPLACE`, "
        + " `PHONENUMBER`, `EMAIL`) VALUES (?,?,?,?,?,?)";
    try {
      mvConn = BASEConnection();
      mvPreparedStatement = mvConn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
      mvPreparedStatement.setString(1, nameplace);
      mvPreparedStatement.setString(2, decripsion);
      mvPreparedStatement.setInt(3, idlocation);
      mvPreparedStatement.setInt(4, idTypePlace);
      mvPreparedStatement.setString(5, phoneNumber);
      mvPreparedStatement.setString(6, Email);
      
      if(mvPreparedStatement.executeUpdate()>0) {
        try(ResultSet rs =  mvPreparedStatement.getGeneratedKeys()){
          if(rs.next()) {
            return rs.getInt(1);
          }
        }
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      this.closeConnection(mvConn);
      this.closeStatement(mvPreparedStatement);
    }
    return 0;
  }

}
