package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Plan;
import com.vstu.entity.Practice;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.PracticeRepository;
import com.vstu.service.interfaces.PlanService;
import com.vstu.service.interfaces.PracticeService;


/**
 * service for work with practice table
 * 
 */
@Service
public class PracticeServiceImpl implements PracticeService{
	private static final Logger LOGGER = LoggerFactory.getLogger(PracticeServiceImpl.class);
	
	@Autowired
	PracticeRepository practiceRepository;
	
	@Autowired
	PlanService planService;

	@Override
	public List<Practice> getAllByPlanId(Long id) {
		if(!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id " + id +" wasn't found!");
		}
		
		return practiceRepository.findAllByPlanId(id);
	}

	@Override
	public Practice getPracticeById(Long id) {
		if(!existsPractice(id)) {
			LOGGER.error("Practice with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Practice with Id " + id +" wasn't found!");
			
		}
			
		return practiceRepository.findById(id).get();
	}

	/**
	 * add list of practice in plan with id
	 * 
	 */
	@Override
	public List<Practice> addListPracticeByPlanId(Long id, List<Practice> p) {
		
		if(!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id " + id +" wasn't found!");
		}
		
		Plan plan=planService.getPlanById(id);
		
		for (Practice practice : p) {
			practice.setPlan(plan);
			
		}
		
		List<Practice> lst = practiceRepository.saveAll(p);
		LOGGER.info("List of practices has been added in plan with id + "+ lst.get(0).getPlan().getId());
		
		return lst;
	}

	/**
	 * update list of practices in plan with id
	 * 
	 */
	@Override
	public List<Practice> updateListPracticeByPlanId(Long id, List<Practice> p) {
		
		if(!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id " + id +" wasn't found!");
		}
		
		Plan plan=planService.getPlanById(id);
		
		for (Practice practice : p) {
			practice.setPlan(plan);
			
		}
		
		List<Practice> lst = practiceRepository.saveAll(p);
		LOGGER.info("List of practices has been added in plan with id + "+ lst.get(0).getPlan().getId());
		
		return lst;
	}

	@Override
	public void deletePractice(Long id) {
		if (!existsPractice(id)) {
			LOGGER.error("Practice with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Practice with Id:" + id + " wasn't found!");
		}

		LOGGER.info("Practice with Id:" + id + " has been deleted");
        practiceRepository.deleteById(id);
		
	}

	@Override
	public boolean existsPractice(Long id) {
		
		return practiceRepository.existsById(id);
	}

}
