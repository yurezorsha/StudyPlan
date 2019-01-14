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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vstu.entity.Plan;
import com.vstu.entity.data.DataAllLoad;
import com.vstu.service.interfaces.PlanService;

@RestController
@CrossOrigin(origins = "*")
public class PlanController {

	@Autowired
	PlanService planService;

	@GetMapping("plan/{id}/data")
	public ResponseEntity<DataAllLoad> getData(@PathVariable("id") Long id,
			@RequestParam(value = "year", required = true) int year) {

		return new ResponseEntity<DataAllLoad>(planService.getLoad(id, year), HttpStatus.OK);
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
	public ResponseEntity<Plan> addPlan(@RequestBody Plan p) {
		Plan plan = planService.addPlan(p);

		return new ResponseEntity<Plan>(plan, HttpStatus.CREATED);
	}

	@PutMapping("plan")
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan p) {
		Plan plan = planService.updatePlan(p);
		return new ResponseEntity<Plan>(plan, HttpStatus.OK);
	}

	@DeleteMapping("plan/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable("id") Long id) {
		planService.deletePlan(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("plan/doc/upload/{id}")
	public ResponseEntity<Void> uploadDocByPlanId(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file ) {
		planService.uploadDocByPlanId(id, file);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("plan/doc/download/{id}")
	public ResponseEntity<byte[]> uploadDocByPlanId(@PathVariable("id") Long id) {
		byte[] file = planService.downloadDocByPlanId(id);
		String  fileName=planService.getPlanById(id).getFileName();
		
		
		return   ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(file);	
	}

}
