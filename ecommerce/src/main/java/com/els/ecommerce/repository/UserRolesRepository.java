package com.els.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.els.ecommerce.entity.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

}
