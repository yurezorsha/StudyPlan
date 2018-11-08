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

import com.vstu.entity.Type;
import com.vstu.service.interfaces.ITypeService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class TypeController {

	@Autowired
	ITypeService typeService;

	@GetMapping("type/{id}")
	public ResponseEntity<Type> getTypeById(@PathVariable("id") Long id) {
		Type t = typeService.getTypeById(id);
		return new ResponseEntity<Type>(t, HttpStatus.OK);
	}

	@GetMapping("type")
	public ResponseEntity<List<Type>> getAllType() {
		List<Type> list = typeService.getAllType();
		return new ResponseEntity<List<Type>>(list, HttpStatus.OK);
	}

	@PostMapping("type")
	public ResponseEntity<Void> addType(@RequestBody Type t, UriComponentsBuilder builder) {
		boolean flag = typeService.addType(t);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/type/{id}").buildAndExpand(t.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("type")
	public ResponseEntity<Type> updateType(@RequestBody Type t) {
		if (typeService.existsType(t.getId())) {
			typeService.updateType(t);
			return new ResponseEntity<Type>(t, HttpStatus.OK);
		} else {
			t = null;
			return new ResponseEntity<Type>(t, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("type/{id}")
	public ResponseEntity<Void> deleteType(@PathVariable("id") Long id) {
		if (typeService.existsType(id)) {
			typeService.deleteType(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
