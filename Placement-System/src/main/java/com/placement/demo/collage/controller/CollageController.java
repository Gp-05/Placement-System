package com.placement.demo.collage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.ResponseAdmin;
import com.placement.demo.collage.enitity.Collage;
import com.placement.demo.collage.enitity.ResponseCollage;
import com.placement.demo.collage.services.CollageServices;
import com.placement.demo.security.entity.User;
import com.placement.demo.security.services.UserServices;

@RestController
@RequestMapping("/collage")
public class CollageController {
	
	@Autowired
	private CollageServices collageServices;
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/createCollage")
	public ResponseEntity<?> saveUser(@RequestBody Collage collage) {

		try {
			Collage collage2= collageServices.saveCollage(collage);
			User user = userServices.getUserbyUserId(collage2.getUser().getUser_id());
			ResponseCollage responseCollage=new ResponseCollage(collage2,user);
			return ResponseEntity.ok(responseCollage);
		} catch (Exception e) {
			return ResponseEntity.ok("UserName already exists....!");
		}

	}

}
