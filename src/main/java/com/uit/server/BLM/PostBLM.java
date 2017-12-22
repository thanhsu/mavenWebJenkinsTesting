package com.uit.server.BLM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.uit.server.Action.BaseAction;
import com.uit.server.Dao.BaseDao;
import com.uit.server.Dao.PostDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.PostBean;

public class PostBLM extends BaseBLM {
  PostDao mvPostDao;

  public PostBLM(BaseRequestBean pvBaseRequestBean) {
    super(pvBaseRequestBean);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void DoDao() {
    // TODO Auto-generated method stub

  }

  public int PostStatus(int userid, String detail, int[] lstImage, int idfeel) {
    mvPostDao = new PostDao();
    int statusid = mvPostDao.PostStatus(userid, detail, idfeel);
    if (statusid > 0 && lstImage != null) {
      for (int i = 0; i < lstImage.length; i++) {
        mvPostDao.MapImageToStatus(statusid, lstImage[i]);
      }
    }

    return statusid;
  }

  public PostBean[] ALLPostMyUser(int UserId) {
    PostBean[] Result;
    mvPostDao = new PostDao();
    List result = mvPostDao.AllPostOfUser(UserId);
    if (result != null) {
      Result = new PostBean[result.size()];
      for (int i = 0; i < result.size(); i++) {
        Result[i] = new PostBean();
        HashMap lvModel = (HashMap) result.get(i);
        Result[i].setIDStatus((int) lvModel.get("ID"));
        Result[i].setDetail(lvModel.get("DETAIL").toString());
        Result[i].setIDFeel((int) lvModel.get("IDFEEL"));
        Result[i].setDateCreate((Date) lvModel.get("DATECREATE"));
        List listImage = mvPostDao.ListAllImagePost(Result[i].getIDStatus());
        if (listImage != null) {
          int[] lst = new int[listImage.size()];
          for (int j = 0; j < listImage.size(); j++) {
            lst[j] = (int) ((HashMap) listImage.get(j)).get("IDIMAGE");
          }
          Result[i].setLstImage(lst);
        } else {
          Result[i].setLstImage(null);
        }

      }
      return Result;
    }

    return null;
  }

  public PostBean[] AllPostFollow(int UserId) {
    PostBean[] Result;
    mvPostDao = new PostDao();
    List result = mvPostDao.ALLPostUserFollow(UserId);
    if (result != null) {
      Result = new PostBean[result.size()];
      for (int i = 0; i < result.size(); i++) {
        Result[i] = new PostBean();
        HashMap lvModel = (HashMap) result.get(i);
        Result[i].setIDStatus((int) lvModel.get("IDSTATUS"));
        Result[i].setDetail(lvModel.get("DETAIL").toString());
        Result[i].setFullName(lvModel.get("FIRSTNAME") + " " + lvModel.get("LASTNAME"));
        Result[i].setIDUser((int) lvModel.get("IDUSER"));
        Result[i].setIDFeel((int) lvModel.get("IDFEEL"));

        Result[i].setDateCreate((Date) lvModel.get("DATECREATE"));
        List listImage = mvPostDao.ListAllImagePost(Result[i].getIDStatus());
        if (listImage != null) {
          int[] lst = new int[listImage.size()];
          for (int j = 0; j < listImage.size(); j++) {
            lst[j] = (int) ((HashMap) listImage.get(j)).get("IDIMAGE");
          }
          Result[i].setLstImage(lst);
        } else {
          Result[i].setLstImage(null);
        }

      }
      return Result;
    }

    return null;
  }
}
