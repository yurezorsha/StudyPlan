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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Semestr;
import com.vstu.repository.SemestrRepository;
import com.vstu.service.interfaces.ISemestrService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class SemestrController {
	@Autowired
	ISemestrService semestrService;

	@Autowired
	SemestrRepository repo;

	@GetMapping("semestr/{id}")
	public ResponseEntity<Semestr> getSemestrById(@PathVariable("id") Long id) {
		Semestr gr = semestrService.getSemestrById(id);
		return new ResponseEntity<Semestr>(gr, HttpStatus.OK);
	}

	@GetMapping("semestr/sum/{id}")
	public @ResponseBody Long getSum(@PathVariable("id") Long id) {

		return repo.sumAllHoursById(id);
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

	@PostMapping("semestr")
	public ResponseEntity<Void> addSemestr(@RequestBody Semestr gr, UriComponentsBuilder builder) {
		boolean flag = semestrService.addSemestr(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/semestr/{id}").buildAndExpand(gr.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("semestr")
	public ResponseEntity<Semestr> updateSemestr(@RequestBody Semestr gr) {
		if (semestrService.existsSemestr(gr.getId())) {
			semestrService.updateSemestr(gr);
			return new ResponseEntity<Semestr>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<Semestr>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("semestr/{id}")
	public ResponseEntity<Void> deleteSemestr(@PathVariable("id") Long id) {
		if (semestrService.existsSemestr(id)) {
			semestrService.deleteSemestr(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
