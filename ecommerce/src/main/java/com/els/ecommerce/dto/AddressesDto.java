package com.els.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressesDto {

	private String street;
	
	private String unit;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipcode;
	
}
