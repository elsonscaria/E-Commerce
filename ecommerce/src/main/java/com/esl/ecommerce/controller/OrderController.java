package com.esl.ecommerce.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esl.ecommerce.dto.OrdersDto;
import com.esl.ecommerce.entity.Products;
import com.esl.ecommerce.dto.AddressesDto;
import com.esl.ecommerce.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/cart/show")
	public ResponseEntity<Map<Products,Integer>> getCart(HttpSession session) {
		return new ResponseEntity<Map<Products,Integer>>(orderService.getCart(session),
				session != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/cart/add")
	public ResponseEntity<String> addProduct(HttpSession session,
			@RequestParam long productId, @RequestParam int quantity) {
				return getResponseEntityStatusString(orderService.addProduct(session, productId, quantity));		
	}
	
	@DeleteMapping("/cart/remove")
	public ResponseEntity<String> removeProduct(HttpSession session, @RequestParam long productId) {
				return getResponseEntityStatusString(orderService.removeProduct(session, productId));
	}
	
	
	@PostMapping("/cart/checkout")
	public ResponseEntity<String> checkout (HttpSession session, @RequestBody AddressesDto addressDto) {
		return getResponseEntityStatusString(orderService.checkout(session, addressDto));
	}
	
	
	
	static ResponseEntity<String> getResponseEntityStatusString(String status) {
		return new ResponseEntity<String>(status,
				"success".equals(status) ? HttpStatus.OK 
						: HttpStatus.BAD_REQUEST);		
	}
	
	static ResponseEntity<String> getResponseEntityAuthString(String status) {
		HttpStatus errorStatus;
		if ("Unauthorized".equals(status))
			errorStatus = HttpStatus.UNAUTHORIZED;
		else
			errorStatus = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<String>(status,
				"success".equals(status) ? HttpStatus.OK 
						: errorStatus);		
	}
		

}
