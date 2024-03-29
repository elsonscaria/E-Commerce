package com.esl.ecommerce.dto;

import java.util.Date;

import com.esl.ecommerce.entity.Addresses;
import com.esl.ecommerce.entity.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersDto {
	
	private Users userId;

	private Date orderDate;

	private String orderTotal;

	private Addresses shippingAddressId;

	private Addresses billingAddressId;

	private String orderStatus;
}
