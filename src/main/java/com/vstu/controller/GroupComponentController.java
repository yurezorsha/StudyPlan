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

import com.vstu.entity.GroupComponent;
import com.vstu.service.interfaces.IGroupComponentService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class GroupComponentController {
	@Autowired
	IGroupComponentService groupComponentService;

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
	public ResponseEntity<Void> addGroupComponent(@RequestBody GroupComponent gr, UriComponentsBuilder builder) {
		boolean flag = groupComponentService.addGroupComponent(gr);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/groupcomponent/{id}").buildAndExpand(gr.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("groupcomponent")
	public ResponseEntity<GroupComponent> updateGroupComponent(@RequestBody GroupComponent gr) {
		if (groupComponentService.existsGroupComponent(gr.getId())) {
			groupComponentService.updateGroupComponent(gr);
			return new ResponseEntity<GroupComponent>(gr, HttpStatus.OK);
		} else {
			gr = null;
			return new ResponseEntity<GroupComponent>(gr, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("groupcomponent/{id}")
	public ResponseEntity<Void> deleteGroupComponent(@PathVariable("id") Long id) {
		if (groupComponentService.existsGroupComponent(id)) {
			groupComponentService.deleteGroupComponent(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
