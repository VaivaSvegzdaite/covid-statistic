package com.vaivasvegzdaite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vaivasvegzdaite.model.WeeklyDataByCountry;

public interface WeeklyDataByCountryRepository extends JpaRepository<WeeklyDataByCountry, Long> {

	@Query("SELECT DISTINCT c.country FROM WeeklyDataByCountry c")
	List<String> getAllCountries();

	@Query("SELECT c.weekly_count FROM WeeklyDataByCountry c WHERE c.indicator = 'cases' AND c.country = :country")
	List<Integer> getAllCasesByCountry(String country);

	@Query("SELECT c.weekly_count FROM WeeklyDataByCountry c WHERE c.indicator = 'deaths' AND c.country = :country")
	List<Integer> getAllDeathsByCountry(String country);

	@Query("SELECT DISTINCT c.year_week FROM WeeklyDataByCountry c WHERE c.country = :country")
	List<String> getAllWeeksByCountry(String country);

	@Query("SELECT DISTINCT c.year_week FROM WeeklyDataByCountry c")
	List<String> getAllWeeks();

	@Query("SELECT SUM(c.weekly_count) FROM WeeklyDataByCountry c WHERE c.indicator = 'cases' GROUP BY c.year_week")
	List<Integer> getAllCases();

	@Query("SELECT SUM(c.weekly_count) FROM WeeklyDataByCountry c WHERE c.indicator = 'deaths' GROUP BY c.year_week")
	List<Integer> getAllDeaths();

}
