package com.els.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.els.ecommerce.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
