package com.esl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esl.ecommerce.dto.ProductsDto;
import com.esl.ecommerce.entity.Products;
import com.esl.ecommerce.service.ProductsService;

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
	@GetMapping("/products/all")
	public List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}

	// updating products
	@PostMapping("/products/update/{productId}")
	public Products updateProducts(@PathVariable Long productId, @RequestBody ProductsDto productsDto ) { 
		return productsService.updateProducts(productId, productsDto); 
	}

	// deleting products
	@DeleteMapping("/products/delete/{productId}")
	public String deleteproducts(@PathVariable Long productId) {
		productsService.deleteproducts(productId);
		return "Product Deleted";
	}
}