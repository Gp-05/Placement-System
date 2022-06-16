package com.placement.demo.admin.services;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.ResponseAdmin;

public interface Adminservices {
	
	Admin createAdmin(Admin admin);
	
	Admin getAdminByUserId(int userId);
}
