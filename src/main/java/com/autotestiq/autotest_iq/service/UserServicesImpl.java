package com.autotestiq.autotest_iq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotestiq.autotest_iq.model.User;
import com.autotestiq.autotest_iq.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository repository;

	@Override
	public boolean registerUser(User user) {
		try {
			repository.save(user);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}

	@Override
	public User loginUser(String email, String password) {
		
		User validUser = repository.findByEmail(email);
		
		if (validUser != null && validUser.getPassword().equals(password)) 
		{
			return validUser;
		}
		 
		 return null;
	}

}
