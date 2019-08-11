/**
 * 
 */
package com.cognizantiiht.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizantiiht.projectmanager.model.Users;

/**
 * @author Admin
 *
 */
@Service
@Transactional
public interface UserService {

	public List<Users> getUsers();
	public void createUser(Users user);
	public void updateUser(Users user);
	public void deleteUserById(Long id);
}
