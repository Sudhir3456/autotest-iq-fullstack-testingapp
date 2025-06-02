package com.autotestiq.autotest_iq.service;

import org.springframework.stereotype.Service;

import com.autotestiq.autotest_iq.model.User;

@Service
public interface UserServices {
	
	public boolean registerUser(User user);
	
	public User loginUser(String email, String password);
	
	 
	 
}
