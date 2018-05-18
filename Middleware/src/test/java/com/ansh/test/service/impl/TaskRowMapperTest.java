package com.ansh.test.service.impl;

import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.RowMapper;

import com.ansh.test.mapper.TaskRowMapper;
import com.ansh.test.repository.TaskList;

public class TaskRowMapperTest {
	
	@Mock
	private ResultSet resultSet;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testTaskRowMapper() throws SQLException{
		//Define mock behavior
		when(resultSet.getInt("task_id")).thenReturn(2);
		when(resultSet.getString("task_name")).thenReturn("Webassign");
		when(resultSet.getString("task_class")).thenReturn("Physics");
		when(resultSet.getString("status")).thenReturn("COMPLETED");
		
		//launch the method against the mock
		RowMapper<TaskList> rowMapper = new TaskRowMapper();
		TaskList task = rowMapper.mapRow(resultSet, 0);
		
		//Check the result
		Assert.assertNotNull(task);
		Assert.assertEquals(2, task.getId());
		Assert.assertEquals("Webassign", task.getName());
		Assert.assertEquals("Physics", task.getClazz());
		Assert.assertEquals("COMPLETED", task.getStatus());
	}
	
	
}
