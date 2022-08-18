package com.esl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esl.ecommerce.dto.UsersDto;
import com.esl.ecommerce.entity.Users;
import com.esl.ecommerce.service.EmailService;
import com.esl.ecommerce.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	UsersService usersService;

	@Autowired
	EmailService emailService;

	@GetMapping("/")
	public String getUser() {
		return "Welcome";
	}

	//User Registration
	@PostMapping("/users/register")
	public Users registerUser(@RequestBody UsersDto userDto) {
		return usersService.registerUser(userDto);
	}

	//Listing all users
	@GetMapping("/users/all")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

	
	//User Retrieval by username and password 
	@GetMapping("/users/login")
	public Users getUserByName(@RequestParam String userName, @RequestParam String password) {
		// emailService.sendMail("345@gmail.com","Test Mail","Hi, you have logged in");
		return usersService.getUserByName(userName, password);
	}

	// updating user info
	@PostMapping("/users/update")
	public Users updateUsers(@RequestParam String userName, @RequestParam String password, @RequestBody UsersDto userDto) {
		return usersService.updateUsers(userName, password, userDto);
	}
}
