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
@Table(name = "products")
@Setter
@Getter
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private float unitPrice;
	
	@Column(name = "product_stock")
	private int productStock;
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "productId")
	private Set<OrderItems> orderId;
	

}
