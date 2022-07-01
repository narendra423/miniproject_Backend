package com.stg.exception;

public class ExceptionClass extends RuntimeException {
	private String errorMessage;

	public ExceptionClass(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
