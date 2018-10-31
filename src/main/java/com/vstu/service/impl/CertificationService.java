package com.vstu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.entity.Certification;
import com.vstu.repository.CertificationRepository;
import com.vstu.service.interfaces.ICertificationService;

@Service
public class CertificationService implements ICertificationService{
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
		return certificationRepository.findById(id).get();
	}

	@Override
	public boolean addCertification(Certification c) {
		if (certificationRepository.existsById(c.getId())) {
			return false;
		} else {
			certificationRepository.save(c);
			return true;
		}
	}

	@Override
	public void updateCertification(Certification c) {
		certificationRepository.save(c);
		
	}

	@Override
	public void deleteCertification(Long id) {
		certificationRepository.deleteById(id);
		
	}

	@Override
	public boolean existsCertification(Long id) {
		return certificationRepository.existsById(id);
	}

}
