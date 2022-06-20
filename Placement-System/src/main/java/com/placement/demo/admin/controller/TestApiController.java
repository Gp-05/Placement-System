package com.placement.demo.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "this URL is Only accessible to admin";
	}

	@GetMapping("/forStudent")
	@PreAuthorize("hasRole('Student')")
	public String forUser() {
		return "this URL is Only accessible to Student";
	}
	
	@GetMapping("/forCollage")
	@PreAuthorize("hasRole('Collage')")
	public String forCollage() {
		return "this URL is Only accessible to Collage";
	}

}
