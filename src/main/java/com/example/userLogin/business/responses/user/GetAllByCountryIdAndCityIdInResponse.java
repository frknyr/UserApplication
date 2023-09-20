package com.example.userLogin.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllByCountryIdAndCityIdInResponse {
	
	private String name;
	private String surname;
	private String username;
	private String phoneNumber;
	private String email;
	private String genderName;
	
}
