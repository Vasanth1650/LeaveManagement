package com.virtusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
