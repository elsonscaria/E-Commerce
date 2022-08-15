package com.els.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.ecommerce.dto.UsersDto;
import com.els.ecommerce.entity.Users;
import com.els.ecommerce.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

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
	public Users getUser(Long userId) {
		Optional<Users> user = usersRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public Users getUserByName(String userName, String password) {
		return usersRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

}
