package org.example.task_003.employeeManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Employee> listEmployees = getEmployees();

        System.out.println("Welcome to the team management system.");

        boolean systemOn = true;
        String functionality;
        String person;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you Manager or Technician? ");
        while (systemOn) {
            person = scanner.next();
            if (person.equals("Manager")) {
                Manager manager = new Manager();
                boolean display = true;
                while (display) {
                    System.out.println();
                    System.out.println("Possible functionalities: displayEmployees, addEmployee, removeEmployee, " +
                            "manageYourTeam, completeTask, closeSystem");
                    functionality = scanner.next();
                    switch (functionality) {
                        case "displayEmployees" -> displayEmployees(listEmployees);
                        case "addEmployee" -> addEmployee(listEmployees);
                        case "removeEmployee" -> removeEmployee(listEmployees);
                        case "manageYourTeam" -> manageYourTeam(manager, listEmployees);
                        case "completeTask" -> manager.completeTask();
                        case "closeSystem" -> {
                            display = false;
                            systemOn = false;
                        }
                        default -> System.out.println("Incorrect value!");
                    }
                }
            } else if (person.equals("Technician")) {
                Technician technician = new Technician();
                boolean display = true;
                while (display) {
                    System.out.println();
                    System.out.println("Possible functionalities: displayEmployees, addEmployee, removeEmployee, " +
                            "completeTask, closeSystem");
                    functionality = scanner.next();
                    switch (functionality) {
                        case "displayEmployees" -> displayEmployees(listEmployees);
                        case "addEmployee" -> addEmployee(listEmployees);
                        case "removeEmployee" -> removeEmployee(listEmployees);
                        case "completeTask" -> technician.completeTask();
                        case "closeSystem" -> {
                            display = false;
                            systemOn = false;
                        }
                        default -> System.out.println("Incorrect value!");
                    }
                }
            }
        }
    }

    private static List<Employee> getEmployees() {
        Technician technician_01 = new Technician("Jan", "Kowalski", 234, Specialization.BACKEND_DEVELOPER);
        Technician technician_02 = new Technician("Krzysztof", "Nowak", 356, Specialization.QA_ENGINEER);
        Technician technician_03 = new Technician("Kamil", "Szczodry", 548, Specialization.FRONTEND_DEVELOPER);
        Manager manager_01 = new Manager("Marcin", "Głodny", 846, Specialization.PRODUCT_MANAGER);

        technician_01.completeTask();
        List<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(technician_01);
        listEmployees.add(technician_02);
        listEmployees.add(technician_03);
        listEmployees.add(manager_01);
        return listEmployees;
    }

    private static void manageYourTeam(Manager manager, List<Employee> listEmployees) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Team management: addSubordinate, removeSubordinate, displayTeam");
            String functionality = scanner.next();
            switch (functionality) {
                case "addSubordinate": {
                    System.out.println("List of employees:");
                    for (Employee employee : listEmployees) {
                        printEmployee(employee);
                    }
                    System.out.println("Enter the id of the subordinate you want to add to your team: ");
                    int userId = scanner.nextInt();
                    for (Employee employee : listEmployees) {
                        if (userId == employee.getId()) {
                            manager.addSubordinate(employee);
                            System.out.println("Subordinate added to your team");
                            break;
                        }
                    }
                    break label;
                }
                case "removeSubordinate": {
                    System.out.println("List of subordinates in your team:");
                    for (Employee employee : manager.getSubordinateList()) {
                        printEmployee(employee);
                    }
                    System.out.println("Enter the id of the subordinate you want to remove from the team:");
                    int userId = scanner.nextInt();
                    for (Employee employee : listEmployees) {
                        if (userId == employee.getId()) {
                            manager.removeSubordinate(employee);
                            break;
                        }
                    }
                    break;
                }
                case "displayTeam":
                    System.out.println("List of subordinates in your team:");
                    List<Employee> subordinateList = manager.getSubordinateList();
                    for (Employee employee : subordinateList) {
                        printEmployee(employee);
                    }
                    break label;
                default:
                    System.out.println("Incorrect value!");
                    break;
            }
        }
    }

    private static void displayEmployees(List<Employee> listEmployees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Display: ALL, QA_ENGINEER, BACKEND_DEVELOPER, FRONTEND_DEVELOPER, PRODUCT_MANAGER");
        String display = scanner.next();
        switch (display) {
            case "ALL" -> {
                for (Employee employee : listEmployees) {
                    printEmployee(employee);
                }
            }
            case "QA_ENGINEER" -> {
                for (Employee employee : listEmployees) {
                    if (employee.getSpecialization() == Specialization.QA_ENGINEER) {
                        printEmployee(employee);
                    }
                }
            }
            case "BACKEND_DEVELOPER" -> {
                for (Employee employee : listEmployees) {
                    if (employee.getSpecialization() == Specialization.BACKEND_DEVELOPER) {
                        printEmployee(employee);
                    }
                }
            }
            case "FRONTEND_DEVELOPER" -> {
                for (Employee employee : listEmployees) {
                    if (employee.getSpecialization() == Specialization.FRONTEND_DEVELOPER) {
                        printEmployee(employee);
                    }
                }
            }
            case "PRODUCT_MANAGER" -> {
                for (Employee employee : listEmployees) {
                    if (employee.getSpecialization() == Specialization.PRODUCT_MANAGER) {
                        printEmployee(employee);
                    }
                }
            }
            default -> System.out.println("Incorrect value!");
        }
    }

    private static void displayAllEmployees(List<Employee> listEmployees) {
        for (Employee employee : listEmployees) {
            printEmployee(employee);
        }
    }

    private static void printEmployee(Employee employee) {
        System.out.println("Id: " + employee.getId() + ", " + employee.getName() + " " + employee.getSurname() + ", " + employee.getSpecialization());
    }

    private static void removeEmployee(List<Employee> listEmployees) {
        Scanner scanner = new Scanner(System.in);
        displayAllEmployees(listEmployees);
        boolean removeEmployee = false;
        System.out.println("Enter user id to be deleted: ");
        int userId = scanner.nextInt();
        while (!removeEmployee) {
            for (Employee employee : listEmployees) {
                if (userId == employee.getId()) {
                    listEmployees.remove(employee);
                    System.out.println("User has been removed");
                    removeEmployee = true;
                    break;
                }
            }
            if (!removeEmployee) {
                System.out.println("No user with this ID found for deletion");
                removeEmployee = true;
            }
        }
    }


    private static void addEmployee(List<Employee> listEmployees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manager or Technician?");
        String newTypeOfEmployee = scanner.next();
        if (newTypeOfEmployee.equals("Technician")) {
            Technician technician = addTechnician();
            listEmployees.add(technician);
        } else if (newTypeOfEmployee.equals("Manager")) {
            Manager manager = addManager();
            listEmployees.add(manager);
        } else {
            System.out.println("Incorrect value!");
        }
    }

    private static Manager addManager() {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        System.out.println("User id: ");
        int id = scanner.nextInt();
        manager.setId(id);
        System.out.println("Name: ");
        String name = scanner.next();
        manager.setName(name);
        System.out.println("Surname: ");
        String surname = scanner.next();
        manager.setSurname(surname);
        manager.setSpecialization(Specialization.PRODUCT_MANAGER);
        System.out.println("You added an employee");
        return manager;
    }

    private static Technician addTechnician() {
        Scanner scanner = new Scanner(System.in);
        Technician technician = new Technician();
        System.out.println("User Id: ");
        int id = scanner.nextInt();
        technician.setId(id);
        System.out.println("Name: ");
        String name = scanner.next();
        technician.setName(name);
        System.out.println("Surname: ");
        String surname = scanner.next();
        technician.setSurname(surname);

        boolean defineUserSpecialization = true;
        while (defineUserSpecialization) {
            System.out.println("Specialization: QA_ENGINEER, BACKEND_DEVELOPER, FRONTEND_DEVELOPER");
            String specialization = scanner.next();
            switch (specialization) {
                case "QA_ENGINEER" -> {
                    technician.setSpecialization(Specialization.QA_ENGINEER);
                    defineUserSpecialization = false;
                }
                case "BACKEND_DEVELOPER" -> {
                    technician.setSpecialization(Specialization.BACKEND_DEVELOPER);
                    defineUserSpecialization = false;
                }
                case "FRONTEND_DEVELOPER" -> {
                    technician.setSpecialization(Specialization.FRONTEND_DEVELOPER);
                    defineUserSpecialization = false;
                }
                default -> System.out.println("Incorrect value!");
            }
        }
        return technician;
    }
}

