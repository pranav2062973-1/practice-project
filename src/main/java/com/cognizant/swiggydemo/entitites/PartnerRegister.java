package com.cognizant.swiggydemo.entitites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PartnerRegister {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int partnerId;
	
	@Column
	private String partnerName;
	
	@Column(unique = true)
	private String partnerEmail;
	
	@Column
	private String partnerPassword;
	
	
}
