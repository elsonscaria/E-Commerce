package com.els.ecommerce.service;

import com.els.ecommerce.dto.ProductsDto;
import com.els.ecommerce.entity.Products;

public interface ProductsService {

	Products addProducts(ProductsDto productsDto);

	Products getProducts(Long getProducts);

	void deleteproducts(Long productsId);

	Products updateProducts(Long userId, ProductsDto productsDto);

}
