package com.flairstech.task.Controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flairstech.task.DTO.CityCountryLangDTO;
import com.flairstech.task.Services.CityCountryLangService;

@RestController
public class ServicesController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CityCountryLangService service;
	
	public ServicesController(CityCountryLangService service) {
		this.service = service ;
	}
	
	@GetMapping("/")
	public String home() {
		return "Hello Docker World ";
	}
	
	@RequestMapping(path="/{CountryCode}")
	public List<CityCountryLangDTO> getCountry(@PathVariable("CountryCode") String CountryCode) throws Exception {
        List<CityCountryLangDTO> list = service.findCitiesByCountryCode(CountryCode);
        if(list.size() == 0) {
        	throw new Exception("INVALID_COUNTRY_CODE");
        }
        return list;
	}

	
}
