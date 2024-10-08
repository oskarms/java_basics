package org.example.task_003.employeeManagementSystem;

public class Technician extends Employee {

    public Technician(String name, String surname, int id, Specialization specialization) {
        super(name, surname, id, specialization);
    }

    public Technician() {
        super();
    }

    @Override
    void completeTask() {
        System.out.println("Technician: completed task");
    }
}
