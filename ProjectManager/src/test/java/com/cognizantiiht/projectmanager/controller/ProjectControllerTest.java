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
import com.cognizantiiht.projectmanager.data.ProjectTO;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
    ProjectController projectController;
	
	@Mock
	ProjectService projectService;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();

	}
	@Test
	public void verifyAllProjects() throws Exception {
		List<ProjectTO> projects = Arrays.asList(new ProjectTO(new Long(1),"Project 1","08-08-2019","08-09-2019", 5, null, 0, 0));
        Mockito.when(projectService.getAllProjects()).thenReturn(projects);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/project/all")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
    public void createProject() throws Exception {
        String jsonString = "{\n" +
                "\"projectId\":1,\n" +
                "\"projectName\":\"Project 1\",\n" +
                "\"projectStartDate\":\"08-08-2019\",\n" +
                "\"projectEndDate\":\"08-09-2019\",\n" +
                "\"priority\":\"1\",\n" +
                "\"user\":\n" +
                "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"1\",\n" +
                "\"projectId\":\"1\"\n" +
                "},\n"+
                "\"noOfTasks\":\"\",\n" +
                "\"noOfCompletedTasks\":\"\"\n" +
                "}";
        
        		mockMvc.perform(MockMvcRequestBuilders.post("/api/project/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void updateUser() throws Exception {
        String jsonString = "{\n" +
                "\"projectId\":1,\n" +
                "\"projectName\":\"Project 1\",\n" +
                "\"projectStartDate\":\"08-08-2019\",\n" +
                "\"projectEndDate\":\"08-09-2019\",\n" +
                "\"priority\":\"1\",\n" +
                "\"user\":\n" +
                "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"1\",\n" +
                "\"projectId\":\"1\"\n" +
                "},\n"+
                "\"noOfTasks\":\"\",\n" +
                "\"noOfCompletedTasks\":\"\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/project/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void deleteUser() throws Exception {
		
        String jsonString = "{\n" +
                "\"projectId\":1,\n" +
                "\"projectName\":\"Project 1\",\n" +
                "\"projectStartDate\":\"08-08-2019\",\n" +
                "\"projectEndDate\":\"08-09-2019\",\n" +
                "\"priority\":\"1\",\n" +
                "\"user\":\n" +
                "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"1\",\n" +
                "\"projectId\":\"1\"\n" +
                "},\n"+
                "\"noOfTasks\":\"\",\n" +
                "\"noOfCompletedTasks\":\"\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/project/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
}
