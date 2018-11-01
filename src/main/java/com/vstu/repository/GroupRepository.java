package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

	@Query("SELECT gr FROM Group gr WHERE gr.plan.id = :id")
	public List<Group> findAllByPlanId(@Param("id") Long id);

}
