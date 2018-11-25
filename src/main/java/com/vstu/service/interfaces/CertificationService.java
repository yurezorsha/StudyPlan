package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Certification;

public interface CertificationService {

	List<Certification> getAllCertification();

	List<Certification> getAllByPlanId(Long id);

	Certification getCertificationById(Long id);

	Certification addCertification(Certification c);

	Certification updateCertification(Certification c);

	void deleteCertification(Long id);

	boolean existsCertification(Long id);

}
