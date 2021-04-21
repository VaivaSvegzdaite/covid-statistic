package com.vaivasvegzdaite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeeklyDataByCountry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String country;
	private String country_code;
	private String continent;
	private Long population;
	private String indicator;
	private Integer weekly_count;
	private String year_week;
	private String rate_14_day;
	private Integer cumulative_count;
	private String source;

	public WeeklyDataByCountry() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getContinent() {
		return continent;
	}

	public Long getPopulation() {
		return population;
	}

	public String getIndicator() {
		return indicator;
	}

	public Integer getWeekly_count() {
		return weekly_count;
	}

	public String getYear_week() {
		return year_week;
	}

	public String getRate_14_day() {
		return rate_14_day;
	}

	public Integer getCumulative_count() {
		return cumulative_count;
	}

	public String getSource() {
		return source;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public void setWeekly_count(Integer weekly_count) {
		this.weekly_count = weekly_count;
	}

	public void setYear_week(String year_week) {
		this.year_week = year_week;
	}

	public void setRate_14_day(String rate_14_day) {
		this.rate_14_day = rate_14_day;
	}

	public void setCumulative_count(Integer cumulative_count) {
		this.cumulative_count = cumulative_count;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
