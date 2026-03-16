package com.example.techcorp;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("TechCorp", 50000);

        // Employees
        Employee anna = new Developer("Anna", 8, 7000);
        Employee piotr = new Tester("Piotr", 6, 6500);
        Employee karen = new Manager("Karen", 5, 8000);
        Employee lucas = new Intern("Lucas", 4, 2000);

        company.hire(anna);
        company.hire(piotr);
        company.hire(karen);
        company.hire(lucas);

        // Project 1
        Project projectA = new Project("Mobile App", 40);
        projectA.addEmployee(anna);
        projectA.addEmployee(piotr);

        // Project 2
        Project projectB = new Project("AI Dashboard", 55);
        projectB.addEmployee(karen);
        projectB.addEmployee(lucas);

        company.startProject(projectA);
        company.startProject(projectB);

        // Run the simulation
        Simulation simulation = new Simulation(company);
        simulation.runSimulation(10);
    }
}