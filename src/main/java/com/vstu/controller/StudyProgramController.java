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

import com.vstu.entity.StudyProgramm;
import com.vstu.service.interfaces.IStudyProgramService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class StudyProgramController {
	@Autowired
	IStudyProgramService studyProgramService;

	@GetMapping("studyprogram/{id}")
	public ResponseEntity<StudyProgramm> getStudyProgramById(@PathVariable("id") Long id) {
		StudyProgramm creator = studyProgramService.getStudyProgramById(id);
		return new ResponseEntity<StudyProgramm>(creator, HttpStatus.OK);
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
	public ResponseEntity<Void> addStudyProgram(@RequestBody StudyProgramm creator, UriComponentsBuilder builder) {
		boolean flag = studyProgramService.addStudyProgram(creator);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/studyprogram/{id}").buildAndExpand(creator.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("studyprogram")
	public ResponseEntity<StudyProgramm> updateStudyProgram(@RequestBody StudyProgramm gr) {
		if (studyProgramService.existsStudyProgram(gr.getId())) {
			studyProgramService.updateStudyProgram(gr);
			return new ResponseEntity<StudyProgramm>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<StudyProgramm>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("studyprogram/{id}")
	public ResponseEntity<Void> deleteStudyProgram(@PathVariable("id") Long id) {
		if (studyProgramService.existsStudyProgram(id)) {
			studyProgramService.deleteStudyProgram(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
