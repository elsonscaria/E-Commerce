package com.esl.ecommerce.dto;

import com.esl.ecommerce.entity.Roles;
import com.esl.ecommerce.entity.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRolesDto {

	private Users user;

	private Roles role;
}
