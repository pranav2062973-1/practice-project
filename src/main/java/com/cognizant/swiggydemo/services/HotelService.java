package com.cognizant.swiggydemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.swiggydemo.entitites.HotelRegister;
import com.cognizant.swiggydemo.repositories.HotelRepository;

@Service
public class HotelService {

	
	@Autowired
	private HotelRepository hotelRepo;
	
	
	public HotelRegister addNewHotel(HotelRegister hotel)
	{
		HotelRegister savedHotel = this.hotelRepo.save(hotel);
		return savedHotel;
	}
	
	
	
	public HotelRegister loginCheck(String email, String password)
	{
		Optional<HotelRegister> hotel = this.hotelRepo.findByHotelEmailAndHotelPassword(email, password);
		if(hotel.isPresent())
		{
			return hotel.get();
		}
		else
		{
			return null;
		}
	}
	
}
