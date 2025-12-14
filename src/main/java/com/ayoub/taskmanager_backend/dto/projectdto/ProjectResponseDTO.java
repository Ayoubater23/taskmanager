package com.ayoub.taskmanager_backend.dto.projectdto;

import com.ayoub.taskmanager_backend.model.Project;
import com.ayoub.taskmanager_backend.repository.TaskRepository;

import java.time.LocalDateTime;

public record ProjectResponseDTO(
        int id,
        String title,
        String description,
        LocalDateTime createdAt,
        int totalTasks,
        int completedTasks,
        double progressPercentage
) {}

