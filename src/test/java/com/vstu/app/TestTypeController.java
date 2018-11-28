package com.vstu.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vstu.entity.Type;


/**
 * integration tests for Type api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/create-type-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/delete-type-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestTypeController {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetTypeWithCorrectId() throws Exception {
		Type t= new Type();
		t.setId(2);
		t.setName("диф. зачет");
		t.setKoff(0.35f);

		mockMvc.perform(get("/type/{id}", 2L)
			   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$.id").value(t.getId()))
			   .andExpect(jsonPath("$.name").value(t.getName()))
			   .andExpect(jsonPath("$.koff").value(t.getKoff()));
			   
	}

	@Test
	public void testAddType() throws Exception {
		Type t= new Type();
		t.setName("test");
		t.setKoff(4L);
		
		 mockMvc.perform(post("/type")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(JsonUtil.toJson(t)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value(t.getName()))
				.andExpect(jsonPath("$.koff").value(t.getKoff()));
		  		
	}

	@Test
	public void testGetTypeWithIncorrectId() throws Exception {

		mockMvc.perform(get("/type/{id}", 6L))
		       .andExpect(status()
		       .isNotFound());

	}
	
	@Test
	public void testUpdateType() throws Exception {
		Type t= new Type();
		t.setId(1);
		t.setName("test");
		t.setKoff(3L);

		mockMvc.perform(put("/type")
		       .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
			   .content(JsonUtil.toJson(t)))
	    	   .andExpect(status().isOk())
	    	   .andExpect(jsonPath("$.name").value(t.getName()))
	    	   .andExpect(jsonPath("$.koff").value(t.getKoff()));
	    	  
	}
	
	@Test
	public void testDeleteType() throws Exception {
		
		mockMvc.perform( delete("/type/{id}",1L)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
		        .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk());
	    	       	  
	}
	
	
}
