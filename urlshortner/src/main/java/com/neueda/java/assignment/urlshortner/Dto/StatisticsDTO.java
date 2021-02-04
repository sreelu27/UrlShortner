package com.neueda.java.assignment.urlshortner.Dto;

import java.io.Serializable;

public class StatisticsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Long total;
	
	public StatisticsDTO() {
		
	}

	public StatisticsDTO(String name, Long total) {
		super();
		this.name = name;
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "StatisticsDTO [name=" + name + ", total=" + total + "]";
	}

}
