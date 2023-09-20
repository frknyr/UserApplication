package com.example.userLogin.business.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 40)
	private String name;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 40)
	private String surname;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 10)
	private String username;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 20)
	private String password;
	
	@NotNull
	@NotBlank
	@Size(min = 11, max = 11)
	private String phoneNumber;
	
	@NotNull
	@NotBlank
	private byte genderId;
	
	@NotNull
	@NotBlank
	private int countryId;
	
	@NotNull
	@NotBlank
	private int cityId;
	
}
