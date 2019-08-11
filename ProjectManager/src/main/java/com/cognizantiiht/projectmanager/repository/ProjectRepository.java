package com.cognizantiiht.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizantiiht.projectmanager.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
