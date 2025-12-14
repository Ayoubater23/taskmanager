package com.ayoub.taskmanager_backend.repository;

import com.ayoub.taskmanager_backend.model.Project;
import com.ayoub.taskmanager_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findByUser(User user);

}
