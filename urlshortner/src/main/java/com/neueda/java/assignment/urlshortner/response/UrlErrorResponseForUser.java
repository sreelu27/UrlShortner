package com.neueda.java.assignment.urlshortner.response;

public class UrlErrorResponseForUser {
	
	private String status;
	private String errorMessage;
	
	public UrlErrorResponseForUser() {
		
	}

	public UrlErrorResponseForUser(String status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "UrlErrorResponseForUser [status=" + status + ", errorMessage=" + errorMessage + "]";
	}
	
}
