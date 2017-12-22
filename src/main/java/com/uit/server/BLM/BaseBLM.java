package com.uit.server.BLM;

import java.util.List;
import com.uit.server.Dao.BaseDao;
import com.uit.server.bean.BaseRequestBean;

public abstract class BaseBLM {
   BaseDao mvBaseDao;
   List mvResult;
   BaseRequestBean mvBaseRequestBean;
  
  public List getMvResult() {
    return mvResult;
  }

  public void setMvResult(List mvResult) {
    this.mvResult = mvResult;
  }

  public BaseBLM(BaseRequestBean pvBaseRequestBean) {
    this.mvBaseRequestBean = pvBaseRequestBean;
    
  }
  
  public abstract void DoDao();
}
