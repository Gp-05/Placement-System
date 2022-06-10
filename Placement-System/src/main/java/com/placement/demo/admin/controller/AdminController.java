package com.placement.demo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.services.Adminservices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private Adminservices adminservices;
	
	@PostMapping("/createAdmin")
	public ResponseEntity<?> saveAdmin(Admin admin){
		System.out.println(admin);
		return ResponseEntity.ok("Done");
	}
	
}
