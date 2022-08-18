package com.esl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esl.ecommerce.entity.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

}
