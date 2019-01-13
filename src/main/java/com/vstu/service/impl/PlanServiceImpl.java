package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Node;
import com.vstu.entity.Plan;
import com.vstu.entity.Practice;
import com.vstu.entity.data.DataAllLoad;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.PlanRepository;
import com.vstu.service.interfaces.CertificationService;
import com.vstu.service.interfaces.FakultativService;
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.PlanService;
import com.vstu.service.interfaces.PracticeService;
import com.vstu.service.interfaces.SemestrService;

/**
 * service for work with plan table
 */
@Service
public class PlanServiceImpl implements PlanService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanServiceImpl.class);

	@Autowired
	PlanRepository planRepository;

	@Autowired
	NodeService nodeService;
	
	@Autowired
	PracticeService practiceService;
	
	@Autowired
	FakultativService fakultativService;
	
	@Autowired
	CertificationService certificationService;

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
		if (!existsPlan(id)) {
			LOGGER.error("Plan with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");
		}

		return planRepository.findById(id).get();
	}

	/**
	 * adding full plan with all nodes and semesters
	 */
	@Override
	public Plan addPlan(Plan p) {
		if (existsPlan(p.getId())) {
			LOGGER.error("Plan with Id:" + p.getId() + " already exists!");
			throw new AlreadyExistException("Plan with Id: " + p.getId() + " already exists!");
		}
		{
			Plan plan = planRepository.save(p);

			practiceService.addListPracticeByPlanId(plan.getId(), p.getPractices());
			fakultativService.addListFakultativByPlanId(plan.getId(), plan.getFakultativs());
			certificationService.addListCertificationByPlanId(plan.getId(), plan.getCertifications());
			
			for (Node node : p.getNodes()) {
				Node n = nodeService.addNode(plan.getId(), node);
			}
		}

		LOGGER.info("Plan with Id:" + p.getId() + " has been added!");

		return p;
	}

	/**
	 * updating full plan with nodes and semesters
	 */
	@Override
	public Plan updatePlan(Plan p) {
		if (!existsPlan(p.getId())) {
			
			LOGGER.error("Plan with Id: " + p.getId() + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + p.getId() + " wasn't found!");
			
		} else {
			
			practiceService.updateListPracticeByPlanId(p.getId(), p.getPractices());
			fakultativService.updateListFakultativByPlanId(p.getId(),p.getFakultativs());
			certificationService.updateListCertificationByPlanId(p.getId(), p.getCertifications());
			
			for (Node node : p.getNodes()) {
				nodeService.updateNode(p.getId(), node);
			}

			p = planRepository.save(p);
		}
		LOGGER.info("Plan with Id: " + p.getId() + " has been updated!");

		return p;

	}

	@Override
	public void deletePlan(Long id) {
		if (!existsPlan(id)) {
			LOGGER.error("Plan with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");
		}

		planRepository.deleteById(id);
		LOGGER.error("Plan with Id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsPlan(Long id) {
		return planRepository.existsById(id);
	}

	/**
	 * getting full load by id plan and year
	 **/
	@Override
	public DataAllLoad getLoad(long id, int year) {

		int year1 = planRepository.getYearById(id);
		int course = (year - year1) + 1;
		if (course > 0 && course <= 5) {
			int num2 = course * 2;
			int num1 = num2 - 1;
			DataAllLoad datadto = new DataAllLoad();
			datadto.setLoadSubjects(planRepository.getDataLoadSubject(id, num1, num2));
			datadto.setLoadDiploma(planRepository.getDataLoadDiploma(id, num1, num2));
			datadto.setLoadPractice(planRepository.getDataLoadPractice(id, num1, num2));

			return datadto;

		} else
			return null;
	}

}
