package com.els.ecommerce.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users userId;
	//@Column(name = "user_id")
	//private Long userId;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "order_total")
	private String orderTotal;
	
	@ManyToOne
	@JoinColumn(name = "shipping_address_id", nullable = false)
	private Addresses shippingAddressId;
	//@Column(name = "shipping_address_id")
	//private Long shippingAddressId;
	
	@ManyToOne
	@JoinColumn(name = "billing_address_id", nullable = false)
	private Addresses billingAddressId;
	//@Column(name = "billing_address_id")
	//private Long billingAddressId;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "orderId")
	private Set<OrderItems> orderItems;

}
