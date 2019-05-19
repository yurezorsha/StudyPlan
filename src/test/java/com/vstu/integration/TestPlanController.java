package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vstu.service.interfaces.PlanService;
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

import com.vstu.entity.Plan;
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.SpecialityService;

import java.util.Collections;


/**
 * integration tests for Speciality api
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestPlanController {

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.access_token}")
    private String token;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private PlanService planService;


    @Test
    public void testGetPlanWithCorrectId() throws Exception {

        Plan plan = new Plan();
        plan.setId(1);
        plan.setSetYearGroup(2009);
        plan.setSpeciality(specialityService.getSpecialityById(1L));
        plan.setNodes(nodeService.getAllByPlanId(1L));
        mockMvc.perform(get("/api/plan/{id}", 1)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(plan.getId()))
                .andExpect(jsonPath("$.setYearGroup").value(plan.getSetYearGroup()))
                .andExpect(jsonPath("$.speciality").isNotEmpty())
                .andExpect(jsonPath("$.nodes").isNotEmpty());

    }


    @Test
    public void testGetPlanWithIncorrectId() throws Exception {

        mockMvc.perform(get("/api/plan/{id}", 100)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());


    }


    @Test
    public void testGetLoadByYear() throws Exception {

        mockMvc.perform(get("/api/plan/{id}/data/?year=2009", 1)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loadSubjects").isNotEmpty());


    }

    @Test
    public void testUpdatePlan() throws Exception {

        Plan plan = planService.getPlanById(1L);
        plan.setSetYearGroup(2008);
        plan.setSpeciality(specialityService.getSpecialityById(2L));
        mockMvc.perform(put("/api/plan")
                .header("Authorization", "Bearer " + token)
                .content(JsonUtil.toJson(plan))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.setYearGroup").value(plan.getSetYearGroup()))
                .andExpect(jsonPath("$.speciality.name").value(plan.getSpeciality().getName()));


    }

}
