package com.ayoub.taskmanager_backend.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_sequence")
    @SequenceGenerator(name = "project_id_sequence", sequenceName = "project_id_sequence")
    private int id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;


    public Project(int id, String title, String description, LocalDateTime createdAt, User user, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.user = user;
        this.tasks = tasks;
    }

    public Project() {
    }

    public Project(String title, String description, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task>  getTasks() {
        return tasks;
    }

    public void setTasks(List<Task>  tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", tasks=" + tasks +
                '}';
    }
}
