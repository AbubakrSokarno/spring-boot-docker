package com.flairstech.task.world;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.flairstech.task.Controllers.ServicesController;
import com.flairstech.task.DTO.CityCountryLangDTO;
import com.flairstech.task.Services.CityCountryLangService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ServicesController.class)
public class ServicesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CityCountryLangService service;

	CityCountryLangDTO citydto = new CityCountryLangDTO("Bahrain", "Asia", 617000, 73, "Arabic");

	String expectedCityJson = "{\r\n" + "    \"timestamp\": \"2020-02-01T20:17:45.215+0000\",\r\n"
			+ "    \"status\": 500,\r\n" + "    \"error\": \"Internal Server Error\",\r\n"
			+ "    \"message\": \"INVALID_COUNTRY_CODE\",\r\n" + "    \"path\": \"/BHRa\"\r\n" + "}";

	@SuppressWarnings("unchecked")
	@Test
	public void retrieveDetailsForCity() throws Exception {

		Mockito.when(service.findCitiesByCountryCode("BHRaaa")).thenReturn((List<CityCountryLangDTO>) citydto);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BHRaaa").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(expectedCityJson, result.getResponse().getContentAsString(), false);
	}

}
