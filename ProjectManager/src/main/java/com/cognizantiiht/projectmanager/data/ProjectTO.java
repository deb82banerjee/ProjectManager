package com.cognizantiiht.projectmanager.data;

import com.cognizantiiht.projectmanager.model.Users;

public class ProjectTO {
    public Long projectId;
    public String projectName;
    public String projectStartDate;
    public String projectEndDate;
    public int priority;
    public Users user;
    public int noOfTasks;
    public int noOfCompletedTasks;
    
    
	public ProjectTO(Long projectId, String projectName, String projectStartDate, String projectEndDate, int priority,
			Users user, int noOfTasks, int noOfCompletedTasks) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.priority = priority;
		this.user = user;
		this.noOfTasks = noOfTasks;
		this.noOfCompletedTasks = noOfCompletedTasks;
	}
	public ProjectTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public int getNoOfTasks() {
		return noOfTasks;
	}
	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}
	public int getNoOfCompletedTasks() {
		return noOfCompletedTasks;
	}
	public void setNoOfCompletedTasks(int noOfCompletedTasks) {
		this.noOfCompletedTasks = noOfCompletedTasks;
	}
    
}
