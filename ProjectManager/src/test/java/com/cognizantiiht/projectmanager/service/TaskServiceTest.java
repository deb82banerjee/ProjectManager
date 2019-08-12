package com.cognizantiiht.projectmanager.service;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
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
import com.cognizantiiht.projectmanager.model.Task;
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
    @Mock
    private TaskServiceImpl taskServiceImpl;
    @InjectMocks
    private TaskServiceImpl taskService;
    @Mock
    private ParentTaskRepository parentTaskRepo;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }    
    @Test
    public void testGetAllTasksByProjectId() {
        try {
        	List<Task> taskList = new ArrayList<Task>();
        	Task t = new Task(new Long(1),new Long(2),new Long(3),"Task 1",format.parse("08-08-2019"),format.parse("08-09-2019"),5,1,"Parent Task 1");
        	taskList.add(t);
        	when(taskRepo.findTasksByProjectId(new Long(3))).thenReturn(taskList);
			taskService.getAllTasksByProjectId(new Long(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Test
    public void testCreateTask() {
    	TaskTO taskTO = new TaskTO(new Long(95),new Long(2),new Long(3),"Task 1","08-08-2019","08-09-2019", 5,1, null, "Parent Task 1");
    	taskService.createTask(taskTO);
		//verify(projectRepo, times(1)).save(project); 
    }
    
    @Test
    public void testUpdateTask() {
    	TaskTO taskTOUpdate = new TaskTO(new Long(95),new Long(2),new Long(3),"Task 1 Updated","08-08-2019","08-09-2019", 5,1, null, "Parent Task 1");
    	Task t = null;
		try {
			t = new Task(new Long(1),new Long(2),new Long(3),"Task 1",format.parse("08-08-2019"),format.parse("08-09-2019"),5,1,"Parent Task 1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Optional<Task> optionalTask = Optional.of(t);
    	when(taskRepo.findById(taskTOUpdate.getTaskId())).thenReturn(optionalTask);
    	taskService.updateTask(taskTOUpdate);
		//verify(projectRepo, times(1)).save(project); 
    }

    @Test
    public void testCreateParentTask() {
    	TaskTO taskTO = new TaskTO(new Long(1),new Long(2),new Long(3),"Task 1","08-08-2019","08-09-2019", 0,1, null, "Parent Task 1");
    	ParentTask parentTask = new ParentTask();
    	parentTask.setParentTaskId(new Long(2));
    	parentTask.setParentTaskName("Parent Task 2");
    	taskService.createTask(taskTO);
		//verify(projectRepo, times(1)).save(project); 
    }
}

