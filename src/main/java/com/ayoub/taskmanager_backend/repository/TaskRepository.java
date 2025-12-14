package com.ayoub.taskmanager_backend.repository;

import com.ayoub.taskmanager_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByProjectId(int projectId);

    int countByProject_Id(int projectId);

    int countByProject_IdAndCompletedTrue(int projectId);
    @Query(value = """
    SELECT * FROM tasks t
    WHERE t.project_id = :projectId
      -- String filters: Use CAST(:param AS text)
      AND (:title IS NULL OR t.title ILIKE CONCAT('%', CAST(:title AS text), '%'))
      AND (:description IS NULL OR t.description ILIKE CONCAT('%', CAST(:description AS text), '%'))
      
      -- Boolean filter: Use CAST(:param AS boolean) for the IS NULL check
      AND (CAST(:completed AS boolean) IS NULL OR t.completed = :completed)
      
      -- Date filters: Use CAST(:param AS timestamp) for the IS NULL checks
      AND (CAST(:fromDate AS timestamp) IS NULL OR t.due_date >= :fromDate)
      AND (CAST(:toDate AS timestamp) IS NULL OR t.due_date <= :toDate)
""", nativeQuery = true)
    List<Task> searchTasks(
            @Param("projectId") int projectId,
            @Param("title") String title,
            @Param("description") String description,
            @Param("completed") Boolean completed,
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate
    );
}
