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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vstu.entity.Semestr;
import com.vstu.repository.SemestrRepository;
import com.vstu.service.interfaces.SemestrService;

@RestController
@CrossOrigin(origins = "*")
public class SemestrController {
	@Autowired
	SemestrService semestrService;

	@Autowired
	SemestrRepository repo;

	@GetMapping("semestr/{id}")
	public ResponseEntity<Semestr> getSemestrById(@PathVariable("id") Long id) {
		Semestr s = semestrService.getSemestrById(id);
		return new ResponseEntity<Semestr>(s, HttpStatus.OK);
	}

	@GetMapping("semestr/sum/{id}")
	public @ResponseBody int getSum(@PathVariable("id") Long id) {

		return semestrService.sumAllHoursById(id);
	}

	@GetMapping("semestrs/{id}")
	public ResponseEntity<List<Semestr>> getAllByGroupComponent(@PathVariable("id") Long id) {
		List<Semestr> list = semestrService.getAllByNodeId(id);
		return new ResponseEntity<List<Semestr>>(list, HttpStatus.OK);
	}

	@GetMapping("semestr")
	public ResponseEntity<List<Semestr>> getAllSemestr() {
		List<Semestr> list = semestrService.getAllSemestr();
		return new ResponseEntity<List<Semestr>>(list, HttpStatus.OK);
	}

	@PostMapping("semestr/{id}")
	public ResponseEntity<Semestr> addSemestr(@PathVariable("id") Long id, @RequestBody Semestr s) {
		Semestr semestr = semestrService.addSemestr(id, s);

		return new ResponseEntity<Semestr>(semestr, HttpStatus.CREATED);
	}

	@PostMapping("semestrs/{id}")
	public ResponseEntity<List<Semestr>> addSemestrs(@PathVariable("id") Long id, @RequestBody List<Semestr> s) {
		List<Semestr> lst = semestrService.addListSemestr(id, s);
		return new ResponseEntity<List<Semestr>>(lst, HttpStatus.CREATED);
	}

	@PutMapping("semestr/{id}")
	public ResponseEntity<Semestr> updateSemestr(@PathVariable("id") Long id, @RequestBody Semestr s) {
		Semestr sem = semestrService.updateSemestr(id, s);
		return new ResponseEntity<Semestr>(sem, HttpStatus.OK);

	}

	@DeleteMapping("semestr/{id}")
	public ResponseEntity<Void> deleteSemestr(@PathVariable("id") Long id) {

		semestrService.deleteSemestr(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
