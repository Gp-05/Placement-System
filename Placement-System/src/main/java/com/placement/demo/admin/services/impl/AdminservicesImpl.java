package com.placement.demo.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.repository.AdminRepository;
import com.placement.demo.admin.services.Adminservices;

@Service
public class AdminservicesImpl implements Adminservices {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
