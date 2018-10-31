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

import com.vstu.entity.Speciality;
import com.vstu.service.interfaces.ISpecialityService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class SpecialityController {
	@Autowired
	ISpecialityService specialityService;
	
	@GetMapping("speciality/{id}")
	public ResponseEntity<Speciality> getSpecialityById(@PathVariable("id") Long id) {
		Speciality sp = specialityService.getSpecialityById(id);
		return new ResponseEntity<Speciality>(sp, HttpStatus.OK);
	}

	
	@GetMapping("speciality")
	public ResponseEntity<List<Speciality>> getAllSpeciality() {
		List<Speciality> list = specialityService.getAllSpeciality();
		return new ResponseEntity<List<Speciality>>(list, HttpStatus.OK);
	}

	@PostMapping("speciality")
	public ResponseEntity<Void> addSpeciality(@RequestBody Speciality sp, UriComponentsBuilder builder) {
		boolean flag = specialityService.addSpeciality(sp);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/speciality/{id}").buildAndExpand(sp.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("speciality")
	public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality sp) {
		if (specialityService.existsSpeciality(sp.getId())) {
			specialityService.updateSpeciality(sp);
			return new ResponseEntity<Speciality>(sp, HttpStatus.OK);
		} else {
			sp = null;
			return new ResponseEntity<Speciality>(sp, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("speciality/{id}")
	public ResponseEntity<Void> deleteSpeciality(@PathVariable("id") Long id) {
		if (specialityService.existsSpeciality(id)) {
			specialityService.deleteSpeciality(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
