package com.ansh.test.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_list")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private int id;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_details") 
	private String taskDetails;
	
	@Column(name = "class")
	private String taskClass;
	
	@Column(name = "task_status")
	private String taskStatus;
	
	@Column(name = "task_archived")
	private int taskArchived = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	public String getTaskClass() {
		return taskClass;
	}

	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getTaskArchived() {
		return taskArchived;
	}

	public void setTaskArchived(int taskArchived) {
		this.taskArchived = taskArchived;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", taskDetails=" + taskDetails + ", taskClass=" + taskClass
				+ ", taskStatus=" + taskStatus + ", taskArchived=" + taskArchived + "]";
	}
	
	
}	
