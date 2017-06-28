package com.expertpia.web.domains;

import org.springframework.web.multipart.MultipartFile;

public class FileBean
{
  private MultipartFile upload;
  private String filename;
  
  public MultipartFile getUpload()
  {
    return this.upload;
  }
  
  public void setUpload(MultipartFile upload)
  {
    this.upload = upload;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public void setFilename(String filename)
  {
    this.filename = filename;
  }
}
