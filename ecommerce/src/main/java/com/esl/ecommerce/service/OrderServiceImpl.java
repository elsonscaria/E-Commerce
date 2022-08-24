package com.esl.ecommerce.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.esl.ecommerce.dto.AddressesDto;
import com.esl.ecommerce.dto.OrdersDto;
import com.esl.ecommerce.entity.Addresses;
import com.esl.ecommerce.entity.Orders;
import com.esl.ecommerce.entity.Products;
import com.esl.ecommerce.entity.Users;
import com.esl.ecommerce.repository.OrdersRepository;
import com.esl.ecommerce.repository.ProductsRepository;
import com.esl.ecommerce.repository.UsersRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	EmailService emailService;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	UsersRepository usersRepository;
	
	
	private Map<Products,Integer> rawCartToFull(Map<Long,Integer> rawCart) {
		Map<Products,Integer> fullCart = new HashMap<>();
		for(Map.Entry<Long,Integer> p : rawCart.entrySet()) {
			Optional<Products> op = null;
			if (!(op = productsRepository.findById(p.getKey())).isPresent())
				return null;
			fullCart.put(op.get(), p.getValue());
		}
		return fullCart;
	}
	


	@Override
	public String addProduct(HttpSession session, long productId, int quantity) {
		if (!productsRepository.findById(productId).isPresent())
			return "Product with ID "+productId+" not found!";
		// Check for invalid quantity
		if (quantity <= 0)
			return "Invalid quantity!";
		
		// If session does not have cart, create one (map of product id & quantity)
		if (session.getAttribute("cart") == null)
			session.setAttribute("cart", new HashMap<Long,Integer>());
		@SuppressWarnings("unchecked")
		Map<Long,Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
		// Add product, or add quantity if already present
		if (cart.containsKey(productId)) 
			quantity += cart.get(productId);
		cart.put(productId, quantity);
		return "success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String removeProduct(HttpSession session, long productId) {
		Map<Long,Integer> rawCart;
		if ((rawCart = (Map<Long, Integer>) session.getAttribute("cart")) == null)
			return "ERROR - no cart currently!";
		if (!rawCart.containsKey(productId))
			return "Product with ID "+productId+" not in cart!";
		
		rawCart.remove(productId);
		return "success";
	}

	@SuppressWarnings("unchecked")
	@Override
	public String checkout(HttpSession session, AddressesDto addressDto) {
		Map<Long,Integer> rawCart;
		Map<Products,Integer> fullCart;
		// Check if session even has cart
		if ((rawCart = (Map<Long, Integer>) session.getAttribute("cart")) == null)
			return "ERROR - no cart currently!";
		// Check if cart has any items
		if (rawCart.size() == 0)
			return "ERROR - nothing in cart currently!";
		// Convert to fullCart
		if ((fullCart = rawCartToFull(rawCart)) == null)
			return "ERROR - a product id was invalid!";
		
		// Fetch user to save w/order
		// TODO - should reuse existing repository & not reuse code,
		// (this is in UserService), so implement it as singleton later
		Optional<Users> foundUser = null;
		// If username wasn't found
		if (!(foundUser = usersRepository.findById(
				(Long) session.getAttribute("user")))
				.isPresent())
			return "User's ID in session not found!";
		
		// Save cart as order
		Orders order;
		try {
			order = new Orders(foundUser.get(),
					new Addresses(addressDto.getBillingAddress()),
					new Addresses(addressDto.getMailingAddress()),
					fullCart);
			ordersRepository.save(order);
		} catch (ConstraintViolationException e) {
			return "Invalid fields!";			
		}	
		
		// Remove cart from session
		session.removeAttribute("cart");
		// Send confirmation email
		emailService.sendOrderConfirmed(foundUser.get(),order);
		
		return "success";
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Products, Integer> getCart(HttpSession session) {
		Map<Products,Integer> cart;
		Map<Long,Integer> rawCart;
		// Check if session even has cart
		if ((rawCart = (Map<Long, Integer>) session.getAttribute("cart") == null)
			return null;
		if ((cart = rawCartToFull(rawCart)) == null)
			return null;
		return cart;
	}

}
