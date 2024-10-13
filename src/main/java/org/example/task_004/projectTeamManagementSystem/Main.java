package org.example.task_004.projectTeamManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Management Team System ");
        ProjectManagementSystem projectManagementSystem = new ProjectManagementSystem();
        boolean systemOn = true;
        Scanner scanner = new Scanner(System.in);

        while (systemOn) {
            System.out.println("Menu: addNewTeamMember, assignTaskToTeamMember, displayTeamMembers, displayTasks, displayTasksByStatus, updateTaskStatus, close");
            String functionality = scanner.next();
            if (functionality.equals("addNewTeamMember")) {
                projectManagementSystem.addMember(scanner);
            } else if (functionality.equals("assignTaskToTeamMember")) {
                projectManagementSystem.assignTask(scanner);
            } else if (functionality.equals("displayTeamMembers")) {
                projectManagementSystem.displayMembers();
            } else if (functionality.equals("displayTasks")) {
                projectManagementSystem.displayTasks();
            } else if (functionality.equals("displayTasksByStatus")) {
                projectManagementSystem.displayTasksByFilter(scanner);
            } else if (functionality.equals("updateTaskStatus")) {
                projectManagementSystem.updateStatusTask(scanner);
            } else if (functionality.equals("close")) {
                systemOn = false;
            } else {
                System.out.println("Invalid value!");
            }
        }
    }
}

