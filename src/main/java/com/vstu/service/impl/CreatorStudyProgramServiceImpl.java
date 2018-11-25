package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.CreatorStudyProgramm;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CreatorStudyProgrammRepository;
import com.vstu.service.interfaces.CreatorStudyProgramService;

/**
 * service for work with table creator_study_program
 */
@Service
public class CreatorStudyProgramServiceImpl implements CreatorStudyProgramService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CreatorStudyProgramServiceImpl.class);

	@Autowired
	CreatorStudyProgrammRepository creatorStudyProgramRepository;

	@Override
	public List<CreatorStudyProgramm> getAllCreatorStudyProgram() {
		return creatorStudyProgramRepository.findAll();
	}

	@Override
	public CreatorStudyProgramm getCreatorStudyProgramById(Long id) {
		if (!existsCreatorStudyProgram(id)) {
			LOGGER.error("CreatorStudyProgramm with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("CreatorStudyProgramm with Id:" + id + " wasn't found!");
		}
		return creatorStudyProgramRepository.findById(id).get();

	}

	@Override
	public CreatorStudyProgramm addCreatorStudyProgram(CreatorStudyProgramm c) {
		if (existsCreatorStudyProgram(c.getId())) {
			LOGGER.error("CreatorStudyProgramm with name: " + c.getId() + " already exists!");
			throw new AlreadyExistException("CreatorStudyProgramm with name: " + c.getId() + " already exists!");
		}

		CreatorStudyProgramm creatorStudyProgramm = creatorStudyProgramRepository.save(c);
		LOGGER.info("CreatorStudyProgramm with id: " + creatorStudyProgramm.getId() + " has been added!");
		return creatorStudyProgramm;

	}

	@Override
	public CreatorStudyProgramm updateCreatorStudyProgram(CreatorStudyProgramm c) {
		if (!existsCreatorStudyProgram(c.getId())) {
			LOGGER.error("CreatorStudyProgramm with name: " + c.getId() + " wasn't found!");
			throw new EntityNotFoundException("CreatorStudyProgramm with Id:" + c.getId() + " wasn't found!");
		}

		CreatorStudyProgramm creatorStudyProgramm = creatorStudyProgramRepository.save(c);
		LOGGER.info("CreatorStudyProgramm with id: " + creatorStudyProgramm.getId() + " has been updated!");
		return creatorStudyProgramm;
	}

	@Override
	public void deleteCreatorStudyProgram(Long id) {
		if (!existsCreatorStudyProgram(id)) {
			LOGGER.error("CreatorStudyProgramm with name: " + id + " wasn't found!");
			throw new EntityNotFoundException("CreatorStudyProgramm with Id:" + id + " wasn't found!");
		}
		creatorStudyProgramRepository.deleteById(id);
		LOGGER.info("CreatorStudyProgramm with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsCreatorStudyProgram(Long id) {
		return creatorStudyProgramRepository.existsById(id);
	}

	@Override
	public List<CreatorStudyProgramm> getCreatorStudyProgramByStudyProgramId(Long id) {

		return creatorStudyProgramRepository.findAllByStudyProgrammId(id);
	}

}
