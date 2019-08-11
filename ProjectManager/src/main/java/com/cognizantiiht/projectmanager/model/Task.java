package com.cognizantiiht.projectmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	private Long parentID;
	private Long projectId;
	private String taskName;
	private Date startDate;
	private Date endDate;
	private int priority;
	private int status;
	private String parentTaskName;
	/**
	 * @return the taskId
	 */
	public Long getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the parentId
	 */
	public Long getParentID() {
		return parentID;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentID) {
		this.parentID = parentID;
	}
	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the parentTaskName
	 */
	public String getParentTaskName() {
		return parentTaskName;
	}
	/**
	 * @param parentTaskName the parentTaskName to set
	 */
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", parentId=" + parentID + ", projectId=" + projectId + ", taskName="
				+ taskName + ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority
				+ ", status=" + status + ", parentTaskName=" + parentTaskName + "]";
	}
	/**
	 * @param taskId
	 * @param parentId
	 * @param projectId
	 * @param taskName
	 * @param startDate
	 * @param endDate
	 * @param priority
	 * @param status
	 * @param parentTaskName
	 */
	public Task(Long taskId, Long parentID, Long projectId, String taskName, Date startDate, Date endDate, int priority,
			int status, String parentTaskName) {
		super();
		this.taskId = taskId;
		this.parentID = parentID;
		this.projectId = projectId;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.parentTaskName = parentTaskName;
	}
	public Task() {
		// TODO Auto-generated constructor stub
	}
	

}
