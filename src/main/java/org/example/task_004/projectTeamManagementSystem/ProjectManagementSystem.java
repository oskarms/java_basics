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
                System.out.print("Size of your team: ");
                int team = scanner.nextInt();
                Manager manager = new Manager(id, name, email, team);
                members.add(manager);
                addMemberOn = false;
            } else {
                System.out.println("Invalid value!");
            }
        }
        System.out.println("You have added a new team member");
    }

    public void displayMembers() {
        for (Person person : members) {
            System.out.println("id: " + person.getId() + ", name: " + person.getName() + ", email: " + person.getEmail());
        }
    }

    public void assignTask(Scanner scanner) {
        boolean chooseTaskToAssignOn = true;
        Task taskToAssign = null;
        while (chooseTaskToAssignOn) {
            displayTasks();
            System.out.println("Give task id, to which you want assign user: ");
            int taskId = scanner.nextInt();
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    taskToAssign = task;
                    chooseTaskToAssignOn = false;
                    break;
                }
            }
        }

        Person assignPerson = null;
        boolean assignPersonToTaskOn = true;
        while (assignPersonToTaskOn) {
            displayMembers();
            System.out.println("Give user id, which will be realize task: ");
            int personId = scanner.nextInt();
            for (Person person : members) {
                if (person.getId() == personId) {
                    assignPerson = person;
                    assignPersonToTaskOn = false;
                    break;
                }
            }
        }

        taskToAssign.setAssignee(assignPerson);
    }

    public void createTask(Scanner scanner) {
        int id = generateTaskId(tasks);
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Description: ");
        String description = scanner.next();
        Task task = new Task(id, title, description, null, StatusOfTask.CREATED);
        tasks.add(task);
        System.out.println("Task created!");
    }

    private static int generateTaskId(List<Task> taskList) {
        boolean correctValue = true;
        int uniqueTaskId = 0;
        while (correctValue) {
            Random random = new Random();
            uniqueTaskId = random.nextInt(1, 100);
            correctValue = false;
            for (Task task : taskList) {
                if (uniqueTaskId == task.getTaskId()) {
                    correctValue = true;
                    break;
                }
            }
        }
        return uniqueTaskId;
    }

    public void displayTasks() {
        System.out.println();
        for (Task task : tasks) {
            System.out.println("id: " + task.getTaskId());
            System.out.println("title: " + task.getTitle());
            System.out.println("status: " + task.getStatus());
            if (task.getAssignee() != null) {
                System.out.println("assignee: " + task.getAssignee().getName() + ", " + task.getAssignee().getEmail());
            } else {
                System.out.println("assignee: -");
            }
            System.out.println("description: " + task.getDescription());
            System.out.println();
        }
    }

    public void updateStatusTask(Scanner scanner) {
        boolean updateStatusTaskOn = true;
        while (updateStatusTaskOn) {
            displayTasks();
            System.out.println("Give task id which you want update: ");
            int taskId = scanner.nextInt();
            for (Task task : tasks) {
                if (task.getTaskId() == taskId) {
                    boolean newStatusTaskOn = true;
                    while (newStatusTaskOn) {
                        System.out.println("New status of task: created, to_realise, open, to_verify, verified, " +
                                "closed");
                        String status = scanner.next();
                        switch (status) {
                            case "created":
                                task.setStatus(StatusOfTask.CREATED);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                                break;
                            case "to_realise":
                                task.setStatus(StatusOfTask.TO_REALISE);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                            case "open":
                                task.setStatus(StatusOfTask.OPEN);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                                break;
                            case "to_verify":
                                task.setStatus(StatusOfTask.TO_VERIFY);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                                break;
                            case "verified":
                                task.setStatus(StatusOfTask.VERIFIED);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                                break;
                            case "closed":
                                task.setStatus(StatusOfTask.CLOSED);
                                newStatusTaskOn = false;
                                updateStatusTaskOn = false;
                                System.out.println("Status of task updated!");
                                break;
                            default:
                                System.out.println("Invalid value!");
                        }
                    }
                }
            }
        }
    }

    public void displayTasksByStatus(Scanner scanner) {
        boolean displayTasksByStatusOn = true;
        while (displayTasksByStatusOn) {
            System.out.println("Display tasks by status: created, to_realise, open, to_verify, verified, closed");
            String status = scanner.next();
            switch (status) {
                case "created" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.CREATED)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                case "to_realise" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.TO_REALISE)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                case "open" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.OPEN)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                case "to_verify" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.TO_VERIFY)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                case "verified" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.VERIFIED)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                case "closed" -> {
                    List<Task> result =
                            tasks.stream().filter(task -> task.getStatus().equals(StatusOfTask.CLOSED)).toList();
                    displayTasks(result);
                    displayTasksByStatusOn = false;
                }
                default -> System.out.println("Invalid value!");
            }
        }
    }

    private void displayTasks(List<Task> tasks) {
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found with this status.");
        } else{
            for (Task task : tasks) {
                System.out.println("id: " + task.getTaskId());
                System.out.println("title: " + task.getTitle());
                System.out.println("status: " + task.getStatus());
                if (task.getAssignee() != null) {
                    System.out.println("assignee: " + task.getAssignee().getName() + ", " + task.getAssignee().getEmail());
                } else {
                    System.out.println("assigned to: -");
                }
                System.out.println("description: " + task.getDescription());
                System.out.println();
            }
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
