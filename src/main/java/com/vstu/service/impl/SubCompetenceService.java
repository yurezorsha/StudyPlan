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
	public SubCompetence getSubCompetenceById(Long idGr) {

		return subCompetenceRepository.findById(idGr).get();
	}

	@Override
	public boolean addSubCompetence(SubCompetence g) {
		if (subCompetenceRepository.existsById(g.getId())) {
			return false;
		} else {
			subCompetenceRepository.save(g);
			return true;
		}
	}

	@Override
	public void updateSubCompetence(SubCompetence g) {
		subCompetenceRepository.save(g);

	}

	@Override
	public void deleteSubCompetence(Long idGr) {
		subCompetenceRepository.deleteById(idGr);

	}

	@Override
	public boolean existsSubCompetence(Long idGr) {
		return subCompetenceRepository.existsById(idGr);
	}

}
