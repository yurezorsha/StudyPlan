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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Subject;
import com.vstu.service.interfaces.ISubjectService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class SubjectController {
	@Autowired
	ISubjectService subjectService;

	@GetMapping("subject/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id) {
		Subject sb = subjectService.getSubjectById(id);
		return new ResponseEntity<Subject>(sb, HttpStatus.OK);
	}

	@GetMapping("subject")
	public ResponseEntity<List<Subject>> getAllSubject() {
		List<Subject> list = subjectService.getAllSubject();
		return new ResponseEntity<List<Subject>>(list, HttpStatus.OK);
	}

	@GetMapping("subjects/{id}")
	public ResponseEntity<List<Subject>> getAllSubjectByGroupUnitId(@PathVariable("id") Long id) {
		List<Subject> list = subjectService.getSubjectByGroupUnitId(id);
		return new ResponseEntity<List<Subject>>(list, HttpStatus.OK);
	}

	@PostMapping("subject")
	public ResponseEntity<Subject> addSubject(@RequestBody Subject sb, UriComponentsBuilder builder) {
		Subject subj = subjectService.addSubject(sb);
		return new ResponseEntity<Subject>(subj, HttpStatus.CREATED);
	}

	@PutMapping("subject")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject sb) {
		Subject subj = subjectService.updateSubject(sb);
		return new ResponseEntity<Subject>(subj, HttpStatus.OK);

	}

	@DeleteMapping("subject/{id}")
	public ResponseEntity<Void> deleteSubject(@PathVariable("id") Long id) {
		subjectService.deleteSubject(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
