package org.example.task_004.projectTeamManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProjectManagementSystem {

    private final List<Person> members = new ArrayList<>();
    private final List<Task> tasks = new ArrayList<>();

    public void addMember(Scanner scanner) {
        int id = generateUserId(members);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        boolean addMemberOn = true;
        while (addMemberOn) {
            System.out.println("New member is a developer or manager?");
            String member = scanner.next();
            if (member.equals("developer")) {
                List<String> programingLanguages = addProgramingLanguages(scanner);
                Developer developer = new Developer(id, name, email, programingLanguages);
                members.add(developer);
                addMemberOn = false;
            } else if (member.equals("manager")) {
                System.out.print("wielkość zespołu managera: ");
                int team = scanner.nextInt();
                Manager manager = new Manager(id, name, email, team);
                members.add(manager);
                addMemberOn = false;
            } else {
                System.out.println("Invalid value!");
            }
        }

        Person person = new Person(id, name, email);
        members.add(person);
        System.out.println("You have added a new team member");
    }

    public void displayMembers() {
        for (Person person : members) {
            System.out.println("id: " + person.getId() + ", imię: " + person.getName() + ", email: " + person.getEmail());
        }
    }

    public void assignTask(Scanner scanner) {
        System.out.print("Podaj id zadania: ");
        int id = scanner.nextInt();
        System.out.print("Podaj tytuł: ");
        String title = scanner.next();
        System.out.print("Podaj opis: ");
        String description = scanner.next();

        Person assignPerson = null;
        boolean assignedPersonToTask = false;
        while (!assignedPersonToTask) {
            displayMembers();
            System.out.println("Przypisz osobę, podaj jej id: ");
            int personId = scanner.nextInt();
            for (Person person : members) {
                if (person.getId() == personId) {
                    assignPerson = person;
                    assignedPersonToTask = true;
                }
            }
        }

        System.out.print("Podaj status: ");
        String status = scanner.next();

        Task task = new Task(id, title, description, assignPerson, status);
        tasks.add(task);
        System.out.println("Przypisałeś zadanie do członka zespołu");
    }

    public void displayTasks() {
        System.out.println();
        for (Task task : tasks) {
            System.out.println("id: " + task.getTaskId());
            System.out.println("title: " + task.getTitle());
            System.out.println("status: " + task.getStatus());
            System.out.println("assignee: " + task.getAssignee().getName() + ", " + task.getAssignee().getEmail());
            System.out.println("description: " + task.getDescription());
            System.out.println();
        }
    }

    public void updateStatusTask(Scanner scanner) {
        displayTasks();
        boolean taskExist = false;
        while (!taskExist) {
            System.out.println("Wybierz id zadania istniejącego do aktualizacji: ");
            int taskId = scanner.nextInt();
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    System.out.print("Ustaw nowy status zadania: ");
                    String status = scanner.next();
                    task.setStatus(status);
                    taskExist = true;
                    System.out.println("Wykonałeś aktulizacje statusu zadania");
                }
            }
        }
    }

    public void displayTasksByFilter(Scanner scanner) {
        boolean filter = true;
        while (filter) {
            System.out.print("Podaj status zadań do wyświetlenia (TO_DO, IN_PROGRESS, DONE): ");
            String status = scanner.next();
            if (status.equals("TO_DO")) {
                List<Task> result = tasks.stream().filter(task -> task.getStatus().equals("TO_DO")).toList();
                displayTasks(result);
                filter = false;
            } else if (status.equals("IN_PROGRESS")) {
                List<Task> result = tasks.stream().filter(task -> task.getStatus().equals("IN_PROGRESS")).toList();
                displayTasks(result);
                filter = false;
            } else if (status.equals("DONE")) {
                List<Task> result = tasks.stream().filter(task -> task.getStatus().equals("DONE")).toList();
                displayTasks(result);
                filter = false;
            } else {
                System.out.println("Niepoprawna wartość!");
            }
        }
    }

    private void displayTasks(List<Task> tasks) {
        System.out.println();
        for (Task task : tasks) {
            System.out.println("id: " + task.getTaskId());
            System.out.println("title: " + task.getTitle());
            System.out.println("status: " + task.getStatus());
            System.out.println("assignee: " + task.getAssignee().getName() + ", " + task.getAssignee().getEmail());
            System.out.println("description: " + task.getDescription());
            System.out.println();
        }
    }

    private static int generateUserId(List<Person> listOfMembers) {
        boolean correctValue = true;
        int randomIdUser = 0;
        while (correctValue) {
            Random random = new Random();
            randomIdUser = random.nextInt(1, 999);
            correctValue = false;
            for (Person person : listOfMembers) {
                if (randomIdUser == person.getId()) {
                    correctValue = true;
                    break;
                }
            }
        }
        return randomIdUser;
    }

    private static List<String> addProgramingLanguages(Scanner scanner) {
        List<String> programingLanguages = new ArrayList<>();
        while (true) {
            System.out.print("Enter the developer's programming languages, or type 'close': ");
            String programingLanguage = scanner.next();
            if (programingLanguage.equals("close")) {
                break;
            } else {
                programingLanguages.add(programingLanguage);
            }
        }
        return programingLanguages;
    }
}
