package com.placement.demo.security.services;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.placement.demo.security.entity.User;
import com.placement.demo.security.entity.JwtReponse;
import com.placement.demo.security.entity.JwtRequest;

public interface JwtService extends UserDetailsService {
	
	public JwtReponse createjwttoken(JwtRequest jwtRequest) throws Exception;
	
	public Set getAuthroities(User commonUser);
	
	public void authenticate(String username, String password) throws Exception;
}
