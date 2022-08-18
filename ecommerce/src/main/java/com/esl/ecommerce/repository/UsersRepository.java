package com.esl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esl.ecommerce.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUserNameAndPassword(String userName, String password);

}
