package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Subject;

public interface ISubjectService {
	List<Subject> getAllSubject();

	Subject getSubjectById(Long id);

	List<Subject> getSubjectByGroupUnitId(Long id);

	Subject addSubject(Subject s);

	Subject updateSubject(Subject s);

	void deleteSubject(Long id);

	boolean existsSubject(Long id);

}
