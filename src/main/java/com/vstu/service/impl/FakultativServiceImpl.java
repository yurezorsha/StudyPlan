package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Fakultativ;
import com.vstu.entity.Plan;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.FakultativRepository;
import com.vstu.service.interfaces.FakultativService;
import com.vstu.service.interfaces.PlanService;

/**
 * service for work with fakultativ table
 */
@Service
public class FakultativServiceImpl implements FakultativService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FakultativServiceImpl.class);

	@Autowired
	FakultativRepository fakultativRepository;
	
	@Autowired
	PlanService planService;

	@Override
	public List<Fakultativ> getAllByPlanId(Long id) {
		return fakultativRepository.findAllByPlanId(id);
	}

	@Override
	public Fakultativ getFakultativById(Long id) {
		if (!existsFakultativ(id)) {
			LOGGER.error("Fakultativ with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");
		}

		return fakultativRepository.findById(id).get();
	}

	@Override
	public void deleteFakultativ(Long id) {
		if (!existsFakultativ(id)) {
			LOGGER.error("Fakultativ with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Fakultativ with Id: " + id + " wasn't found!");
		}
		fakultativRepository.deleteById(id);
		LOGGER.info("Fakultativ with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsFakultativ(Long id) {
		return fakultativRepository.existsById(id);
	}

	/**
	 * add list of fakultativs in plan with id
	 * 
	 */
	@Override
	public List<Fakultativ> addListFakultativByPlanId(Long id, List<Fakultativ> f) {
		if (!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");
		}
		
		Plan plan = planService.getPlanById(id);
		for (Fakultativ fakultativ : f) {
			fakultativ.setPlan(plan);
		}

		List<Fakultativ> fakultativ = fakultativRepository.saveAll(f);
		LOGGER.info("List of fakultativ has been added in plan with Id: " + id);
		return fakultativ;
	}
	
    /**
     * update list of fakultativs in plan with id
     * 
     */
	@Override
	public List<Fakultativ> updateListFakultativByPlanId(Long id, List<Fakultativ> f) {
		if (!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");
		}
		
		Plan plan = planService.getPlanById(id);
		for (Fakultativ fakultativ : f) {
			fakultativ.setPlan(plan);
		}

		List<Fakultativ> fakultativ = fakultativRepository.saveAll(f);
		LOGGER.info("List of fakultativ has been updated in plan with Id: " + id);
		return fakultativ;
	}

}
