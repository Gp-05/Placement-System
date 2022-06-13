package com.placement.demo.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.repository.AdminRepository;
import com.placement.demo.admin.services.Adminservices;

@Service
public class AdminservicesImpl implements Adminservices {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin createAdmin(Admin admin) {
		//user.setPassword(getEncodedpassword(user.getPassword()));
		admin.getUser().setPassword(getEncodedpassword(admin.getUser().getPassword()));
		return adminRepository.save(admin);
	}

	public String getEncodedpassword(String password) {
		return passwordEncoder.encode(password);
	}

}
