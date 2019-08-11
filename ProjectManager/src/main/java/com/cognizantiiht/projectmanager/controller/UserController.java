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

import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.response.JSendResponse;
import com.cognizantiiht.projectmanager.service.UserService;

/**
 * @author Admin
 *
 */
@RestController
@RequestMapping(value={"/api/users"})
public class UserController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/all", headers="Accept=application/json")
    public JSendResponse getAllUser() {
        List<Users> users=userService.getUsers();
        JSendResponse response = new JSendResponse();
        response.setData(users);
        return response;
    }
	@PostMapping(value="/create",headers="Accept=application/json")
    public JSendResponse createUser(@RequestBody Users user){
		LOGGER.info("Creating User "+user.getFirstName());
        userService.createUser(user);
        return new JSendResponse();
    }	
	@PostMapping(value="/update",headers="Accept=application/json")
    public JSendResponse updateUser(@RequestBody Users user){
		LOGGER.info("Updating User "+user.getFirstName());
        userService.updateUser(user);
        return new JSendResponse();
    }	
    @PostMapping(value="/delete", headers ="Accept=application/json")
    public JSendResponse deleteUser(@RequestBody Users user){
		/*
		 * Optional<Users> incomingUser = userService.getUserByEmpId(user.getUserid());
		 * if (user == null) { return new JSendResponse(); }
		 */
    	userService.deleteUserById(user.getUserId());
        return new JSendResponse();
    }



}
