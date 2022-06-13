package com.placement.demo.admin.services;

import com.placement.demo.admin.entity.Role;

public interface RoleServices {

	Role createRole(Role role);

	Role findByRoleName(String rollname);
	
	Role findByRoleId(int id);

}
