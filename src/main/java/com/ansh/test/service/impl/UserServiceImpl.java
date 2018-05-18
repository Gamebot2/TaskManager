package com.ansh.test.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.ansh.test.dao.UserDao;
import com.ansh.test.mapper.TaskRowMapper;
import com.ansh.test.repository.Department;
import com.ansh.test.repository.DepartmentRepository;
import com.ansh.test.repository.Task;
import com.ansh.test.repository.TaskList;
import com.ansh.test.repository.TaskRepository;
import com.ansh.test.service.UserService;

import lombok.NonNull;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	DepartmentRepository repo;
	
	@Autowired
	TaskRepository repo2;
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	//TaskRowMapper mapper;
	
	@PostConstruct
	public void init() {
		System.out.println("--------HI--------");
	}
	
	public List<String> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<Department> getAllDepartments() {

		return IteratorUtils.toList(repo.findAll().iterator());
	}
	
	public Department getAllDepartmentId(Integer deptName) {

		return (repo.findOne(deptName));
	}
	
	public boolean isDeptExists(@NonNull Integer deptName) {

		return repo.exists(deptName);
	}

	@Override
	public List<TaskList> getAllTasks() {
		//return template.query("select * from task_list", mapper);
		return null;
	}
	
	@Override
	public void addTask(String name, String task_class) {
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(
			    "INSERT INTO task_list (task_name, task_class, status) VALUES (?, ?, ?)",
			    name, task_class, "ACTIVE"
			);
	}
	
	@Override
	public int toggleStatus(int id) {
		// TODO Auto-generated method stub
		return template.update("UPDATE task_list SET status = 'COMPLETED' WHERE task_id = ?", id);
	}
	
	@Override
	public int clearCompletedTasks() {
		template.update("DELETE FROM task_list WHERE status='COMPLETED'");
		return 0;
	}
	
	
	
	
}
