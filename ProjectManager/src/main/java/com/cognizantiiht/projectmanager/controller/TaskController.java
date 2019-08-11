/**
 * 
 */
package com.cognizantiiht.projectmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizantiiht.projectmanager.data.TaskTO;
import com.cognizantiiht.projectmanager.model.ParentTask;
import com.cognizantiiht.projectmanager.response.JSendResponse;
import com.cognizantiiht.projectmanager.service.TaskService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping(value={"/api/task"})
public class TaskController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TaskService taskService;
	
	@GetMapping(value="/retrieveTask", headers="Accept=application/json")
    public JSendResponse getAllTasksByProjectId(@RequestParam Long projectId) {
		LOGGER.info("Retrieving tasks by Project Id");
        List<TaskTO> tasks=taskService.getAllTasksByProjectId(projectId);
        JSendResponse response = new JSendResponse();
        response.setData(tasks);
        return response;
    }
	@GetMapping(value="/parent", headers="Accept=application/json")
    public JSendResponse getParentTasks() {
		LOGGER.info("Retrieving Parent tasks");
        List<ParentTask> project=taskService.getParentTasks();
        JSendResponse response = new JSendResponse();
        response.setData(project);
        return response;
    }	
	@PostMapping(value="/add",headers="Accept=application/json")
    public JSendResponse createTask(@RequestBody TaskTO task){
		LOGGER.info("Creating task for "+task.getTask_Name());
        taskService.createTask(task);
        JSendResponse response = new JSendResponse();
        return response;
    }	
	@PostMapping(value="/update",headers="Accept=application/json")
    public JSendResponse updateTask(@RequestBody TaskTO task){
		LOGGER.info("Updating task for "+task.getTask_Name());
		taskService.updateTask(task);
        return new JSendResponse();
    }	
    @PostMapping(value="/delete", headers ="Accept=application/json")
    public JSendResponse endTask(@RequestBody TaskTO task){
    	LOGGER.info("Ending Task "+task.getTask_Name());
    	taskService.deleteTaskById(task.getTaskId());
        return new JSendResponse();
    }
}
