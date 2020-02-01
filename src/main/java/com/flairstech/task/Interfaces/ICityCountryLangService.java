package com.flairstech.task.Interfaces;

import java.util.List;

import com.flairstech.task.DTO.CityCountryLangDTO;

public interface ICityCountryLangService {

    List<CityCountryLangDTO> findCitiesByCountryCode(String CountryCode);
    
}