package com.example.userLogin.business.abstracts;

import java.util.List;

import com.example.userLogin.business.responses.country.GetAllCountriesResponse;

public interface CountryService{
	List<GetAllCountriesResponse> getAllCountriesResponses();
}
