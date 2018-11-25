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

import com.vstu.entity.GroupUnit;
import com.vstu.service.interfaces.GroupUnitService;

@RestController
@CrossOrigin(origins = "*")
public class GroupUnitController {
	@Autowired
	GroupUnitService groupUnitService;

	@GetMapping("groupunit/{id}")
	public ResponseEntity<GroupUnit> getGroupUnitById(@PathVariable("id") Long id) {
		GroupUnit gr = groupUnitService.getGroupUnitById(id);
		return new ResponseEntity<GroupUnit>(gr, HttpStatus.OK);
	}

	@GetMapping("groupunits/{id}")
	public ResponseEntity<List<GroupUnit>> getAllByGroupComponent(@PathVariable("id") Long id) {
		List<GroupUnit> list = groupUnitService.getAllByGroupComponentId(id);
		return new ResponseEntity<List<GroupUnit>>(list, HttpStatus.OK);
	}

	@GetMapping("groupunit")
	public ResponseEntity<List<GroupUnit>> getAllGroupUnit() {
		List<GroupUnit> list = groupUnitService.getAllGroupUnit();
		return new ResponseEntity<List<GroupUnit>>(list, HttpStatus.OK);
	}

	@PostMapping("groupunit")
	public ResponseEntity<GroupUnit> addGroupUnit(@RequestBody GroupUnit gr) {

		GroupUnit gu = groupUnitService.addGroupUnit(gr);

		return new ResponseEntity<GroupUnit>(gu, HttpStatus.CREATED);
	}

	@PutMapping("groupunit")
	public ResponseEntity<GroupUnit> updateGroupUnit(@RequestBody GroupUnit gr) {
		GroupUnit gu = groupUnitService.updateGroupUnit(gr);
		return new ResponseEntity<GroupUnit>(gr, HttpStatus.OK);
	}

	@DeleteMapping("groupunit/{id}")
	public ResponseEntity<Void> deleteGroupUnit(@PathVariable("id") Long id) {
		groupUnitService.deleteGroupUnit(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
