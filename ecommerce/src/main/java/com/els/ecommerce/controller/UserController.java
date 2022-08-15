package com.els.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.els.ecommerce.dto.UsersDto;
import com.els.ecommerce.entity.Users;
import com.els.ecommerce.service.EmailService;
import com.els.ecommerce.service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	@Autowired
	UsersService usersService;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/testing")
	public String getUser() {
		return "Success";
	}

	@PostMapping("/register")
	public Users registerUser(@RequestBody UsersDto userDto) {
		return usersService.registerUser(userDto);
	}

	@GetMapping("/{userId}")
	public Users getUser(@PathVariable Long userId) {
		return usersService.getUser(userId);
	}
	
	@GetMapping("/all")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

	@GetMapping("/byname")
	public Users getUserByName(@RequestParam String userName, @RequestParam String password) {
		emailService.sendMail("345@gmail.com","Test Mail","Hi, this is the test body");
		return usersService.getUserByName(userName, password);
	}

}
