package com.vstu.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vstu.entity.*;
import com.vstu.entity.data.DataAllLoad;
import com.vstu.repository.PlanRepository;
import com.vstu.service.impl.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.vstu.integration.*;

import javax.persistence.EntityExistsException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class TestPlanControllerUnit {

    @Mock
    private PlanServiceImpl planService;

    @Mock
    private PlanRepository planRepository;

    @Mock
    private PracticeServiceImpl practiceService;

    @Mock
    private FakultativServiceImpl fakulatativService;

    @Mock
    private CertificationServiceImpl certificationService;

    @Mock
    private NodeServiceImpl nodeService;

    @Autowired
    private MockMvc mockMvc;

    @Value("${test.access_token}")
    private String token;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllPlans() throws Exception {
        Plan plan1 = new Plan();
        plan1.setId(1);
        plan1.setSetYearGroup(2015);
        assertEquals(2015, plan1.getSetYearGroup());

        Plan plan2 = new Plan();
        plan2.setId(2);
        plan2.setSetYearGroup(2016);
        assertEquals(2016, plan2.getSetYearGroup());

        Plan plan3 = new Plan();
        plan3.setId(3);
        plan3.setSetYearGroup(2017);
        assertEquals(2017, plan3.getSetYearGroup());

        List<Plan> plans = Arrays.asList(plan1, plan2, plan3);
        assertEquals(plans.size(), 3);

        when(planService.getAllPlan()).thenReturn(plans);

        ResultActions m = mockMvc.perform(get("/api/plan")
                .header("Authorization", "Bearer " + token))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(plan1.getId())).andExpect(jsonPath("$[0].setYearGroup").value(plan1.getSetYearGroup()))
                .andExpect(jsonPath("$[1].id").value(plan2.getId())).andExpect(jsonPath("$[1].setYearGroup").value(plan2.getSetYearGroup()))
                .andExpect(jsonPath("$[2].id").value(plan3.getId())).andExpect(jsonPath("$[2].setYearGroup").value(plan3.getSetYearGroup()));
        m.andDo(print());

    }

    @Test
    public void testGetPlanById() throws Exception {
        Plan plan1 = new Plan();
        plan1.setId(1);
        plan1.setSetYearGroup(2015);

        assertEquals(1, plan1.getId());
        assertEquals(2015, plan1.getSetYearGroup());

        when(planService.getPlanById(1L)).thenReturn(plan1);

        ResultActions m = mockMvc.perform(get("/api/plan/{id}", 1L)
                .header("Authorization", "Bearer " + token))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(plan1.getId()))
                .andExpect(jsonPath("$.setYearGroup").value(plan1.getSetYearGroup()));


        m.andDo(print());
    }

    @Test
    public void testGetAllSpecialityById() throws Exception {
        Speciality sp = new Speciality();
        sp.setId(1);
        sp.setName("speciality");
        sp.setShifr("10487");

        Plan plan1 = new Plan();
        plan1.setId(1);
        plan1.setSetYearGroup(2015);
        plan1.setSpeciality(sp);

        Plan plan2 = new Plan();
        plan2.setId(2);
        plan2.setSetYearGroup(2018);
        plan2.setSpeciality(sp);

        List<Plan> plans = Arrays.asList(plan1, plan2);
        sp.setPlans(plans);

        when(planService.getAllBySpecialityId(1L)).thenReturn(plans);

        ResultActions m = mockMvc.perform(get("/api/plans/{id}", 1L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(plan1.getId()))
                .andExpect(jsonPath("$[0].setYearGroup").value(plans.get(0).getSetYearGroup()))
                .andExpect(jsonPath("$[0].speciality.id").value(plans.get(0).getSpeciality().getId())).andExpect(jsonPath("$[0].speciality.name").value(plans.get(0).getSpeciality().getName())).andExpect(jsonPath("$[0].speciality.shifr").value(plans.get(0).getSpeciality().getShifr()));
        m.andDo(print());
    }

    @Test
    public void testPut() throws Exception {
        Plan plan = new Plan();
        plan.setId(2);
        plan.setSetYearGroup(2018);

        when(planService.updatePlan(plan)).thenReturn(plan);

        ResultActions m = mockMvc.perform(put("/api/plan")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(plan)))
                .andExpect(status().isOk());
        m.andDo(print());
    }

    @Test
    public void testPostWhenNotExists() throws Exception {
        Subject subject = new Subject();
        subject.setName("subject");
        Node node = new Node();
        node.setSubject(subject);
        Practice practice = new Practice();
        practice.setName("Practice");
        Fakultativ fakultativ = new Fakultativ();
        fakultativ.setName("fakultativ");
        Certification certification = new Certification();
        certification.setName("Certif");

        Plan plan = new Plan();
        plan.setId(10L);
        plan.setSetYearGroup(2018);
        plan.setCountSemesters(10);
        plan.setPractices(Arrays.asList(practice));
        plan.setFakultativs(Arrays.asList(fakultativ));
        plan.setCertifications(Arrays.asList(certification));
        plan.setNodes(Arrays.asList(node));

        when(planRepository.existsById(2L)).thenReturn(false);
        when(planService.addPlan(plan)).thenReturn(plan);
        when(practiceService.addListPracticeByPlanId(2L, Arrays.asList(practice))).thenReturn(Arrays.asList(practice));
        when(fakulatativService.addListFakultativByPlanId(2L, Arrays.asList(fakultativ))).thenReturn(Arrays.asList(fakultativ));
        when(certificationService.addListCertificationByPlanId(2L,Arrays.asList(certification))).thenReturn(Arrays.asList(certification));
        when(nodeService.addListNodesByPlanId(2L,Arrays.asList(node))).thenReturn(Arrays.asList(node));
        ResultActions m = mockMvc.perform(post("/api/plan")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JsonUtil.toJson(plan)))
                .andExpect(status().isCreated());

        m.andReturn().getResponse().getContentAsString();
    }


    @Test
    public void testPostWhenExists() throws Exception {

        Plan plan = new Plan();
        plan.setId(2);
        plan.setSetYearGroup(2018);
        plan.setCountSemesters(10);


        ResultActions m = mockMvc.perform(post("/api/plan")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JsonUtil.toJson(plan)))
                .andExpect(status().isConflict());

        m.andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testDeletePlan() throws Exception {
        Plan plan = new Plan();
        plan.setId(1);
        plan.setSetYearGroup(2018);

        mockMvc.perform(delete("/api/plan/{id}", 1L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDataLoad() throws Exception {

        DataAllLoad datadto = new DataAllLoad();
        datadto.setLoadDiploma(null);
        datadto.setLoadPractice(null);
        datadto.setLoadSubjects(null);

        when(planService.getLoad(1, 2018)).thenReturn(datadto);

        ResultActions m = mockMvc.perform(get("/api/plan/{id}/data?year=2018", 1L)
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
        m.andDo(print());

        assertEquals(null, datadto.getLoadDiploma());
        assertEquals(null, datadto.getLoadPractice());
        assertEquals(null, datadto.getLoadSubjects());
    }

}
