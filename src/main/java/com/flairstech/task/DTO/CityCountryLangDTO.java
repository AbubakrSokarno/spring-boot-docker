package com.flairstech.task.DTO;

public class CityCountryLangDTO {
	
    private String name;
    
    private String continent ;
    
    private long population ;

    private float life_expectancy; 
    
    private String country_language ;
    
    public CityCountryLangDTO() { }
    
    public CityCountryLangDTO(String name, String continent , long population , float lifeExpectancy , String countryLanguage) {
        this.continent = continent ;
        this.name = name;
        this.population = population ;
        this.life_expectancy = lifeExpectancy ;
        this.country_language = countryLanguage ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public float getLifeExpectancy() {
		return life_expectancy;
	}

	public void setLifeExpectancy(float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public String getCountryLanguage() {
		return country_language;
	}

	public void setCountryLanguage(String country_language) {
		this.country_language = country_language;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
}
