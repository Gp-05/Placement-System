package com.placement.demo.security.services;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.placement.demo.security.entity.CommonUser;
import com.placement.demo.security.entity.JwtReponse;
import com.placement.demo.security.entity.JwtRequest;

public interface JwtService extends UserDetailsService {
	
	public JwtReponse createjwttoken(JwtRequest jwtRequest) throws Exception;
	
	public Set getAuthroities(CommonUser commonUser);
	
	public void authenticate(String username, String password) throws Exception;
}
