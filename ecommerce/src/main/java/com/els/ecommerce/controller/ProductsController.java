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
	@PostMapping("/products/add")
	public Products addProducts(@RequestBody ProductsDto productsDto) {
		return productsService.addProducts(productsDto);
	}

	// Displaying products
	@GetMapping("/products/read/{productsId}")
	public Products getProducts(@PathVariable Long productsId) {
		return productsService.getProducts(productsId);
	}

	// updating products
	/*
	 * @PostMapping("/products/update/{userId}") public Products
	 * updateProducts(@PathVariable Long userId, @RequestParam int ) { return
	 * productsService.updateProducts(userId, ); }
	 */

	// deleting records
	@DeleteMapping("/products/delete/{productsId}")
	public String deleteproducts(@PathVariable Long productsId) {
		productsService.deleteproducts(productsId);
		return "Product Deleted";
	}

}
