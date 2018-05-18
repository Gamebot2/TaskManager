package com.ansh.test.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ansh.test.repository.Department;
import com.ansh.test.repository.DepartmentRepository;
import com.ansh.test.repository.TaskList;
import com.ansh.test.repository.TaskRepository;
import com.ansh.test.service.Task;

import ch.qos.logback.core.boolex.Matcher;


public class UserServiceImplTest {
	
	@Mock
	DepartmentRepository repo;
	
	@Mock
	TaskRepository repo2;
	
	@Mock
	JdbcTemplate template;
	
	@InjectMocks
	UserServiceImpl service = new UserServiceImpl();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Department dept1 = new Department();
		dept1.setDeptName("Marketing");
		dept1.setId(1);
		
		Department dept2 = new Department();
		dept2.setDeptName("Finance");
		dept2.setId(2);
				
		TaskList task = new TaskList();
		
		when(repo.findAll()).thenReturn(Arrays.asList(dept1, dept2));
		
		when(repo.findOne(1)).thenReturn(dept1);
		when(repo.findOne(2)).thenReturn(dept2);
		
		when(repo.exists(Matchers.anyInt())).thenReturn(true);
		
		when(template.update(anyString(), Matchers.anyInt())).thenReturn(Integer.MAX_VALUE);
		
		when(template.query(anyString(), Matchers.any(RowMapper.class))).thenReturn(Arrays.asList());
		//when(template.update(anyString(), anyString(), anyString(), anyString())).
		when(template.update(anyString(), anyString(), anyString(), anyString())).thenReturn(Integer.MIN_VALUE);
	}
	
	
	@Test
	public void testGetAllDepartments() {
		List<Department> list = service.getAllDepartments();
		Assert.assertEquals(2, list.size());
	}
	
	@Test
	public void testGetbyId() {
		Department dept = service.getAllDepartmentId(new Integer(1));
		Assert.assertEquals("Marketing", dept.getDeptName());
	}
	
	@Test
	public void testExists() {
		Assert.assertTrue(service.isDeptExists(new Integer(1)));
	}
	
	@Test
	public void testAddTask() {
		service.addTask("", "");
	}
	
	@Test
	public void testToggleStatus() {
		service.toggleStatus(0);
	}
	
	@Test
	public void testClearCompletedTasks() {
		service.clearCompletedTasks();
	}
	
	@Test
	public void testGetAllTasks_ReturnsListOfTasks() {
		List<TaskList> taskList = service.getAllTasks();
		Assert.assertEquals(0, taskList.size());
	}

}
