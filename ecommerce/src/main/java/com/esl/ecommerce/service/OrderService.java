package com.esl.ecommerce.service;

import javax.servlet.http.HttpSession;

import com.esl.ecommerce.dto.AddressesDto;

public interface OrderService {


	String addProduct(HttpSession session, long productId, int quantity);

	String removeProduct(HttpSession session, long productId);

	String checkout(HttpSession session, AddressesDto addressDto);

	

}
