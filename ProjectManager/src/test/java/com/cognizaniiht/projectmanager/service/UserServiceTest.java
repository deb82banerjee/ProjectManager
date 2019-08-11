package com.cognizaniiht.projectmanager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizantiiht.projectmanager.ProjectManagerApplication;
import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectManagerApplication.class)
public class UserServiceTest {
	
    @Mock
    private UserRepository userRepo;
    @InjectMocks
    private UserServiceImpl userService;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }    
    @Test
    public void testGetAllUsers() {
    	Users user = new Users(new Long(1), "Debajyoti", "Banerjee", "157094");
    	List<Users> userList = new ArrayList<Users>();
    	userList.add(user);
    	when(userRepo.findAll()).thenReturn(userList);
    	
    	List<Users> users = userService.getUsers();
    	assertEquals(1,users.size());
    }
    @Test
    public void createUserTest()
    {
    	Users user = new Users(new Long(1), "Debajyoti", "Banerjee", "157094");
    	userService.createUser(user);
        verify(userRepo, times(1)).save(user);
    }
    @Test
    public void updateUserTest()
    {
    	Users user = new Users(new Long(1), "Debajyoti", "Banerjee", "157094");
    	userService.updateUser(user);
        verify(userRepo, times(1)).save(user);
    }
}

