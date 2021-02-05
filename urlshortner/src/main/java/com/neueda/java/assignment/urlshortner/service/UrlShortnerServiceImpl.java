package com.neueda.java.assignment.urlshortner.service;

import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.neueda.java.assignment.urlshortner.Dto.UrlDTO;
import com.neueda.java.assignment.urlshortner.helper.Helper;
import com.neueda.java.assignment.urlshortner.helper.ShortenUrl;
import com.neueda.java.assignment.urlshortner.model.Url;
import com.neueda.java.assignment.urlshortner.repository.UrlRepository;


@Component
public class UrlShortnerServiceImpl implements UrlShortnerService {
	
	Logger logger = LoggerFactory.getLogger(UrlShortnerService.class);
	
	@Autowired
    private UrlRepository urlRepository;
	@Autowired
	private ShortenUrl shortenUrl;
	@Autowired
	private Helper helper;
	@Override
	public Url generateShortUrl(UrlDTO urlDto) {
		logger.info("Creating a short url");
		if(StringUtils.isNotEmpty(urlDto.getUrl())) {
			String encodedUrl = shortenUrl.shortenUrl(urlDto.getUrl());
			Url url = new Url();
			url.setCreationDate(LocalDateTime.now());
            url.setOriginalUrl(urlDto.getUrl());
            url.setShortUrl(encodedUrl);
            url.setExpirationDate(helper.getExpirationDate(urlDto.getExpiryDate(),url.getCreationDate()));
            Url urlToSave = saveShortUrl(url);

            if(urlToSave != null)
                return urlToSave;

            return null;
		}
		return null;
	}
	
	@Override
	public Url saveShortUrl(Url url) {
		logger.info("Persisting a short url");
		Url urltoSave = urlRepository.save(url);
        return  urltoSave;
	}

	@Override
	public Url getEncodedUrl(String url) {
		Url urlToEncode = urlRepository.findByShortUrl(url);
        return urlToEncode;
	}

	@Override
	public void deleteShortLink(Url url) {
		logger.info("Deleting short url");
		urlRepository.delete(url);
	}

}
