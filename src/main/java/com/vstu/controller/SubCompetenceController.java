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

import com.vstu.entity.SubCompetence;
import com.vstu.service.interfaces.ISubCompetenceService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class SubCompetenceController {
	@Autowired
	ISubCompetenceService subCompetenceService;

	@GetMapping("subcompetence/{id}")
	public ResponseEntity<SubCompetence> getSubCompetenceById(@PathVariable("id") Long id) {
		SubCompetence gr = subCompetenceService.getSubCompetenceById(id);
		return new ResponseEntity<SubCompetence>(gr, HttpStatus.OK);
	}

	@GetMapping("subcompetences/{id}")
	public ResponseEntity<List<SubCompetence>> getAllBySubjectId(@PathVariable("id") Long id) {
		List<SubCompetence> list = subCompetenceService.getAllBySubjectId(id);
		return new ResponseEntity<List<SubCompetence>>(list, HttpStatus.OK);
	}

	@GetMapping("subcompetence")
	public ResponseEntity<List<SubCompetence>> getAllSubCompetence() {
		List<SubCompetence> list = subCompetenceService.getAllSubCompetence();
		return new ResponseEntity<List<SubCompetence>>(list, HttpStatus.OK);
	}

	@PostMapping("subcompetence")
	public ResponseEntity<Void> addSubCompetence(@RequestBody SubCompetence gr, UriComponentsBuilder builder) {
		boolean flag = subCompetenceService.addSubCompetence(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subcompetence/{id}").buildAndExpand(gr.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("subcompetence")
	public ResponseEntity<SubCompetence> updateSubCompetence(@RequestBody SubCompetence gr) {
		if (subCompetenceService.existsSubCompetence(gr.getId())) {
			subCompetenceService.updateSubCompetence(gr);
			return new ResponseEntity<SubCompetence>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<SubCompetence>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("subcompetence/{id}")
	public ResponseEntity<Void> deleteSubCompetence(@PathVariable("id") Long id) {
		if (subCompetenceService.existsSubCompetence(id)) {
			subCompetenceService.deleteSubCompetence(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
