package org.example.task_003.onlineCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Course> listOfCourses = getListOfCourses();

        System.out.println("Welcome to the online course management system");
        boolean systemOn = true;
        Scanner scanner = new Scanner(System.in);
        while (systemOn) {
            System.out.println("Possible functionalities: availableCourses, addCourse, deleteCourse, addParticipant, "
                    + "deleteParticipant, showCourseMaterial, closeSystem");
            String functionality = scanner.next();
            switch (functionality) {
                case "availableCourses" -> availableCourses(listOfCourses);
                case "addCourse" -> addCourse(listOfCourses);
                case "deleteCourse" -> deleteCourse(listOfCourses);
                case "addParticipant" -> addParticipant(listOfCourses);
//                case "deleteParticipant" -> deleteParticipant();
//                case "showCourseMaterial" -> showCourseMaterial();
                case "closeSystem" -> systemOn = false;
                default -> System.out.println("Incorrect value!");
            }
        }
    }

    private static List<Course> getListOfCourses() {
        List<Course> listOfCourses = new ArrayList<>();

        ProgramingCourse programingCourse_01 = new ProgramingCourse(456, "Java from scratch", "Learning the Java " +
                "programming language", "Java");
        listOfCourses.add(programingCourse_01);
        ProgramingCourse programingCourse_02 = new ProgramingCourse(650, "Python from scratch", "Learning the Python "
                + "programming language", "Python");
        listOfCourses.add(programingCourse_02);
        ProgramingCourse programingCourse_03 = new ProgramingCourse(231, "JS from scratch", "Learning the JS " +
                "programming language", "Java Script");
        listOfCourses.add(programingCourse_03);
        MarketingCourse marketingCourse_01 = new MarketingCourse(685, "How use advertising on social media", "In " +
                "this" + " course, you will learn how to use social media to advertise your products");
        listOfCourses.add(marketingCourse_01);
        return listOfCourses;
    }

    private static void availableCourses(List<Course> listOfCourses) {
        for (Course course : listOfCourses) {
            System.out.println("Id: " + course.getId() + " Title: " + course.getTitle() + " Describe: " + course.getDescribe());
        }
    }

    private static void addCourse(List<Course> listOfCourses) {
        Scanner scanner = new Scanner(System.in);
        boolean windowOpen = true;
        Course course;
        while (windowOpen) {
            System.out.println();
            System.out.println("What type of course, you want to add: programingCourse, marketingCourse, closeWindow");
            String functionality = scanner.next();
            switch (functionality) {
                case "programingCourse" -> {
                    course = addProgramingCourse();
                    listOfCourses.add(course);
                }
                case "marketingCourse" -> {
                    course = addMarketingCourse();
                    listOfCourses.add(course);
                }
                case "closeWindow" -> windowOpen = false;
                default -> System.out.println("Incorrect value!");
            }
        }
    }

    private static Course addProgramingCourse() {
        Scanner scanner = new Scanner(System.in);
        ProgramingCourse programingCourse = new ProgramingCourse();
        System.out.println("Course id: ");
        int id = scanner.nextInt();
        programingCourse.setId(id);
        System.out.println("Title: ");
        String title = scanner.next();
        programingCourse.setTitle(title);
        System.out.println("Describe: ");
        String describe = scanner.next();
        programingCourse.setDescribe(describe);
        System.out.println("Programing language: ");
        String programingLanguage = scanner.next();
        programingCourse.setProgrammingLanguage(programingLanguage);
        System.out.println("You added a new course");
        return programingCourse;
    }

    private static Course addMarketingCourse() {
        Scanner scanner = new Scanner(System.in);
        MarketingCourse marketingCourse = new MarketingCourse();
        System.out.println("Course id: ");
        int id = scanner.nextInt();
        marketingCourse.setId(id);
        System.out.println("Title: ");
        String title = scanner.next();
        marketingCourse.setTitle(title);
        System.out.println("Describe: ");
        String describe = scanner.next();
        marketingCourse.setDescribe(describe);
        System.out.println("You added a new course");
        return marketingCourse;
    }

    private static void deleteCourse(List<Course> listOfCourses) {
        availableCourses(listOfCourses);
        Scanner scanner = new Scanner(System.in);
        boolean deleteCourseOn = true;
        boolean foundedCourseToDelete = false;
        while (deleteCourseOn) {
            System.out.println("Enter course id to be deleted: ");
            int courseId = scanner.nextInt();
            for (Course course : listOfCourses) {
                if (courseId == course.getId()) {
                    listOfCourses.remove(course);
                    System.out.println("Course has been removed");
                    foundedCourseToDelete = true;
                    deleteCourseOn = false;
                    break;
                }
            }
            if (!foundedCourseToDelete) {
                System.out.println("This id not exist");
                System.out.println("Do you still want to delete course? (yes/no)");
                String deleteCourse = scanner.next();
                if (deleteCourse.equals("yes")){
                    deleteCourseOn = true;
                } else if (deleteCourse.equals("no")){
                    deleteCourseOn = false;
                }
            }
        }
    }

    private static void addParticipant(List<Course> listOfCourses) {
        availableCourses(listOfCourses);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the course to which you want to add a participant: ");
        int id = scanner.nextInt();
        Course course = findCourse(listOfCourses, id);
        List<Participant> participantList = new ArrayList<>();
        Participant participant = createParticipant();
        participantList.add(participant);
        course.setParticipantList(participantList);
    }

    private static Participant createParticipant() {
        Scanner scanner = new Scanner(System.in);
        Participant participant = new Participant();
        System.out.println("Participant name: ");
        String name = scanner.next();
        participant.setName(name);
        System.out.println("Participant surname: ");
        String surname = scanner.next();
        participant.setSurname(surname);
        return participant;
    }

    private static Course findCourse(List<Course> listOfCourses, int id) {
        Course searchedCourse = null;
        for (Course course : listOfCourses) {
            if (id == course.getId()) {
                searchedCourse = course;
                break;
            }
        }
        return searchedCourse;
    }
}
