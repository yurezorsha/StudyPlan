package com.vstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vstu.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
