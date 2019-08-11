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
import org.springframework.web.bind.annotation.RestController;

import com.cognizantiiht.projectmanager.data.ProjectTO;
import com.cognizantiiht.projectmanager.model.Project;
import com.cognizantiiht.projectmanager.response.JSendResponse;
import com.cognizantiiht.projectmanager.service.ProjectService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping(value={"/api/project"})
public class ProjectController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value="/all", headers="Accept=application/json")
    public JSendResponse getAllProjects() {
		LOGGER.info("Retrieving Projects");
        List<ProjectTO> project=projectService.getAllProjects();
        JSendResponse response = new JSendResponse();
        response.setData(project);
        return response;
    }
	@PostMapping(value="/add",headers="Accept=application/json")
    public JSendResponse createProject(@RequestBody ProjectTO project){
		LOGGER.info("Creating Project "+project.getProjectName());
        project = projectService.createProject(project);
        JSendResponse response = new JSendResponse();
        response.setData(project);
        return response;
    }	
	@PostMapping(value="/update",headers="Accept=application/json")
    public JSendResponse updatePRoject(@RequestBody ProjectTO project){
		LOGGER.info("Updating Project "+project.getProjectName());
        projectService.updateProject(project);
        return new JSendResponse();
    }	
    @PostMapping(value="/delete", headers ="Accept=application/json")
    public JSendResponse deletePRoject(@RequestBody ProjectTO project){
    	LOGGER.info("Deleting Project "+project.getProjectName());
    	projectService.deleteProjectById(project.getProjectId());
        return new JSendResponse();
    }



}
