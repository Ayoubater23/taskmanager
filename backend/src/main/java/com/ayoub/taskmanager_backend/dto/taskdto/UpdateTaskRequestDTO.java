package com.ayoub.taskmanager_backend.dto.taskdto;

import java.time.LocalDateTime;

public record UpdateTaskRequestDTO(
        String title,
        String description,
        LocalDateTime dueDate,
        Boolean completed
) {}
