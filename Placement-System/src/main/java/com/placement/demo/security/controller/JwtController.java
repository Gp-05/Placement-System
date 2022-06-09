package com.placement.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.security.entity.JwtReponse;
import com.placement.demo.security.entity.JwtRequest;
import com.placement.demo.security.services.JwtService;


@RestController
public class JwtController {
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/authenticate")
	public JwtReponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createjwttoken(jwtRequest);
	}

}
