package com.cognizantiiht.projectmanager.service;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizantiiht.projectmanager.ProjectManagerApplication;
import com.cognizantiiht.projectmanager.data.TaskTO;
import com.cognizantiiht.projectmanager.model.ParentTask;
import com.cognizantiiht.projectmanager.repository.ParentTaskRepository;
import com.cognizantiiht.projectmanager.repository.ProjectRepository;
import com.cognizantiiht.projectmanager.repository.TaskRepository;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.impl.TaskServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
public class TaskServiceTest {
	SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
	
    @Mock
    private ProjectRepository projectRepo;
    @Mock
    private UserRepository userRepo;
    @Mock
    private TaskRepository taskRepo;
    @InjectMocks
    private TaskServiceImpl projectService;
    @Mock
    private ParentTaskRepository parentTaskRepo;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }    
   /* @Test
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
    }*/
    @Test
    public void testCreateTask() {
    	TaskTO taskTO = new TaskTO(new Long(1),new Long(2),new Long(3),"Task 1","08-08-2019","08-09-2019", 5,1, null, "Parent Task 1");
		projectService.createTask(taskTO);
		//verify(projectRepo, times(1)).save(project); 
    }
    
    @Test
    public void testCreateParentTask() {
    	TaskTO taskTO = new TaskTO(new Long(1),new Long(2),new Long(3),"Task 1","08-08-2019","08-09-2019", 0,1, null, "Parent Task 1");
    	ParentTask parentTask = new ParentTask();
    	parentTask.setParentTaskId(new Long(2));
    	parentTask.setParentTaskName("Parent Task 2");
		projectService.createTask(taskTO);
		//verify(projectRepo, times(1)).save(project); 
    }
	/*
	 * @Test public void testUpdateTask() { TaskTO taskTO = new TaskTO(new
	 * Long(1),new Long(2),new Long(3),"Task 1","08-08-2019","08-09-2019", 5,1,
	 * null, "Parent Task 1"); projectService.createTask(taskTO); TaskTO task = new
	 * TaskTO(new Long(1),new Long(2),new
	 * Long(3),"Task 1 New","08-08-2019","08-09-2019", 5,1, null, "Parent Task 1");
	 * projectService.updateTask(task); //verify(projectRepo,
	 * times(1)).save(project); }
	 */
}

