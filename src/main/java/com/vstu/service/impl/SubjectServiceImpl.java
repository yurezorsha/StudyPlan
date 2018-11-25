package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Subject;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SubjectRepository;
import com.vstu.service.interfaces.SubjectService;

/**
 * service for work with table subject
 * 
 */
@Service
public class SubjectServiceImpl implements SubjectService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubject() {

		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {

		if (!existsSubject(id)) {
			LOGGER.error("Subject with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Subject with Id:" + id + " wasn't found!");
		}

		return subjectRepository.findById(id).get();
	}

	@Override
	public List<Subject> getSubjectByGroupUnitId(Long id) {
		return subjectRepository.findAllByGroupUnitId(id);
	}

	@Override
	public Subject addSubject(Subject s) {
		if (subjectRepository.existsByName(s.getName())) {
			LOGGER.error("Subject with name: " + s.getName() + " already exists!");
			throw new AlreadyExistException("Subject with name: " + s.getName() + " already exists!");
		}

		Subject subject = subjectRepository.save(s);
		LOGGER.info("Subject with id: " + subject.getId() + " has been added!");
		return subject;

	}

	@Override
	public Subject updateSubject(Subject s) {
		if (!existsSubject(s.getId())) {
			LOGGER.error("Subject with Id:" + s.getId() + " wasn't found!");
			throw new EntityNotFoundException("Subject with Id:" + s.getId() + " wasn't found!");
		}
		Subject subject = subjectRepository.save(s);
		LOGGER.info("Subject with id: " + subject.getId() + " has been updated!");

		return subject;
	}

	@Override
	public void deleteSubject(Long id) {
		if (!existsSubject(id)) {
			LOGGER.error("Subject with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Subject with Id:" + id + " wasn't found!");
		}

		subjectRepository.deleteById(id);
		LOGGER.info("Subject with id: " + id + " has been deleted!");
	}

	@Override
	public boolean existsSubject(Long id) {
		return subjectRepository.existsById(id);
	}

}
