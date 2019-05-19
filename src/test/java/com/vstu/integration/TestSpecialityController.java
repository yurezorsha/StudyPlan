package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

import com.vstu.entity.Speciality;

/**
 * integration tests for Speciality api
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestSpecialityController {

    @Autowired
    MockMvc mockMvc;

    @Value("${test.access_token}")
    private String token;

    @Test
    public void testGetSpecialityWithCorrectId() throws Exception {

        Speciality speciality = new Speciality();
        speciality.setId(1);
        speciality.setName("Информационные системы и технологии");
        speciality.setShifr("1-40 05 01-01");

        mockMvc.perform(get("/api/speciality/{id}", 1)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(speciality.getId()))
                .andExpect(jsonPath("$.name").value(speciality.getName()))
                .andExpect(jsonPath("$.shifr").value(speciality.getShifr()));


    }


    @Test
    public void testGetSpecialityWithIncorrectId() throws Exception {

        mockMvc.perform(get("/api/speciality/{id}", 100)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());


    }


    @Test
    public void testPostSpeciality() throws Exception {
        Speciality speciality = new Speciality();
        speciality.setName("TEST");
        speciality.setShifr("1-40 05 01-02");


        mockMvc.perform(post("/api/speciality")
                .header("Authorization", "Bearer " + token)
                .content(JsonUtil.toJson(speciality))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value(speciality.getName()))
                .andExpect(jsonPath("$.shifr").value(speciality.getShifr()));
    }


    @Test
    public void testGetListSpeciality() throws Exception {

        mockMvc.perform(get("/api/speciality")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Информационные системы и технологии"))
                .andExpect(jsonPath("$[1].name").value("Автоматизация технологических процессов и производств (легкая промышленность)"));


    }


    @Test
    public void testPostSpeicialityIfExistsName() throws Exception {

        Speciality speciality = new Speciality();
        speciality.setName("Информационные системы и технологии");

        mockMvc.perform(post("/api/speciality")
                .header("Authorization", "Bearer " + token)
                .content(JsonUtil.toJson(speciality))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isConflict());


    }

    @Test
    public void testDeleteSpecialityWithIncorrectId() throws Exception {


        mockMvc.perform(delete("/api/speciality/{id}", 100)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());


    }


}
