package com.vstu.app;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vstu.entity.Type;
import com.vstu.service.interfaces.TypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UnitMockMVCTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private TypeService typeService;

		 	

	@org.junit.Test
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

		ResultActions m = mockMvc.perform(get("/type"))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("type1")))
				.andExpect(jsonPath("$[0].koff", is(5.0)));
		m.andDo(print());
	}

	@org.junit.Test
	public void testGetbyId() throws Exception {
		Type type = new Type();
		type.setId(1);
		type.setKoff(4);
		type.setName("testGet");
	    when(typeService.getTypeById(type.getId())).thenReturn(type);
	    ResultActions m = mockMvc.perform(get("/type/{id}", type.getId()))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	            .andExpect(jsonPath("$.id", is(1)))
	            .andExpect(jsonPath("$.name", is("testGet")))
	            .andExpect(jsonPath("$.koff", is(4.0)));
	    verify(typeService, times(1)).getTypeById(1L);//проверяем что метод getTypeById для TypeService вызывается ровно один раз
	    verifyNoMoreInteractions(typeService);//проверяем что после ответа больше не происходит взаимодействия с TypeService
	    m.andDo(print());
	}
	

	@org.junit.Test
    public void testPost() throws Exception {
		Type type = new Type();
		type.setId(1);
		type.setKoff(5);
		type.setName("testPOST");
		when(typeService.existsType(type.getId())).thenReturn(false);	   
		
		 ResultActions m = mockMvc.perform( post("/type")
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
	   
	    ResultActions m = mockMvc.perform(put("/type")
	            .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
	            .content(objectMapper.writeValueAsString(type)))	    		
	            .andExpect(status().isOk());
	    m.andDo(print());
	}
	

	@org.junit.Test
	public void testDelete() throws Exception {
		Type type = new Type();
		type.setId(1); 
		type.setKoff(9);
		type.setName("testDELETE");
	    when(typeService.getTypeById(type.getId())).thenReturn(type);
	    
	    mockMvc.perform(delete("/type/{id}", type.getId()))
	            .andExpect(status().isOk());
	    verify(typeService, times(1)).deleteType(type.getId());//проверяем что метод deleteType для TypeService вызывается ровно один раз
	    verifyNoMoreInteractions(typeService);//проверяем что после ответа больше не происходит взаимодействия с TypeService
	}
}
