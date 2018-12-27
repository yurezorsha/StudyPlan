package com.vstu.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hibernate.exception.ConstraintViolationException;
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

import com.vstu.entity.GroupUnit;
import com.vstu.exceptions.EntityNotFoundException;
import com.vstu.service.interfaces.GroupComponentService;


/**
 * integration tests for GroupUnit api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestGroupUnitController {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	public GroupComponentService groupComponentService;
	
	@Test
	public void testGetGroupUnitWithCorrectId() throws Exception {
		
		GroupUnit groupUnit = new GroupUnit();
		groupUnit.setId(1);
		groupUnit.setName("Социально-гуманитарный модуль 1");
		groupUnit.setGroupComponent(groupComponentService.getGroupComponentById(1L));
		
		mockMvc.perform(get("/groupunit/{id}", 1L)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(groupUnit.getId()))
				   .andExpect(jsonPath("$.name").value(groupUnit.getName()))
				   .andExpect(jsonPath("$.groupComponent.id").value(groupUnit.getGroupComponent().getId()))
		           .andExpect(jsonPath("$.groupComponent.name").value(groupUnit.getGroupComponent().getName()));
		
		
		
	}
	
	@Test
	public void testGetListGroupUnitByGroupComponentId() throws Exception {
		
		mockMvc.perform(get("/groupunits/{id}", 1L)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$[0].id").value(1L))
				   .andExpect(jsonPath("$[0].name").value("Социально-гуманитарный модуль 1"));
		
		
		
	}
	
	@Test
	public void testGetGroupUnitWithIncorrectId() throws Exception {
		
		mockMvc.perform(get("/groupunit/{id}", 15L)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				   
		
		
	}
	
	
	@Test
	public void testPostGroupUnit() throws Exception {
		
		GroupUnit groupUnit =new GroupUnit();
		groupUnit.setName("Тестовый модуль");
		groupUnit.setGroupComponent(groupComponentService.getGroupComponentById(4L));
		
		mockMvc.perform(post("/groupunit")
		           .content(JsonUtil.toJson(groupUnit))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.name").value(groupUnit.getName()))
				   .andExpect(jsonPath("$.groupComponent.id").value(groupUnit.getGroupComponent().getId()))
		           .andExpect(jsonPath("$.groupComponent.name").value(groupUnit.getGroupComponent().getName()));
		
		
		
	}
	
	@Test
	public void testUpdateGroupUnit() throws Exception {
		
		GroupUnit groupUnit =new GroupUnit();
		groupUnit.setId(1);
		groupUnit.setName("Тестовый модуль");
		groupUnit.setGroupComponent(groupComponentService.getGroupComponentById(2L));
		
		mockMvc.perform(put("/groupunit")
		           .content(JsonUtil.toJson(groupUnit))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.name").value(groupUnit.getName()))
				   .andExpect(jsonPath("$.groupComponent.id").value(groupUnit.getGroupComponent().getId()))
		           .andExpect(jsonPath("$.groupComponent.name").value(groupUnit.getGroupComponent().getName()));
		
		
		
	}
	
	
	@Test
	public void testDeleteGroupUnitWithIncorrectId() throws Exception {
		
		mockMvc.perform(delete("/groupunit/{id}", 15L)
				   .contentType(MediaType.APPLICATION_JSON_VALUE)
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(status().isNotFound());
				   
		
		
	}
	
	

}
