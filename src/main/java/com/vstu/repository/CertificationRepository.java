package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Certification;


@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long>{
	
	@Query("SELECT c FROM Certification c where c.plan.id = :id")
	public List<Certification> findAllByPlanId(@Param("id") Long id);

}
