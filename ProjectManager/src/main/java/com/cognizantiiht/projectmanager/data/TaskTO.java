/**
 * 
 */
package com.cognizantiiht.projectmanager.data;

import com.cognizantiiht.projectmanager.model.Users;

/**
 * @author Admin
 *
 */
public class TaskTO {

    public Long taskId;
    public Long parent_ID;
    public Long project_ID;
    public String task_Name;
    public String start_Date;
    public String end_Date;
    public int priority;
    public int status;
    public Users user;
    public String parentTaskName;
    
    
	public TaskTO(Long taskId, Long parent_ID, Long project_ID, String task_Name, String start_Date, String end_Date,
			int priority, int status, Users user, String parentTaskName) {
		super();
		this.taskId = taskId;
		this.parent_ID = parent_ID;
		this.project_ID = project_ID;
		this.task_Name = task_Name;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.priority = priority;
		this.status = status;
		this.user = user;
		this.parentTaskName = parentTaskName;
	}

	public TaskTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getParent_ID() {
		return parent_ID;
	}
	public void setParent_ID(Long parent_ID) {
		this.parent_ID = parent_ID;
	}
	public Long getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(Long project_ID) {
		this.project_ID = project_ID;
	}
	public String getTask_Name() {
		return task_Name;
	}
	public void setTask_Name(String task_Name) {
		this.task_Name = task_Name;
	}
	public String getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}
	public String getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getParentTaskName() {
		return parentTaskName;
	}
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
}
