package com.esl.ecommerce.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esl.ecommerce.repository.UsersRepository;

import lombok.Getter;
import lombok.Setter;

import com.esl.ecommerce.dto.UsersDto;
import com.esl.ecommerce.entity.Products;
import com.esl.ecommerce.entity.Users;

@Service
@Setter
@Getter
public class UsersServiceImpl implements UsersService{

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	EmailService emailService;
	
	@Override
	public Users registerUser(UsersDto userDto) {
		Users user = new Users();
		BeanUtils.copyProperties(userDto, user);
		emailService.sendMail(userDto.getEmail(),"Welcome","Hi, You have signed up for the website");
		return usersRepository.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserByName(String userName, String password) {
		Users user = usersRepository.findByUserNameAndPassword(userName, password);
		emailService.sendMail(user.getEmail(),"Login Alert","Hi, you have logged in");
		return user;
	}

	@Override
	public Users updateUsers(String userName, String password, UsersDto userDto) {
		Users users = usersRepository.findByUserNameAndPassword(userName, password);
		BeanUtils.copyProperties(userDto, users);
		return usersRepository.save(users);
	}

	

	


}
