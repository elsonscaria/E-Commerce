package com.esl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsDto {
	
	private String productName;

	private float unitPrice;

	private int productStock;

	private String productImage;

	private String productDescription;


}
