package com.placement.demo.admin.services;

import com.placement.demo.admin.entity.Role;

public interface RoleServices {

	Role saveRole(Role role);
	
	Role getRoleById(int role_id);

}
