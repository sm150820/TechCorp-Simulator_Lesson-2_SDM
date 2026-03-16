package com.example.techcorp;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private double budget;
    private List<Employee> employees;
    private List<Project> projects;

    public Company(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void startProject(Project project) {
        projects.add(project);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    // Exercise 3 — Display status including roles
    public void printStatus() {
        System.out.println("=== Company Status: " + name + " ===");
        System.out.println("Budget: " + budget);
        System.out.println("\nEmployees:");

        for (Employee e : employees) {
            System.out.println(" - " + e.getName() + " (" + e.getRoleName() + "), Skill=" + e.getSkill());
        }

        System.out.println("\nProjects:");
        for (Project p : projects) {
            System.out.println(" - " + p.getName() + ": " + p.getProgress() + "/" + p.getRequiredWork());
        }

        System.out.println("====================================");
    }
}