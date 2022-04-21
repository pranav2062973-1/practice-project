package com.cognizant.swiggydemo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.swiggydemo.entitites.PartnerRegister;

@Repository
public interface PartnerRepository extends JpaRepository<PartnerRegister, Integer> {

	public Optional<PartnerRegister> findByPartnerEmailAndPartnerPassword(String partnerEmail, String partnerPassword);
}
