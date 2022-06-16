package com.placement.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.security.entity.JwtRequest;
import com.placement.demo.security.services.JwtService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;

	@PostMapping("/signin")
	public ResponseEntity<?> createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			return ResponseEntity.ok(jwtService.createjwttoken(jwtRequest));
		} catch (Exception e) {
			return ResponseEntity.ok("UserName & Password Invalid please try again....!");
		}
	}

}
