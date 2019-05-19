package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Semestr;
import com.vstu.service.interfaces.SemestrService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SemestrController {
	@Autowired
	SemestrService semestrService;

	@GetMapping("semestr/{id}")
	public ResponseEntity<Semestr> getSemestrById(@PathVariable("id") Long id) {
		Semestr s = semestrService.getSemestrById(id);
		return new ResponseEntity<Semestr>(s, HttpStatus.OK);
	}

	@GetMapping("semestr/sum/{id}")
	public @ResponseBody int getSum(@PathVariable("id") Long id) {

		return semestrService.sumAllHoursById(id);
	}

	@GetMapping("semesters/{id}")
	public ResponseEntity<List<Semestr>> getAllByNodeId(@PathVariable("id") Long id) {
		List<Semestr> list = semestrService.getAllByNodeId(id);
		return new ResponseEntity<List<Semestr>>(list, HttpStatus.OK);
	}


	@PostMapping("semesters/{id}")
	public ResponseEntity<List<Semestr>> addSemestrsByNodeId(@PathVariable("id") Long id, @RequestBody List<Semestr> s) {
		List<Semestr> lst = semestrService.addListSemestrByNodeId(id, s);
		return new ResponseEntity<List<Semestr>>(lst, HttpStatus.CREATED);
	}

	@PutMapping("semesters/{id}")
	public ResponseEntity<List<Semestr>> updateSemestrByNode(@PathVariable("id") Long id, @RequestBody List<Semestr> s) {
		List<Semestr> lst = semestrService.addListSemestrByNodeId(id, s);
		return new ResponseEntity<List<Semestr>>(lst, HttpStatus.OK);

	}

	@DeleteMapping("semestr/{id}")
	public ResponseEntity<Void> deleteSemestr(@PathVariable("id") Long id) {

		semestrService.deleteSemestr(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
