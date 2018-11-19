package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Certification;
import com.vstu.exceptions.AlreadyExistException;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.repository.CertificationRepository;
import com.vstu.service.interfaces.ICertificationService;

@Service
public class CertificationService implements ICertificationService {
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
		if (!existsCertification(id))
			throw new EntityNotFoundException("Certification with Id: " + id + " wasn't found!");

		return certificationRepository.findById(id).get();
	}

	@Override
	public Certification addCertification(Certification c) {
		if (existsCertification(c.getId()))
			throw new AlreadyExistException("Certification with Id: " + c.getId() + " already exists!");

		return certificationRepository.save(c);
	}

	@Override
	public Certification updateCertification(Certification c) {
		if (!existsCertification(c.getId()))
			throw new EntityNotFoundException("Certification with Id: " + c.getId() + " wasn't found!");

		return certificationRepository.save(c);

	}

	@Override
	public void deleteCertification(Long id) {
		if (!existsCertification(id))
			throw new EntityNotFoundException("Certification with Id: " + id + " wasn't found!");
		else
			certificationRepository.deleteById(id);

	}

	@Override
	public boolean existsCertification(Long id) {
		return certificationRepository.existsById(id);
	}

}
