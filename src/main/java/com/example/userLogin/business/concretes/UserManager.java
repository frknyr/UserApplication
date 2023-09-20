package com.example.userLogin.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
import com.example.userLogin.business.rules.UserBusinessRules;
import com.example.userLogin.core.utilities.mappers.ModelMapperService;
import com.example.userLogin.dataAccess.abstracts.UserRepository;
import com.example.userLogin.entities.concretes.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	
	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;

	@Override
	public void add(CreateUserRequest createUserRequest) {
		
		this.userBusinessRules.checkIfUsernameExists(createUserRequest.getUsername());
		this.userBusinessRules.checkIfPhoneNumberExists(createUserRequest.getPhoneNumber());
		this.userBusinessRules.checkIfCountryIdExists(createUserRequest.getCountryId());
		
		User user= modelMapperService.forRequest()
				.map(createUserRequest, User.class);
		
		this.userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		this.userBusinessRules.checkIfIdIs(id);
		
		this.userRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		
		this.userBusinessRules.checkIfUsernameExists(updateUserRequest.getUsername());
		this.userBusinessRules.checkIfPhoneNumberExists(updateUserRequest.getPhoneNumber());
		
		User user=this.modelMapperService.forRequest()
				.map(updateUserRequest, User.class);
		
		this.userRepository.save(user);
		
	}

	@Override
	public GetByIdUserResponse getById(int id) {
		this.userBusinessRules.checkIfIdIs(id);
		
		User user= this.userRepository.findById(id).orElseThrow();
		
		GetByIdUserResponse getByIdUserResponse= this.modelMapperService.forResponse()
				.map(user, GetByIdUserResponse.class);
		
		return getByIdUserResponse;
	}
	
	@Override
	public List<GetAllUsersResponse> getAll() {
		
		List<User> users=this.userRepository.findAll();
		
		List<GetAllUsersResponse> getAll= users.stream()
				.map(user-> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());
		
		return getAll;
	}

	@Override
	public List<GetAllByGenderIdResponse> getAllByGenderId(byte id) {
		List<User> getAllByGenderId= this.userRepository.findAllByGenderId(id);
		
		List<GetAllByGenderIdResponse> getAll=getAllByGenderId.stream()
				.map(user-> this.modelMapperService.forResponse().map(user, GetAllByGenderIdResponse.class))
				.collect(Collectors.toList());
		
		return getAll;
	}
	

	@Override
	public List<GetAllByCountryIdInResponse> getAllByCountryIdIn(List<Integer> countriesId) {
		List<User> getAllByCountryId= this.userRepository.findAllByCountryIdIn(countriesId);
		
		List<GetAllByCountryIdInResponse> getAll= getAllByCountryId.stream()
				.map(user-> this.modelMapperService.forResponse().map(user,GetAllByCountryIdInResponse.class))
				.collect(Collectors.toList());
		
		return getAll;
	}

	@Override
	public List<GetAllByCountryIdAndCityIdInResponse> getAllByCountryIdAndCityIdIn(int countryId, List<Integer> cities) { 
		
		List<User> getAllByCountryIdAndCityId=this.userRepository.findAllByCountryIdAndCityIdIn(countryId, cities);
		
		List<GetAllByCountryIdAndCityIdInResponse> getAll= getAllByCountryIdAndCityId.stream()
				.map(user-> this.modelMapperService.forResponse().map(user, GetAllByCountryIdAndCityIdInResponse.class))
				.collect(Collectors.toList());
		
		return getAll;
	}

	@Override
	public GetByUsernameResponse getByUsername(String username) {
		this.userBusinessRules.checkIfUsernameIs(username);
		
		User user= this.userRepository.findByUsername(username);
		
		GetByUsernameResponse byUsernameResponse= this.modelMapperService.forResponse().map(user, GetByUsernameResponse.class);
		
		return byUsernameResponse;
	}

	@Override
	public GetByNameAndSurnameResponse getByNameAndSurname(String name, String surname) {
		User user= this.userRepository.findByNameAndSurname(name, surname);
		
		GetByNameAndSurnameResponse getByNameAndSurnameResponse= this.modelMapperService.forResponse()
				.map(user, GetByNameAndSurnameResponse.class);
		
		return getByNameAndSurnameResponse;
	}

	@Override
	public GetByPhoneNumberResponse getByPhoneNumberResponse(String phoneNumber) {
		this.userBusinessRules.checkIfPhoneNumberIs(phoneNumber);
		
		User user= this.userRepository.findByPhoneNumber(phoneNumber);
		
		GetByPhoneNumberResponse getByPhoneNumberResponse= this.modelMapperService.forResponse()
				.map(user, GetByPhoneNumberResponse.class);
		
		return getByPhoneNumberResponse;
	}

	@Override
	public List<GetAllByActiveTrueResponse> getAllByActiveTrueResponse() {
		List<User> users= this.userRepository.findAllByActiveTrue();
		
		List<GetAllByActiveTrueResponse> activeTrueResponses= users.stream()
				.map(user-> this.modelMapperService.forResponse().map(user, GetAllByActiveTrueResponse.class ))
				.collect(Collectors.toList());
		
		return activeTrueResponses;
	}

	
	
}
