package com.neueda.java.assignment.urlshortner.service;

import java.util.Map;

import com.neueda.java.assignment.urlshortner.Dto.StatisticsSummaryDTO;
import com.neueda.java.assignment.urlshortner.model.Statistic;
import com.neueda.java.assignment.urlshortner.model.Url;

public interface StatisticService {

	public Statistic create(Statistic statistic);
	public Statistic mapFrom(Map<String, String> headers, Url url);
	public StatisticsSummaryDTO getStatisticsSummary();
	public StatisticsSummaryDTO getStatisticsSummaryByCode(String code);

}
