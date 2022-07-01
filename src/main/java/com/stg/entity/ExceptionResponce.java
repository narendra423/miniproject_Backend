package com.stg.entity;

public class ExceptionResponce {
	private String errMessage;
	private String requestedURI;

	public ExceptionResponce() {
		super();
	}

	public ExceptionResponce(String errMessage, String requestedURI) {
		super();
		this.errMessage = errMessage;
		this.requestedURI = requestedURI;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
