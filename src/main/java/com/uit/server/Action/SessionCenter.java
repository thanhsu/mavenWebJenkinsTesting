package com.uit.server.Action;

import java.util.HashMap;

public class SessionCenter {
  private volatile static HashMap<String, String> SessionMap = null;
  private static SessionCenter instance;
  
  public synchronized static void init() {
   
  }

  public static SessionCenter getInstance() {
    if (instance == null) {
      instance = new SessionCenter();
      SessionMap = null;
    }
    return instance;
  }

  public void RegisterSession(String Username, String Session) {
    if (this.SessionMap.get(Username) != null) {
      this.SessionMap.remove(Username);
    }
    this.SessionMap.put(Username, Session);

  }

  public String CheckSession(String UserName, String Session) {
    if (this.SessionMap.get(UserName) != null) {
      String mvSession = this.SessionMap.get(UserName);
      if (mvSession.equals(Session)) {
        return mvSession;
      } else {
        return mvSession;
      }
    }
    return null;
  }
  
  public boolean checkSession(String UserName) {
    if(this.SessionMap.get(UserName)!=null) {
      return true;
    }
    return false;
  }
}
