package com.ansh.test.controller;

import java.io.Console;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ansh.test.dao.UserDao;
import com.ansh.test.repository.Department;
import com.ansh.test.repository.TaskResponse;
import com.ansh.test.service.Task;
import com.ansh.test.service.UserService;

@RestController
public class SpringRestController {
	

	Logger log = LoggerFactory.getLogger(SpringRestController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(name="/home", method=RequestMethod.GET) 
	public String home(){
		return "index";
	}
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam String name, @RequestParam(required=false) String lastName) {
		return "Hello " + name + " " + lastName;
	}
	
	
	@RequestMapping("/allUsers")
	public List<String> getAllUsers() {
		log.info("All Users invoked");
		return userService.getAllUsers();
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true", origins = "http://localhost:8081")
	@RequestMapping(method=RequestMethod.POST, value="/addUser")
	public ResponseEntity addUser(@RequestBody(required=false) Task task) {
		//return "Task added Successfully : " + task.getTaskName();
		ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
		System.out.println("Hey look it worked " + task.getTaskClass());
		userService.addTask(task.getTaskName(), task.getTaskClass());
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/allDepartments")
	public List<Department> getAllDepartments() {
		log.info("All Users invoked");
		return userService.getAllDepartments();
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/tasks")
	public TaskResponse getAllTasks() {
		
		TaskResponse response = new TaskResponse();
		response.setTaskList(userService.getAllTasks());
		//System.out.println(userService.getAllTasks().toString());
		return response;
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/toggle")
	public int toggleStatus(@RequestParam(required = true) int id) {
		return userService.toggleStatus(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/clear")
	public int clearCompletedTasks() {
		return userService.clearCompletedTasks();
	}
	
	
	public String toUpperCase(String input) {
		return input.toUpperCase();
	}
}
