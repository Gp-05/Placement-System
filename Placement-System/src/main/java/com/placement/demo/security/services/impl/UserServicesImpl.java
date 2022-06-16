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

	@Override
	public User findByUsername(String username) {
		return userRepository.findByuserName(username);
	}

	@Override
	public User getUserbyUserId(int user_id) {
		return userRepository.findById(user_id).get();
	}
}
