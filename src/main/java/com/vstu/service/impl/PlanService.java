package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Plan;
import com.vstu.repository.PlanRepository;
import com.vstu.service.interfaces.IPlanService;

@Service
public class PlanService implements IPlanService {

	@Autowired
	PlanRepository planRepository;

	@Override
	public List<Plan> getAllPlan() {

		return planRepository.findAll();
	}

	@Override
	public List<Plan> getAllBySpecialityId(Long id) {

		return planRepository.findAllBySpecialityId(id);
	}

	@Override
	public Plan getPlanById(Long id) {

		return planRepository.findById(id).get();
	}

	@Override
	public boolean addPlan(Plan p) {
		if (planRepository.existsById(p.getId())) {
			return false;
		} else {
			planRepository.save(p);
			return true;
		}
	}

	@Override
	public void updatePlan(Plan p) {
		planRepository.save(p);

	}

	@Override
	public void deletePlan(Long id) {
		planRepository.deleteById(id);

	}

	@Override
	public boolean existsPlan(Long id) {
		return planRepository.existsById(id);
	}

	@Override
	public List<Object> getNagruzka(Long id, int year) {
		int year1 = planRepository.getYearById(id);
		int course = (year - year1) + 1;
		if (course > 0 && course <= 5) {
			int num2 = course * 2;
			int num1 = num2 - 1;

			return planRepository.getData(id, num1, num2);

		} else
			return null;
	}

}
