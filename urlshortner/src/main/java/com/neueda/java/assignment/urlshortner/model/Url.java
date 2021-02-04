package com.neueda.java.assignment.urlshortner.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;


@Entity
public class Url {
	
	@Id
	@GeneratedValue
	private long id;
	@Lob
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="url")
	private List<Statistic> statistics = new ArrayList<>();
    
    public Url() {
    	
    }
    
	public Url(long id, String originalUrl, String shortUrl, LocalDateTime creationDate, LocalDateTime expirationDate) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", creationDate="
				+ creationDate + ", expirationDate=" + expirationDate + "]";
	}
	
}
