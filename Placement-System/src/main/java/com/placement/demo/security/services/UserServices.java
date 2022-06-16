package com.placement.demo.security.services;

import com.placement.demo.security.entity.User;

public interface UserServices {
	
	User findByUsername(String username);

	User getUserbyUserId(int user_id);
	
}
