package org.example.task_003.employeeManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements EmployeeManagement {

    private List<Employee> subordinateList = new ArrayList<>();

    public Manager(String name, String surname, int id, Specialization specialization) {
        super(name, surname, id, specialization);
    }

    public Manager() {
    }

    public List<Employee> getSubordinateList() {
        return subordinateList;
    }

    @Override
    void completeTask() {
        System.out.println("Manager: completed task");
    }

    @Override
    public void addSubordinate(Employee employee) {
        subordinateList.add(employee);
    }

    @Override
    public void removeSubordinate(Employee employee) {
        subordinateList.remove(employee);
    }
}
