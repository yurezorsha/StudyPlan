package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vstu.entity.Certification;
import com.vstu.service.interfaces.CertificationService;

@RestController
@CrossOrigin(origins = "*")
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

	@GetMapping("certification")
	public ResponseEntity<List<Certification>> getAllCertification() {
		List<Certification> list = certificationService.getAllCertification();
		return new ResponseEntity<List<Certification>>(list, HttpStatus.OK);
	}

	@PostMapping("certification")
	public ResponseEntity<Certification> addCertification(@RequestBody Certification c) {
		Certification cert = certificationService.addCertification(c);
		return new ResponseEntity<Certification>(cert, HttpStatus.CREATED);
	}

	@PutMapping("certification")
	public ResponseEntity<Certification> updateCertification(@RequestBody Certification c) {
		certificationService.updateCertification(c);
		return new ResponseEntity<Certification>(c, HttpStatus.OK);

	}

	@DeleteMapping("certification/{id}")
	public ResponseEntity<Void> deleteCertification(@PathVariable("id") Long id) {
		certificationService.deleteCertification(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
