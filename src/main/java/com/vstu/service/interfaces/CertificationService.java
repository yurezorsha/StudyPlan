package com.vstu.service.interfaces;

import java.util.List;

import com.vstu.entity.Certification;

public interface CertificationService {

	List<Certification> getAllByPlanId(Long id);

	Certification getCertificationById(Long id);

	List<Certification> addListCertificationByPlanId(Long id, List<Certification> c);

	List<Certification> updateListCertificationByPlanId(Long id, List<Certification> c);

	void deleteCertification(Long id);

	boolean existsCertification(Long id);

}
