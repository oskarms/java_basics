package org.example.task_004.projectTeamManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Person{

    private List<String> programingLanguages = new ArrayList<>();

    public Developer(int id, String name, String email, List<String> programingLanguages) {
        super(id, name, email);
        this.programingLanguages = programingLanguages;
    }
}
