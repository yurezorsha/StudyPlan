package com.vstu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vstu.entity.GroupComponent;
import com.vstu.service.interfaces.GroupComponentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class GroupComponentController {
	@Autowired
	GroupComponentService groupComponentService;

	@GetMapping("groupcomponent/{id}")
	public ResponseEntity<GroupComponent> getGroupComponentById(@PathVariable("id") Long id) {
		GroupComponent gr = groupComponentService.getGroupComponentById(id);
		return new ResponseEntity<GroupComponent>(gr, HttpStatus.OK);
	}

	@GetMapping("groupcomponent")
	public ResponseEntity<List<GroupComponent>> getAllGroupComponent() {
		List<GroupComponent> list = groupComponentService.getAllGroupComponent();
		return new ResponseEntity<List<GroupComponent>>(list, HttpStatus.OK);
	}

	@PostMapping("groupcomponent")
	public ResponseEntity<GroupComponent> addGroupComponent(@RequestBody GroupComponent gr) {
		GroupComponent gc = groupComponentService.addGroupComponent(gr);

		return new ResponseEntity<GroupComponent>(gc, HttpStatus.CREATED);
	}

	@PutMapping("groupcomponent")
	public ResponseEntity<GroupComponent> updateGroupComponent(@RequestBody GroupComponent gr) {
		GroupComponent gc = groupComponentService.updateGroupComponent(gr);
		return new ResponseEntity<GroupComponent>(gc, HttpStatus.OK);

	}

	@DeleteMapping("groupcomponent/{id}")
	public ResponseEntity<Void> deleteGroupComponent(@PathVariable("id") Long id) {
		groupComponentService.deleteGroupComponent(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
