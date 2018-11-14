package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.CreatorStudyProgramm;

public interface ICreatorStudyProgramService {
	List<CreatorStudyProgramm> getAllCreatorStudyProgram();

	CreatorStudyProgramm getCreatorStudyProgramById(Long id);

	List<CreatorStudyProgramm> getCreatorStudyProgramByStudyProgramId(Long id);

	CreatorStudyProgramm addCreatorStudyProgram(CreatorStudyProgramm c);

	CreatorStudyProgramm updateCreatorStudyProgram(CreatorStudyProgramm c);

	void deleteCreatorStudyProgram(Long id);

	boolean existsCreatorStudyProgram(Long id);

}
