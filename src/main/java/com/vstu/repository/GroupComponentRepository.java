package com.vstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vstu.entity.GroupComponent;

@Repository
public interface GroupComponentRepository extends JpaRepository<GroupComponent, Long> {

}
