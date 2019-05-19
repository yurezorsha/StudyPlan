package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Speciality;
import com.vstu.service.interfaces.SpecialityService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SpecialityController {
	@Autowired
	SpecialityService specialityService;

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
	public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality sp) {
		Speciality s = specialityService.addSpeciality(sp);
		return new ResponseEntity<Speciality>(s, HttpStatus.CREATED);
	}

	@PutMapping("speciality")
	public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality sp) {
		specialityService.updateSpeciality(sp);
		return new ResponseEntity<Speciality>(sp, HttpStatus.OK);
	}

	@DeleteMapping("speciality/{id}")
	public ResponseEntity<Void> deleteSpeciality(@PathVariable("id") Long id) {
		specialityService.deleteSpeciality(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
