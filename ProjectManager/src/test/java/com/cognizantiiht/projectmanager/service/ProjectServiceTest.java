package com.cognizantiiht.projectmanager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizantiiht.projectmanager.ProjectManagerApplication;
import com.cognizantiiht.projectmanager.data.ProjectTO;
import com.cognizantiiht.projectmanager.model.Project;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.repository.ProjectRepository;
import com.cognizantiiht.projectmanager.repository.TaskRepository;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.impl.ProjectServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
public class ProjectServiceTest {
	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
    @Mock
    private ProjectRepository projectRepo;
    @Mock
    private UserRepository userRepo;
    @Mock
    private TaskRepository taskRepo;
    @Mock
    private ProjectServiceImpl mockProjectService;
    @InjectMocks
    private ProjectServiceImpl projectService;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }    
    @Test
    public void testGetAllProjects() {
    	Project project = null;
		try {
			project = new Project(new Long(1),"Project 1",format.parse("08-08-2019"),format.parse("08-09-2019"), 5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<Project> projectList = new ArrayList<Project>();
    	projectList.add(project);
    	when(projectRepo.findAll()).thenReturn(projectList);
    	
    	List<ProjectTO> projectLst = projectService.getAllProjects();
    	assertEquals(1,projectLst.size());
    }
    @Test
    public void testCreateProject() {
    	ProjectTO projectTO = new ProjectTO(new Long(1),"Project 1","08-08-2019","08-09-2019", 5, null, 0, 0);
    	Project project = new Project();
    	project.setProjectId(projectTO.getProjectId());
    	project.setPriority(projectTO.getPriority());
		projectService.createProject(projectTO); 
    }
    
    @Test
    public void testUpdateProject() {
    	ProjectTO projectTO = new ProjectTO(new Long(1),"Project 1","08-08-2019","08-09-2019", 5, new Users(new Long(1),"Debajyoti", "Banerjee", "157094"), 0, 0);
    	Users users = new Users(new Long(1),"Debajyoti", "Banerjee", "157094");
    	Optional<Users> optionalUser = Optional.of(users);
    	when(userRepo.findById(new Long(1))).thenReturn(optionalUser);
    	projectService.updateProject(projectTO);
    }
}

