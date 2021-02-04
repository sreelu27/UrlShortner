package com.neueda.java.assignment.urlshortner.service;

import org.springframework.stereotype.Service;
import com.neueda.java.assignment.urlshortner.Dto.UrlDTO;
import com.neueda.java.assignment.urlshortner.model.Url;

@Service
public interface UrlShortnerService {
	
	public Url generateShortUrl(UrlDTO urlDto);
	public Url saveShortUrl(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);

}
