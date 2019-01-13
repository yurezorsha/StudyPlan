package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Practice;


public interface PracticeService {
	
	List<Practice> getAllByPlanId(Long id);

	Practice getPracticeById(Long id);

	List<Practice> addListPracticeByPlanId(Long id, List<Practice> p);

	List<Practice> updateListPracticeByPlanId(Long id, List<Practice> p);

	void deletePractice(Long id);

	boolean existsPractice(Long id);


}
