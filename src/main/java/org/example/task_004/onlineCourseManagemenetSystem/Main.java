package org.example.task_004.onlineCourseManagemenetSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlineCourseManagementSystem onlineCourseManagementSystem = new OnlineCourseManagementSystem();
        boolean systemOn = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Online Course Management System ");
        while (systemOn) {
            System.out.println("Menu: addCourse, addStudent, assignStudentOnCourse, displayCourses, displayStudents, displayStudentProgress, updateStudentProgress, closeSystem");
            String functionality = scanner.next();
            switch (functionality) {
                case "addCourse" -> onlineCourseManagementSystem.addCourse(scanner);
                case "addStudent" -> onlineCourseManagementSystem.addStudent(scanner);
                case "assignStudentOnCourse" -> onlineCourseManagementSystem.studentEnrollment(scanner);
                case "displayCourses" -> onlineCourseManagementSystem.displayCourses();
                case "displayStudents" -> onlineCourseManagementSystem.displayStudents();
                case "displayStudentProgress" -> onlineCourseManagementSystem.displayStudentProgress();
                case "updateStudentProgress" -> onlineCourseManagementSystem.updateEnrollment(scanner);
                case "closeSystem" -> systemOn = false;
                default -> System.out.println("Incorrect value!");
            }
        }
    }
}
