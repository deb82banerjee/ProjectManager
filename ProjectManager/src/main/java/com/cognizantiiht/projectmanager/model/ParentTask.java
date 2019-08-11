package com.cognizantiiht.projectmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parentTaskId;
	private String parentTaskName;
	
	public ParentTask(Long parentTaskId, String parentTaskName) {
		super();
		this.parentTaskId = parentTaskId;
		this.parentTaskName = parentTaskName;
	}
	public ParentTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(Long parentId) {
		this.parentTaskId = parentTaskId;
	}
	public String getParentTaskName() {
		return parentTaskName;
	}
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
	
	
}
