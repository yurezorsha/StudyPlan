package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

	@Query("SELECT p FROM Plan p WHERE p.speciality.id = :id")
	public List<Plan> findAllBySpecialityId(@Param("id") Long id);

	@Query("SELECT p.set_data_group FROM Plan p WHERE p.id = :id")
	public int getYearById(@Param("id") Long id);

	public List<Object> getData(@Param("id") Long id, @Param("num1") int num1, @Param("num2") int num2);

}
