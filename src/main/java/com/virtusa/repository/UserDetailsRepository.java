package com.virtusa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.model.User;




@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer>{
	 User findByUsername(String username);

	 Object getById(long id);

}
