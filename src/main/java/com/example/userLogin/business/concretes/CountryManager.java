package com.example.userLogin.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.userLogin.business.abstracts.CountryService;
import com.example.userLogin.business.responses.country.GetAllCountriesResponse;
import com.example.userLogin.core.utilities.mappers.ModelMapperService;
import com.example.userLogin.dataAccess.abstracts.CountryRepository;
import com.example.userLogin.entities.concretes.Country;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService{
	
	private CountryRepository countryRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCountriesResponse> getAllCountriesResponses() {
		List<Country> countries=this.countryRepository.findAll();
		
		List<GetAllCountriesResponse> getAllCountriesResponses= countries.stream()
				.map(country-> this.modelMapperService.forResponse().map(country, GetAllCountriesResponse.class))
				.collect(Collectors.toList());
		
		return getAllCountriesResponses;
	}

}
