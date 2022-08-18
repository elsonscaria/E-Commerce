package com.esl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esl.ecommerce.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
