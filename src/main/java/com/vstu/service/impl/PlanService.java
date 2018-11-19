package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Plan;
import com.vstu.entity.data.DataDTO;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.PlanRepository;
import com.vstu.service.interfaces.IPlanService;

@Service
public class PlanService implements IPlanService {

	@Autowired
	PlanRepository planRepository;

	@Autowired
	NodeService nodeService;

	@Autowired
	SemestrService semestrService;

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
		if (!existsPlan(id))
			throw new EntityNotFoundException("Plan with Id: " + id + "wasn't found!");

		return planRepository.findById(id).get();
	}

	@Override
	public Plan addPlan(Plan p) {
		if (existsPlan(p.getId()))
			throw new AlreadyExistException("Plan with Id: " + p.getId() + "already exists!");
		Plan plan = new Plan(p.getSet_data_group(), p.getSpeciality());
		plan = planRepository.save(plan);

		for (Node node : p.getNodes()) {

			Node n = nodeService.addNode(plan.getId(), node);

		}

		return p;
	}

	@Override
	public Plan updatePlan(Plan p) {
		if (!existsPlan(p.getId()))
			throw new EntityNotFoundException("Plan with Id: " + p.getId() + "wasn't found!");

		for (Node node : p.getNodes())
			nodeService.updateNode(p.getId(), node);

		return planRepository.save(p);

	}

	@Override
	public void deletePlan(Long id) {
		if (!existsPlan(id))
			throw new EntityNotFoundException("Plan with Id: " + id + "wasn't found!");

		planRepository.deleteById(id);

	}

	@Override
	public boolean existsPlan(Long id) {
		return planRepository.existsById(id);
	}

	@Override
	public DataDTO getNagruzka(Long id, int year) {

		int year1 = planRepository.getYearById(id);
		int course = (year - year1) + 1;
		if (course > 0 && course <= 5) {
			int num2 = course * 2;
			int num1 = num2 - 1;
			DataDTO datadto = new DataDTO();
			datadto.setLoad_subjects(planRepository.getData(id, num1, num2));
			datadto.setLoad_diploma(planRepository.getDataDip(id, num1, num2));
			datadto.setLoad_practice(planRepository.getDataPrac(id, num1, num2));

			return datadto;

		} else
			return null;
	}

}
