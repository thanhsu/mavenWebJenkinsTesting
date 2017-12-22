package com.uit.server.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageDao extends BaseDao {
  public File getImage(int imageID) throws FileNotFoundException {
    Connection lvConnection = null;
    PreparedStatement lvStatement = null;


    try {
      String lvStrSql = "SELECT IM.ID, IM.CAPTION, IM.DATA  FROM IMAGEPIC IM WHERE IM.ID = ?";

      byte b[];
      Blob blob;
      lvConnection = this.BASEConnection();

      lvStatement = lvConnection.prepareStatement(lvStrSql);
      lvStatement.setInt(1, imageID);
      File image;
      ResultSet rs = lvStatement.executeQuery();
      if (rs != null) {
        while (rs.next()) {
          String name = rs.getString("CAPTION");
          image = new File("./tempImage/" + rs.getString("CAPTION"));
          FileOutputStream fos = new FileOutputStream(image);
          blob = rs.getBlob("DATA");
          b = blob.getBytes(1, (int) blob.length());
          fos.write(b);
          fos.close();
          return image;
        }

      }

    } catch (SQLException | IOException e) {
      System.out.println("Error: " + e.toString());

    } finally {
      this.closeStatement(lvStatement);
      this.closeConnection(lvConnection);

    }
    return null;

  }

  public int SaveImage(File imgFile, String fileName) throws FileNotFoundException {
    Connection lvConnection;
    PreparedStatement lvStatement;
    String strSql = "INSERT INTO IMAGEPIC(`DATA`, `CAPTION`)" + " VALUES(?,?)";
    FileInputStream fis = new FileInputStream(imgFile);
    try {
      lvConnection = BASEConnection();
      lvStatement = lvConnection.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
      lvStatement.setBinaryStream(1, fis, (int) imgFile.length());
      lvStatement.setString(2, fileName);

      if (lvStatement.executeUpdate() > 0)
        try (ResultSet generatedKeys = lvStatement.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            int result = generatedKeys.getInt(1);
            return result;
          } else {
            throw new SQLException("Creating imagepic failed, no ID obtained.");
          }
        }

      return -1;

    } catch (SQLException e) {
      return 0;
    }
  }

}
