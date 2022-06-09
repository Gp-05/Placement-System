package com.placement.demo.admin.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.placement.demo.security.entity.CommonUser;

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
	private String roleName;	
	private String roleDescription ;
	
	@OneToMany(mappedBy="role")
	@JsonIgnore
    private Set<CommonUser> users;
	
		
	
	

}
