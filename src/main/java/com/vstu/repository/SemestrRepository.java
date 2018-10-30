package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vstu.entity.Semestr;

public interface SemestrRepository extends JpaRepository<Semestr, Long> {

	@Query("SELECT s FROM Semestr  s where s.node.id = :id")
	public List<Semestr> findAllByNodeId(@Param("id") Long id);

	@Query("SELECT (s.lecture+s.laboratory+s.practice+s.seminar) FROM Semestr s where s.id=:id")
	public long sumAllHoursById(@Param("id") Long id);

	@Query("SELECT Sum(s.lecture+s.laboratory+s.practice+s.seminar) FROM Semestr s where s.node.id=:id")
	public long sumAllHours(@Param("id") Long id);

}
