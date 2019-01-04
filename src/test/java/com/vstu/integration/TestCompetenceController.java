package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.vstu.entity.Competence;


/**
 * integration tests for Competence api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestCompetenceController {
	
	@Autowired
	private MockMvc mockMvc;
		
	@Test
	public void testCompetenceWithCorrectId() throws Exception {
		Competence competence = new Competence();
		competence.setId(1);
		competence.setCode("БПК-3");
		competence.setNameCompetence("Быть способным использовать \r\n" + 
				                     "основные законы электротехники \r\n" + 
				                     "и владеть методами их применения, \r\n" + 
				                     "применять электронные элементы \r\n" + 
									 "и приборы в системах автоматизации");
		
		mockMvc.perform(get("/competence/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(competence.getId()))
				   .andExpect(jsonPath("$.nameCompetence").isNotEmpty())
				   .andExpect(jsonPath("$.code").value(competence.getCode()));
				  		
		
	}
	
	
	@Test
	public void testCompetenceWithIncorrectId() throws Exception {
				
		mockMvc.perform(get("/competence/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				   
		
	}
	
	
	@Test
	public void testPostCompetence() throws Exception {
		Competence competence = new Competence();
		competence.setCode("test");
		competence.setNameCompetence("test");
		
		mockMvc.perform(post("/competence")
				   .content(JsonUtil.toJson(competence))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		           .andExpect(status().isCreated())
		           .andExpect(jsonPath("$.id").isNotEmpty())
		           .andExpect(jsonPath("$.code").value(competence.getCode()))
		           .andExpect(jsonPath("$.nameCompetence").value(competence.getNameCompetence()));
		
	}
	
	
	@Test
	public void testPutCompetence() throws Exception {
		Competence competence = new Competence();
		competence.setId(1);
		competence.setCode("test");
		competence.setNameCompetence("test");
		
		mockMvc.perform(put("/competence")
				   .content(JsonUtil.toJson(competence))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		           .andExpect(status().isOk())
		           .andExpect(jsonPath("$.id").value(competence.getId()))
		           .andExpect(jsonPath("$.code").value(competence.getCode()))
		           .andExpect(jsonPath("$.nameCompetence").value(competence.getNameCompetence()));
		
	}
	

}
