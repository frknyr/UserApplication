package com.example.userLogin.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userLogin.entities.concretes.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Byte>{
	
	boolean existsById(int id);
	
}
