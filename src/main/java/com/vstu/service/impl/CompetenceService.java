package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Competence;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
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
		if (!existsCompetence(id))
			throw new EntityNotFoundException("Competence with Id:" + id + " wasn't found!");

		return competenceRepository.findById(id).get();
	}

	@Override
	public Competence addCompetence(Competence c) {
		if (competenceRepository.existsByNameCompetence(c.getNameCompetence()))
			throw new AlreadyExistException("Competence with name: " + c.getNameCompetence() + " already exists!");

		return competenceRepository.save(c);

	}

	@Override
	public Competence updateCompetence(Competence c) {
		if (!existsCompetence(c.getId()))
			throw new EntityNotFoundException("Competence with Id:" + c.getId() + " wasn't found!");

		return competenceRepository.save(c);

	}

	@Override
	public void deleteCompetence(Long id) {
		if (!existsCompetence(id))
			throw new EntityNotFoundException("Competence with Id:" + id + " wasn't found!");
		else
			competenceRepository.deleteById(id);

	}

	@Override
	public boolean existsCompetence(Long id) {

		return competenceRepository.existsById(id);
	}

}
