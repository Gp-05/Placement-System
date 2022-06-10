package com.placement.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placement.demo.security.entity.User;

@Repository
public interface CommonUserRepository extends JpaRepository<User,String> {

}
