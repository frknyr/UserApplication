package com.example.userLogin.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userLogin.entities.concretes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	User findByNameAndSurname(String name,String surname);
	User findByPhoneNumber(String phoneNumber);
	
	List<User> findAllByGenderId(byte genderId);
	List<User> findAllByCountryIdIn(List<Integer> countriesId);
	List<User> findAllByCountryIdAndCityIdIn(int countryId, List<Integer> citiesId);
	List<User> findAllByActiveTrue();
	
	boolean existsByUsername(String username);
	boolean existsByPhoneNumber(String phoneNumber);
}
