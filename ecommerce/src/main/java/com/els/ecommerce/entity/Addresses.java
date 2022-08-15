package com.els.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Setter
@Getter
public class Addresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "shippingAddressId")
	private Set<Orders> orders;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "billingAddressId")
	private Set<Orders> orderb;

}
