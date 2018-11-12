package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Competence;

public interface ICompetenceService {
	List<Competence> getAllCompetence();

	Competence getCompetenceById(Long id);

	Competence addCompetence(Competence c);

	void updateCompetence(Competence c);

	void deleteCompetence(Long id);

	boolean existsCompetence(Long id);

}
