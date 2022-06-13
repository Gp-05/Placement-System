package com.placement.demo.admin.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.placement.demo.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int roleId;

	@Column(unique = true)
	private String roleName;

	private String roleDescription;

	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;

}
