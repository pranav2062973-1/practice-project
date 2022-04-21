package com.cognizant.swiggydemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cognizant.swiggydemo.entitites.HotelRegister;
import com.cognizant.swiggydemo.entitites.OrderData;
import com.cognizant.swiggydemo.services.HotelService;
import com.cognizant.swiggydemo.services.OrderService;

@RestController
public class HotelController {

	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/HotelRegister")
	public ModelAndView addNewHotel(HotelRegister hotel) {
		this.hotelService.addNewHotel(hotel);
		return new ModelAndView("RegisterSuccess");
	}
	
	
	
	@PostMapping("/HotelLogin")
	public ModelAndView userLogin(@RequestParam("hotelEmail") String email, @RequestParam("hotelPassword") String password)
	{
		System.out.println("Email :- " + email + "   Password :- " + password);
		HotelRegister hotel = this.hotelService.loginCheck(email, password);
		List<OrderData> hotelOrders = this.orderService.getHotelReceivedOrders();
		if(hotel != null)
		{
			ModelAndView mv = new ModelAndView();
			mv.addObject("hotelList", hotelOrders);
			mv.setViewName("HotelIndex");
			return mv;
		}
		else
		{
			return new ModelAndView("InvalidLogin");
		}
	}
	
	
	
	@GetMapping("/HotelIndex")
	public ModelAndView getHotelIndexPage()
	{
		List<OrderData> hotelOrders = this.orderService.getHotelReceivedOrders();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelList", hotelOrders);
		mv.setViewName("HotelIndex");
		return mv;
	}
	
	
	@GetMapping("/LiveOrders")
	public ModelAndView getHotelLiveOrderPage()
	{
		List<OrderData> hotelLiveOrders = this.orderService.getHotelOnlineOrders();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelList", hotelLiveOrders);
		mv.setViewName("LiveOrders");
		return mv;
	}
	
	
	
	@GetMapping("/HotelHistory")
	public ModelAndView getHotelHistoryPage()
	{
		List<OrderData> hotelLiveOrders = this.orderService.getHotelOrderHistory();
		ModelAndView mv = new ModelAndView();
		mv.addObject("hotelList", hotelLiveOrders);
		mv.setViewName("HotelHistory");
		return mv;
	}
	
	
	
	@GetMapping("/HotelAccept/{orderId}")
	public RedirectView hotelAcceptOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.acceptHotelStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/HotelIndex");
		return rv;
	}
	
	
	@GetMapping("/HotelReject/{orderId}")
	public RedirectView hotelRejectOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.rejectHotelStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/HotelIndex");
		return rv;
	}
	
	
	@GetMapping("/HotelComplete/{orderId}")
	public RedirectView hotelCompleteOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.completeHotelStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/LiveOrders");
		return rv;
	}
}
