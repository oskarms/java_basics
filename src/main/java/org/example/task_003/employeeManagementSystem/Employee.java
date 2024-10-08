package org.example.task_003.employeeManagementSystem;


public class Employee extends Person {
    private String name;
    private String surname;
    private int id;
    private Specialization specialization;

    public Employee(String name, String surname, int id, Specialization specialization) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.specialization = specialization;
    }

    public Employee() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
