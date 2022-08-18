package com.esl.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Setter
@Getter
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long itemId;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Products productId;
	//@Column(name = "product_id")
	//private Long productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Orders orderId;
	//@Column(name = "order_id")
	//private Long orderId;

}
