package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.StudyProgramm;

@Repository
public interface StudyProgrammRepository extends JpaRepository<StudyProgramm, Long> {
	@Query("SELECT s FROM StudyProgramm s where s.subject.id = :id")
	public List<StudyProgramm> findAllBySubjectId(@Param("id") Long id);

}
