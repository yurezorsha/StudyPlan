package com.vstu.app;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vstu.entity.Type;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTestGet {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetOne() throws Exception {
		ResponseEntity<List<Type>> responseEntity = 
				restTemplate.exchange("/type",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Type>>() {
				});

		List<Type> listOfType = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());//проверка на успешное выполенение запроса
		assertThat(listOfType.size(), is(4));//проверка кол-ва элементов
		assertThat(listOfType.get(1).getName(), is("диф. зачет"));//проверка 2 элемента списка по имени
	}
	
	@Test
	public void testGetTwo() throws Exception {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("/type", List.class);				
		List<Type> listOfType = responseEntity.getBody();		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());//проверка на успешное выполенение запроса
		assertThat(listOfType.size(), is(4));//проверка кол-ва элементов
	}
}
