package com.vstu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.Subject;
import com.vstu.service.interfaces.SubjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SubjectController {
	@Autowired
	SubjectService subjectService;

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
	public ResponseEntity<Subject> addSubject(@RequestBody @Valid Subject sb) {
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
