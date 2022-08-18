package com.esl.ecommerce.dto;

import com.esl.ecommerce.entity.Orders;
import com.esl.ecommerce.entity.Products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemsDto {
	
	private Products productId;
	
	private int quantity;
	
	private Orders orderId;

}
