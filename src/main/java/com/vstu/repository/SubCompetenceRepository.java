package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.SubCompetence;

@Repository

public interface SubCompetenceRepository extends JpaRepository<SubCompetence, Long> {

	@Query("SELECT s FROM SubCompetence s where s.subject.id = :id")
	public List<SubCompetence> findAllBySubjectId(@Param("id") Long id);

}
