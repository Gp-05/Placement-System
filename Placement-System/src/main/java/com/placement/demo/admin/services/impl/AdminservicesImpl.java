package com.placement.demo.admin.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.Role;
import com.placement.demo.admin.repository.AdminRepository;
import com.placement.demo.admin.services.Adminservices;
import com.placement.demo.admin.services.RoleServices;

@Service
public class AdminservicesImpl implements Adminservices {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleServices roleServices;

	@Override
	public Admin createAdmin(Admin admin) {
		admin.getUser().setRole(roleServices.getRoleById(admin.getUser().getRole().getRoleId()));
		admin.getUser().setPassword(getEncodedpassword(admin.getUser().getPassword()));
		System.out.println(admin);
		return adminRepository.save(admin);
	}

	public String getEncodedpassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public Admin findByID(int id) {
		return adminRepository.findById(id).get();
	}

}
