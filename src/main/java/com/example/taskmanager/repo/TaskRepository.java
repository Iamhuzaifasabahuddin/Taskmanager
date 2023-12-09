package com.example.taskmanager.repo;

import com.example.taskmanager.domain.Tasks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskRepository extends CrudRepository<Tasks, Integer> {
    Tasks findByName(String name);
    Tasks findById(int id);
}
