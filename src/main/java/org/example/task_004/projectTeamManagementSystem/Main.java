package org.example.task_004.projectTeamManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Management Team System ");
        ProjectManagementSystem projectManagementSystem = new ProjectManagementSystem();
        boolean systemOn = true;
        Scanner scanner = new Scanner(System.in);

        while (systemOn) {
            System.out.println("Menu: addNewTeamMember, displayTeamMembers, createTask, assignTask, displayTasks, displayTasksByStatus, updateTaskStatus, close");
            String functionality = scanner.next();
            switch (functionality) {
                case "addNewTeamMember" -> projectManagementSystem.addMember(scanner);
                case "displayTeamMembers" -> projectManagementSystem.displayMembers();
                case "createTask" -> projectManagementSystem.createTask(scanner);
                case "assignTask" -> projectManagementSystem.assignTask(scanner);
                case "displayTasks" -> projectManagementSystem.displayTasks();
                case "displayTasksByStatus" -> projectManagementSystem.displayTasksByStatus(scanner);
                case "updateTaskStatus" -> projectManagementSystem.updateStatusTask(scanner);
                case "close" -> systemOn = false;
                default -> System.out.println("Invalid value!");
            }
        }
    }
}

