package com.vstu.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
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
import org.thymeleaf.standard.expression.AndExpression;

import com.vstu.entity.GroupUnit;
import com.vstu.entity.Node;
import com.vstu.entity.Semestr;
import com.vstu.entity.Subject;
import com.vstu.service.interfaces.PlanService;
import com.vstu.service.interfaces.SubjectService;

/**
 * integration tests for Node api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-subj-unit-group-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-subj-unit-group-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestNodeController {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	public SubjectService subjectService;
	
	@Autowired
	public PlanService planService;

	
	@Test
	public void testGetNodeWithCorrectId() throws Exception {
		
		Node node =new Node();
		node.setId(1);
		node.setIdCathedra(1);
		node.setSubject(subjectService.getSubjectById(1L));
		node.setPlan(planService.getPlanById(1L));
		
		
		mockMvc.perform(get("/node/{id}", 1L)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(node.getId()))
				   .andExpect(jsonPath("$.idCathedra").value(node.getIdCathedra()))
				   .andExpect(jsonPath("$.subject.id").value(node.getSubject().getId()));
		            
		
				   	
	}
	
	@Test
	public void testPostNodeWithCorrectId() throws Exception {
		Node node =new Node();
		node.setIdCathedra(1);
		node.setSubject(subjectService.getSubjectById(3L));
		
		List<Semestr> sem=new LinkedList<>();
		Semestr s=new Semestr();
		s.setSeminar(20);
		s.setLecture(20);
		s.setNumber(1);
		sem.add(s);
		node.setSemestrs(sem);
		
		
		mockMvc.perform(post("/node/{id}", 1L)
				   .content(JsonUtil.toJson(node))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
	               .andExpect(jsonPath("$.id").isNotEmpty())
	           	   .andExpect(jsonPath("$.idCathedra").value(node.getIdCathedra()))
		           .andExpect(jsonPath("$.subject.id").value(node.getSubject().getId()))
		           .andExpect(jsonPath("$.semestrs[0].id").isNotEmpty())
		           .andExpect(jsonPath("$.semestrs[0].number").value(s.getNumber()))
		           .andExpect(jsonPath("$.semestrs[0].seminar").value(s.getSeminar()))
		           .andExpect(jsonPath("$.semestrs[0].lecture").value(s.getLecture()));
		            
		
				   	
	}
	
	@Test
	public void testPostNodeIfExist() throws Exception {
		Node node =new Node();
		node.setIdCathedra(1);
		node.setSubject(subjectService.getSubjectById(1L));
		
		List<Semestr> sem=new LinkedList<>();
		Semestr s=new Semestr();
		s.setSeminar(20);
		s.setLecture(20);
		s.setNumber(1);
		sem.add(s);
		node.setSemestrs(sem);
		
		mockMvc.perform(post("/node/{id}", 1L)
				   .content(JsonUtil.toJson(node))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isConflict());
	               
		            
				   	
	}
	
	@Test
	public void testUpdateNode() throws Exception {
		Node node =new Node();
		node.setIdCathedra(1);
		node.setSubject(subjectService.getSubjectById(3L));
		
		List<Semestr> sem=new LinkedList<>();
		Semestr s=new Semestr();
		s.setId(1);
		s.setSeminar(20);
		s.setLecture(20);
		s.setNumber(1);
		sem.add(s);
		node.setSemestrs(sem);
		node.setId(1);
		node.setIdCathedra(5);
		node.setSubject(subjectService.getSubjectById(4L));
	
		
		mockMvc.perform(put("/node/{id}", 1L)
				   .content(JsonUtil.toJson(node))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(node.getId()))
		           .andExpect(jsonPath("$.idCathedra").value(node.getIdCathedra()))
		           .andExpect(jsonPath("$.subject.id").value(node.getSubject().getId()));
		
	            
				   	
	}

	
	@Test
	public void testGetNodeIncorrectId() throws Exception {
		
		mockMvc.perform(get("/node/{id}", 5L)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				              
			   	
	}
	
	

}
