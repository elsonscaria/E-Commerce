package com.esl.ecommerce.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.esl.ecommerce.dto.AddressesDto;
import com.esl.ecommerce.entity.Products;

public interface OrderService {


	String addProduct(HttpSession session, long productId, int quantity);

	String removeProduct(HttpSession session, long productId);

	String checkout(HttpSession session, AddressesDto addressDto);

	Map<Products, Integer> getCart(HttpSession session);

	

}
