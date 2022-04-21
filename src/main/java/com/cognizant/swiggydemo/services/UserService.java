package com.cognizant.swiggydemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.swiggydemo.entitites.UserRegister;
import com.cognizant.swiggydemo.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	public UserRegister addNewUser(UserRegister user)
	{
		UserRegister savedUser = this.userRepo.save(user);
		return savedUser;
	}
	
	
	
	public UserRegister loginCheck(String email, String password)
	{
		Optional<UserRegister> user = this.userRepo.findByUserEmailAndUserPassword(email, password);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			return null;
		}
	}
}
