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

import com.vstu.entity.WeeksSemestr;
import com.vstu.service.interfaces.WeeksSemestrService;

@RestController
@CrossOrigin(origins = "*")
public class WeeksSemestrController {

	@Autowired
	WeeksSemestrService weeksSemestrService;

	@GetMapping("weekssemestr/{id}")
	public ResponseEntity<WeeksSemestr> getWeeksSemestrById(@PathVariable("id") Long id) {
		WeeksSemestr w = weeksSemestrService.getWeeksSemestrById(id);
		return new ResponseEntity<WeeksSemestr>(w, HttpStatus.OK);
	}

	@GetMapping("weekssemestrs/{id}")
	public ResponseEntity<List<WeeksSemestr>> getAllPlanId(@PathVariable("id") Long id) {
		List<WeeksSemestr> list = weeksSemestrService.getAllBySemestrId(id);
		return new ResponseEntity<List<WeeksSemestr>>(list, HttpStatus.OK);
	}

	@GetMapping("weekssemestr")
	public ResponseEntity<List<WeeksSemestr>> getAllWeeksSemestr() {
		List<WeeksSemestr> list = weeksSemestrService.getAllWeeksSemestr();
		return new ResponseEntity<List<WeeksSemestr>>(list, HttpStatus.OK);
	}

	@PostMapping("weekssemestr")
	public ResponseEntity<WeeksSemestr> addCertification(@RequestBody WeeksSemestr w) {
		WeeksSemestr week = weeksSemestrService.addWeeksSemestr(w);
		return new ResponseEntity<WeeksSemestr>(week, HttpStatus.CREATED);
	}

	@PutMapping("weekssemestr")
	public ResponseEntity<WeeksSemestr> updateWeeksSemestr(@RequestBody WeeksSemestr w) {
		weeksSemestrService.updateWeeksSemestr(w);
		return new ResponseEntity<WeeksSemestr>(w, HttpStatus.OK);
	}

	@DeleteMapping("weekssemestr/{id}")
	public ResponseEntity<Void> deleteWeeksSemestr(@PathVariable("id") Long id) {
		weeksSemestrService.deleteWeeksSemestr(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
