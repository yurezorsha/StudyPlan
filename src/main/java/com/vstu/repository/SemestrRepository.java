package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Semestr;

@Repository
public interface SemestrRepository extends JpaRepository<Semestr, Long> {

	@Query("SELECT s FROM Semestr  s where s.node.id = :id")
	public List<Semestr> findAllByNodeId(@Param("id") Long id);

	@Query("SELECT (s.lecture+s.laboratory+s.practice+s.seminar) FROM Semestr s where s.id=:id")
	public long sumAllHoursById(@Param("id") Long id);

	@Query("SELECT Sum(s.lecture+s.laboratory+s.practice+s.seminar) FROM Semestr s where s.node.id=:id")
	public long sumAllHours(@Param("id") Long id);

	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Semestr s WHERE s.number = :number and s.node.id=:id")
	public boolean existsByNumberAndNodeId(@Param("number") Integer number, @Param("id") Long id);

}
