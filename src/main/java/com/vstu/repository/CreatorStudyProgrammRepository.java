package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.CreatorStudyProgramm;

@Repository
public interface CreatorStudyProgrammRepository extends JpaRepository<CreatorStudyProgramm, Long> {

	@Query("SELECT c FROM CreatorStudyProgramm c where c.studyProgramm.id = :id")
	public List<CreatorStudyProgramm> findAllByStudyProgrammId(@Param("id") Long id);

}
