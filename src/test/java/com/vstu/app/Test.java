package com.vstu.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.vstu.controller.TypeController;
import com.vstu.entity.Type;
import com.vstu.service.interfaces.TypeService;

@RunWith(MockitoJUnitRunner.class)
public class Test {

	@Mock
	private TypeService typeService;
	@InjectMocks
	private TypeController typeController;
	
	@org.junit.Test
	public void getAllTypeTest() {
		ResponseEntity<List<Type>> lst =  typeController.getAllType();		
		verify(typeService).getAllType();//проверка на вызов метода getAllType()
	}
	
	@org.junit.Test
	public void checkCreateTypeTest() {
		
		Type type = new Type();
		type.setId(1);
		type.setKoff(9);
		type.setName("test");
		assertEquals(type.getName(), "test");//проверка имени
		assertNotNull(type);//проверка на не нулевой объект
	}
	
}
