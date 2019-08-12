package com.cognizantiiht.projectmanager.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizantiiht.projectmanager.ProjectManagerApplication;
import com.cognizantiiht.projectmanager.data.TaskTO;
import com.cognizantiiht.projectmanager.model.ParentTask;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
    TaskController taskController;
	
	@Mock
	TaskService taskService;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();

	}
	@Test
	public void verifyAllTasksByProjectId() throws Exception {
		List<TaskTO> tasks = Arrays.asList(new TaskTO(new Long(1), new Long(2), new Long(3),"Task 1", "08-08-2019", "08-09-2019", 1, 0, new Users(new Long(1), "Debajyoti", "Banerjee", "157094"), "Parent Task 1"));
        Mockito.when(taskService.getAllTasksByProjectId(new Long(1))).thenReturn(tasks);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/task/retrieveTask").
        		param("projectId", "1"))
        		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
    public void getParentTasks() throws Exception {
		List<ParentTask> tasks = Arrays.asList(new ParentTask(new Long(1),"Parent Task 1"));
        Mockito.when(taskService.getParentTasks()).thenReturn(tasks);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/task/parent")).andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void addTask() throws Exception {
		TaskTO task = new TaskTO(new Long(1), new Long(2), new Long(3),"Task 1", "08-08-2019", "08-09-2019", 1, 0, new Users(new Long(1), "Debajyoti", "Banerjee", "157094"), "Parent Task 1");
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(task);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/task/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void updateTask() throws Exception {
		TaskTO task = new TaskTO(new Long(1), new Long(2), new Long(3),"Task 1", "08-08-2019", "08-09-2019", 1, 0, new Users(new Long(1), "Debajyoti", "Banerjee", "157094"), "Parent Task 1");
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(task);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/task/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
    public void endTask() throws Exception {
		TaskTO task = new TaskTO(new Long(1), new Long(2), new Long(3),"Task 1", "08-08-2019", "08-09-2019", 1, 0, new Users(new Long(1), "Debajyoti", "Banerjee", "157094"), "Parent Task 1");
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(task);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/task/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}
}
