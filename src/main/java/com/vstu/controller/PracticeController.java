package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Practice;
import com.vstu.repository.PracticeRepository;
import com.vstu.service.interfaces.PracticeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PracticeController {
	@Autowired
	PracticeService practiceService;

	@GetMapping("practice/{id}")
	public ResponseEntity<Practice> getPracticeById(@PathVariable("id") Long id) {
		Practice s = practiceService.getPracticeById(id);
		return new ResponseEntity<Practice>(s, HttpStatus.OK);
	}

	

	@GetMapping("practices/{id}")
	public ResponseEntity<List<Practice>> getAllByPlanId(@PathVariable("id") Long id) {
		List<Practice> list = practiceService.getAllByPlanId(id);
		return new ResponseEntity<List<Practice>>(list, HttpStatus.OK);
	}

	@PostMapping("practices/{id}")
	public ResponseEntity<List<Practice>> addListPractices(@PathVariable("id") Long id, @RequestBody List<Practice> p) {
		List<Practice> lst = practiceService.addListPracticeByPlanId(id, p);
		return new ResponseEntity<List<Practice>>(lst, HttpStatus.CREATED);
	}

	@PutMapping("practices/{id}")
	public ResponseEntity<List<Practice>> updateListPractice(@PathVariable("id") Long id, @RequestBody List<Practice> p) {
		List<Practice> lst = practiceService.updateListPracticeByPlanId(id, p);
		return new ResponseEntity<List<Practice>>(lst, HttpStatus.OK);

	}

	@DeleteMapping("practice/{id}")
	public ResponseEntity<Void> deletePractice(@PathVariable("id") Long id) {

		practiceService.deletePractice(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
