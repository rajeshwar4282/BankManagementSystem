package com.bms.authserver.pojo;

public class ResponseData {
	
	String username;
	
	String ststus;
	
	int code;
	
	String message;

	public ResponseData(String username, String ststus, int code, String message) {
		super();
		this.username = username;
		this.ststus = ststus;
		this.code = code;
		this.message = message;
	}

	public ResponseData() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStstus() {
		return ststus;
	}

	public void setStstus(String ststus) {
		this.ststus = ststus;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
