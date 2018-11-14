package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Plan;

public interface IPlanService {

	List<Plan> getAllPlan();

	List<Plan> getAllBySpecialityId(Long id);

	Plan getPlanById(Long id);

	Plan addPlan(Plan p);

	Plan updatePlan(Plan p);

	void deletePlan(Long id);

	boolean existsPlan(Long id);

	List<Object> getNagruzka(Long id, int year);

}
