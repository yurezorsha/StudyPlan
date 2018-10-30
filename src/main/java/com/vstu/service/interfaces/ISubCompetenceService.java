package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.SubCompetence;

public interface ISubCompetenceService {
	List<SubCompetence> getAllSubCompetence();

	List<SubCompetence> getAllBySubjectId(Long id);

	SubCompetence getSubCompetenceById(Long id);

	boolean addSubCompetence(SubCompetence s);

	void updateSubCompetence(SubCompetence s);

	void deleteSubCompetence(Long id);

	boolean existsSubCompetence(Long id);

}
