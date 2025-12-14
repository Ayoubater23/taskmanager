package com.ayoub.taskmanager_backend.controller;

import com.ayoub.taskmanager_backend.dto.taskdto.CreateTaskRequestDTO;
import com.ayoub.taskmanager_backend.dto.taskdto.TaskResponseDTO;
import com.ayoub.taskmanager_backend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<TaskResponseDTO> createTask(@PathVariable int projectId,
                                                      @RequestHeader("userId") int userId,
                                                      @RequestBody CreateTaskRequestDTO dto) {
        TaskResponseDTO createdTask= taskService.createTask(projectId, userId, dto);
        return ResponseEntity.ok(createdTask);
    }
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(
            @PathVariable int projectId,
            @RequestHeader("userId") int userId
    ) {
        List<TaskResponseDTO> tasks =
                taskService.getAllTasks(projectId, userId);
        return ResponseEntity.ok(tasks);
    }
    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<TaskResponseDTO> markTaskCompleted(
            @PathVariable int taskId,
            @RequestHeader("userId") int userId
    ) {
        TaskResponseDTO updated =
                taskService.markTaskCompleted(taskId, userId);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable int taskId,
            @RequestHeader("userId") int userId
    ) {
        taskService.deleteTask(taskId, userId);
        return ResponseEntity.noContent().build();
    }
    }
