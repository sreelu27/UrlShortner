package com.neueda.java.assignment.urlshortner.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neueda.java.assignment.urlshortner.Dto.UrlDTO;
import com.neueda.java.assignment.urlshortner.model.Statistic;
import com.neueda.java.assignment.urlshortner.model.Url;
import com.neueda.java.assignment.urlshortner.response.UrlErrorResponseForUser;
import com.neueda.java.assignment.urlshortner.response.UrlResponseForUser;
import com.neueda.java.assignment.urlshortner.service.StatisticService;
import com.neueda.java.assignment.urlshortner.service.UrlShortnerService;

@RestController
public class UrlShortnerController {
	
	@Autowired
    private UrlShortnerService urlService;
	@Autowired
	private StatisticService statisticService;
	
	@PostMapping("/generate")
    public ResponseEntity<?> generateShortLink(@RequestBody UrlDTO urlDto)
    {
        Url urlToRet = urlService.generateShortUrl(urlDto);

        if(urlToRet != null)
        {
            UrlResponseForUser urlResponseDto = new UrlResponseForUser();
            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
            urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
            urlResponseDto.setShortUrl(urlToRet.getShortUrl());
            return new ResponseEntity<UrlResponseForUser>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setErrorMessage("There was an error processing your request. please try again.");
        return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);

    }
	
	@GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response, @RequestHeader Map<String, String> headersMap) throws IOException {

        if(StringUtils.isEmpty(shortLink))
        {
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Invalid Url");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }
        Url urlToRet = urlService.getEncodedUrl(shortLink);

        if(urlToRet == null)
        {
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Url does not exist or it might have expired!");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }

        if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now()))
        {
            urlService.deleteShortLink(urlToRet);
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Url Expired. Please try generating a fresh one.");
            urlErrorResponseDto.setStatus("200");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }

        Statistic statistic = statisticService.mapFrom(headersMap, urlToRet);
		statisticService.create(statistic);
        response.sendRedirect(urlToRet.getOriginalUrl());
        return null;
    }

}
