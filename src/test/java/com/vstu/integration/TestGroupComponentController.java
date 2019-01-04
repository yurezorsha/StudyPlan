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

import com.vstu.entity.GroupComponent;
import com.vstu.entity.Subject;
import com.vstu.service.interfaces.GroupUnitService;

/**
 * integration tests for GroupComponent api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestGroupComponentController {
	@Autowired
	private MockMvc mockMvc;
		
	@Test
	public void testGetGroupComponentWithCorrectId() throws Exception {
		
		GroupComponent groupComponent=new GroupComponent() ;
		groupComponent.setId(1);
		groupComponent.setName("Государственный компонент");
		
		mockMvc.perform(get("/groupcomponent/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(groupComponent.getId()))
				   .andExpect(jsonPath("$.name").value(groupComponent.getName()));
				  		
		
	}
	
	@Test
	public void testGetGroupComponentWithIncorrectId() throws Exception {
		
		mockMvc.perform(get("/groupcomponent/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				  		
		
	}
	
	@Test
	public void testPostGroupComponent() throws Exception {
		
		GroupComponent groupComponent=new GroupComponent() ;
		groupComponent.setName("2");
		
		mockMvc.perform(post("/groupcomponent")
				   .content(JsonUtil.toJson(groupComponent))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.name").value(groupComponent.getName()));
				 
			
	}
	
	@Test
	public void testDeleteGroupComponent() throws Exception {
		
		mockMvc.perform(delete("/groupcomponent/{id}", 3L)
				   .contentType(MediaType.APPLICATION_JSON_VALUE)
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(status().isOk());
				   
				   	
	}

	
	
}
