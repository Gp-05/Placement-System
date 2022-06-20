package com.placement.demo.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placement.demo.collage.enitity.Collage;

@Repository
public interface CollageRepository extends JpaRepository<Collage, Integer> {

}
