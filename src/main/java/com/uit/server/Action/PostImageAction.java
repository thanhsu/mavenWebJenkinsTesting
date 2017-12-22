package com.uit.server.Action;

import java.io.File;
import java.io.FileNotFoundException;
import com.uit.server.Dao.ImageDao;
import io.vertx.ext.web.FileUpload;

public class PostImageAction extends BaseAction {
  
  private String imageNameFile;
  ImageDao mvImageDao;
  File mvFileTemp;
  
   public PostImageAction() {
    super();
    mvImageDao = new ImageDao();
  }

  @Override
  public void ParseRequestBean() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void ProcessTxn() {
    // TODO Auto-generated method stub
    
  }
  
  public int ImageData(String name) {
    File fl = new File(this.imageNameFile);
    try {
      return mvImageDao.SaveImage(fl, name);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return -1;
  }

  public void setImageNameFile(String imageNameFile) {
    this.imageNameFile = imageNameFile;
  }

}
