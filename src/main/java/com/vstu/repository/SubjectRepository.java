package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	@Query("SELECT s FROM Subject s where s.groupUnit.id = :id")
	public List<Subject> findAllByGroupUnitId(@Param("id") Long id);

	public boolean existsByName(@Param("name") String name);

}
