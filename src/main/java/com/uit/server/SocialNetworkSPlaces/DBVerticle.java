package com.uit.server.SocialNetworkSPlaces;

import java.util.Map;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.demo.utils.MessObj;
import io.vertx.demo.utils.WTradeRequest;
import javolution.util.FastMap;
import com.uit.server.Action.BaseAction;
import com.uit.server.Action.CheckSesionAction;
import com.uit.server.Action.DoLikeStatusAction;
import com.uit.server.Action.FollowUserAction;
import com.uit.server.Action.GetPostAction;
import com.uit.server.Action.LikePlaceAction;
import com.uit.server.Action.LoginAction;
import com.uit.server.Action.NewPlaceAction;
import com.uit.server.Action.PlaceCommentAction;
import com.uit.server.Action.PlaceDetailAction;
import com.uit.server.Action.PlaceReviewCommentAction;
import com.uit.server.Action.PlaceReviewLikeAction;
import com.uit.server.Action.PostAction;
import com.uit.server.Action.PostReviewAction;
import com.uit.server.Action.RegisterAction;
import com.uit.server.Action.SearchPlaceAction;
import com.uit.server.Action.TypeLocationAction;
import com.uit.server.Action.TypePlaceAction;
import com.uit.server.Action.UpdateAvatarAction;
import com.uit.server.Action.UserInfoAction;
import com.uit.server.bean.TypeLocation;
import com.uit.server.bean.TypePlace;
import com.uit.server.utils.Tag;

public class DBVerticle extends AbstractVerticle {
  private Map<String, BaseAction> mvIncommingWorkflow;

  @Override
  public void init(Vertx vertx, Context context) {
     mvIncommingWorkflow = new FastMap<>();
     mvIncommingWorkflow.put(Tag.LOGIN_ACTION, new LoginAction());
     mvIncommingWorkflow.put(Tag.SEARCHPLACE_ACTION, new SearchPlaceAction());
     mvIncommingWorkflow.put(Tag.RIGISTER_ACTION, new RegisterAction());
     mvIncommingWorkflow.put(Tag.CHECKSESSION_ACTION, new CheckSesionAction());
     mvIncommingWorkflow.put(Tag.TYPELOCATION_ACTION, new TypeLocationAction());
     mvIncommingWorkflow.put(Tag.TYPEPLACE_ACTION, new TypePlaceAction());
     mvIncommingWorkflow.put(Tag.GETUSERINFO, new UserInfoAction());
     mvIncommingWorkflow.put(Tag.UPDATEAVATAR, new UpdateAvatarAction());
     mvIncommingWorkflow.put(Tag.FOLLOWUSER, new FollowUserAction());
     mvIncommingWorkflow.put(Tag.PLACELIKE_ACTION, new LikePlaceAction());
     
     mvIncommingWorkflow.put(Tag.POSTSTATUS, new PostAction());
     mvIncommingWorkflow.put(Tag.GETMYALLPOST, new GetPostAction().setCode(1));
     mvIncommingWorkflow.put(Tag.GETALLFOLLOWPOST, new GetPostAction().setCode(2));
     
     mvIncommingWorkflow.put(Tag.PLACEDETAIL_ACTION, new PlaceDetailAction());
     
     
    // mvIncommingWorkflow.put(Tag.PLACECOMMENT_ACTION, )
     mvIncommingWorkflow.put(Tag.NEWPLACE_ACTION, new NewPlaceAction());
     mvIncommingWorkflow.put(Tag.DOLIKEPOST, new DoLikeStatusAction());
     mvIncommingWorkflow.put(Tag.PLACECOMMENT_ACTION, new PlaceCommentAction());
     mvIncommingWorkflow.put(Tag.PLACELIKE_ACTION, new LikePlaceAction());
     mvIncommingWorkflow.put(Tag.PLACEREVIEW_ACTION,new PostReviewAction());
     mvIncommingWorkflow.put(Tag.PLACEREVIEWLIKE_ACTION, new PlaceReviewLikeAction());
     mvIncommingWorkflow.put(Tag.PLACEREVIEWCOMMENT_ACTION, new PlaceReviewCommentAction());
     
     
     super.init(vertx, context);
  }

  @Override
  public void start() {
    System.out.println("Start TP Connect IN: " + Thread.currentThread());
    EventBus eventBus = vertx.eventBus();
    eventBus.consumer("DBMessage.data", message -> { // Get evetn bus get client id get stock list
      Object ob = message.body();
      WTradeRequest rq = (WTradeRequest) ob;
      
      String mvKey = rq.getMvAction();
      BaseAction mvAction = (BaseAction) mvIncommingWorkflow.get(mvKey);
      mvAction.setMvRoutinContext(rq.getMvRouteCtx());
      mvAction.ProcessTxn();
      message.reply("Succees!");
    });
    
    eventBus.consumer("DBGet.data", message -> { // Get evetn bus get client id get stock list
      Object ob = message.body();
      WTradeRequest rq = (WTradeRequest) ob;
      
      String mvKey = rq.getMvAction();
      BaseAction mvAction = (BaseAction) mvIncommingWorkflow.get(mvKey);
      mvAction.setMvRoutinContext(rq.getMvRouteCtx());
      mvAction.ProcessTxn();
      message.reply("Succees!");
    });
  }



}
