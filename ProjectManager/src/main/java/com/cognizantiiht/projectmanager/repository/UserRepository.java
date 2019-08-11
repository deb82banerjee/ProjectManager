package com.cognizantiiht.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizantiiht.projectmanager.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	@Query("SELECT t FROM Users t where t.projectId = :projectId") 
    Users findUsersByProjectId(@Param("projectId") Long projectId);

	@Query("SELECT t FROM Users t where t.taskId = :taskId") 
    Users findUsersByTaskId(@Param("taskId") Long taskId);
}
