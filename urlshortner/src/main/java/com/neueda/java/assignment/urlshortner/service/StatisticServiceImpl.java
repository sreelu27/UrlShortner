package com.neueda.java.assignment.urlshortner.service;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.neueda.java.assignment.urlshortner.Dto.StatisticsSummaryDTO;
import com.neueda.java.assignment.urlshortner.model.Statistic;
import com.neueda.java.assignment.urlshortner.model.Url;
import com.neueda.java.assignment.urlshortner.repository.StatisticRepository;
import ua_parser.Client;
import ua_parser.Parser;

@Service
public class StatisticServiceImpl implements StatisticService{
	
	Logger logger = LoggerFactory.getLogger(StatisticService.class);

	@Autowired
	private StatisticRepository repository;

	public Statistic create(Statistic statistic) {
		logger.info("Creating a statistic: {0}", statistic);

		statistic.setId(null);
		return repository.save(statistic);
	}

	public Statistic mapFrom(Map<String, String> headers, Url url) {

		String userAgentString = headers.get(HttpHeaders.USER_AGENT.toLowerCase());

		userAgentString = userAgentString.replaceAll("[\n|\r|\t]", "_");

		logger.info("Mapping statistic from headers: {0}", userAgentString);

		Parser uaParser = new Parser();
		Client agent = uaParser.parse(userAgentString);
		String deviceType = agent.device.family;
		String browser = agent.userAgent.family;
		String operatingSystem = agent.os.family;

		return new Statistic(browser, deviceType, operatingSystem, url);
	}

	public StatisticsSummaryDTO getStatisticsSummary() {

		StatisticsSummaryDTO summaryDTO = new StatisticsSummaryDTO();
		summaryDTO.setNumberOfHits(repository.getNumberOfHits());
		summaryDTO.setBrowsers(repository.getBrowsers());
		summaryDTO.setDevicesTypes(repository.getDevicesTypes());
		summaryDTO.setOperatingSystems(repository.getOperatingSystems());

		return summaryDTO;
	}
	
	public StatisticsSummaryDTO getStatisticsSummaryByCode(String code) {

		code = code.replaceAll("[\n|\r|\t]", "_");

		StatisticsSummaryDTO summaryDTO = new StatisticsSummaryDTO();
		summaryDTO.setNumberOfHits(repository.getNumberOfHitsByCode(code));
		summaryDTO.setBrowsers(repository.getBrowsersByCode(code));
		summaryDTO.setDevicesTypes(repository.getDevicesTypesByCode(code));
		summaryDTO.setOperatingSystems(repository.getOperatingSystemsByCode(code));

		return summaryDTO;
	}

}
