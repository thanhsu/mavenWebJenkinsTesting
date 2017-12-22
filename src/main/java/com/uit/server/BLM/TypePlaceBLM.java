package com.uit.server.BLM;

import java.util.HashMap;
import java.util.List;
import com.uit.server.Dao.TypePlaceDao;
import com.uit.server.bean.TypePlace;

public class TypePlaceBLM {
  TypePlaceDao mvTypePlaceDao;
  
  public int NewTypePlaceDao(String name, String des, String kw) {
    mvTypePlaceDao = new TypePlaceDao();
    return mvTypePlaceDao.NewTypePlace(name, des, kw);
  }
  
  public TypePlace[] AllTypePlace() {
    TypePlace[] Result;
    mvTypePlaceDao= new TypePlaceDao();
    List mvListTypePlace = mvTypePlaceDao.AllTypePlace();
    if(mvListTypePlace!= null) {
      Result = new TypePlace[mvListTypePlace.size()];
      for(int i=0 ; i<mvListTypePlace.size();i++) {
        Result[i]  = new TypePlace();
        HashMap lvModel = (HashMap)mvListTypePlace.get(i);
        
        Result[i].setIDTypePlace((int)lvModel.get("ID"));
        Result[i].setNameTypePlace(lvModel.get("NAMETYPEPLACE").toString());
        Result[i].setDescription(lvModel.get("DESCRIPTION").toString());
        Result[i].setKeyWord(lvModel.get("KEYWORD").toString());
      }
      return Result;
    }
    return null;
  }
  
}
