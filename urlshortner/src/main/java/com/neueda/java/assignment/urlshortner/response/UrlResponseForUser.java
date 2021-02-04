package com.neueda.java.assignment.urlshortner.response;

import java.time.LocalDateTime;

public class UrlResponseForUser {
	
	private String originalUrl;
    private String shortUrl;
    private LocalDateTime expirationDate;
    
	public UrlResponseForUser() {
		
	}

	public UrlResponseForUser(String originalUrl, String shortUrl, LocalDateTime expirationDate) {
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.expirationDate = expirationDate;
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	public String getShortUrl() {
		return shortUrl;
	}
	
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "UrlResponseForUser [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", expirationDate="
				+ expirationDate + "]";
	}

}
