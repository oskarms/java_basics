package org.example.task_003.onlineCourseManagementSystem;

public class Participant {

    private String name;
    private String surname;

    public Participant(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Participant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
