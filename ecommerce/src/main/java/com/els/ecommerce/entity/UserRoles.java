package com.els.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "user_roles")
@Setter
@Getter
public class UserRoles {

	@Id
	@Column(name = "user_id", unique=true, nullable= false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy="foreign", parameters = @Parameter(name="property", value="user"))
	private Long userId;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Roles role;
	
	
}
