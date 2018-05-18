package com.ansh.test.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.ansh.test.controller.SpringRestController;
import com.ansh.test.dao.UserDao;
import com.ansh.test.repository.Department;
import com.ansh.test.service.Task;
import com.ansh.test.service.UserService;

public class SpringRestControllerTest {
	
	@Mock
	UserService userService1;
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	SpringRestController controller = new SpringRestController();
	
	@InjectMocks
	UserServiceImpl userService= new UserServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testToUpperCase() {
		String str= controller.toUpperCase("Testing");
		Assert.assertEquals("TESTING", str);
	}
	
	@Test
	public void testHome() {
		Assert.assertEquals("index", controller.home());
	}
	
	@Test
	public void testSayHello() {
		String response = controller.sayHello("Ansh", "Jain");
		Assert.assertEquals("Hello Ansh Jain", response);
	}
	
	@Test
	public void testGetAllUsers() {
		List<String> response = controller.getAllUsers();
		Assert.assertEquals(0, response.size());
	}
	
	@Test
	public void testGetAllControllers() {
		List<Department> response = controller.getAllDepartments();
		Assert.assertEquals(0, response.size());
	}
	
	@Test
	public void testClearCompletedTasks() {
		int a = controller.clearCompletedTasks();
		Assert.assertEquals(0, a);
	}
	
	@Test
	public void testAddUser() {
		ResponseEntity<Task> responseEntity = controller.addUser(new Task());
		//Assert.assertEquals(responseEntity., actual);
	}
}
