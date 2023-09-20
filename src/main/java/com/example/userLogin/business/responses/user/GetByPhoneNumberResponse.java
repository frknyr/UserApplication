package com.example.userLogin.business.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByPhoneNumberResponse {
	
	private int id;
	private String name;
	private String surname;
	private String username;
	private String email;
	private String genderName;
	private String countryName;
	private String cityName;
	
}
