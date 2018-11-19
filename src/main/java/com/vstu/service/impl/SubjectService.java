package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Subject;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.SubjectRepository;
import com.vstu.service.interfaces.ISubjectService;

@Service
public class SubjectService implements ISubjectService {
	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long id) {
		if (!existsSubject(id))
			throw new EntityNotFoundException("Subject with Id:" + id + " wasn't found!");

		return subjectRepository.findById(id).get();
	}

	@Override
	public List<Subject> getSubjectByGroupUnitId(Long id) {
		return subjectRepository.findAllByGroupUnitId(id);
	}

	@Override
	public Subject addSubject(Subject s) {
		if (subjectRepository.existsByName(s.getName()))
			throw new AlreadyExistException("Subject with name: " + s.getName() + " already exists!");

		return subjectRepository.save(s);

	}

	@Override
	public Subject updateSubject(Subject s) {
		if (!existsSubject(s.getId()))
			throw new EntityNotFoundException("Subject with Id:" + s.getId() + " wasn't found!");

		return subjectRepository.save(s);
	}

	@Override
	public void deleteSubject(Long id) {
		if (!existsSubject(id))
			throw new EntityNotFoundException("Subject with Id:" + id + " wasn't found!");

		subjectRepository.deleteById(id);
	}

	@Override
	public boolean existsSubject(Long id) {
		return subjectRepository.existsById(id);
	}

}
