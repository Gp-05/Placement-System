package com.placement.demo.collage.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.services.RoleServices;
import com.placement.demo.collage.enitity.Collage;
import com.placement.demo.collage.repository.CollageRepository;
import com.placement.demo.collage.services.CollageServices;

@Service
public class CollageServicesImpl implements CollageServices {

	@Autowired
	private CollageRepository collageRepository;
	
	@Autowired
	private RoleServices roleServices;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String getEncodedpassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	@Override
	public Collage saveCollage(Collage collage) {
		collage.getUser().setRole(roleServices.getRoleById(collage.getUser().getRole().getRoleId()));
		collage.getUser().setPassword(getEncodedpassword(collage.getUser().getPassword()));
		System.out.println(collage);
		return collageRepository.save(collage);
	}

}
