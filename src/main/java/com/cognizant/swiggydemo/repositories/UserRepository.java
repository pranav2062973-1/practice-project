package com.cognizant.swiggydemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.swiggydemo.entitites.UserRegister;

@Repository
public interface UserRepository extends JpaRepository<UserRegister, Integer> {

	
	public Optional<UserRegister> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
