package com.esl.ecommerce.service;

import java.util.List;

import com.esl.ecommerce.dto.ProductsDto;
import com.esl.ecommerce.entity.Products;

public interface ProductsService {

	Products addProducts(ProductsDto productsDto);
	
	Products updateProducts(Long productId, ProductsDto productsDto);

	void deleteproducts(Long productId);

	List<Products> getAllProducts();

}
