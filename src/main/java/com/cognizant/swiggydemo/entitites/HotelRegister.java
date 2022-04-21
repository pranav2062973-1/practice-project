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
public class HotelRegister {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;
	
	@Column
	private String hotelName;
	
	@Column(unique = true)
	private String hotelEmail;
	
	@Column
	private String hotelPassword;
	
	
}
