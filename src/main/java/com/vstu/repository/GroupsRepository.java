package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Groups;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {

	@Query("SELECT gr FROM Groups gr WHERE gr.plan.id = :id")
	public List<Groups> findAllByPlanId(@Param("id") Long id);

}
