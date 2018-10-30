package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.GroupUnit;

@Repository
public interface GroupUnitRepository extends JpaRepository<GroupUnit, Long> {

	@Query("SELECT g FROM GroupUnit g where g.groupComponent.id = :id")
	public List<GroupUnit> findAllByGroupComponentId(@Param("id") Long id);

}
