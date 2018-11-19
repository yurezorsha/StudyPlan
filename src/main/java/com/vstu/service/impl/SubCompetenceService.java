package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.SubCompetence;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
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
		if (!existsSubCompetence(id))
			throw new EntityNotFoundException("SubCompetence with Id: " + id + " wasn't found!");

		return subCompetenceRepository.findById(id).get();
	}

	@Override
	public SubCompetence addSubCompetence(SubCompetence c) {
		if (existsSubCompetence(c.getId()))
			throw new AlreadyExistException("SubCompetence with Id: " + c.getId() + " already exists!");

		return subCompetenceRepository.save(c);
	}

	@Override
	public SubCompetence updateSubCompetence(SubCompetence c) {
		if (!existsSubCompetence(c.getId()))
			throw new EntityNotFoundException("SubCompetence with Id: " + c.getId() + " wasn't found!");

		return subCompetenceRepository.save(c);

	}

	@Override
	public void deleteSubCompetence(Long id) {
		if (!existsSubCompetence(id))
			throw new EntityNotFoundException("SubCompetence with Id: " + id + " wasn't found!");
		else
			subCompetenceRepository.deleteById(id);

	}

	@Override
	public boolean existsSubCompetence(Long id) {
		return subCompetenceRepository.existsById(id);
	}

}
