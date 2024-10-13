package org.example.task_003.onlineCourseManagementSystem;

public class ProgramingCourse extends Course {
    private String programmingLanguage;

    public ProgramingCourse(int id, String title, String describe, String programmingLanguage) {
        super(id, title, describe);
        this.programmingLanguage = programmingLanguage;
    }

    public ProgramingCourse() {
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void videoLessonsBasics() {
        System.out.println("Video - " + programmingLanguage + " from scratch");
    }

    @Override
    void videoLessonsAdvanced() {
        System.out.println("Video - " + programmingLanguage + " for advanced");
    }

    @Override
    void quiz() {
        System.out.println("Quiz on programming language " + programmingLanguage);
    }
}
