package com.cognizant.swiggydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DisplayPageController {

	
	@GetMapping("/UserHome")
	public ModelAndView getUserHomePage()
	{
		return new ModelAndView("UserHome");
	}
	
	
	@GetMapping("/HotelHome")
	public ModelAndView getHotelHomePage()
	{
		return new ModelAndView("HotelHome");
	}
	
	
	@GetMapping("/PartnerHome")
	public ModelAndView getDeliveryHomePage()
	{
		return new ModelAndView("PartnerHome");
	}
	
	@GetMapping("/HotelMenu")
	public ModelAndView getHotelMenuPage()
	{
		return new ModelAndView("HotelMenu");
	}
	
	
	@GetMapping("/ViewItem")
	public ModelAndView getViewItemPage()
	{
		return new ModelAndView("ViewItem");
	}
	
	@GetMapping("/ConfirmOrder")
	public ModelAndView getConfirmOrderPage()
	{
		return new ModelAndView("ConfirmOrder");
	}
	
	
	
	@GetMapping("/OrderPlaced")
	public ModelAndView getOrderPlacedPage()
	{
		return new ModelAndView("OrderPlaced");
	}
	

	
	
	@GetMapping("/")
	public ModelAndView getIndexPage()
	{
		return new ModelAndView("Index");
	}
}
