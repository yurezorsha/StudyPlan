package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Certification;
import com.vstu.service.interfaces.ICertificationService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class CertificationController {
	
	@Autowired
	ICertificationService certificationService;
	
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
	public ResponseEntity<Void> addCertification(@RequestBody Certification c, UriComponentsBuilder builder) {
		boolean flag = certificationService.addCertification(c);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/certification/{id}").buildAndExpand(c.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("certification")
	public ResponseEntity<Certification> updateCertification(@RequestBody Certification c) {
		if (certificationService.existsCertification(c.getId())) {
			certificationService.updateCertification(c);
			return new ResponseEntity<Certification>(c, HttpStatus.OK);
		} else {
			c = null;
			return new ResponseEntity<Certification>(c, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("certification/{id}")
	public ResponseEntity<Void> deleteCertification(@PathVariable("id") Long id) {
		if (certificationService.existsCertification(id)) {
			certificationService.deleteCertification(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
