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

import com.vstu.entity.CreatorStudyProgramm;
import com.vstu.service.interfaces.ICreatorStudyProgramService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class CreatorStudyProgramController {
	@Autowired
	ICreatorStudyProgramService creatorStudyProgramService;

	@GetMapping("creatorstudyprogram/{id}")
	public ResponseEntity<CreatorStudyProgramm> getCreatorStudyProgramById(@PathVariable("id") Long id) {
		CreatorStudyProgramm creator = creatorStudyProgramService.getCreatorStudyProgramById(id);
		return new ResponseEntity<CreatorStudyProgramm>(creator, HttpStatus.OK);
	}

	@GetMapping("creatorstudyprogram")
	public ResponseEntity<List<CreatorStudyProgramm>> getAllCreatorStudyProgram() {
		List<CreatorStudyProgramm> list = creatorStudyProgramService.getAllCreatorStudyProgram();
		return new ResponseEntity<List<CreatorStudyProgramm>>(list, HttpStatus.OK);
	}

	@GetMapping("creatorstudyprograms/{id}")
	public ResponseEntity<List<CreatorStudyProgramm>> getAllCreatorStudyProgramByStudyProgram(
			@PathVariable("id") Long id) {
		List<CreatorStudyProgramm> list = creatorStudyProgramService.getCreatorStudyProgramByStudyProgramId(id);
		return new ResponseEntity<List<CreatorStudyProgramm>>(list, HttpStatus.OK);
	}

	@PostMapping("creatorstudyprogram")
	public ResponseEntity<CreatorStudyProgramm> addCreatorStudyProgram(@RequestBody CreatorStudyProgramm c) {
		CreatorStudyProgramm creator = creatorStudyProgramService.addCreatorStudyProgram(c);
		return new ResponseEntity<CreatorStudyProgramm>(creator, HttpStatus.CREATED);
	}

	@PutMapping("creatorstudyprogram")
	public ResponseEntity<CreatorStudyProgramm> updateCreatorStudyProgram(@RequestBody CreatorStudyProgramm c) {
		CreatorStudyProgramm creator = creatorStudyProgramService.updateCreatorStudyProgram(c);
		return new ResponseEntity<CreatorStudyProgramm>(creator, HttpStatus.OK);
	}

	@DeleteMapping("creatorstudyprogram/{id}")
	public ResponseEntity<Void> deleteCreatorStudyProgram(@PathVariable("id") Long id) {
		creatorStudyProgramService.deleteCreatorStudyProgram(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
