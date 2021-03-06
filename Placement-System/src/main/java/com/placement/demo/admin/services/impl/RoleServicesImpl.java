package com.placement.demo.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.demo.admin.entity.Role;
import com.placement.demo.admin.repository.RoleRepository;
import com.placement.demo.admin.services.RoleServices;

@Service
public class RoleServicesImpl implements RoleServices {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(int role_id) {
		return roleRepository.findById(role_id).get();
	}

}
