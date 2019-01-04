package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.vstu.entity.GroupUnit;
import com.vstu.entity.Subject;
import com.vstu.service.interfaces.GroupComponentService;
import com.vstu.service.interfaces.GroupUnitService;

/**
 * integration tests for Subject api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestSubjectController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	public GroupUnitService groupUnitService;
	
	
	@Test
	public void testGetSubjectWithCorrectId() throws Exception {
		
		Subject subject =new Subject();
	    subject.setId(3);
		subject.setName("Философия");
		subject.setShifr("Фил");
		subject.setGroupUnit(groupUnitService.getGroupUnitById(1L));
				
		
		mockMvc.perform(get("/subject/{id}", 3)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(subject.getId()))
				   .andExpect(jsonPath("$.name").value(subject.getName()))
				   .andExpect(jsonPath("$.groupUnit.id").value(subject.getGroupUnit().getId()))
		           .andExpect(jsonPath("$.groupUnit.name").value(subject.getGroupUnit().getName()));
		
				
	}
	
	@Test
	public void testGetListSubjectByIdGroupUnit() throws Exception {
			
		mockMvc.perform(get("/subjects/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$[0].name").value("История"))
				   .andExpect(jsonPath("$[1].name").value("Политология"))
				   .andExpect(jsonPath("$[2].name").value("Философия"))
		           .andExpect(jsonPath("$[3].name").value("Экономика"));
		
		
		
	}

	
	@Test
	public void testGetSubjectWithIncorrectId() throws Exception {
		
		mockMvc.perform(get("/subject/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				  		
		
	}
	
	@Test
	public void testPostSubject() throws Exception {
		
		Subject subject =new Subject();
		subject.setName("Тестовый предмет");
		subject.setShifr("Тест");
		subject.setGroupUnit(groupUnitService.getGroupUnitById(1L));
		
		mockMvc.perform(post("/subject")
				   .content(JsonUtil.toJson(subject))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.name").value(subject.getName()))
				   .andExpect(jsonPath("$.groupUnit.id").value(subject.getGroupUnit().getId()))
		           .andExpect(jsonPath("$.groupUnit.name").value(subject.getGroupUnit().getName()));
		
		
		
	}
	
	@Test
	public void testPostSubjectWithExistSubject() throws Exception {
		
		Subject subject =new Subject();
		subject.setName("История");
			
		mockMvc.perform(post("/subject")
				   .content(JsonUtil.toJson(subject))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isConflict());
				   	
	}
	
	@Test
	public void testUpdateSubjectIfNotExist() throws Exception {
		
		Subject subject =new Subject();
		subject.setId(20);
		subject.setName("История");
			
		mockMvc.perform(put("/subject")
				   .content(JsonUtil.toJson(subject))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				   	
	}
	
	@Test
	public void testDeleteSubject() throws Exception {
		
		mockMvc.perform(delete("/subject/{id}", 3L)
				   .contentType(MediaType.APPLICATION_JSON_VALUE)
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(status().isOk());
				   
				   	
	}

}
