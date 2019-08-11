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
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
    UserController userController;
	
	@Mock
	UserService userService;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

	}
	@Test
	public void verifyAllUsers() throws Exception {
		List<Users> users = Arrays.asList(new Users(new Long(1),"Debajyoti","Banerjee","157094"));
        Mockito.when(userService.getUsers()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/all")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
    public void createUser() throws Exception {
        String jsonString = "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"\",\n" +
                "\"projectId\":\"\"\n" +
                "}";
        Users usr = new Users(new Long(1),"Debajyoti","Banerjee","157094");
        ObjectMapper obj = new ObjectMapper();
        System.out.println(obj.writeValueAsString(usr));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void updateUser() throws Exception {
        String jsonString = "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"1\",\n" +
                "\"projectId\":\"1\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
	@Test
    public void deleteUser() throws Exception {
		
        String jsonString = "{\n" +
                "\"userId\":1,\n" +
                "\"firstName\":\"Debajyoti\",\n" +
                "\"lastName\":\"Banerjee\",\n" +
                "\"employeeId\":\"157094\",\n" +
                "\"taskId\":\"1\",\n" +
                "\"projectId\":\"1\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }	
}
