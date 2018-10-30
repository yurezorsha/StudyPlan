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

import com.vstu.entity.GroupUnit;
import com.vstu.service.interfaces.IGroupUnitService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class GroupUnitController {
	@Autowired
	IGroupUnitService groupUnitService;

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
	public ResponseEntity<Void> addGroupUnit(@RequestBody GroupUnit gr, UriComponentsBuilder builder) {
		boolean flag = groupUnitService.addGroupUnit(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/groupunit/{id}").buildAndExpand(gr.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("groupunit")
	public ResponseEntity<GroupUnit> updateGroupUnit(@RequestBody GroupUnit gr) {
		if (groupUnitService.existsGroupUnit(gr.getId())) {
			groupUnitService.updateGroupUnit(gr);
			return new ResponseEntity<GroupUnit>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<GroupUnit>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("groupunit/{id}")
	public ResponseEntity<Void> deleteGroupUnit(@PathVariable("id") Long id) {
		if (groupUnitService.existsGroupUnit(id)) {
			groupUnitService.deleteGroupUnit(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
