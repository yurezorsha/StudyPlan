package com.vstu.app;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vstu.entity.Type;
import com.vstu.service.interfaces.TypeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTestPost {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
    private MockMvc mockMvc;

	@MockBean
	private TypeService typeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Type type;
	
	
	@Before
	public void setUp() {
		type = new Type(); 			
		type.setId(1);
		type.setKoff(9);
		type.setName("testPOST");
	}
	
	@Test
	public void testPostOne() throws Exception {
		ResponseEntity<Type> responseEntity = 
				restTemplate.exchange("/type", HttpMethod.POST, new HttpEntity<>(type), Type.class);

		type = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());//проверка на успешное выполенение запроса
		assertThat(type.getName(), is("testPOST"));//проверка имени	
	}
	
	@Test
	public void testPostTwo() throws Exception{
		ResponseEntity<Type> responseEntity = 
				restTemplate.postForEntity("/type", type, Type.class);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());//проверка на успешное выполенение запроса
		
		type = responseEntity.getBody();		
		assertEquals("testPOST", type.getName());//проверка имени		
	}
	
	
	
	@After
	public void afterTest()	{				
		restTemplate.delete("/type/" + type.getId());
	}

}
