package com.ssl.user.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title; // 封装文件标题请求参数
	private File upload; // 上传文件域
	private String uploadContentType; // 上传文件的类型
	private String uploadFileName; // 上传文件名的属性

	private String savePath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws Exception {

		// 以服务器的文件保存地址和原文件名建立上传文件输出流
		@SuppressWarnings("resource")
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ getUploadFileName());
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);

		}
		return SUCCESS;
	}

}
