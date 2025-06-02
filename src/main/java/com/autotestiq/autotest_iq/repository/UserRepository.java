package com.autotestiq.autotest_iq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autotestiq.autotest_iq.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);

}
