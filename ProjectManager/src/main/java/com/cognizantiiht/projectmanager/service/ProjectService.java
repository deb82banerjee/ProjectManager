package com.cognizantiiht.projectmanager.service;

import java.util.List;

import com.cognizantiiht.projectmanager.data.ProjectTO;

public interface ProjectService {

	public List<ProjectTO> getAllProjects();
	public ProjectTO createProject(ProjectTO project);
	public ProjectTO updateProject(ProjectTO project);
	public void deleteProjectById(Long id);
}
