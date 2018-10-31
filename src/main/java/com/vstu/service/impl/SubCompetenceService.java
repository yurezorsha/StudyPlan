package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.SubCompetence;
import com.vstu.repository.SubCompetenceRepository;
import com.vstu.service.interfaces.ISubCompetenceService;

@Service
public class SubCompetenceService implements ISubCompetenceService {
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

		return subCompetenceRepository.findById(id).get();
	}

	@Override
	public boolean addSubCompetence(SubCompetence s) {
		if (subCompetenceRepository.existsById(s.getId())) {
			return false;
		} else {
			subCompetenceRepository.save(s);
			return true;
		}
	}

	@Override
	public void updateSubCompetence(SubCompetence s) {
		subCompetenceRepository.save(s);

	}

	@Override
	public void deleteSubCompetence(Long id) {
		subCompetenceRepository.deleteById(id);

	}

	@Override
	public boolean existsSubCompetence(Long id) {
		return subCompetenceRepository.existsById(id);
	}

}
