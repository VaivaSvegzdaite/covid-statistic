package com.vaivasvegzdaite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaivasvegzdaite.model.ChartWeekData;
import com.vaivasvegzdaite.model.WeeklyDataByCountry;
import com.vaivasvegzdaite.repository.WeeklyDataByCountryRepository;

@Service
public class WeekleDataByCountryService {

	private WeeklyDataByCountryRepository repository;

	public WeekleDataByCountryService(WeeklyDataByCountryRepository repository) {
		super();
		this.repository = repository;
	}

	public Iterable<WeeklyDataByCountry> findAllData() {
		return repository.findAll();
	}

	public void save(List<WeeklyDataByCountry> allData) {
		repository.saveAll(allData);
	}

	public void save(WeeklyDataByCountry data) {
		repository.save(data);
	}

	public List<String> getAllCountries() {
		return repository.getAllCountries();
	}

	public ChartWeekData chartWeekData(String country) {
		var cwd = new ChartWeekData();
		cwd.setYear_weeks(repository.getAllWeeksByCountry(country));
		cwd.setCases_week(repository.getAllCasesByCountry(country));
		cwd.setDeaths_week(repository.getAllDeathsByCountry(country));
		return cwd;
	}

	public ChartWeekData allChartWeekData() {
		var acwd = new ChartWeekData();
		acwd.setYear_weeks(repository.getAllWeeks());
		acwd.setCases_week(repository.getAllCases());
		acwd.setDeaths_week(repository.getAllDeaths());
		return acwd;
	}

}
