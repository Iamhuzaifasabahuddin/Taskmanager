package com.example.taskmanager;

import com.example.taskmanager.repo.TaskRepository;
import com.example.taskmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner {

    @Autowired
    public TaskRepository taskRepository;

    @Autowired
    public UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {




    }
}
