package com.example.techcorp;

import java.util.ArrayList;
import java.util.List;

public class Project {

    public enum ProjectStatus {
        PLANNED,
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    private String name;
    private int requiredWork;
    private int progress;
    private List<Employee> team;
    private ProjectStatus status;

    public Project(String name, int requiredWork) {
        this.name = name;
        this.requiredWork = requiredWork;
        this.progress = 0;
        this.team = new ArrayList<>();
        this.status = ProjectStatus.PLANNED;
    }

    public void addEmployee(Employee employee) {
        team.add(employee);
    }

    public void workOneTurn() {
        if (status != ProjectStatus.IN_PROGRESS) return;

        for (Employee employee : team) {
            progress += employee.work();
        }

        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.FINISHED;
        }
    }

    public boolean isFinished() {
        return status == ProjectStatus.FINISHED;
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }

    public int getRequiredWork() {
        return requiredWork;
    }

    public List<Employee> getTeam() {
        return team;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void start() {
        if (status == ProjectStatus.PLANNED) {
            status = ProjectStatus.IN_PROGRESS;
        }
    }

    public void cancel() {
        if (status != ProjectStatus.FINISHED) {
            status = ProjectStatus.CANCELLED;
        }
    }
}