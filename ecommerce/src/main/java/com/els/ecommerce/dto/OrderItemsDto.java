package com.els.ecommerce.dto;

import com.els.ecommerce.entity.Orders;
import com.els.ecommerce.entity.Products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemsDto {

	private Long itemId;

	private Products productId;

	private int quantity;
	
	private Orders orderId;

}
