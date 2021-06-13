package com.example.service;

import com.example.model.Task;
import com.example.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    private final TasksRepository taskRepository;
    public TasksService(TasksRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public void addTask(Task task) {
        Task newTask = new Task(
                task.getId(),
                task.getDeadline(),
                task.getDescription(),
                task.getColor(),
                task.getCreationDate());
        taskRepository.save(newTask);
        System.out.println("adding person on id:" + newTask.getId());
    }
}
