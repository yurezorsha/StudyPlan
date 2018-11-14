package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.StudyProgramm;

public interface IStudyProgramService {
	List<StudyProgramm> getAllStudyProgram();

	StudyProgramm getStudyProgramById(Long id);

	List<StudyProgramm> getStudyProgramBySubjectId(Long id);

	StudyProgramm addStudyProgram(StudyProgramm c);

	StudyProgramm updateStudyProgram(StudyProgramm c);

	void deleteStudyProgram(Long id);

	boolean existsStudyProgram(Long id);

}
