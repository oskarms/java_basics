package org.example.task_004.onlineCourseManagemenetSystem;

import java.util.List;

public class ProgramingCourse extends Course{

    private List<String> programingLanguages;

    public ProgramingCourse(int id, String tittle, String instructor, int duration, List<String> programingLanguages) {
        super(id, tittle, instructor, duration);
        this.programingLanguages = programingLanguages;
    }
}
