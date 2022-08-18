package com.esl.ecommerce.service;

import java.util.List;

import com.esl.ecommerce.dto.UsersDto;
import com.esl.ecommerce.entity.Users;

public interface UsersService {

	Users registerUser(UsersDto userDto);

	List<Users> getAllUsers();

	Users getUserByName(String userName, String password);

	Users updateUsers(String userName, String password, UsersDto userDto);



}
