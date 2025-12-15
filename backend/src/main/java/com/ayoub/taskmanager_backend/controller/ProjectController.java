package com.ayoub.taskmanager_backend.controller;

import com.ayoub.taskmanager_backend.dto.projectdto.CreateProjectRequestDTO;
import com.ayoub.taskmanager_backend.dto.projectdto.ProjectResponseDTO;
import com.ayoub.taskmanager_backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody CreateProjectRequestDTO dto,
                                                            @RequestHeader("userId")int userId){
        ProjectResponseDTO responseDTO = projectService.createProject(dto, userId);
        return ResponseEntity.ok(responseDTO);
    }
    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects(
            @RequestHeader("userId") int userId) {
        List<ProjectResponseDTO> responseDTO = projectService.getAllProjects(userId);
        return ResponseEntity.ok(responseDTO);

    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable int projectId,
                                             @RequestHeader("userId")int userId) {
        ProjectResponseDTO responseDTO = projectService.getProjectById(projectId, userId);
        return ResponseEntity.ok(responseDTO);
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable int projectId,
                                                  @RequestHeader("userId") int userId) {
        projectService.deleteProjectById(projectId, userId);
        return ResponseEntity.noContent().build();
    }
}
