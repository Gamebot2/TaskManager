package com.ansh.test.service;

import java.util.List;

import com.ansh.test.repository.Department;
import com.ansh.test.repository.Task;
import com.ansh.test.repository.TaskList;

public interface UserService {
	public List<String> getAllUsers();
	public List<TaskList> getAllTasks();
	public List<Department> getAllDepartments();
	public void addTask(String a,String b);
	public int clearCompletedTasks();
	public int toggleStatus(int a);
}
