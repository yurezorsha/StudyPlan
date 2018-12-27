package com.vstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long>{
	
	
	public boolean existsByName(@Param("name") String name);

}
