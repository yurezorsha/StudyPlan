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

import com.vstu.entity.Type;
import com.vstu.service.interfaces.TypeService;

@RestController
@CrossOrigin(origins = "*")
public class TypeController {

	@Autowired
	TypeService typeService;

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
	public ResponseEntity<Type> addType(@RequestBody Type t) {
		Type type = typeService.addType(t);
		return new ResponseEntity<Type>(type, HttpStatus.CREATED);
	}

	@PutMapping("type")
	public ResponseEntity<Type> updateType(@RequestBody Type t) {
		Type type = typeService.updateType(t);
		return new ResponseEntity<Type>(type, HttpStatus.OK);
	}

	@DeleteMapping("type/{id}")
	public ResponseEntity<Void> deleteType(@PathVariable("id") Long id) {
		typeService.deleteType(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
