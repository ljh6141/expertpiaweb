package com.expertpia.test.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileBean {

	private MultipartFile upload;
	private String filename;
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
