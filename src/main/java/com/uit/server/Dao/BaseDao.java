package com.uit.server.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import org.omg.CORBA.SystemException;


public class BaseDao {

  private String userName;
  private String password;
  private String serverName;
  private String dbms;
  private String portNumber;
  private String dbName;


  public BaseDao() {
    this.userName = "root";
    this.password = "";
    this.serverName = "127.0.0.1";
    this.dbms = "mysql";
    this.portNumber = "3306";
    this.dbName = "socialplace";
  }

  public Connection BASEConnection() throws SQLException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Connection conn = null;
    Properties connectionProps = new Properties();
    connectionProps.put("user", this.userName);
    connectionProps.put("password", this.password);

    if (this.dbms.equals("mysql")) {
      conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber + "/" + this.dbName,
          this.userName, this.password);
    } else if (this.dbms.equals("derby")) {
      conn = DriverManager.getConnection("jdbc:" + this.dbms + ":" + this.dbName + ";create=true", connectionProps);
    }
    System.out.println("Connected to database");
    return conn;
  }
  /*
   * public DataSet ExecuteSql() { PreparedStatement result = getIntance().conn.prepareStatement("");
   * 
   * }
   */

  public void closeStatement(PreparedStatement pvStatement) throws SystemException {
    try {
      pvStatement.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void closeConnection(Connection pvConnection) throws SystemException {
    try {
      pvConnection.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


}
