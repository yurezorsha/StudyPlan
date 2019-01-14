package com.vstu.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vstu.entity.Plan;
import com.vstu.entity.data.DataAllLoad;

public interface PlanService {

	List<Plan> getAllPlan();

	List<Plan> getAllBySpecialityId(Long id);

	Plan getPlanById(Long id);

	Plan addPlan(Plan p);

	Plan updatePlan(Plan p);

	void deletePlan(Long id);

	boolean existsPlan(Long id);
	
    byte[] downloadDocByPlanId(Long id);
	
	void uploadDocByPlanId(Long id, MultipartFile doc);

	DataAllLoad getLoad(long id, int year);

}
