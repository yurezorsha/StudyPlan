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

import com.vstu.entity.StudyProgramm;
import com.vstu.service.interfaces.StudyProgramService;

@RestController
@CrossOrigin(origins = "*")
public class StudyProgramController {
	@Autowired
	StudyProgramService studyProgramService;

	@GetMapping("studyprogram/{id}")
	public ResponseEntity<StudyProgramm> getStudyProgramById(@PathVariable("id") Long id) {
		StudyProgramm st = studyProgramService.getStudyProgramById(id);
		return new ResponseEntity<StudyProgramm>(st, HttpStatus.OK);
	}

	@GetMapping("studyprogram")
	public ResponseEntity<List<StudyProgramm>> getAllStudyProgram() {
		List<StudyProgramm> list = studyProgramService.getAllStudyProgram();
		return new ResponseEntity<List<StudyProgramm>>(list, HttpStatus.OK);
	}

	@GetMapping("studyprograms")
	public ResponseEntity<List<StudyProgramm>> getAllStudyProgramByStudyProgram(@PathVariable("id") Long id) {
		List<StudyProgramm> list = studyProgramService.getStudyProgramBySubjectId(id);
		return new ResponseEntity<List<StudyProgramm>>(list, HttpStatus.OK);
	}

	@PostMapping("studyprogram")
	public ResponseEntity<StudyProgramm> addStudyProgram(@RequestBody StudyProgramm st) {
		StudyProgramm s = studyProgramService.addStudyProgram(st);
		return new ResponseEntity<StudyProgramm>(s, HttpStatus.CREATED);
	}

	@PutMapping("studyprogram")
	public ResponseEntity<StudyProgramm> updateStudyProgram(@RequestBody StudyProgramm st) {
		studyProgramService.updateStudyProgram(st);
		return new ResponseEntity<StudyProgramm>(st, HttpStatus.OK);
	}

	@DeleteMapping("studyprogram/{id}")
	public ResponseEntity<Void> deleteStudyProgram(@PathVariable("id") Long id) {
		studyProgramService.deleteStudyProgram(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
