package com.esl.ecommerce.dto;

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

		public Object getMailingAddress() {
			this.street=street;
			this.unit;
			this.city;
			this.state;
			this.country;
			this.zipcode;
		
}
