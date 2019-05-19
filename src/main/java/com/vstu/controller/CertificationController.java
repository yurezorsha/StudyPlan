package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Certification;
import com.vstu.service.interfaces.CertificationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CertificationController {

	@Autowired
	CertificationService certificationService;

	@GetMapping("certification/{id}")
	public ResponseEntity<Certification> getCertificationById(@PathVariable("id") Long id) {
		Certification c = certificationService.getCertificationById(id);

		return new ResponseEntity<Certification>(c, HttpStatus.OK);
	}

	@GetMapping("certifications/{id}")
	public ResponseEntity<List<Certification>> getAllPlanId(@PathVariable("id") Long id) {
		List<Certification> list = certificationService.getAllByPlanId(id);
		return new ResponseEntity<List<Certification>>(list, HttpStatus.OK);
	}

	@PostMapping("certifications/{id}")
	public ResponseEntity<List<Certification>> addCertification(@PathVariable("id") Long id, @RequestBody List<Certification> c) {
		List<Certification> cert = certificationService.addListCertificationByPlanId(id, c);
		return new ResponseEntity<List<Certification>>(cert, HttpStatus.CREATED);
	}

	@PutMapping("certifications/{id}")
	public ResponseEntity<List<Certification>> updateCertification(@PathVariable("id") Long id, @RequestBody List<Certification> c) {
		List<Certification> cert = certificationService.updateListCertificationByPlanId(id, c);
		return new ResponseEntity<List<Certification>>(c, HttpStatus.OK);

	}

	@DeleteMapping("certification/{id}")
	public ResponseEntity<Void> deleteCertification(@PathVariable("id") Long id) {
		certificationService.deleteCertification(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
