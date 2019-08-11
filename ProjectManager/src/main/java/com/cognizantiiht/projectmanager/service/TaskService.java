package com.cognizantiiht.projectmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizantiiht.projectmanager.data.TaskTO;
import com.cognizantiiht.projectmanager.model.ParentTask;

@Service
@Transactional
public interface TaskService {
	public List<ParentTask> getParentTasks();
	public void createTask(TaskTO project);
	public void updateTask(TaskTO project);
	public void deleteTaskById(Long id);
	public List<TaskTO> getAllTasksByProjectId(Long projectId);
}
