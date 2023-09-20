package com.example.userLogin.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userLogin.business.abstracts.CountryService;
import com.example.userLogin.business.responses.country.GetAllCountriesResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {
	
	private CountryService countryService;
	
	@GetMapping("/getAllCountries")
	public List<GetAllCountriesResponse> getAllCountriesResponses(){
		return this.countryService.getAllCountriesResponses();
	}
}
