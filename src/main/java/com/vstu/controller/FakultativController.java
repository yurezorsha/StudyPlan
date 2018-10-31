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

import com.vstu.entity.Fakultativ;
import com.vstu.service.interfaces.IFakultativService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class FakultativController {
	
	@Autowired
	IFakultativService fakultativService;
	
	@GetMapping("fakultativ/{id}")
	public ResponseEntity<Fakultativ> getFakultativById(@PathVariable("id") Long id) {
		Fakultativ f = fakultativService.getFakultativById(id);
		return new ResponseEntity<Fakultativ>(f, HttpStatus.OK);
	}

	@GetMapping("fakultatives/{id}")
	public ResponseEntity<List<Fakultativ>> getAllPlanId(@PathVariable("id") Long id) {
		List<Fakultativ> list = fakultativService.getAllByPlanId(id);
		return new ResponseEntity<List<Fakultativ>>(list, HttpStatus.OK);
	}

	@GetMapping("fakultativ")
	public ResponseEntity<List<Fakultativ>> getAllFakultativ() {
		List<Fakultativ> list = fakultativService.getAllFakultativ();
		return new ResponseEntity<List<Fakultativ>>(list, HttpStatus.OK);
	}

	@PostMapping("fakultativ")
	public ResponseEntity<Void> addFakultativ(@RequestBody Fakultativ f, UriComponentsBuilder builder) {
		boolean flag = fakultativService.addFakultativ(f);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/fakultativ/{id}").buildAndExpand(f.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("fakultativ")
	public ResponseEntity<Fakultativ> updateFakultativ(@RequestBody Fakultativ f) {
		if (fakultativService.existsFakultativ(f.getId())) {
			fakultativService.updateFakultativ(f);
			return new ResponseEntity<Fakultativ>(f, HttpStatus.OK);
		} else {
			f = null;
			return new ResponseEntity<Fakultativ>(f, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("fakultativ/{id}")
	public ResponseEntity<Void> deleteFakultativ(@PathVariable("id") Long id) {
		if (fakultativService.existsFakultativ(id)) {
			fakultativService.deleteFakultativ(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
