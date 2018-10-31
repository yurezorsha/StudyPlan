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

import com.vstu.entity.WeeksSemestr;
import com.vstu.service.interfaces.IWeeksSemestrService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class WeeksSemestrController {
	
	@Autowired
	IWeeksSemestrService weeksSemestrService;
	
	@GetMapping("weekssemestr/{id}")
	public ResponseEntity<WeeksSemestr> getWeeksSemestrById(@PathVariable("id") Long id) {
		WeeksSemestr w = weeksSemestrService.getWeeksSemestrById(id);
		return new ResponseEntity<WeeksSemestr>(w, HttpStatus.OK);
	}

	@GetMapping("weekssemestrs/{id}")
	public ResponseEntity<List<WeeksSemestr>> getAllPlanId(@PathVariable("id") Long id) {
		List<WeeksSemestr> list = weeksSemestrService.getAllByPlanId(id);
		return new ResponseEntity<List<WeeksSemestr>>(list, HttpStatus.OK);
	}

	@GetMapping("weekssemestr")
	public ResponseEntity<List<WeeksSemestr>> getAllWeeksSemestr() {
		List<WeeksSemestr> list = weeksSemestrService.getAllWeeksSemestr();
		return new ResponseEntity<List<WeeksSemestr>>(list, HttpStatus.OK);
	}

	@PostMapping("weekssemestr")
	public ResponseEntity<Void> addCertification(@RequestBody WeeksSemestr w, UriComponentsBuilder builder) {
		boolean flag = weeksSemestrService.addWeeksSemestr(w);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/weekssemestr/{id}").buildAndExpand(w.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("weekssemestr")
	public ResponseEntity<WeeksSemestr> updateWeeksSemestr(@RequestBody WeeksSemestr w) {
		if (weeksSemestrService.existsWeeksSemestr(w.getId())) {
			weeksSemestrService.updateWeeksSemestr(w);
			return new ResponseEntity<WeeksSemestr>(w, HttpStatus.OK);
		} else {
			w = null;
			return new ResponseEntity<WeeksSemestr>(w, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("weekssemestr/{id}")
	public ResponseEntity<Void> deleteWeeksSemestr(@PathVariable("id") Long id) {
		if (weeksSemestrService.existsWeeksSemestr(id)) {
			weeksSemestrService.deleteWeeksSemestr(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}


}
