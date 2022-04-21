package com.cognizant.swiggydemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.swiggydemo.entitites.HotelRegister;


@Repository
public interface HotelRepository extends JpaRepository<HotelRegister, Integer> {

	public Optional<HotelRegister> findByHotelEmailAndHotelPassword(String hotelEmail, String hotelPassword);
}
