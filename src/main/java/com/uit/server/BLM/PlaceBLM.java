package com.uit.server.BLM;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.uit.server.Dao.CommentDao;
import com.uit.server.Dao.LikeDao;
import com.uit.server.Dao.PlaceDao;
import com.uit.server.bean.BaseRequestBean;
import com.uit.server.bean.ImageBean;
import com.uit.server.bean.LikerBean;
import com.uit.server.bean.PlaceBean;
import com.uit.server.bean.PlaceCommentBean;
import com.uit.server.bean.PlaceRequestBean;

public class PlaceBLM extends BaseBLM {
  PlaceDao mvPlaceDao;
  ReviewBLM mvReviewBlm;

  public PlaceBLM(BaseRequestBean pvBaseRequestBean) {
    super(pvBaseRequestBean);
    mvPlaceDao = new PlaceDao();
    mvReviewBlm = new ReviewBLM();
  }

  @Override
  public void DoDao() {}

  public PlaceBean[] getListPlace(PlaceRequestBean pvPlaceRequestBean) {
    PlaceBean[] result;
    List mvResultSearchPlace;
    mvResultSearchPlace = mvPlaceDao.SearchPlaceByName(pvPlaceRequestBean);
    if (mvResultSearchPlace != null) {
      result = new PlaceBean[mvResultSearchPlace.size()];
      for (int i = 0; i < mvResultSearchPlace.size(); i++) {
        HashMap lvModel = new HashMap();
        lvModel = (HashMap) mvResultSearchPlace.get(i);
        result[i].setNamePace(lvModel.get("NAMEPLACE").toString());
        result[i].setTypePlace(lvModel.get("NAMETYPEPLACE").toString());
        result[i].setEmail(lvModel.get("EMAIL").toString());
        result[i].setPhoneNumber(lvModel.get("PHONENUMBER").toString());
        result[i].setLocationX(lvModel.get("LOCATIONX").toString());
        result[i].setLocationY(lvModel.get("LOCATIONY").toString());
        result[i].setIDPlace((int) lvModel.get("IDPLACE"));
        result[i].setIDTypePlace((int) lvModel.get("IDGROUPLOCATION"));
        result[i].setTypeLocation(lvModel.get("NAMEGROUPLOCATION").toString());

        result[i].setLstComment(this.getListPlaceComment(result[i].getIDPlace()));
        result[i].setLstReview(mvReviewBlm.AllReviewBean(result[i].getIDPlace()));
        result[i].setLstImage(this.AllImagePlace(result[i].getIDPlace()));
        result[i].setLstLike(this.AllLikePlace(result[i].getIDPlace()));
        
      }
      return result;
    }
    return null;
  }

  public PlaceCommentBean[] getListPlaceComment(int IdPlace) {
    PlaceCommentBean[] result;
    LikeDao mvLikeDao = new LikeDao();
    LikerBean[] lstLike;
    CommentDao mvCommentDao = new CommentDao();
    List mvResultPlaceComment = mvCommentDao.AllCommentPlace(IdPlace);
    result = new PlaceCommentBean[mvResultPlaceComment.size()];
    if (mvResultPlaceComment != null) {
      for (int i = 0; i < mvResultPlaceComment.size(); i++) {
        HashMap lvModel = new HashMap();
        result[i] = new PlaceCommentBean();
        lvModel = (HashMap) mvResultPlaceComment.get(i);
        result[i].setID((int) lvModel.get("ID"));
        result[i].setDetail(lvModel.get("DETAILCOMMENT").toString());
        result[i].setDateCreate((Date) lvModel.get("DATECOMMENT"));
        result[i].setState(lvModel.get("STATE").toString());
        result[i].setImageID((int) lvModel.get("IDIMAGE"));
        result[i].setUserID((int) lvModel.get("IDUSER"));
        result[i].setFirstName(lvModel.get("FIRSTNAME").toString());
        result[i].setLastName(lvModel.get("LASTNAME").toString());

        List mvResultLike = mvLikeDao.AllLikeCommentPlace(result[i].getID());
        if (mvResultLike != null) {
          lstLike = new LikerBean[mvResultLike.size()];
          for (int j = 0; j < mvResultLike.size(); j++) {
            HashMap lvModelLike = new HashMap();
            lvModelLike = (HashMap) mvResultLike.get(j);
            lstLike[j] = new LikerBean();
            lstLike[j].setUserFullName(lvModelLike.get("FIRSTNAME").toString() + " " + lvModelLike.get("LASTNAME").toString());
            lstLike[j].setIDLike((int) lvModelLike.get("ID"));
            lstLike[j].setUserID((int) lvModelLike.get("IDUSER"));
          }
          result[i].setListLike(lstLike);
        }
      }
    }

    return result;
  }

  public ImageBean[] AllImagePlace(int idPlace) {
    ImageBean[] Result;
    List listImage = mvPlaceDao.AllImagePlace(idPlace);
    if (listImage != null) {
      Result = new ImageBean[listImage.size()];
      for(int i=0;i < listImage.size(); i++) {
        HashMap lvModel  = (HashMap) listImage.get(i);
        Result[i] = new ImageBean();
        Result[i].setImageID((int)lvModel.get("IDIMAGE"));
        Result[i].setCaption(lvModel.get("CAPTION").toString());
        Result[i].setDiscription(lvModel.get("CAPTION").toString());
      }
      return Result;
    }
    return null;
  }
  
  public LikerBean[] AllLikePlace(int idPlace) {
    LikerBean[] Result;
    List listLike = mvPlaceDao.AllLikePlace(idPlace);
    if(listLike!=null) {
      Result = new LikerBean[listLike.size()];
      for(int i = 0 ; i <listLike.size();i++) {
        HashMap lvModel = (HashMap)listLike.get(i);
        Result[i] = new LikerBean();
        Result[i].setIDLike((int)lvModel.get("ID"));
        Result[i].setUserFullName(lvModel.get("FIRSTNAME")+" "+lvModel.get("LASTNAME"));
        Result[i].setUserID((int)lvModel.get("IDUSER"));
        
      }
      return Result;
    }
    return null;
  }
}
