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

import com.vstu.entity.Group;
import com.vstu.service.interfaces.IGroupService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class GroupController {

	@Autowired
	IGroupService groupService;
	
	@GetMapping("group/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable("id") Long id) {
		Group gr = groupService.getGroupById(id);
		return new ResponseEntity<Group>(gr, HttpStatus.OK);
	}

	@GetMapping("groups/{id}")
	public ResponseEntity<List<Group>> getAllPlanId(@PathVariable("id") Long id) {
		List<Group> list = groupService.getAllByPlanId(id);
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}

	@GetMapping("group")
	public ResponseEntity<List<Group>> getAllGroup() {
		List<Group> list = groupService.getAllGroup();
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}

	@PostMapping("group")
	public ResponseEntity<Void> addGroup(@RequestBody Group gr, UriComponentsBuilder builder) {
		boolean flag = groupService.addGroup(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/group/{id}").buildAndExpand(gr.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("group")
	public ResponseEntity<Group> updateGroup(@RequestBody Group gr) {
		if (groupService.existsGroup(gr.getId())) {
			groupService.updateGroup(gr);
			return new ResponseEntity<Group>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<Group>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("group/{id}")
	public ResponseEntity<Void> deleteGroup(@PathVariable("id") Long id) {
		if (groupService.existsGroup(id)) {
			groupService.deleteGroup(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}
}
