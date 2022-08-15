package com.els.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.els.ecommerce.entity.Addresses;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long> {
	

}
