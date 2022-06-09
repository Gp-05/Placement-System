package com.placement.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.admin.services.RoleServices;
import com.placement.demo.security.entity.Role;

@RestController
@RequestMapping("/admin")
public class RoleController {
	
	@Autowired
	private RoleServices roleServices;
	
	@PostMapping("/createNewRole")
	public ResponseEntity<?> createRole(@RequestBody Role role){
		return ResponseEntity.ok(roleServices.createRole(role));
	}
	
	

}
