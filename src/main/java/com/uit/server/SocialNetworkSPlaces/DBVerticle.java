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
import com.uit.server.Action.LoginAction;
import com.uit.server.Action.RegisterAction;
import com.uit.server.Action.SearchPlaceAction;
import com.uit.server.Action.TypeLocationAction;
import com.uit.server.Action.TypePlaceAction;
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
