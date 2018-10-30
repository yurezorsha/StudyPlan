package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.StudyProgramm;
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
		return studyProgramRepository.findById(id).get();

	}

	@Override
	public boolean addStudyProgram(StudyProgramm c) {
		if (studyProgramRepository.existsById(c.getId())) {
			return false;
		} else {
			studyProgramRepository.save(c);
			return true;
		}
	}

	@Override
	public void updateStudyProgram(StudyProgramm c) {
		studyProgramRepository.save(c);
	}

	@Override
	public void deleteStudyProgram(Long id) {
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
