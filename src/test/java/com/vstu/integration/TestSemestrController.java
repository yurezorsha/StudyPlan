package com.vstu.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
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

import com.vstu.entity.Node;
import com.vstu.entity.Semestr;
import com.vstu.service.interfaces.NodeService;
import com.vstu.service.interfaces.PlanService;
import com.vstu.service.interfaces.SubjectService;
import com.vstu.service.interfaces.TypeService;

/**
 * integration tests for Semestr api
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/testdb/create-test-before.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/testdb/delete-test-after.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class TestSemestrController {

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.access_token}")
    private String token;

    @Autowired
    private TypeService typeService;

    @Autowired
    private NodeService nodeService;

    private Semestr semestr;

    @Before
    public void setUp() {
        semestr = new Semestr();
        semestr.setId(1);
        semestr.setNumber(1);
        semestr.setLecture(15);
        semestr.setLaboratory(15);
        semestr.setPractice(15);
        semestr.setSeminar(15);
        semestr.setType(typeService.getTypeById(1L));
        semestr.setRgr(1);
        semestr.setCourseWorkType("1");
        semestr.setZe(5);
        semestr.setCourceWorkZe(1);
        semestr.setCourceWorkHours(10);
        semestr.setIdTeacher(1);
        semestr.setIdFaculty(1);
        semestr.setDiplomHour(0);
        semestr.setDiplomZe(0);
    }

    @Test
    public void testGetSemestrWithCorrectId() throws Exception {


        mockMvc.perform(get("/api/semestr/{id}", 1L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(semestr.getId()))
                .andExpect(jsonPath("$.number").value(semestr.getNumber()))
                .andExpect(jsonPath("$.lecture").value(semestr.getLecture()))
                .andExpect(jsonPath("$.laboratory").value(semestr.getLaboratory()))
                .andExpect(jsonPath("$.practice").value(semestr.getPractice()))
                .andExpect(jsonPath("$.seminar").value(semestr.getSeminar()))
                .andExpect(jsonPath("$.type").isNotEmpty())
                .andExpect(jsonPath("$.rgr").value(semestr.getRgr()))
                .andExpect(jsonPath("$.courseWorkType").value(semestr.getCourseWorkType()))
                .andExpect(jsonPath("$.ze").value(semestr.getZe()))
                .andExpect(jsonPath("$.courceWorkZe").value(semestr.getCourceWorkZe()))
                .andExpect(jsonPath("$.courceWorkHours").value(semestr.getCourceWorkHours()))
                .andExpect(jsonPath("$.idTeacher").value(semestr.getIdTeacher()))
                .andExpect(jsonPath("$.idFaculty").value(semestr.getIdFaculty()))
                .andExpect(jsonPath("$.diplomHour").value(semestr.getDiplomHour()))
                .andExpect(jsonPath("$.diplomZe").value(semestr.getDiplomZe()));


    }

    @Test
    public void testGetSemestrWithIncorrectId() throws Exception {
        mockMvc.perform(get("/api/semestr/{id}", 15L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());


    }

    @Test
    public void checkSum() throws Exception {
        Integer sum = semestr.getCourceWorkHours() + semestr.getDiplomHour() + semestr.getPractice() + semestr.getLaboratory() + semestr.getLecture()
                + semestr.getSeminar();
        mockMvc.perform(get("/api/semestr/sum/{id}", 1L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(sum.toString()));

    }


}
