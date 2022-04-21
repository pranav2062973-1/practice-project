package com.cognizant.swiggydemo.entitites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OrderData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDataId;
	
	
	@Column
	private String itemName;
	
	@Column
	private int totalQuantity;
	
	@Column
	private String pickUpLocation;
	
	@Column
	private String deliveryLocation;
	
	@Column
	private int totalAmount;
	
	@Column
	private String userStatus;
	
	@Column
	private String hotelStatus;
	
	@Column
	private String partnerStatus;
}
