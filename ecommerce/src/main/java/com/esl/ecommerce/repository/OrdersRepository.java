package com.esl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esl.ecommerce.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
