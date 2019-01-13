package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Certification;
import com.vstu.entity.Plan;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CertificationRepository;
import com.vstu.service.interfaces.CertificationService;
import com.vstu.service.interfaces.PlanService;

/**
 * service for work with cerification table
 */
@Service
public class CertificationServiceImpl implements CertificationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CertificationServiceImpl.class);

	@Autowired
	CertificationRepository certificationRepository;
	
	@Autowired
	PlanService planService;

	@Override
	public List<Certification> getAllByPlanId(Long id) {

		return certificationRepository.findAllByPlanId(id);
	}

	@Override
	public Certification getCertificationById(Long id) {
		if (!existsCertification(id)) {
			LOGGER.error("Cerification with Id:" + id + " wasn't found!");
			throw new EntityNotFoundException("Certification with Id: " + id + " wasn't found!");
		}

		return certificationRepository.findById(id).get();
	}

	@Override
	public void deleteCertification(Long id) {
		if (!existsCertification(id)) {
			LOGGER.error("Certification with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Certification with Id: " + id + " wasn't found!");
		}
		certificationRepository.deleteById(id);
		LOGGER.info("Certification with id: " + id + " has been deleted!");

	}

	@Override
	public boolean existsCertification(Long id) {
		return certificationRepository.existsById(id);
	}

	
	/**
	 * add list of certifications in plan with id
	 * 
	 */
	@Override
	public List<Certification> addListCertificationByPlanId(Long id, List<Certification> c) {
		if (!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");		
		
		}
		
		Plan plan = planService.getPlanById(id);
		for (Certification certification : c) {
			certification.setPlan(plan);
			
		}

		List<Certification> certification = certificationRepository.saveAll(c);
		LOGGER.info("List of certifications has been added in plan with id: +"+id);

		return certification;
	}

	
	/**
	 * update list of certifications in plan with id
	 * 
	 */
	@Override
	public List<Certification> updateListCertificationByPlanId(Long id, List<Certification> c) {
		if (!planService.existsPlan(id)) {
			LOGGER.error("Plan with Id: " + id + " wasn't found!");
			throw new EntityNotFoundException("Plan with Id: " + id + " wasn't found!");		
		
		}
		
		Plan plan = planService.getPlanById(id);
		for (Certification certification : c) {
			certification.setPlan(plan);
			
		}

		List<Certification> certification = certificationRepository.saveAll(c);
		LOGGER.info("List of certifications has been updated in plan with id: +"+id);

		return certification;
	}

}
