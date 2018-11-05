package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.WeeksSemestr;

@Repository
public interface WeeksSemestrRepository extends JpaRepository<WeeksSemestr, Long>{
	
	@Query("SELECT w FROM WeeksSemestr w where w.semestr.id = :id")
	public List<WeeksSemestr> findAllBySemestrId(@Param("id") Long id);

}
