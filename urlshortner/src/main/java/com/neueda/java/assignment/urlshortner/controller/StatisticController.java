package com.neueda.java.assignment.urlshortner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.neueda.java.assignment.urlshortner.Dto.StatisticsSummaryDTO;
import com.neueda.java.assignment.urlshortner.service.StatisticService;


@RestController
public class StatisticController {
	Logger logger = LoggerFactory.getLogger(StatisticController.class);

	@Autowired
	private StatisticService service;

	@GetMapping(path = "/summary")
	public ResponseEntity<?> getSummary() {
		logger.info("Getting all statistics ....");

		StatisticsSummaryDTO summary = service.getStatisticsSummary();
		return ResponseEntity.ok().body(summary);
	}
	
	@GetMapping(path = "/summary/{code}")
	public ResponseEntity<?> getSummaryByCode(@PathVariable String code) {
        	code = code.replaceAll("[\n|\r|\t]", "_");
    		logger.info("Getting all statistics for "+ code);
    		StatisticsSummaryDTO summary = service.getStatisticsSummaryByCode(code);
    		return ResponseEntity.ok().body(summary);
		
	}

}