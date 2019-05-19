package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Fakultativ;
import com.vstu.service.interfaces.FakultativService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FakultativController {

	@Autowired
	FakultativService fakultativService;

	@GetMapping("fakultativ/{id}")
	public ResponseEntity<Fakultativ> getFakultativById(@PathVariable("id") Long id) {
		Fakultativ f = fakultativService.getFakultativById(id);
		return new ResponseEntity<Fakultativ>(f, HttpStatus.OK);
	}

	@GetMapping("fakultatives/{id}")
	public ResponseEntity<List<Fakultativ>> getAllPlanId(@PathVariable("id") Long id) {
		List<Fakultativ> list = fakultativService.getAllByPlanId(id);
		return new ResponseEntity<List<Fakultativ>>(list, HttpStatus.OK);
	}

	@PostMapping("fakultatives/{id}")
	public ResponseEntity<List<Fakultativ>> addListFakultativByPlanId(@PathVariable("id") Long id, @RequestBody List<Fakultativ> f) {
		List<Fakultativ> fakult = fakultativService.addListFakultativByPlanId(id, f);
		return new ResponseEntity<List<Fakultativ>>(fakult, HttpStatus.CREATED);
	}

	@PutMapping("fakultatives/{id}")
	public ResponseEntity<List<Fakultativ>> updateListFakultativByPlanID(@PathVariable("id") Long id, @RequestBody List<Fakultativ> f) {
		List<Fakultativ> fakult = fakultativService.updateListFakultativByPlanId(id, f);
		return new ResponseEntity<List<Fakultativ>>(fakult, HttpStatus.CONFLICT);

	}

	@DeleteMapping("fakultativ/{id}")
	public ResponseEntity<Void> deleteFakultativ(@PathVariable("id") Long id) {
		fakultativService.deleteFakultativ(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
