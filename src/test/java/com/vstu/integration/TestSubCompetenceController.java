package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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

import com.vstu.entity.SubCompetence;
import com.vstu.service.interfaces.CompetenceService;
import com.vstu.service.interfaces.SubjectService;



/**
 * integration tests for SubCompetence api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestSubCompetenceController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CompetenceService competenceService;
	
	@Autowired
	private SubjectService subjectService;
		
	@Test
	public void testGetSubCompetenceWithCorrectId() throws Exception {
		
		SubCompetence subCompetence=new SubCompetence();
		subCompetence.setId(1);
		subCompetence.setCompetence(competenceService.getCompetenceById(1L));
		subCompetence.setSubject(subjectService.getSubjectById(1L));
		
		mockMvc.perform(get("/subcompetence/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(subCompetence.getId()))
				   .andExpect(jsonPath("$.competence.id").value(subCompetence.getCompetence().getId()))
				   .andExpect(jsonPath("$.subject.id").value(subCompetence.getSubject().getId()));
				  		
		
	}
	
	
	@Test
	public void testGetSubCompetenceWithInCorrectId() throws Exception {
		
		mockMvc.perform(get("/subcompetence/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				 
				  			
	}
	
	
	@Test
	public void testGetListSubCompetenceBySubjectId() throws Exception {
			
		mockMvc.perform(get("/subcompetences/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$[0].id").isNotEmpty())
				   .andExpect(jsonPath("$[0].competence").isNotEmpty())
				   .andExpect(jsonPath("$[0].subject").isNotEmpty());				   
				  		
		
	}
	
	
	@Test
	public void testPostSubCompetence() throws Exception {
		
		SubCompetence subCompetence=new SubCompetence();
		subCompetence.setCompetence(competenceService.getCompetenceById(1L));
		subCompetence.setSubject(subjectService.getSubjectById(2L));
		
		mockMvc.perform(post("/subcompetence")
				   .content(JsonUtil.toJson(subCompetence))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.competence.id").value(subCompetence.getCompetence().getId()))
				   .andExpect(jsonPath("$.subject.id").value(subCompetence.getSubject().getId()));
				  		
		
	}
	
	
	@Test
	public void testPutSubCompetence() throws Exception {
		
		SubCompetence subCompetence=new SubCompetence();
		subCompetence.setId(1);
		subCompetence.setCompetence(competenceService.getCompetenceById(1L));
		subCompetence.setSubject(subjectService.getSubjectById(2L));
		
		mockMvc.perform(put("/subcompetence")
				   .content(JsonUtil.toJson(subCompetence))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.competence.id").value(subCompetence.getCompetence().getId()))
				   .andExpect(jsonPath("$.subject.id").value(subCompetence.getSubject().getId()));
				  		
		
	}
	
	
	
	
	
	

}
