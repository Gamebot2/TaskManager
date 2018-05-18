package com.ansh.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ansh.test.repository.TaskList;

public class TaskRowMapper implements RowMapper<TaskList> {

	@Override
	public TaskList mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		TaskList task = new TaskList();
		task.setId(rs.getInt("task_id"));
		task.setName(rs.getString("task_name"));
		task.setClazz(rs.getString("task_class"));
		task.setStatus(rs.getString("status"));
		return task;
	}

}
