package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Certification;

public interface ICertificationService {
	
	List<Certification> getAllCertification();

	List<Certification> getAllByPlanId(Long id);

	Certification getCertificationById(Long id);

	boolean addCertification(Certification c);

	void updateCertification(Certification c);

	void deleteCertification(Long id);

	boolean existsCertification(Long id);

}
