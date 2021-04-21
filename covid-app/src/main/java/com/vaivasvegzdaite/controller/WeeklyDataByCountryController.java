package com.vaivasvegzdaite.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaivasvegzdaite.model.ChartWeekData;
import com.vaivasvegzdaite.model.WeeklyDataByCountry;
import com.vaivasvegzdaite.service.WeekleDataByCountryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "data")
@RequestMapping("/api/data")
public class WeeklyDataByCountryController {

	private WeekleDataByCountryService service;

	public WeeklyDataByCountryController(WeekleDataByCountryService service) {
		super();
		this.service = service;
	}

	@ApiOperation(value = "Get all data", notes = "Returns all data")
	@GetMapping(path = "/alldata")
	public Iterable<WeeklyDataByCountry> getAllData() {
		return service.findAllData();
	}

	@ApiOperation(value = "Get all countries", notes = "Returns all countries")
	@GetMapping(path = "/countries")
	public List<String> getAllCountries() {
		return service.getAllCountries();
	}

	@ApiOperation(value = "Get chart data by country", notes = "Returns chart data by country")
	@GetMapping(path = "/{country}")
	public ChartWeekData chartWeekData(@PathVariable("country") String country) {
		return service.chartWeekData(country);
	}

	@ApiOperation(value = "Get all chart data", notes = "Returns all chart data")
	@GetMapping(path = "/allcountriesdata")
	public ChartWeekData allChartWeekData() {
		return service.allChartWeekData();
	}

}
