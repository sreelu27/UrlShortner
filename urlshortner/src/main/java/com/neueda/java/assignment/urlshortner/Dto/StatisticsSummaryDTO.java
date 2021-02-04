package com.neueda.java.assignment.urlshortner.Dto;

import java.util.List;

public class StatisticsSummaryDTO{

	private Long numberOfHits;
	private List<StatisticsDTO> browsers;
	private List<StatisticsDTO> devicesTypes;
	private List<StatisticsDTO> operatingSystems;

	public StatisticsSummaryDTO() {
	
	}

	public StatisticsSummaryDTO(Long numberOfHits, List<StatisticsDTO> browsers, List<StatisticsDTO> devicesTypes,
			List<StatisticsDTO> operatingSystems) {
		this.numberOfHits = numberOfHits;
		this.browsers = browsers;
		this.devicesTypes = devicesTypes;
		this.operatingSystems = operatingSystems;
	}

	public List<StatisticsDTO> getBrowsers() {
		return browsers;
	}

	public void setBrowsers(List<StatisticsDTO> browsers) {
		this.browsers = browsers;
	}

	public List<StatisticsDTO> getDevicesTypes() {
		return devicesTypes;
	}

	public void setDevicesTypes(List<StatisticsDTO> devicesTypes) {
		this.devicesTypes = devicesTypes;
	}

	public List<StatisticsDTO> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<StatisticsDTO> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public Long getNumberOfHits() {
		return numberOfHits;
	}

	public void setNumberOfHits(Long numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	@Override
	public String toString() {
		return "StatisticsSummaryDTO [numberOfHits=" + numberOfHits + ", browsers=" + browsers + ", devicesTypes="
				+ devicesTypes + ", operatingSystems=" + operatingSystems + "]";
	}
	
	
}
