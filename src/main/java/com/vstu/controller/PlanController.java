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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vstu.entity.Plan;
import com.vstu.repository.PlanRepository;
import com.vstu.service.interfaces.IPlanService;

@RestController
@RequestMapping("app")
@CrossOrigin(origins = "*")
public class PlanController {

	@Autowired
	IPlanService planService;

	@Autowired
	PlanRepository planRepo;

	@GetMapping("plan/getYear")
	public int getYearById(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "year1", required = true) int year1,
			@RequestParam(value = "year2", required = true) int year2) {

		return planRepo.getYearById(id);
	}

	@GetMapping("plan/{id}/data")
	public List<Object> getData(@PathVariable("id") Long id, @RequestParam(value = "year", required = true) int year) {

		return planService.getNagruzka(id, year);
	}

	@GetMapping("plan/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable("id") Long id) {
		Plan p = planService.getPlanById(id);
		return new ResponseEntity<Plan>(p, HttpStatus.OK);
	}

	@GetMapping("plans/{id}")
	public ResponseEntity<List<Plan>> getAllSpecialityId(@PathVariable("id") Long id) {
		List<Plan> list = planService.getAllBySpecialityId(id);
		return new ResponseEntity<List<Plan>>(list, HttpStatus.OK);
	}

	@GetMapping("plan")
	public ResponseEntity<List<Plan>> getAllPlan() {
		List<Plan> list = planService.getAllPlan();
		return new ResponseEntity<List<Plan>>(list, HttpStatus.OK);
	}

	@PostMapping("plan")
	public ResponseEntity<Void> addPlan(@RequestBody Plan p, UriComponentsBuilder builder) {
		boolean flag = planService.addPlan(p);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/plan/{id}").buildAndExpand(p.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("plan")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan p) {
		if (planService.existsPlan(p.getId())) {
			planService.updatePlan(p);
			return new ResponseEntity<Plan>(p, HttpStatus.OK);
		} else {
			p = null;
			return new ResponseEntity<Plan>(p, HttpStatus.CONFLICT);

		}
	}

	@DeleteMapping("plan/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable("id") Long id) {
		if (planService.existsPlan(id)) {
			planService.deletePlan(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);

		}
	}

}
