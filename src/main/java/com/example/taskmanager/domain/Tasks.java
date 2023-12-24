package com.example.taskmanager.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    private String priority;

    private LocalDate startDate;
    private LocalDate endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            this.description = "NA";
        } else {
            this.description = description;
        }
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        if (priority == null || priority.trim().isEmpty()) {
            this.priority = "Medium";
        } else {
            this.priority = priority;
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
