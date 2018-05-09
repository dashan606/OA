package com.ssm.OaManager.entity;

public class Test {

	private Integer id;
	private byte[] doc;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(byte[] doc) {
		super();
		this.doc = doc;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
