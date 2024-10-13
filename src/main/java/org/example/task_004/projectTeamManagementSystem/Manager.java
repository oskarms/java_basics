package org.example.task_004.projectTeamManagementSystem;

public class Manager extends Person{

    private int teamSize;

    public Manager(int id, String name, String email, int teamSize) {
        super(id, name, email);
        this.teamSize = teamSize;
    }
}
