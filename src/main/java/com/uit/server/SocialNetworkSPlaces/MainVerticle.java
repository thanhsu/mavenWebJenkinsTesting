package com.uit.server.SocialNetworkSPlaces;

import java.util.HashMap;
import org.apache.commons.httpclient.HttpStatus;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.vertx.VertxAtmosphere;
import com.uit.server.Action.BaseAction;
import com.uit.server.Action.CheckSesionAction;
import com.uit.server.Action.LoginAction;
import com.uit.server.Action.RegisterAction;
import com.uit.server.Action.SearchPlaceAction;
import com.uit.server.Action.SessionCenter;
import com.uit.server.utils.Tag;
import io.netty.handler.codec.http.HttpStatusClass;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.demo.utils.ActionRequestCodec;
import io.vertx.demo.utils.CustomCodec;
import io.vertx.demo.utils.MessObj;
import io.vertx.demo.utils.WTradeRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

public class MainVerticle extends AbstractVerticle {
  private HttpServer httpServer;
  private Vertx vertx;
  private EventBus eventBus;

  @Override
  public void init(Vertx vertx, Context context) {
    SessionCenter.init();
    /*
     * MapAction.put(Tag.LOGIN_ACTION, new LoginAction()); MapAction.put(Tag.RIGISTER_ACTION, new
     * RegisterAction()); MapAction.put(Tag.CHECKSESSION_ACTION, new CheckSesionAction());
     * 
     * MapAction.put(Tag.SEARCHPLACE_ACTION, new SearchPlaceAction());
     */

    DeploymentOptions TpWorkerOption = new DeploymentOptions().setWorker(true).setInstances(5);
    DeploymentOptions DBWorkerOption = new DeploymentOptions().setWorker(true).setInstances(10);
    this.httpServer = vertx.createHttpServer();
    this.vertx = vertx;
    eventBus = this.vertx.eventBus();
    eventBus.registerDefaultCodec(MessObj.class, new CustomCodec()).registerDefaultCodec(WTradeRequest.class, new ActionRequestCodec());

    vertx.deployVerticle(ImageWorkerVerticle.class, TpWorkerOption);
    
    vertx.deployVerticle(DBVerticle.class, DBWorkerOption);
  }

  @Override
  public void start() {
      Router router = Router.router(this.vertx);
      router.route().handler(BodyHandler.create());

      router.get("/SocialPlaceServer/Image/:imageid").handler(this::DoGetImage);
      router.post("/SocialPlaceServer/Image/Post").handler(this::DoPostImage);
      router.post("/SocialPlaceServer/Action/:ActionName").handler(this::DoExecutePostAction);
      router.get("/SocialPlaceServer/Action/:ActionName").handler(this::DoExecuteGetAction);
      
      router.route("/login").handler(context -> {
                  HttpServerResponse res = context.response();
                  res.putHeader("location", "/");
                  res.setStatusCode(HttpStatus.SC_MOVED_TEMPORARILY);
                  res.end();
              }
      );
      //Start a static server for React frontend
      router.route().handler(
              StaticHandler.create("webroot").setIndexPage("index.html")
      );


      VertxAtmosphere.Builder b = new VertxAtmosphere.Builder();
     /* b.resource(StockInfoSocket.class).httpServer(httpServer)
              .url("/ITradePushServer/StockInfo/:ClientID")
              .webroot("src/main/webroot/")
              .initParam(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json")
              .vertx(this.vertx)
              .build();*/
      /*router.mountSubRouter("/StockInfo", StockInfoRouter());*/
      httpServer.requestHandler(router::accept).listen(8089);
  }


  private void DoLogin(RoutingContext rtContext) {
    String pvClientID = rtContext.request().getParam("clientID");
    eventBus.send("TPMessage.data", new MessObj("GetStockWatchList", "0", pvClientID), res2 -> {
      if (res2.succeeded()) {
        // Log.println("[StockInfoSocket] Send TPMessage.data To TP Verticle Successfully.Value: " +
        // pvClientID, Log.ACCESS_LOG);
      } else {
        // Log.println("[StockInfoSocket] Send TPMessage.data to TP Verticle Failled. Cause: " +
        // res2.cause(), Log.ERROR_LOG);
      }

    });
    // eventBus.publish("TPMessage.data", new MessObj("GetStockWatchList", "0", pvClientID));
    rtContext.response().putHeader("content-type", "text/html").end("Register Socket Session Success!");
  }

  private void DoGetImage(RoutingContext rtContext) {
    String pvImageID = rtContext.request().getParam("imageid");
    eventBus.send("GetImage.data", new WTradeRequest("GetImage", new JsonObject(), rtContext, pvImageID), res2 -> {

      if (res2.succeeded()) {
        System.out.println("Send GetImage.data, ImageId = " + pvImageID);
      } else {
        // Log.println("[StockInfoSocket] Send TPMessage.data to TP Verticle Failled. Cause: " +
        // res2.cause(), Log.ERROR_LOG);
      }

    });
    // eventBus.publish("TPMessage.data", new MessObj("GetStockWatchList", "0", pvClientID));

  }

  private void DoPostImage(RoutingContext rtContext) {
    eventBus.send("PostImage.data", new WTradeRequest("PostImage", new JsonObject(), rtContext, ""), res2 -> {
      if (res2.succeeded()) {
        System.out.println("Do Post Image Sucess");
      } else {
        // Log.println("[StockInfoSocket] Send TPMessage.data to TP Verticle Failled. Cause: " +
        // res2.cause(), Log.ERROR_LOG);
      }

    });


  }

  private void DoExecutePostAction(RoutingContext rtContext) {
    String Actionname = rtContext.request().getParam("ActionName");
    eventBus.send("DBMessage.data", new WTradeRequest(Actionname, new JsonObject(), rtContext, Actionname), res2 -> {

      if (res2.succeeded()) {
        System.out.println("Sent DBMessage.data,ActionName = " + Actionname);
      } else {

      }

    });

  }

  private void DoExecuteGetAction(RoutingContext rtContext) {
    String Actionname = rtContext.request().getParam("ActionName");

    eventBus.send("DBGet.data", new WTradeRequest(Actionname, new JsonObject(), rtContext, Actionname), res2 -> {

      if (res2.succeeded()) {
        System.out.println("Sent DBMessage.data,ActionName = " + Actionname);
      } else {

      }

    });


  }


}
