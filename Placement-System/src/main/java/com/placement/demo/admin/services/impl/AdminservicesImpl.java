package com.placement.demo.admin.services.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.Role;
import com.placement.demo.admin.repository.AdminRepository;
import com.placement.demo.admin.services.Adminservices;
import com.placement.demo.security.entity.User;

@Service
public class AdminservicesImpl implements Adminservices {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin createAdmin(Admin admin) {
		
		admin.getUser().setPassword(getEncodedpassword(admin.getUser().getPassword()));
		
//		int cnt = 1;
//		admin.getUser().setRoles(admin.getUser().getRoles().stream().map(r -> {
//			role.setRoleName(r.getRoleName());
//			role.setRoleDescription(r.getRoleDescription());
//			return role;
//		}).collect(Collectors.toSet()));

		System.out.println(admin.getUser().getRole());
		
		
		return adminRepository.save(admin);
	}

	public String getEncodedpassword(String password) {
		return passwordEncoder.encode(password);
	}

}
