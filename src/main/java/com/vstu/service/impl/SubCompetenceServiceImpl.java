package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.SubCompetence;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SubCompetenceRepository;
import com.vstu.service.interfaces.SubCompetenceService;

/**
 * service for work with sub_competence table
 */
@Service
public class SubCompetenceServiceImpl implements SubCompetenceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SubCompetenceServiceImpl.class);

	@Autowired
	SubCompetenceRepository subCompetenceRepository;

	@Override
	public List<SubCompetence> getAllSubCompetence() {

		return subCompetenceRepository.findAll();
	}

	@Override
	public List<SubCompetence> getAllBySubjectId(Long id) {

		return subCompetenceRepository.findAllBySubjectId(id);
	}

	@Override
	public SubCompetence getSubCompetenceById(Long id) {
		if (!existsSubCompetence(id)) {
			LOGGER.error("SubCompetence with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("SubCompetence with Id: " + id + " wasn't found!");
		}

		return subCompetenceRepository.findById(id).get();
	}

	@Override
	public SubCompetence addSubCompetence(SubCompetence c) {
		if (existsSubCompetence(c.getId())) {
			LOGGER.error("SubCompetence with Id: " + c.getId() + " already exists!");
			throw new AlreadyExistException("SubCompetence with Id: " + c.getId() + " already exists!");
		}

		SubCompetence subCompetence = subCompetenceRepository.save(c);
		LOGGER.info("SubCompetence with id: " + subCompetence.getId() + " has been added!");
		return subCompetence;
	}

	@Override
	public SubCompetence updateSubCompetence(SubCompetence c) {
		if (!existsSubCompetence(c.getId())) {
			LOGGER.error("SubCompetence with Id: " + c.getId() + " wasn't found!");
			throw new EntityNotFoundException("SubCompetence with Id: " + c.getId() + " wasn't found!");
		}

		SubCompetence subCompetence = subCompetenceRepository.save(c);
		LOGGER.info("SubCompetence with id: " + subCompetence.getId() + " has been updated!");
		return subCompetence;

	}

	@Override
	public void deleteSubCompetence(Long id) {
		if (!existsSubCompetence(id)) {
			LOGGER.error("SubCompetence with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("SubCompetence with Id: " + id + " wasn't found!");
		}
		subCompetenceRepository.deleteById(id);
		LOGGER.info("SubCompetence with id: " + id + " has been updated!");

	}

	@Override
	public boolean existsSubCompetence(Long id) {
		return subCompetenceRepository.existsById(id);
	}

}
