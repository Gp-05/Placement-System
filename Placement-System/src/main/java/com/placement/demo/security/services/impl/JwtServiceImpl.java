package com.placement.demo.security.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.placement.demo.security.entity.JwtReponse;
import com.placement.demo.security.entity.JwtRequest;
import com.placement.demo.security.entity.User;
import com.placement.demo.security.repository.UserRepository;
import com.placement.demo.security.services.JwtService;
import com.placement.demo.security.util.JwtUtil;

@Service
public class JwtServiceImpl implements JwtService {

	@Autowired
	private UserRepository commonUserRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = commonUserRepository.findById(username).get();

		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					getAuthroities(user));
		} else {
			throw new UsernameNotFoundException("Username is Not Valid");
		}

	}

	@Override
	public JwtReponse createjwttoken(JwtRequest jwtRequest) throws Exception {
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();

		authenticate(username, password);

		final UserDetails userDetails = loadUserByUsername(username);

		String newgeneratedToken = jwtUtil.generateToken(userDetails);

		User user = commonUserRepository.findById(username).get();

		return new JwtReponse(user, newgeneratedToken);
	}

	public Set getAuthroities(User user) {
		Set authorities = new HashSet();

		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});

		return authorities;
	}

	@Override
	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("User is disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad credentials from user");
		}
	}

}
