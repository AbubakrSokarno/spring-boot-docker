package com.flairstech.task.Repositories;

import java.util.List;

import com.flairstech.task.DTO.CityCountryLangDTO;

public interface CityCountryLangRepository {
//	
//	@Query("SELECT city.name, country.continent , city.population, country.population, country.life_expectancy,country_language.language "
//			+ "FROM city "
//			+ "JOIN country ON city.country_code = country.code "
//			+ "JOIN country_language ON country_language.country_code = city.country_code WHERE city.country_code = '?1' ")
	List<CityCountryLangDTO> findCitiesByCountryCode(String CountryCode);
	
}