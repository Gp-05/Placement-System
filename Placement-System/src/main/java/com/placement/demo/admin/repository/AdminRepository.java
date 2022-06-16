package com.placement.demo.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.placement.demo.admin.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value="SELECT * FROM admin WHERE user_id = ?1",nativeQuery=true)
	Admin findByUserId(int id);

}
