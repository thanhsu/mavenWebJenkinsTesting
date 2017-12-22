package com.uit.server.BLM;

import java.util.HashMap;
import java.util.List;
import com.uit.server.Dao.TypeLocationDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.TypeLocation;

public class TypeLocationBLM extends BaseBLM {

  TypeLocationDao mvLocationDao;

  public TypeLocationBLM(BaseRequestBean pvBaseRequestBean) {
    super(pvBaseRequestBean);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void DoDao() {


  }

  public int NewTypeLocation(String name, String des, String kw) {
    mvLocationDao = new TypeLocationDao();
    try {
      return mvLocationDao.NewTypeLocation(name, des, kw);
    } catch (Exception e) {
      return 0;
    }
  }
  
  public TypeLocation[] AllTypeLocation() {
    mvLocationDao  = new TypeLocationDao();
    TypeLocation[] Result;
    
    List mvListAllLocationType = mvLocationDao.AllTypeLocation();
    if(mvListAllLocationType!=null) {
      Result = new TypeLocation[mvListAllLocationType.size()];
      for(int i=0;i< mvListAllLocationType.size();i++) {
        HashMap lvModel =  (HashMap)mvListAllLocationType.get(i);
        Result[i]  = new TypeLocation();
        Result[i].setIDTypeLocaton((int)lvModel.get("ID"));
        Result[i].setNameTypeLocation(lvModel.get("NAMETYPELOCATION").toString());
        Result[i].setDescription(lvModel.get("DESCRIPTION").toString());
        Result[i].setKeyword(lvModel.get("KEYWORD").toString());
      }
      return Result;
    }
    return null;
  }
  
}
