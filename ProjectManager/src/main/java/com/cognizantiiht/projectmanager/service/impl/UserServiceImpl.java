package com.cognizantiiht.projectmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizantiiht.projectmanager.model.Users;
import com.cognizantiiht.projectmanager.repository.UserRepository;
import com.cognizantiiht.projectmanager.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void createUser(Users user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public void updateUser(Users user) {
		userRepo.save(user);
	}

	
	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		
	}

	
	
}
