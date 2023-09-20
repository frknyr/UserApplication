package com.example.userLogin.business.rules;

import org.springframework.stereotype.Service;

import com.example.userLogin.core.utilities.exceptions.BusinessException;
import com.example.userLogin.dataAccess.abstracts.CountryRepository;
import com.example.userLogin.dataAccess.abstracts.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserBusinessRules {
	
	private UserRepository userRepository;
	private CountryRepository countryRepository;
	
	public void checkIfIdIs(int id) {
		if(!this.userRepository.existsById(id)) {
			throw new BusinessException(id+ " id numarasına sahip kullanıcı bulunmuyor !");
		}
	}
	
	public void checkIfUsernameExists(String username){
		if(this.userRepository.existsByUsername(username)) {
			throw new BusinessException("Kullanıcı adı kullanılıyor !");
		}
	}
	
	public void checkIfUsernameIs(String username){
		if(!this.userRepository.existsByUsername(username)) {
			throw new BusinessException(username+ " kullanıcı adına sahip kullanıcı bulunmuyor !");
		}
	}
	
	public void checkIfPhoneNumberExists(String phoneNumber) {
		if(this.userRepository.existsByPhoneNumber(phoneNumber)) {
			throw new BusinessException("Telefon numarası kullanılıyor !");
		}
	}
	
	public void checkIfPhoneNumberIs(String phoneNumber) {
		if(!this.userRepository.existsByPhoneNumber(phoneNumber)) {
			throw new BusinessException("Bu telefon numarasına sahip kullanıcı bulunmuyor !");
		}
	}
	
	public void checkIfCountryIdExists(int countryId) {
		if(!this.countryRepository.existsById(countryId)) {
			throw new BusinessException(countryId + " id numarasına sahip ülke bulunmamaktadır");
		}
	}
	
}
