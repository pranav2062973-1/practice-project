package com.cognizant.swiggydemo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.swiggydemo.entitites.OrderData;
import com.cognizant.swiggydemo.entitites.UserRegister;
import com.cognizant.swiggydemo.services.OrderService;
import com.cognizant.swiggydemo.services.UserService;

@RestController
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	

	@PostMapping("/UserRegister")
	public ModelAndView addNewUser(UserRegister userReg) {
		this.userService.addNewUser(userReg);
		return new ModelAndView("RegisterSuccess");
	}
	
	
	
	@PostMapping("/UserLogin")
	public ModelAndView userLogin(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password)
	{
		System.out.println("Email :- " + email + "   Password :- " + password);
		UserRegister user = this.userService.loginCheck(email, password);
		if(user != null)
		{
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);
			mv.setViewName("UserIndex");
			return mv;
		}
		else
		{
			return new ModelAndView("InvalidLogin");
		}
	}
	
	
	@PostMapping("/OrderFromUser")
	public ModelAndView calculateOrderFromUser(@RequestParam("quantity") Integer quantity, @RequestParam("address") String address)
	{
		Integer totalAmount = 200*quantity;
		/*
		 * OrderData order = new OrderData(); order.setItemName("Biryani");
		 * order.setTotalQuantity(quantity); order.setPickUpLocation("Hotel ABC");
		 * order.setDeliveryLocation(address); order.setTotalAmount(totalAmount);
		 * order.setUserStatus("Placed"); order.setHotelStatus("Received");
		 * order.setDeliveryLocation("Received");
		 * 
		 * this.orderService.addNewOrder(order);
		 */
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("amount", totalAmount);
		mv.addObject("quantity", quantity);
		mv.addObject("address", address);
		mv.setViewName("ConfirmOrder");
		return mv;
		//return new ModelAndView("OrderPlaced");
	}
	
	
	@PostMapping("/PlaceOrderFromUser")
	public ModelAndView placeOrder(@ModelAttribute OrderData order)
	{
		this.orderService.addNewOrder(order);
		return new ModelAndView("OrderPlaced");
	
	}
	
	
	
	@GetMapping("/UserTrackOrder")
	public ModelAndView getUserTrackOrderPage()
	{
		ModelAndView mv = new ModelAndView();
		List<OrderData> orderDataList = this.orderService.getUserLiveOrders();
		mv.addObject("TrackList", orderDataList);
		mv.setViewName("UserTrackOrder");
		return mv;
	}
	
	@GetMapping("/UserOrderHistory")
	public ModelAndView getUserOrderHistory()
	{
		ModelAndView mv = new ModelAndView();
		List<OrderData> orderDataList = this.orderService.getUserOrderHistory();
		mv.addObject("TrackList", orderDataList);
		mv.setViewName("UserOrderHistory");
		return mv;
	}
	
	
	@GetMapping("/UserIndex")
	public ModelAndView getUserIndexPage()
	{
		return new ModelAndView("UserIndex");
	}
}
