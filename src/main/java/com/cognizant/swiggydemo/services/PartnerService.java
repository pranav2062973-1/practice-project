package com.cognizant.swiggydemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.swiggydemo.entitites.PartnerRegister;
import com.cognizant.swiggydemo.repositories.PartnerRepository;

@Service
public class PartnerService {

	
	@Autowired
	private PartnerRepository partnerRepo;
	
	public PartnerRegister addNewPartner(PartnerRegister partner)
	{
		PartnerRegister savedPartner = this.partnerRepo.save(partner);
		return savedPartner;
	}
	
	
	
	public PartnerRegister loginCheck(String email, String password)
	{
		Optional<PartnerRegister> partner = this.partnerRepo.findByPartnerEmailAndPartnerPassword(email, password);
		if(partner.isPresent())
		{
			return partner.get();
		}
		else
		{
			return null;
		}
	}
	
}
