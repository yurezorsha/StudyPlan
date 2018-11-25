package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.StudyProgramm;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.StudyProgrammRepository;
import com.vstu.service.interfaces.StudyProgramService;

/**
 * service for work with study_program table
 */
@Service
public class StudyProgramServiceImpl implements StudyProgramService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudyProgramServiceImpl.class);

	@Autowired
	StudyProgrammRepository studyProgramRepository;

	@Override
	public List<StudyProgramm> getAllStudyProgram() {
		return studyProgramRepository.findAll();
	}

	@Override
	public StudyProgramm getStudyProgramById(Long id) {
		if (!existsStudyProgram(id)) {
			LOGGER.error("StudyProgram with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("StudyProgram with Id: " + id + " wasn't found!");
		}

		return studyProgramRepository.findById(id).get();

	}

	@Override
	public StudyProgramm addStudyProgram(StudyProgramm s) {
		if (existsStudyProgram(s.getId())) {
			LOGGER.error("StudyProgram with name: " + s.getId() + " already exists!");
			throw new AlreadyExistException("StudyProgram with Id: " + s.getId() + " already exists!");
		}

		StudyProgramm studyProgramm = studyProgramRepository.save(s);
		LOGGER.info("StudyProgram with id: " + studyProgramm.getId() + " has been added!");
		return studyProgramm;
	}

	@Override
	public StudyProgramm updateStudyProgram(StudyProgramm s) {
		if (!existsStudyProgram(s.getId())) {
			LOGGER.error("StudyProgram with Id: " + s.getId() + " wasn't found!");
			throw new EntityNotFoundException("StudyProgram with Id: " + s.getId() + " wasn't found!");
		}

		StudyProgramm studyProgramm = studyProgramRepository.save(s);
		LOGGER.info("StudyProgram with id: " + studyProgramm.getId() + " has been updated!");
		return studyProgramm;

	}

	@Override
	public void deleteStudyProgram(Long id) {
		if (!existsStudyProgram(id)) {
			LOGGER.error("StudyProgram with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("StudyProgram with Id: " + id + " wasn't found!");
		}

		LOGGER.info("StudyProgram with id: " + id + " has been deleted!");
		studyProgramRepository.deleteById(id);

	}

	@Override
	public boolean existsStudyProgram(Long id) {
		return studyProgramRepository.existsById(id);
	}

	@Override
	public List<StudyProgramm> getStudyProgramBySubjectId(Long id) {

		return studyProgramRepository.findAllBySubjectId(id);
	}

}
