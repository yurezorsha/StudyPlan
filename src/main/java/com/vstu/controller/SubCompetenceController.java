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
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.SubCompetence;
import com.vstu.service.interfaces.SubCompetenceService;

@RestController
@CrossOrigin(origins = "*")
public class SubCompetenceController {
	@Autowired
	SubCompetenceService subCompetenceService;

	@GetMapping("subcompetence/{id}")
	public ResponseEntity<SubCompetence> getSubCompetenceById(@PathVariable("id") Long id) {
		SubCompetence sb = subCompetenceService.getSubCompetenceById(id);
		return new ResponseEntity<SubCompetence>(sb, HttpStatus.OK);
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
	public ResponseEntity<SubCompetence> addSubCompetence(@RequestBody SubCompetence sb, UriComponentsBuilder builder) {
		SubCompetence s = subCompetenceService.addSubCompetence(sb);
		return new ResponseEntity<SubCompetence>(s, HttpStatus.CREATED);
	}

	@PutMapping("subcompetence")
	public ResponseEntity<SubCompetence> updateSubCompetence(@RequestBody SubCompetence sb) {
		subCompetenceService.updateSubCompetence(sb);
		return new ResponseEntity<SubCompetence>(sb, HttpStatus.OK);
	}

	@DeleteMapping("subcompetence/{id}")
	public ResponseEntity<Void> deleteSubCompetence(@PathVariable("id") Long id) {
		subCompetenceService.deleteSubCompetence(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
