package com.cognizantiiht.projectmanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizantiiht.projectmanager.data.TaskTO;
import com.cognizantiiht.projectmanager.model.ParentTask;
import com.cognizantiiht.projectmanager.model.Task;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.repository.ParentTaskRepository;
import com.cognizantiiht.projectmanager.repository.ProjectRepository;
import com.cognizantiiht.projectmanager.repository.TaskRepository;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired 
	TaskRepository taskRepo;
	@Autowired
	ParentTaskRepository parentTaskRepo;

	@Override
	public List<ParentTask> getParentTasks() {
		// TODO Auto-generated method stub
		return parentTaskRepo.findAll();
	}

	@Override
	public void createTask(TaskTO taskTO) {
		if(taskTO.getPriority()==0) {
			ParentTask parentTask = new ParentTask();
			parentTask.setParentTaskName(taskTO.getTask_Name());
			parentTaskRepo.save(parentTask);
		}else {
			Task task= new Task();
			task.setParentId(taskTO.getParent_ID());
			task.setTaskName(taskTO.getTask_Name());
			task.setProjectId(taskTO.getProject_ID());
			try{
				task.setStartDate(format.parse(taskTO.getStart_Date()));
				task.setEndDate(format.parse(taskTO.getEnd_Date()));
			}catch(Exception e) {
				LOGGER.error("Error parsing dates ::"+e.getMessage());
			}
			task.setPriority(taskTO.getPriority());
			task.setStatus(taskTO.getStatus());
			taskRepo.save(task);
			taskRepo.flush();
			if(taskTO.getUser()!=null) {
				Optional<Users> user = userRepo.findById(taskTO.getUser().getUserId());
				if(user.get()!=null) {
					user.get().setTaskId(task.getTaskId());
					userRepo.save(user.get());
				}
			}
			
		}
	}

	@Override
	public void updateTask(TaskTO taskTO) {
		// TODO Auto-generated method stub
		Optional<Task> task= taskRepo.findById(taskTO.getTaskId());
		if(task.get()==null) {
			return;
		}
		Task existingtask = task.get();
		existingtask.setParentId(taskTO.getParent_ID());
		existingtask.setTaskName(taskTO.getTask_Name());
		existingtask.setProjectId(taskTO.getProject_ID());
		try{
			existingtask.setStartDate(format.parse(taskTO.getStart_Date()));
			existingtask.setEndDate(format.parse(taskTO.getEnd_Date()));
		}catch(Exception e) {
			LOGGER.error("Error parsing dates ::"+e.getMessage());
		}
		existingtask.setPriority(taskTO.getPriority());
		existingtask.setStatus(taskTO.getStatus());
		taskRepo.save(existingtask);
		taskRepo.flush();
		if(taskTO.getUser()!=null) {
			Optional<Users> user = userRepo.findById(taskTO.getUser().getUserId());
			if(user.get()!=null) {
				user.get().setTaskId(existingtask.getTaskId());
				userRepo.save(user.get());
			}
		}
	}

	@Override
	public void deleteTaskById(Long id) {
		taskRepo.endTasksByTaskId(id,1); 
	}

	@Override
	public List<TaskTO> getAllTasksByProjectId(Long projectId) {
		// TODO Auto-generated method stub 
		List<Task> taskList = taskRepo.findTasksByProjectId(projectId);
		List<TaskTO> taskTOList = new ArrayList<TaskTO>();	
		for(Task task : taskList) {
			TaskTO t = new TaskTO();
			t.setTask_Name(task.getTaskName());
			t.setTaskId(task.getTaskId());
			t.setStart_Date(format.format(task.getStartDate()));
			t.setEnd_Date(format.format(task.getEndDate()));
			t.setStatus(task.getStatus());
			t.setPriority(task.getPriority());
			t.setProject_ID(projectId);
			if(task.getParentID()!=null) {
				Optional<ParentTask> parentTask = parentTaskRepo.findById(task.getParentID());
				if(parentTask.isPresent()) {
					t.setParentTaskName(parentTask.get().getParentTaskName());
					t.setParent_ID(parentTask.get().getParentTaskId());
				}
			}
			Users user = userRepo.findUsersByTaskId(task.getTaskId());
			t.setUser(user);
			taskTOList.add(t);
		}
		return taskTOList;
	}

}
