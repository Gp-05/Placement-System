package com.placement.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.Role;
import com.placement.demo.admin.services.Adminservices;
import com.placement.demo.admin.services.RoleServices;
import com.placement.demo.security.entity.User;
import com.placement.demo.security.services.UserServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private Adminservices adminservices;

	@Autowired
	private UserServices userServices;

	@Autowired
	RoleServices roleServices;
	
	@PostMapping("/createAdmin")
	public ResponseEntity<?> saveAdmin(@RequestBody Admin admin) {
		
		Role role=roleServices.findByRoleId(admin.getUser().getRole().getRoleId());
		admin.getUser().setRole(role);
		System.out.println(admin);
		return ResponseEntity.ok(adminservices.createAdmin(admin));
	}

}
