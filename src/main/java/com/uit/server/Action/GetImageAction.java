package com.uit.server.Action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.uit.server.Dao.ImageDao;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpHeaders;

public class GetImageAction extends BaseAction {
  private int imageId;
  ImageDao mvImageDao;
  File mvfile;

  public GetImageAction() {
    super();
    mvImageDao = new ImageDao();
  }

  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub

  }

  @Override
  public void ProcessTxn() {

    try {
      mvfile = mvImageDao.getImage(this.imageId);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    ResponseImageData(this.mvfile);
  }

  public void ResponseImageData(File pvFile) {
    if (mvfile != null) {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_ENCODING, HttpHeaders.IDENTITY).sendFile(pvFile.getAbsolutePath());
    }else {
      this.mvRoutinContext.response().putHeader(HttpHeaders.CONTENT_TYPE, "application/json").end("Không tìm thấy hình ảnh!");
    }
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
  }
}
