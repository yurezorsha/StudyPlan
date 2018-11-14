package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.CreatorStudyProgramm;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CreatorStudyProgrammRepository;
import com.vstu.service.interfaces.ICreatorStudyProgramService;

@Service
public class CreatorStudyProgramService implements ICreatorStudyProgramService {
	@Autowired
	CreatorStudyProgrammRepository creatorStudyProgramRepository;

	@Override
	public List<CreatorStudyProgramm> getAllCreatorStudyProgram() {
		return creatorStudyProgramRepository.findAll();
	}

	@Override
	public CreatorStudyProgramm getCreatorStudyProgramById(Long id) {
		return creatorStudyProgramRepository.findById(id).get();

	}

	@Override
	public CreatorStudyProgramm addCreatorStudyProgram(CreatorStudyProgramm c) {
		if (existsCreatorStudyProgram(c.getId()))
			throw new AlreadyExistException("CreatorStudyProgramm with name: " + c.getId() + " already exists!");

		return creatorStudyProgramRepository.save(c);

	}

	@Override
	public CreatorStudyProgramm updateCreatorStudyProgram(CreatorStudyProgramm c) {
		if (!existsCreatorStudyProgram(c.getId()))
			throw new EntityNotFoundException("CreatorStudyProgramm with Id:" + c.getId() + " wasn't found!");

		return creatorStudyProgramRepository.save(c);

	}

	@Override
	public void deleteCreatorStudyProgram(Long id) {
		if (!existsCreatorStudyProgram(id))
			throw new EntityNotFoundException("CreatorStudyProgramm with Id:" + id + " wasn't found!");
		else
			creatorStudyProgramRepository.deleteById(id);

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
