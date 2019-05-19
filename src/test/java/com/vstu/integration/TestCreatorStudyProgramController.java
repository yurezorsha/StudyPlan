package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vstu.entity.CreatorStudyProgramm;
import com.vstu.service.interfaces.StudyProgramService;

/**
 * integration tests for CreatorStudyProgram api
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestCreatorStudyProgramController {

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.access_token}")
    private String token;

    @Autowired
    private StudyProgramService studyProgramService;

    @Test
    public void testGetCreatorStudyProgramWithCorrectId() throws Exception {

        CreatorStudyProgramm creatorStudyProgramm = new CreatorStudyProgramm();
        creatorStudyProgramm.setId(1);
        creatorStudyProgramm.setIdTeacher(1);
        creatorStudyProgramm.setStudyProgramm(studyProgramService.getStudyProgramById(1L));

        mockMvc.perform(get("/api/creatorstudyprogram/{id}", 1)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(creatorStudyProgramm.getId()))
                .andExpect(jsonPath("$.idTeacher").value(creatorStudyProgramm.getIdTeacher()))
                .andExpect(jsonPath("$.studyProgramm.id").value(creatorStudyProgramm.getStudyProgramm().getId()));

    }


    @Test
    public void testGetCreatorStudyProgramWithInCorrectId() throws Exception {


        mockMvc.perform(get("/api/creatorstudyprogram/{id}", 1000)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());

    }


    @Test
    public void testPostCreatorStudyProgram() throws Exception {

        CreatorStudyProgramm creatorStudyProgramm = new CreatorStudyProgramm();
        creatorStudyProgramm.setIdTeacher(4);
        creatorStudyProgramm.setStudyProgramm(studyProgramService.getStudyProgramById(1L));

        mockMvc.perform(post("/api/creatorstudyprogram")
                .header("Authorization", "Bearer " + token)
                .content(JsonUtil.toJson(creatorStudyProgramm))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.idTeacher").value(creatorStudyProgramm.getIdTeacher()))
                .andExpect(jsonPath("$.studyProgramm.id").value(creatorStudyProgramm.getStudyProgramm().getId()));

    }
}
