package com.vstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Competence;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
