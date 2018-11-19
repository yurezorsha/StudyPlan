package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.StudyProgramm;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.StudyProgrammRepository;
import com.vstu.service.interfaces.IStudyProgramService;

@Service
public class StudyProgramService implements IStudyProgramService {

	@Autowired
	StudyProgrammRepository studyProgramRepository;

	@Override
	public List<StudyProgramm> getAllStudyProgram() {
		return studyProgramRepository.findAll();
	}

	@Override
	public StudyProgramm getStudyProgramById(Long id) {
		if (!existsStudyProgram(id))
			throw new EntityNotFoundException("StudyProgram with Id: " + id + " wasn't found!");

		return studyProgramRepository.findById(id).get();

	}

	@Override
	public StudyProgramm addStudyProgram(StudyProgramm c) {
		if (existsStudyProgram(c.getId()))
			throw new AlreadyExistException("StudyProgram with Id: " + c.getId() + " already exists!");

		return studyProgramRepository.save(c);
	}

	@Override
	public StudyProgramm updateStudyProgram(StudyProgramm c) {
		if (!existsStudyProgram(c.getId()))
			throw new EntityNotFoundException("StudyProgram with Id: " + c.getId() + " wasn't found!");

		return studyProgramRepository.save(c);

	}

	@Override
	public void deleteStudyProgram(Long id) {
		if (!existsStudyProgram(id))
			throw new EntityNotFoundException("StudyProgram with Id: " + id + " wasn't found!");
		else
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
