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

import com.cognizantiiht.projectmanager.data.ProjectTO;
import com.cognizantiiht.projectmanager.model.Project;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.repository.ProjectRepository;
import com.cognizantiiht.projectmanager.repository.TaskRepository;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TaskRepository taskRepo;
	
	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
	@Override
	public List<ProjectTO> getAllProjects() {
		// TODO Auto-generated method stub
		List<ProjectTO> projectList= new ArrayList<ProjectTO>(); 
		List<Project> prjList=  projectRepo.findAll();
		for(Project project : prjList) {
			ProjectTO prj = new ProjectTO();
			prj.setProjectName(project.getProjectName());
			prj.setProjectId(project.getProjectId());
			prj.setProjectStartDate(format.format(project.getStartDate()));
			prj.setProjectEndDate(format.format(project.getEndDate()));
			prj.setPriority(project.getPriority());
			Users users = (Users)userRepo.findUsersByProjectId(prj.getProjectId());
			prj.setUser(users);
			prj.setNoOfTasks(taskRepo.countTaskByProjectId(project.getProjectId()));
			prj.setNoOfCompletedTasks(taskRepo.countCompletedTaskByProjectId(project.getProjectId()));
			projectList.add(prj);
		}
		return projectList;
	}

	@Override
	public ProjectTO createProject(ProjectTO project) {
		Project prjTO = populateData(project);
		projectRepo.save(prjTO);
		projectRepo.flush();
		if(project.getUser()!=null) {
			Optional<Users> user = userRepo.findById(project.getUser().getUserId());
			if(user!=null) {
				user.get().setProjectId(prjTO.getProjectId());
				userRepo.save(user.get());
				userRepo.flush();
				project.setUser(user.get());
			}
		}
		return project;
	}

	@Override
	public ProjectTO updateProject(ProjectTO project) {
		Project prjTO = populateData(project);
		projectRepo.save(prjTO);
		projectRepo.flush();
		if(project.getUser()!=null) {
			Optional<Users> user = userRepo.findById(project.getUser().getUserId());
			if(user!=null) {
				user.get().setProjectId(prjTO.getProjectId());
				userRepo.save(user.get());
				userRepo.flush();
				project.setUser(user.get());
			}
		}
		return project;
	}

	@Override
	public void deleteProjectById(Long id) {
		projectRepo.deleteById(id);
	}
	
	private Project populateData(ProjectTO project) {
		Project prjDO = new Project();
		prjDO.setProjectId(project.getProjectId());
		prjDO.setProjectName(project.getProjectName());
		prjDO.setPriority(project.getPriority());
		try {
			prjDO.setStartDate(format.parse(project.getProjectStartDate()));
			prjDO.setEndDate(format.parse(project.getProjectEndDate()));
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
		}
		return prjDO;
	}

}
