package com.cognizant.swiggydemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.swiggydemo.entitites.OrderData;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Integer> {

	public List<OrderData> findByUserStatus(String userStatus);
	
	public List<OrderData> findByHotelStatus(String hotelStatus);
	
	public List<OrderData> findByPartnerStatus(String partnerStatus);
	
}
