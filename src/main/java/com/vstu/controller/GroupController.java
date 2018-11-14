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

import com.vstu.entity.Groups;
import com.vstu.service.interfaces.IGroupService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class GroupController {

	@Autowired
	IGroupService groupService;

	@GetMapping("group/{id}")
	public ResponseEntity<Groups> getGroupsById(@PathVariable("id") Long id) {
		Groups gr = groupService.getGroupsById(id);
		return new ResponseEntity<Groups>(gr, HttpStatus.OK);
	}

	@GetMapping("groups/{id}")
	public ResponseEntity<List<Groups>> getAllPlanId(@PathVariable("id") Long id) {
		List<Groups> list = groupService.getAllByPlanId(id);
		return new ResponseEntity<List<Groups>>(list, HttpStatus.OK);
	}

	@GetMapping("group")
	public ResponseEntity<List<Groups>> getAllGroups() {
		List<Groups> list = groupService.getAllGroups();
		return new ResponseEntity<List<Groups>>(list, HttpStatus.OK);
	}

	@PostMapping("group")
	public ResponseEntity<Groups> addGroups(@RequestBody Groups gr) {
		Groups g = groupService.addGroups(gr);
		return new ResponseEntity<Groups>(g, HttpStatus.CREATED);
	}

	@PutMapping("group")
	public ResponseEntity<Groups> updateGroups(@RequestBody Groups gr) {
		Groups g = groupService.updateGroups(gr);
		return new ResponseEntity<Groups>(gr, HttpStatus.OK);
	}

	@DeleteMapping("group/{id}")
	public ResponseEntity<Void> deleteGroups(@PathVariable("id") Long id) {
		groupService.deleteGroups(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
