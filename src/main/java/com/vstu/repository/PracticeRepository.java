package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Practice;

@Repository
public interface PracticeRepository  extends JpaRepository<Practice,Long>{
	
	@Query("SELECT p FROM Practice  p where p.plan.id = :id")
	public List<Practice> findAllByPlanId(@Param("id") Long id);

}
