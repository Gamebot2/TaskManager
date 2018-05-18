package com.ansh.test.repository;

import java.util.List;

public class TaskResponse {

	private List<TaskList> taskList;

	public List<TaskList> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskList> taskList) {
		this.taskList = taskList;
	}
}
