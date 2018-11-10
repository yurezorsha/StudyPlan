package com.vstu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

	@Query("SELECT n FROM Node n where n.plan.id = :id")
	public List<Node> findAllByPlanId(@Param("id") Long id);

	@Query("SELECT n FROM Node n where n.plan.id = :id and n.subject.name=:name")
	public Node findBySubjectNameAndPlanId(@Param("id") Long id, @Param("name") String name);

}
