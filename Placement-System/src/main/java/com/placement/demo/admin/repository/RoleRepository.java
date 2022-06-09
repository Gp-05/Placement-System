package com.placement.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placement.demo.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
