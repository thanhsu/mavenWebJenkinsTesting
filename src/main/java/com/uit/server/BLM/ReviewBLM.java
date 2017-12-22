package com.uit.server.BLM;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.uit.server.Dao.ReviewDao;
import com.uit.server.bean.CommentBean;
import com.uit.server.bean.ImageBean;
import com.uit.server.bean.LikerBean;
import com.uit.server.bean.ReviewBean;

public class ReviewBLM {
  ReviewDao mvReviewDao;
  public ReviewBean[] AllReviewBean(int IdPlace) {
    mvReviewDao = new ReviewDao();
    ReviewBean[] Result;
    List ListReview = mvReviewDao.AllReviewPlace(IdPlace);
    if(ListReview!=null) {
      Result = new ReviewBean[ListReview.size()];
      for(int i=0;i<ListReview.size();i++) {
        HashMap lvModel = (HashMap) ListReview.get(i);
        Result[i] = new ReviewBean();
        Result[i].setIDUser((int)lvModel.get("IDUSER"));
        Result[i].setReviewID((int)lvModel.get("ID"));
        Result[i].setReviewCaption(lvModel.get("CAPTION").toString());
        Result[i].setReviewDate((Date)lvModel.get("DATECREATE"));
        Result[i].setReviewDetail(lvModel.get("DESCRIPTION").toString());
        Result[i].setUserFullName(lvModel.get("FIRSTNAME") +" "+lvModel.get("LASTNAME"));
       
        Result[i].setLstLikeReview(this.AllLikeReviewPlace(Result[i].getReviewID()));        
        Result[i].setLstImage(this.AllImagePlaceReview(Result[i].getReviewID()));
        Result[i].setLstComment(this.AllCommentReviewPlace(Result[i].getReviewID()));
      }
      
    }
    
    return null;
  }
  
  public ImageBean[] AllImagePlaceReview(int idPlace) {
    mvReviewDao = new ReviewDao();
    ImageBean[] Result;
    List listImage = mvReviewDao.AllImageReview(idPlace);
    
    if(listImage!= null) {
      Result =  new ImageBean[listImage.size()];
      for(int i = 0; i< listImage.size();i++) {
        HashMap lvModel = (HashMap)listImage.get(i);
        Result[i] = new ImageBean();
        
        Result[i].setImageID((int)lvModel.get("IDIMAGE"));
      }
      return Result;
    }
   
    
    return null;
  }
  
  public LikerBean[] AllLikeReviewPlace(int idPlace) {
    mvReviewDao =  new ReviewDao();
    LikerBean[] Result;
    List ListLike = mvReviewDao.AllLikeReviewPlace(idPlace);
    if(ListLike!=null) {
      Result = new LikerBean[ListLike.size()];
      for(int i=0;i<ListLike.size();i++) {
        HashMap lvModel = (HashMap)ListLike.get(i);
        Result[i] =new LikerBean();
        Result[i].setIDLike((int)lvModel.get("ID"));
        Result[i].setUserID((int)lvModel.get("IDUSER"));
        
      }
      return Result;
    }
    return null;
  }
  
  public CommentBean[] AllCommentReviewPlace(int idReview) {
    CommentBean[] Result;
    mvReviewDao = new ReviewDao();
    List ListComment = mvReviewDao.AllCommentReview(idReview);
    if(ListComment!=null) {
      Result =  new CommentBean[ListComment.size()];
      for(int i=0; i < ListComment.size();i++) {
        HashMap lvModel = (HashMap)ListComment.get(i);
        Result[i] = new CommentBean();
        Result[i].setCommentID((int)lvModel.get("ID"));
        Result[i].setUserID((int)lvModel.get("IDUSER"));
        Result[i].setUserFullName(lvModel.get("FIRSTNAME")+" "+lvModel.get("LASTNAME"));
        Result[i].setImageID((int)lvModel.get("IDIMAGE"));
        Result[i].setDetail(lvModel.get("DETAILCOMMENT").toString());
        Result[i].setCommentDate((Date)lvModel.get("DATECREATE"));
        Result[i].setLstSubComment(null);
        
        Result[i].setLstLikeComment(this.AllLikeCommentReview(Result[i].getCommentID()));
      }
      return Result; 
    }
    
    return null;
  }
  
  public LikerBean[] AllLikeCommentReview(int idCommentReview) {
    mvReviewDao =  new ReviewDao();
    LikerBean[] Result;
    List ListLike = mvReviewDao.AllLikeReviewCommment(idCommentReview);
    if(ListLike!=null) {
      Result = new LikerBean[ListLike.size()];
      for(int i=0;i<ListLike.size();i++) {
        HashMap lvModel = (HashMap)ListLike.get(i);
        Result[i] =new LikerBean();
        Result[i].setIDLike((int)lvModel.get("ID"));
        Result[i].setUserID((int)lvModel.get("IDUSER"));
        Result[i].setUserFullName(lvModel.get("FIRSTNAME")+" "+lvModel.get("LASTNAME"));        
      }
      return Result;
    }
    return null;
    
  }
    
}
