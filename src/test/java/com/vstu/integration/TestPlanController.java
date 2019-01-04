package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vstu.entity.Plan;
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.SpecialityService;



/**
 * integration tests for Speciality api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestPlanController {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	SpecialityService specialityService;
	
	@Autowired
	NodeService nodeService;
	
	
	@Test
	public void testGetPlanWithCorrectId() throws Exception {
		
		Plan plan = new Plan();
		plan.setId(1);
		plan.setSetdatagroup(2009);
		plan.setSpeciality(specialityService.getSpecialityById(1L));
		plan.setNodes(nodeService.getAllByPlanId(1L));
		mockMvc.perform(get("/plan/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(plan.getId()))
				   .andExpect(jsonPath("$.setDataGroup").value(plan.getSetDataGroup()))
				   .andExpect(jsonPath("$.speciality").isNotEmpty())
				   .andExpect(jsonPath("$.nodes").isNotEmpty());
				
	}
	
	
	@Test
	public void testGetPlanWithIncorrectId() throws Exception {
		
		mockMvc.perform(get("/plan/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_VALUE))
				   .andExpect(status().isNotFound());
				   
		           	
	}
	
	
	@Test
	public void testGetLoadByYear() throws Exception {
		
		mockMvc.perform(get("/plan/{id}/data/?year=2009",1)
				   .contentType(MediaType.APPLICATION_JSON_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.loadSubjects").isNotEmpty());
		          
		           	
	}
	
	@Test
	public void testUpdatePlan() throws Exception {
		
		Plan plan = new Plan();
		plan.setId(1);
		plan.setSetdatagroup(2008);
		plan.setSpeciality(specialityService.getSpecialityById(2L));
		plan.setNodes(nodeService.getAllByPlanId(1L));
		mockMvc.perform(put("/plan")
				   .content(JsonUtil.toJson(plan))
				   .contentType(MediaType.APPLICATION_JSON_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.setDataGroup").value(plan.getSetDataGroup()))
				   .andExpect(jsonPath("$.speciality.name").value(plan.getSpeciality().getName()));
		          
		           	
	}

}
