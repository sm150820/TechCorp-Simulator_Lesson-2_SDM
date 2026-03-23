package com.example.techcorp;

import java.util.List;

public class Simulation {

    private Company company;
    private int currentTurn;

    public Simulation(Company company) {
        this.company = company;
        this.currentTurn = 0;
    }

    public void runSimulation(int maxTurns) {
        System.out.println("=== Starting Simulation ===");

        for (int turn = 1; turn <= maxTurns; turn++) {
            currentTurn = turn;

            System.out.println("\n--- Turn " + turn + " ---");

            List<Project> projects = company.getProjects();

            for (Project project : projects) {
                if (!project.isFinished()) {
                    project.workOneTurn();
                }
            }

            company.printStatus();

            // Check if all projects are finished
            if (allProjectsFinished()) {
                System.out.println("\nAll projects completed in " + currentTurn + " turns!");
                break;
            }
        }

        announceWinner();
    }

    private boolean allProjectsFinished() {
        for (Project project : company.getProjects()) {
            if (!project.isFinished()) {
                return false;
            }
        }
        return true;
    }

    private void announceWinner() {
        Project fastest = null;
        int fastestTurns = Integer.MAX_VALUE;

        System.out.println("\n=== Project Completion Summary ===");

        for (Project project : company.getProjects()) {
            int turnsNeeded = turnsToComplete(project);
            System.out.println(" - " + project.getName() + ": " + turnsNeeded + " turns");

            if (turnsNeeded < fastestTurns) {
                fastestTurns = turnsNeeded;
                fastest = project;
            }
        }

        if (fastest != null) {
            System.out.println("\n*** Fastest project: " + fastest.getName() + " (" + fastestTurns + " turns) ***");
        }
    }

    private int turnsToComplete(Project project) {
        int progress = 0;
        int turns = 0;

        for (Employee e : project.getTeam()) {
            // no-op: we just count possible productivity
        }

        while (progress < project.getRequiredWork()) {
            for (Employee e : project.getTeam()) {
                progress += e.work();
            }
            turns++;
        }

        return turns;
    }
}