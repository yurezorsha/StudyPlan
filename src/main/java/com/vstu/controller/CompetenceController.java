package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Competence;
import com.vstu.service.interfaces.CompetenceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CompetenceController {
	@Autowired
	CompetenceService competenceService;

	@GetMapping("competence/{id}")
	public ResponseEntity<Competence> getCompetenceById(@PathVariable("id") Long id) {
		Competence c = competenceService.getCompetenceById(id);
		return new ResponseEntity<Competence>(c, HttpStatus.OK);
	}

	@GetMapping("competence")
	public ResponseEntity<List<Competence>> getAllCompetence() {
		List<Competence> list = competenceService.getAllCompetence();
		return new ResponseEntity<List<Competence>>(list, HttpStatus.OK);
	}

	@PostMapping("competence")
	public ResponseEntity<Competence> addCompetence(@RequestBody Competence c) {
		Competence com = competenceService.addCompetence(c);

		return new ResponseEntity<Competence>(com, HttpStatus.CREATED);
	}

	@PutMapping("competence")
	public ResponseEntity<Competence> updateCompetence(@RequestBody Competence c) {
		Competence com = competenceService.updateCompetence(c);
		return new ResponseEntity<Competence>(com, HttpStatus.OK);

	}

	@DeleteMapping("competence/{id}")
	public ResponseEntity<Void> deleteCompetence(@PathVariable("id") Long id) {
		competenceService.deleteCompetence(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
