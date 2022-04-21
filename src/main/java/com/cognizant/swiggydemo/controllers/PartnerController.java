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

import com.cognizant.swiggydemo.entitites.OrderData;
import com.cognizant.swiggydemo.entitites.PartnerRegister;
import com.cognizant.swiggydemo.services.OrderService;
import com.cognizant.swiggydemo.services.PartnerService;

@RestController
public class PartnerController {

	
	@Autowired
	private PartnerService partnerService;
	
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/PartnerRegister")
	public ModelAndView addNewUser(PartnerRegister partner) {
		this.partnerService.addNewPartner(partner);
		return new ModelAndView("RegisterSuccess");
	}
	
	
	
	@PostMapping("/PartnerLogin")
	public ModelAndView userLogin(@RequestParam("partnerEmail") String email, @RequestParam("partnerPassword") String password)
	{
		System.out.println("Email :- " + email + "   Password :- " + password);
		List<OrderData> partnerOrders = this.orderService.getPartnerReceivedOrders();
		PartnerRegister partner = this.partnerService.loginCheck(email, password);
		if(partner != null)
		{
			ModelAndView mv = new ModelAndView();
			mv.addObject("partnerOrders", partnerOrders);
			mv.setViewName("PartnerIndex");
			return mv;
		}
		else
		{
			return new ModelAndView("InvalidLogin");
		}
	}
	
	
	@GetMapping("/PartnerIndex")
	public ModelAndView getPartnerIndexPage()
	{
		List<OrderData> partnerOrders = this.orderService.getPartnerReceivedOrders();
		ModelAndView mv = new ModelAndView();
		mv.addObject("partnerOrders", partnerOrders);
		mv.setViewName("PartnerIndex");
		return mv;
	}
	
	
	@GetMapping("/OngoingOrder")
	public ModelAndView getOngoingOrderPage()
	{
		List<OrderData> partnerOrders = this.orderService.getPartnerOnlineOrders();
		ModelAndView mv = new ModelAndView();
		mv.addObject("partnerOrders", partnerOrders);
		mv.setViewName("OngoingOrder");
		return mv;
	}
	
	
	@GetMapping("/PartnerHistory")
	public ModelAndView getPartnerHistoryPage()
	{
		List<OrderData> partnerOrders = this.orderService.getPartnerOrderHistory();
		ModelAndView mv = new ModelAndView();
		mv.addObject("partnerOrders", partnerOrders);
		mv.setViewName("PartnerHistory");
		return mv;
	}
	
	
	@GetMapping("/PartnerAccept/{orderId}")
	public RedirectView hotelAcceptOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.acceptPartnerStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/PartnerIndex");
		return rv;
	}
	
	
	@GetMapping("/PartnerReject/{orderId}")
	public RedirectView hotelRejectOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.rejectPartnerStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/PartnerIndex");
		return rv;
	}
	
	@GetMapping("/PartnerComplete/{orderId}")
	public RedirectView hotelCompleteOrder(@PathVariable("orderId") int orderId)
	{
		this.orderService.completePartnerStatus(orderId);
		RedirectView rv = new RedirectView();
		rv.setUrl("/OngoingOrder");
		return rv;
	}
	
	
}
