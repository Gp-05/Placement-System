package com.placement.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.ResponseAdmin;
import com.placement.demo.admin.entity.Role;
import com.placement.demo.admin.services.Adminservices;
import com.placement.demo.security.entity.User;
import com.placement.demo.security.services.UserServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private Adminservices adminservices;

	@Autowired
	private UserServices userServices;

	@PostMapping("/createAdmin")
	public ResponseEntity<?> saveAdmin(@RequestBody Admin admin) {

		try {
			Admin admin2 = adminservices.createAdmin(admin);
			User user = userServices.getUserbyUserId(admin2.getUser().getUser_id());
			ResponseAdmin responseAdmin = new ResponseAdmin(admin2, user);
			return ResponseEntity.ok(responseAdmin);
		} catch (Exception e) {
			return ResponseEntity.ok("UserName already exists....!");
		}

	}

}
