package com.els.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.els.ecommerce.dto.ProductsDto;
import com.els.ecommerce.entity.Products;
import com.els.ecommerce.service.ProductsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductsController {

	@Autowired
	ProductsService productsService;

	// Adding Products
	@PostMapping("/product/add")
	public Products addProducts(@RequestBody ProductsDto productsDto) {
		return productsService.addProducts(productsDto);
	}

	// Displaying products
	@GetMapping("/product/read/{productId}")
	public Products getProducts(@PathVariable Long productId) {
		return productsService.getProducts(productId);
	}

	// updating products
	@PostMapping("/product/update/{productId}")
	public Products updateProducts(@PathVariable Long productId, @RequestBody ProductsDto productsDto ) { 
		return productsService.updateProducts(productId, productsDto); 
	}

	// deleting records
	@DeleteMapping("/product/delete/{productId}")
	public String deleteproducts(@PathVariable Long productId) {
		productsService.deleteproducts(productId);
		return "Product Deleted";
	}

}
