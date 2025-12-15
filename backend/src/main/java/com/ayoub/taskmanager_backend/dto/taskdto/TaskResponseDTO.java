package com.ayoub.taskmanager_backend.dto.taskdto;

import java.time.LocalDateTime;

public record TaskResponseDTO(int id, String title, String description,
                              LocalDateTime dueDate, boolean completed) {
}
