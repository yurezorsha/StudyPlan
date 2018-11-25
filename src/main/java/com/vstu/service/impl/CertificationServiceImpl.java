package com.vstu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Certification;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CertificationRepository;
import com.vstu.service.interfaces.CertificationService;

/**
 * service for work with cerification table
 */
@Service
public class CertificationServiceImpl implements CertificationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CertificationServiceImpl.class);

	@Autowired
	CertificationRepository certificationRepository;

	@Override
	public List<Certification> getAllCertification() {
		return certificationRepository.findAll();
	}

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
	public Certification addCertification(Certification c) {
		if (existsCertification(c.getId())) {
			LOGGER.error("Certification with Id: " + c.getId() + " already exists!");
			throw new AlreadyExistException("Certification with Id: " + c.getId() + " already exists!");
		}

		Certification certification = certificationRepository.save(c);
		LOGGER.info("Certification with id: " + certification.getId() + " has been added!");

		return certification;
	}

	@Override
	public Certification updateCertification(Certification c) {
		if (!existsCertification(c.getId())) {
			LOGGER.error("Certification with Id: " + c.getId() + " wasn't found!");
			throw new EntityNotFoundException("Certification with Id: " + c.getId() + " wasn't found!");
		}
		Certification certification = certificationRepository.save(c);
		LOGGER.info("Subject with id: " + certification.getId() + " has been updated!");

		return certification;

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

}
