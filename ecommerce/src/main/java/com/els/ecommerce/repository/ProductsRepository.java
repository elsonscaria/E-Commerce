package com.els.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.els.ecommerce.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	
}
