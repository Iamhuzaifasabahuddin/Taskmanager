package com.example.taskmanager.Controller;

import com.example.taskmanager.domain.Tasks;
import com.example.taskmanager.repo.TaskRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class TaskValidator implements Validator {

    private TaskRepository taskRepository;


    public TaskValidator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Tasks.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tasks task = (Tasks) target;
        Tasks existingTask = taskRepository.findByName(task.getName());

        if (existingTask != null) {
            errors.rejectValue("name", "", "Task with this name already exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Task should have a title!");

        List<String> priorities = Arrays.asList("High", "Medium", "Low", "low", "medium", "high");

        if (!priorities.contains(task.getPriority())) {
            errors.rejectValue("priority", "", "Only High, Medium & Low priorities");
        }

        if (task.getStartDate() == null) {
            errors.rejectValue("startDate", "", "Start Date cannot be empty");
        }

        if (task.getEndDate() == null) {
            errors.rejectValue("endDate", "", "End Date cannot be empty");
        } else if (task.getStartDate() != null && task.getEndDate().isBefore(task.getStartDate())) {
            errors.rejectValue("endDate", "", "End Date cannot be before Start Date");
        }

    }
}
