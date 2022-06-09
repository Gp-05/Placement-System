package com.placement.demo.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "common_user")
public class CommonUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;

	@Id
	private String UserName;
	private String emailId;
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_name", nullable = false)
	private Role role;

}