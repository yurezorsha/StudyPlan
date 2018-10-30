package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Subject;
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

		return subjectRepository.findById(id).get();
	}

	@Override
	public List<Subject> getSubjectByGroupUnitId(Long id) {
		return subjectRepository.findAllByGroupUnitId(id);
	}

	@Override
	public boolean addSubject(Subject s) {
		if (subjectRepository.existsById(s.getId())) {
			return false;
		} else {
			subjectRepository.save(s);
			return true;
		}
	}

	@Override
	public void updateSubject(Subject s) {
		subjectRepository.save(s);
	}

	@Override
	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);

	}

	@Override
	public boolean existsSubject(Long id) {
		return subjectRepository.existsById(id);
	}

}
