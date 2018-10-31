package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Fakultativ;

@Repository
public interface FakultativRepository extends JpaRepository<Fakultativ, Long> {
	
	@Query("SELECT f FROM Fakultativ f where f.plan.id = :id")
	public List<Fakultativ> findAllByPlanId(@Param("id") Long id);

}
