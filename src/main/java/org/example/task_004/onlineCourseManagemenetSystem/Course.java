package org.example.task_004.onlineCourseManagemenetSystem;

public class Course {
    private int id;
    private String tittle;
    private String instructor;
    private int duration;

    public Course(int id, String tittle, String instructor, int duration) {
        this.id = id;
        this.tittle = tittle;
        this.instructor = instructor;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
