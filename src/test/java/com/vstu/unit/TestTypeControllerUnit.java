package com.vstu.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vstu.entity.Type;
import com.vstu.service.interfaces.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class TestTypeControllerUnit {

    @MockBean
    private TypeService typeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${test.access_token}")
    private String token;

    @Test
    public void checkCreateTypeTest() {

        Type type = new Type();
        type.setId(1);
        type.setKoff(9);
        type.setName("test");
        assertEquals(type.getName(), "test");//проверка имени
        assertNotNull(type);//проверка на не нулевой объект
    }

    @Test
    public void testGet() throws Exception {
        Type type1 = new Type();
        type1.setId(1);
        type1.setKoff(5);
        type1.setName("type1");
        Type type2 = new Type();
        type2.setId(1);
        type2.setKoff(9);
        type2.setName("type2");
        List<Type> types = Arrays.asList(type1, type2);

        when(typeService.getAllType()).thenReturn(types);

        ResultActions m = mockMvc.perform(get("/api/type")
                .header("Authorization","Bearer "+token))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("type1"))
                .andExpect(jsonPath("$[0].koff").value(5.0));
        m.andDo(print());
    }

    @Test
    public void testGetbyId() throws Exception {
        Type type = new Type();
        type.setId(1);
        type.setKoff(4);
        type.setName("testGet");
        when(typeService.getTypeById(type.getId())).thenReturn(type);
        ResultActions m = mockMvc.perform(get("/api/type/{id}", type.getId())
                .header("Authorization","Bearer "+token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("testGet"))
                .andExpect(jsonPath("$.koff").value(4.0));
        verify(typeService, times(1)).getTypeById(1L);//проверяем что метод getTypeById для TypeService вызывается ровно один раз
        verifyNoMoreInteractions(typeService);//проверяем что после ответа больше не происходит взаимодействия с TypeService
        m.andDo(print());
    }


    @Test
    public void testPost() throws Exception {
        Type type = new Type();
        type.setId(1);
        type.setKoff(5);
        type.setName("testPOST");
        when(typeService.existsType(type.getId())).thenReturn(false);

        ResultActions m = mockMvc.perform( post("/api/type")
                .header("Authorization","Bearer "+token)
                .content(objectMapper.writeValueAsString(type))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
        m.andDo(print());

    }


    @org.junit.Test
    public void testPUT() throws Exception {
        Type type = new Type();
        type.setId(1);
        type.setKoff(5);
        type.setName("testPUT");
        when(typeService.updateType(type)).thenReturn(type);

        ResultActions m = mockMvc.perform(put("/api/type")
                .header("Authorization","Bearer "+token)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(type)))
                .andExpect(status().isOk());
        m.andDo(print());
    }


    @Test
    public void testDelete() throws Exception {
        Type type = new Type();
        type.setId(1);
        type.setKoff(9);
        type.setName("testDELETE");
        when(typeService.getTypeById(type.getId())).thenReturn(type);

        mockMvc.perform(delete("/api/type/{id}", type.getId())
                .header("Authorization","Bearer "+token))
                .andExpect(status().isOk());
        verify(typeService, times(1)).deleteType(type.getId());//проверяем что метод deleteType для TypeService вызывается ровно один раз
        verifyNoMoreInteractions(typeService);//проверяем что после ответа больше не происходит взаимодействия с TypeService
    }

}
