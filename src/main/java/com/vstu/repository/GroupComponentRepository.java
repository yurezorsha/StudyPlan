package com.vstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.GroupComponent;

@Repository
public interface GroupComponentRepository extends JpaRepository<GroupComponent, Long> {

	public boolean existsByName(@Param("name") String name);

}
