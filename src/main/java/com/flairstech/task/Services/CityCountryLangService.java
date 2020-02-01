package com.flairstech.task.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flairstech.task.DTO.CityCountryLangDTO;
import com.flairstech.task.Interfaces.ICityCountryLangService;
import com.flairstech.task.Repositories.CityCountryLangRepository;
 
 
@Service
public class CityCountryLangService implements ICityCountryLangService {
	
	private CityCountryLangRepository repository ;
	
	@Autowired
    public CityCountryLangService(CityCountryLangRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public List<CityCountryLangDTO> findCitiesByCountryCode(String CountryCode) {
		List<CityCountryLangDTO> cities = repository.findCitiesByCountryCode(CountryCode);
		if(cities.size() > 0) {
            return cities;
        } else {
            return new ArrayList<CityCountryLangDTO>();
        }
	}
	
}
