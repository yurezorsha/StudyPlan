package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.vstu.entity.StudyProgramm;
import com.vstu.service.interfaces.SubjectService;


/**
 * integration tests for StudyProgramm api
 * 
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value= {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value= {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestStudyProgramController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private SubjectService subjectService;
		
	@Test
	public void testGetStudyProgarmmWithCorrectId() throws Exception {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date =simpleDateFormat.parse("2010-10-05");
		
		StudyProgramm studyProgramm=new StudyProgramm();
		studyProgramm.setId(1);
		studyProgramm.setDateApprove(date);
		studyProgramm.setSubject(subjectService.getSubjectById(1L));
		
		
		mockMvc.perform(get("/studyprogram/{id}", 1)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isOk())
				   .andExpect(jsonPath("$.id").value(studyProgramm.getId()))
				   .andExpect(jsonPath("$.dateApprove").value(simpleDateFormat.format(studyProgramm.getDateApprove())))
				   .andExpect(jsonPath("$.subject.id").value(studyProgramm.getSubject().getId()));
				  		
		
	}
	
	
	@Test
	public void testGetStudyProgarmmWithInCorrectId() throws Exception {
	
		
		mockMvc.perform(get("/studyprogram/{id}", 100)
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
					  		
		
	}
	
	
	@Test
	public void testPostStudyProgarmm() throws Exception {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = simpleDateFormat.parse("2013-05-26");
		
		StudyProgramm studyProgramm=new StudyProgramm();
		studyProgramm.setDateApprove(date);
		studyProgramm.setSubject(subjectService.getSubjectById(2L));
	
		mockMvc.perform(post("/studyprogram")
				   .content(JsonUtil.toJson(studyProgramm))
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isCreated())
				   .andExpect(jsonPath("$.id").isNotEmpty())
				   .andExpect(jsonPath("$.subject.id").value(studyProgramm.getSubject().getId()))
				   .andExpect(jsonPath("$.dateApprove").value(simpleDateFormat.format(studyProgramm.getDateApprove())));
					  		
		
	}
	
	
	@Test
	public void testDeleteStudyProgarmmWithIncorrectId() throws Exception {
		
		mockMvc.perform(delete("/studyprogram/{id}",100)  
				   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				   .andExpect(status().isNotFound());
				 
					  		
		
	}

}
