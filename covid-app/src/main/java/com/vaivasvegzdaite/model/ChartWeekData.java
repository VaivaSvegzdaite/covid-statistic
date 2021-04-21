package com.vaivasvegzdaite.model;

import java.util.List;

public class ChartWeekData {

	private List<String> year_weeks;
	private List<Integer> cases_week;
	private List<Integer> deaths_week;

	public ChartWeekData() {
		super();
	}

	public List<String> getYear_weeks() {
		return year_weeks;
	}

	public List<Integer> getCases_week() {
		return cases_week;
	}

	public List<Integer> getDeaths_week() {
		return deaths_week;
	}

	public void setYear_weeks(List<String> year_weeks) {
		this.year_weeks = year_weeks;
	}

	public void setCases_week(List<Integer> cases_week) {
		this.cases_week = cases_week;
	}

	public void setDeaths_week(List<Integer> deaths_week) {
		this.deaths_week = deaths_week;
	}

}
