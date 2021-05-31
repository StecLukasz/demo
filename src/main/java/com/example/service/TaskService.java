package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskService taskService;

    public TaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getTaskList(){
        return TaskRepository.findAll();
    }
    public Task getTask(Long id){
        return TaskRepository.findById(id).orElse(null);
    }

    public void addTask(Task task){
        Task newTask =  new Task(task.getId(),
                task.getDeadline(),
                task.getPerson());
        TaskRepository.save(newTask);
        System.out.println("New task: " + newTask.getId());
    }

}
