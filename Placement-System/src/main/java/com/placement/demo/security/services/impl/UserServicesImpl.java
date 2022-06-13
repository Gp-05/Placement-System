package com.placement.demo.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.demo.security.entity.User;
import com.placement.demo.security.repository.UserRepository;
import com.placement.demo.security.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(User user) {
		user.setPassword(getEncodedpassword(user.getPassword()));
		userRepository.save(user);
	}

	public String getEncodedpassword(String password) {
		return passwordEncoder.encode(password);
	}

}
