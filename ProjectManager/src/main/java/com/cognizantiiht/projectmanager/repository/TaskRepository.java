package com.cognizantiiht.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cognizantiiht.projectmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("SELECT t FROM Task t where t.projectId = :projectId") 
    List<Task> findTasksByProjectId(@Param("projectId") Long projectId);

	@Transactional
	@Modifying
	@Query("update Task set status=:status where taskId = :taskId") 
    void endTasksByTaskId(@Param("taskId") Long taskId, @Param("status") int status);
	
	@Query("select count(1) from Task where projectId = :projectId") 
    Integer countTaskByProjectId(@Param("projectId") Long projectId);

	@Query("select count(1) from Task where projectId = :projectId and status = 1") 
    Integer countCompletedTaskByProjectId(@Param("projectId") Long projectId);

}
