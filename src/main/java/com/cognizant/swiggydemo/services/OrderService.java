package com.cognizant.swiggydemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.swiggydemo.entitites.OrderData;
import com.cognizant.swiggydemo.repositories.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepo;
	
	//---------------------user order----------------------
	public List<OrderData> getUserLiveOrders()
	{
		List<OrderData> userLiveOrders = this.orderRepo.findByPartnerStatus("Received");
		return userLiveOrders;
	}
	
	
	public List<OrderData> getUserOrderHistory()
	{
		List<OrderData> userOrderHistory = this.orderRepo.findByPartnerStatus("Delivered");
		return userOrderHistory;
	}
	
	
	
	
	//----------------------------------- hotel order---------------------------------
	public List<OrderData> getHotelReceivedOrders()
	{
		List<OrderData> hotelReceivedOrder = this.orderRepo.findByHotelStatus("Received");
		return hotelReceivedOrder;
	}
	
	
	
	public List<OrderData> getHotelOnlineOrders()
	{
		List<OrderData> hotelOnlineOrder = this.orderRepo.findByHotelStatus("Online");
		return hotelOnlineOrder;
	}
	
	
	public List<OrderData> getHotelOrderHistory()
	{
		List<OrderData> hotelOrderHistory = this.orderRepo.findByHotelStatus("Delivered");
		return hotelOrderHistory;
	}
	
	//---------------------------------- partner order --------------------------------------
	
	public List<OrderData> getPartnerReceivedOrders()
	{
		List<OrderData> partnerReceivedOrder = this.orderRepo.findByPartnerStatus("Received");
		return partnerReceivedOrder;
	}
	
	
	
	public List<OrderData> getPartnerOnlineOrders()
	{
		List<OrderData> partnerOnlineOrder = this.orderRepo.findByPartnerStatus("PickedUp");
		return partnerOnlineOrder;
	}
	
	
	public List<OrderData> getPartnerOrderHistory()
	{
		List<OrderData> partnerOrderHistory = this.orderRepo.findByPartnerStatus("Delivered");
		return partnerOrderHistory;
	}
	
	
	//------------------------------------ Orders ----------------------------------------
	
	public void addNewOrder(OrderData order)
	{
		this.orderRepo.save(order);
	}
	
	
	
	//=-----------------------------------update----------------------------------------
	
	
	public void acceptHotelStatus(int orderId)
	{
		OrderData oldOrder = this.orderRepo.findById(orderId).get();
		this.orderRepo.deleteById(orderId);
		OrderData newOrder = new OrderData(orderId, oldOrder.getItemName(), oldOrder.getTotalQuantity(),
				oldOrder.getPickUpLocation(), oldOrder.getDeliveryLocation(), oldOrder.getTotalAmount(),
				oldOrder.getUserStatus(), "Online", oldOrder.getPartnerStatus());
		
		this.orderRepo.save(newOrder);		
	}
	
	
	public void acceptPartnerStatus(int orderId)
	{
		OrderData oldOrder = this.orderRepo.findById(orderId).get();
		this.orderRepo.deleteById(orderId);
		OrderData newOrder = new OrderData(orderId, oldOrder.getItemName(), oldOrder.getTotalQuantity(),
				oldOrder.getPickUpLocation(), oldOrder.getDeliveryLocation(), oldOrder.getTotalAmount(),
				oldOrder.getUserStatus(), oldOrder.getHotelStatus(), "PickedUp");
		
		this.orderRepo.save(newOrder);		
	}
	
	
	public void completeHotelStatus(int orderId)
	{
		OrderData oldOrder = this.orderRepo.findById(orderId).get();
		this.orderRepo.deleteById(orderId);
		OrderData newOrder = new OrderData(orderId, oldOrder.getItemName(), oldOrder.getTotalQuantity(),
				oldOrder.getPickUpLocation(), oldOrder.getDeliveryLocation(), oldOrder.getTotalAmount(),
				oldOrder.getUserStatus(), "Delivered", oldOrder.getPartnerStatus());
		
		this.orderRepo.save(newOrder);		
	}

	
	public void completePartnerStatus(int orderId)
	{
		OrderData oldOrder = this.orderRepo.findById(orderId).get();
		this.orderRepo.deleteById(orderId);
		OrderData newOrder = new OrderData(orderId, oldOrder.getItemName(), oldOrder.getTotalQuantity(),
				oldOrder.getPickUpLocation(), oldOrder.getDeliveryLocation(), oldOrder.getTotalAmount(),
				oldOrder.getUserStatus(), oldOrder.getHotelStatus(), "Delivered");
		
		this.orderRepo.save(newOrder);		
	}
	
	

	public void rejectHotelStatus(int orderId) {
		this.orderRepo.deleteById(orderId);
	}
	
	
	public void rejectPartnerStatus(int orderId) {
		this.orderRepo.deleteById(orderId);
	}
}
