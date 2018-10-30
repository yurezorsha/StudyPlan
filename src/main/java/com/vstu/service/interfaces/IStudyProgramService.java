package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.StudyProgramm;

public interface IStudyProgramService {
	List<StudyProgramm> getAllStudyProgram();

	StudyProgramm getStudyProgramById(Long id);

	List<StudyProgramm> getStudyProgramBySubjectId(Long id);

	boolean addStudyProgram(StudyProgramm c);

	void updateStudyProgram(StudyProgramm c);

	void deleteStudyProgram(Long id);

	boolean existsStudyProgram(Long id);

}
