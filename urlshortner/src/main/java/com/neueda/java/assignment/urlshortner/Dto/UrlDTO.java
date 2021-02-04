package com.neueda.java.assignment.urlshortner.Dto;


public class UrlDTO {
	
	private String url;
	private String expiryDate;
	
	
	public UrlDTO() {
		
	}

	public UrlDTO(String url, String expiryDate) {
		this.url = url;
		this.expiryDate = expiryDate;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "UrlDto [url=" + url + ", expiryDate=" + expiryDate + "]";
	}

}
