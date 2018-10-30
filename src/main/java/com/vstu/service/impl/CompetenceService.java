package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Competence;
import com.vstu.repository.CompetenceRepository;
import com.vstu.service.interfaces.ICompetenceService;

@Service
public class CompetenceService implements ICompetenceService {
	@Autowired
	CompetenceRepository competenceRepository;

	@Override
	public List<Competence> getAllCompetence() {

		return competenceRepository.findAll();
	}

	@Override
	public Competence getCompetenceById(Long id) {

		return competenceRepository.findById(id).get();
	}

	@Override
	public boolean addCompetence(Competence c) {
		if (competenceRepository.existsById(c.getId())) {
			return false;
		} else {
			competenceRepository.save(c);
			return true;
		}

	}

	@Override
	public void updateCompetence(Competence c) {
		competenceRepository.save(c);

	}

	@Override
	public void deleteCompetence(Long id) {

		competenceRepository.deleteById(id);

	}

	@Override
	public boolean existsCompetence(Long id) {

		return competenceRepository.existsById(id);
	}

}
