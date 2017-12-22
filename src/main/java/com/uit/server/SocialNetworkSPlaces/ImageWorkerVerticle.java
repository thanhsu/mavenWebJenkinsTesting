package com.uit.server.SocialNetworkSPlaces;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import com.uit.server.Action.GetImageAction;
import com.uit.server.Action.PostImageAction;
import com.uit.server.bean.ImageBean;
import com.uit.server.bean.ResultBean;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.demo.utils.WTradeRequest;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;

public class ImageWorkerVerticle extends AbstractVerticle {
  public static final String CLIENT_ID = "ClientID";
  public static final String IMAGE_ID = "mvImageID";
  public static final String MESSAGE_TYPE = "Type";
  public static final String FROM_COMP = "From";
  public static final String TO_COMP = "To";
  public static final String ATTACHMENT = "Attach";

  @Override
  public void init(Vertx vertx, Context context) {
    // TODO Auto-generated method stub
    super.init(vertx, context);
  }

  @SuppressWarnings({"static-access", "unused"})
  @Override
  public void start() {
    EventBus eventBus = vertx.eventBus();
    eventBus.consumer("GetImage.data", message -> { // Get evetn bus get client id get stock list

      // Extract info from message
      Object ob = message.body();
      // JsonObject lvEBMessage = (JsonObject) message.body();
      WTradeRequest rq = (WTradeRequest) ob;
      String lvImageID = rq.getMvClientID(); // lvEBMessage.getString(IMAGE_ID);
      RoutingContext rtContext = rq.getMvRouteCtx();// (RoutingContext)lvEBMessage.getValue("response");

      GetImageAction mvGetImageAction = new GetImageAction();
      mvGetImageAction.setMvRoutinContext(rtContext);
      mvGetImageAction.setImageId(Integer.parseInt(lvImageID.trim()));
      mvGetImageAction.ProcessTxn();
      message.reply("Success!");
    });

    eventBus.consumer("PostImage.data", message -> { // Get evetn bus get client id get stock list

      // Extract info from message
      Object ob = message.body();
      // JsonObject lvEBMessage = (JsonObject) message.body();
      WTradeRequest rq = (WTradeRequest) ob;
      String lvImageID = rq.getMvClientID(); // lvEBMessage.getString(IMAGE_ID);
      RoutingContext rtContext = rq.getMvRouteCtx();// (RoutingContext)lvEBMessage.getValue("response");
      List ListIDImage = new ArrayList<>();
      for (FileUpload f : rtContext.fileUploads()) {
        System.out.println("f" + f.fileName());

        // File fl = new File("./Image/Post/"+f.fileName());
        Buffer uploadedFile = vertx.fileSystem().readFileBlocking(f.uploadedFileName());
        vertx.fileSystem().writeFileBlocking("./ImageUpload/" + f.fileName(), uploadedFile);

        PostImageAction mvPostImageAction = new PostImageAction();
        mvPostImageAction.setImageNameFile("./ImageUpload/" + f.fileName());
        int x = mvPostImageAction.ImageData(f.fileName());
        if (mvPostImageAction.ImageData(f.fileName()) != -1) {
          ListIDImage.add(mvPostImageAction.ImageData(f.fileName()));
        }
      }
      if (ListIDImage != null) {
        ImageBean[] listImage = new ImageBean[ListIDImage.size()];
        for (int i = 0; i < ListIDImage.size(); i++) {
          listImage[i] = new ImageBean();
          listImage[i].setImageID((int) ListIDImage.get(i));
        }
        ResultBean result = new ResultBean(1, "List ID Image Was Upload", listImage);
        rtContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end(Json.encodePrettily(result));
        message.reply("Success!");
      } else {
        rtContext.response().end("Lỗi!");
        message.reply("Faile!");
      }
    });


  }

  @Override
  public void stop() {

  }
}
