package com.neueda.java.assignment.urlshortner.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neueda.java.assignment.urlshortner.Dto.StatisticsSummaryDTO;
import com.neueda.java.assignment.urlshortner.response.UrlErrorResponseForUser;
import com.neueda.java.assignment.urlshortner.service.StatisticService;


@RestController
public class StatisticController {
	Logger logger = LoggerFactory.getLogger(StatisticController.class);

	@Autowired
	private StatisticService service;

	@GetMapping(path = "/summary")
	public ResponseEntity<?> getSummary() {
		//logger.info(Constants.GETTING_STATISTICS_SUMMARY);

		StatisticsSummaryDTO summary = service.getStatisticsSummary();
		if(summary == null)
        {
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Summary does not exist or it might have expired!");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }
		return ResponseEntity.ok().body(summary);
	}
	
	@GetMapping(path = "/summary/{code}")
	public ResponseEntity<?> getSummaryByCode(@PathVariable String code) {
		if(StringUtils.isEmpty(code))
        {
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Url is invalid");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }
		
		if(code == null)
        {
            UrlErrorResponseForUser urlErrorResponseDto = new UrlErrorResponseForUser();
            urlErrorResponseDto.setErrorMessage("Url does not exist or it might have expired!");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponseForUser>(urlErrorResponseDto,HttpStatus.OK);
        }
		code = code.replaceAll("[\n|\r|\t]", "_");
		//logger.info(Constants.GETTING_STATISTICS_SUMMARY_BY_CODE, code);
		StatisticsSummaryDTO summary = service.getStatisticsSummaryByCode(code);
		return ResponseEntity.ok().body(summary);
	}


}