package com.ayoub.taskmanager_backend.repository;

import com.ayoub.taskmanager_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByProjectId(int projectId);

    int countByProject_Id(int projectId);

    int countByProject_IdAndCompletedTrue(int projectId);
}
