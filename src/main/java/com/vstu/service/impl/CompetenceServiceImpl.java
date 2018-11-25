package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Competence;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CompetenceRepository;
import com.vstu.service.interfaces.CompetenceService;

/**
 * service for work with competence table
 */
@Service
public class CompetenceServiceImpl implements CompetenceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompetenceServiceImpl.class);

	@Autowired
	CompetenceRepository competenceRepository;

	@Override
	public List<Competence> getAllCompetence() {

		return competenceRepository.findAll();
	}

	@Override
	public Competence getCompetenceById(Long id) {
		if (!existsCompetence(id)) {
			LOGGER.error("Competence with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Competence with Id:" + id + " wasn't found!");
		}

		return competenceRepository.findById(id).get();
	}

	@Override
	public Competence addCompetence(Competence c) {
		if (competenceRepository.existsByNameCompetence(c.getNameCompetence())) {
			LOGGER.error("Competence with name: " + c.getNameCompetence() + " already exists!");
			throw new AlreadyExistException("Competence with name: " + c.getNameCompetence() + " already exists!");
		}

		Competence competence = competenceRepository.save(c);
		LOGGER.info("Competence with id: " + competence.getId() + " has been added!");
		return competence;
	}

	@Override
	public Competence updateCompetence(Competence c) {
		if (!existsCompetence(c.getId())) {
			LOGGER.error("Competence with Id:" + c.getId() + " wasn't found!");
			throw new EntityNotFoundException("Competence with Id:" + c.getId() + " wasn't found!");
		}
		Competence competence = competenceRepository.save(c);
		LOGGER.info("Competence with id: " + competence.getId() + " has been updated!");
		return competence;

	}

	@Override
	public void deleteCompetence(Long id) {
		if (!existsCompetence(id)) {
			LOGGER.error("Competence with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Competence with Id:" + id + " wasn't found!");
		}

		competenceRepository.deleteById(id);
		LOGGER.info("Competence with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsCompetence(Long id) {

		return competenceRepository.existsById(id);
	}

}
