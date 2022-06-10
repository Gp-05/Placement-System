package com.placement.demo.security.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.placement.demo.admin.entity.Admin;
import com.placement.demo.admin.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	private String UserName;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	private String emailId;
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_name", nullable = false)
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Admin> admins=new ArrayList<Admin>();

}