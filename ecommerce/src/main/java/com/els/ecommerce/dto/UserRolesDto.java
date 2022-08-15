package com.els.ecommerce.dto;

import com.els.ecommerce.entity.Roles;
import com.els.ecommerce.entity.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRolesDto {
	
	private Users user;
	
	private Roles role;



}
