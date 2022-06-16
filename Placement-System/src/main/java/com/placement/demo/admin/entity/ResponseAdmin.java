package com.placement.demo.admin.entity;

import com.placement.demo.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAdmin {
	
	private Admin admin;
	private User user;

}
