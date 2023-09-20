package com.example.userLogin.business.abstracts;

import java.util.List;

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

public interface UserService {
	
	void add(CreateUserRequest createUserRequest);
	void delete(int id);
	void update(UpdateUserRequest updateUserRequest);
	
	GetByIdUserResponse getById(int id);
	GetByUsernameResponse getByUsername(String username);
	GetByNameAndSurnameResponse getByNameAndSurname(String name, String surname);
	GetByPhoneNumberResponse getByPhoneNumberResponse(String phoneNumber);
	
	List<GetAllByActiveTrueResponse> getAllByActiveTrueResponse();
	List<GetAllUsersResponse> getAll();
	List<GetAllByGenderIdResponse> getAllByGenderId(byte id);
	List<GetAllByCountryIdInResponse> getAllByCountryIdIn(List<Integer> id);
	List<GetAllByCountryIdAndCityIdInResponse> getAllByCountryIdAndCityIdIn(int countryId, List<Integer> citiesId);
	
	
}
