package com.ssm.OaManager.entity.mail;

public class Attachment {
    
	
	private Integer msgNum;
	
	private Integer bodyNum;
	
	private String fileName;
	
	
	

	public Integer getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(Integer msgNum) {
		this.msgNum = msgNum;
	}

	public Integer getBodyNum() {
		return bodyNum;
	}

	public void setBodyNum(Integer bodyNum) {
		this.bodyNum = bodyNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
