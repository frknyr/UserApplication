package com.example.userLogin.webApi.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.userLogin.business.abstracts.UserService;
import com.example.userLogin.business.request.CreateUserRequest;
import com.example.userLogin.business.request.UpdateUserRequest;
import com.example.userLogin.business.responses.user.GetAllByActiveTrueResponse;
import com.example.userLogin.business.responses.user.GetAllByCountryIdAndCityIdInResponse;
import com.example.userLogin.business.responses.user.GetAllByCountryIdInResponse;
import com.example.userLogin.business.responses.user.GetAllByGenderIdResponse;
import com.example.userLogin.business.responses.user.GetAllUsersResponse;
import com.example.userLogin.business.responses.user.GetByIdUserResponse;
import com.example.userLogin.business.responses.user.GetByNameAndSurnameResponse;
import com.example.userLogin.business.responses.user.GetByPhoneNumberResponse;
import com.example.userLogin.business.responses.user.GetByUsernameResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
	
	private UserService userService;
	
	@PostMapping("/createUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void delete(@PathVariable int id) {
		this.userService.delete(id);
	}
	
	@PutMapping("/updateUser")
	public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
		this.userService.update(updateUserRequest);
	}
	
	@GetMapping("/getByIdUser/{id}")
	public GetByIdUserResponse getByIdUserResponse(@PathVariable int id) {
		return this.userService.getById(id);
	}
	
	@GetMapping("/getByUsername/{username}")
	public GetByUsernameResponse getByUsernameResponse(@PathVariable @Size(min = 3,max = 10) String username) {
		return this.userService.getByUsername(username);
	}
	
	@GetMapping("/getByNameAndSurname/{name}/{surname}")
	public GetByNameAndSurnameResponse getByNameAndSurnameResponse(@PathVariable String name,@PathVariable String surname) {
		return this.userService.getByNameAndSurname(name, surname);
	}
	
	@GetMapping("/getByPhoneNumber/{phoneNumber}")
	public GetByPhoneNumberResponse getByPhoneNumberResponse(@PathVariable @Size(min = 11,max = 11) String phoneNumber){
		return this.userService.getByPhoneNumberResponse(phoneNumber);
	}
	
	@GetMapping("/getAllUsers")
	public List<GetAllUsersResponse> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/getAllByGenderId/{id}")
	public List<GetAllByGenderIdResponse> getAllByGenderId(@PathVariable byte id){
		return this.userService.getAllByGenderId(id);
	}
	
	@GetMapping("/getAllByCountryIdIn/{countriesId}")
	public List<GetAllByCountryIdInResponse> getAllByCountryIdIn(@PathVariable List<Integer> countriesId){
		return this.userService.getAllByCountryIdIn(countriesId);
	}
	
	@GetMapping("/getAllByCountryIdAndCityIdIn/{countryId}/{citiesId}")
	public List<GetAllByCountryIdAndCityIdInResponse> getAllByCountryIdAndCityIdIn(@PathVariable int countryId,@PathVariable List<Integer> citiesId){
		return this.userService.getAllByCountryIdAndCityIdIn(countryId, citiesId);
	}
	
	@GetMapping("/getAllByActiveTrue")
	public List<GetAllByActiveTrueResponse> getAllByActiveTrueResponses(){
		return this.userService.getAllByActiveTrueResponse();
	}
}
