package com.els.ecommerce.service;

import java.util.List;

import com.els.ecommerce.dto.UsersDto;
import com.els.ecommerce.entity.Users;

public interface UsersService {

	Users registerUser(UsersDto userDto);

	Users getUser(Long userId);

	Users getUserByName(String userName, String password);

	List<Users> getAllUsers();


}
