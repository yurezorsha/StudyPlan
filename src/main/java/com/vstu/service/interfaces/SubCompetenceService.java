package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.SubCompetence;

public interface SubCompetenceService {
	List<SubCompetence> getAllSubCompetence();

	List<SubCompetence> getAllBySubjectId(Long id);

	SubCompetence getSubCompetenceById(Long id);

	SubCompetence addSubCompetence(SubCompetence s);

	SubCompetence updateSubCompetence(SubCompetence s);

	void deleteSubCompetence(Long id);

	boolean existsSubCompetence(Long id);

}
