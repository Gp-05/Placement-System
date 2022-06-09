package com.placement.demo.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.repository.RoleRepository;
import com.placement.demo.admin.services.RoleServices;
import com.placement.demo.security.entity.Role;

@Service
public class RoleServicesImpl implements RoleServices {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

}
