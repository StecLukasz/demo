package com.example.repository;

import com.example.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {


    List<Task> findAll();
    Task save(Task entity);
    Task findById(Long id);

}
