package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.CreatorStudyProgramm;
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
	public boolean addCreatorStudyProgram(CreatorStudyProgramm c) {
		if (creatorStudyProgramRepository.existsById(c.getId())) {
			return false;
		} else {
			creatorStudyProgramRepository.save(c);
			return true;
		}
	}

	@Override
	public void updateCreatorStudyProgram(CreatorStudyProgramm c) {
		creatorStudyProgramRepository.save(c);
	}

	@Override
	public void deleteCreatorStudyProgram(Long id) {
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
