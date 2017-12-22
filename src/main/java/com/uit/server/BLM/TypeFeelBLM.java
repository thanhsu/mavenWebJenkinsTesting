package com.uit.server.BLM;

import java.util.HashMap;
import java.util.List;
import com.uit.server.Dao.TypeFeelDao;
import com.uit.server.bean.FeelBean;

public class TypeFeelBLM {
  TypeFeelDao mvFeelDao ;
  public FeelBean[] AllTypeFeel() {
    FeelBean[] Result;
    mvFeelDao = new TypeFeelDao();
    List listFeel = mvFeelDao.AllFeel();
    if(listFeel!=null) {
      Result = new FeelBean[listFeel.size()];
      for(int i=0;i< listFeel.size();i++) {
        Result[i] = new FeelBean();
        HashMap lvModel = (HashMap)listFeel.get(i);
        Result[i].setFeel(lvModel.get("NAME").toString());
        Result[i].setIDFeel((int)lvModel.get("IDFEEL"));
      }
      return Result;
    }
    return null;
  }
}
