package org.example.task_004.onlineCourseManagemenetSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlineCourseManagementSystem onlineCourseManagementSystem = new OnlineCourseManagementSystem();
        boolean systemOn = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("System Zarządzania Kursami Online");
        while (systemOn == true) {
            System.out.println("Dostęne funkcje: dodaj_kurs, dodaj_studenta, zapis_na_kurs, wyświetl_kursy, wyświetl_studentów, wyświetl_postępy_studentów, atkulizacja_postępu_studenta, zamknij_system");
            String functionality = scanner.next();
            if (functionality.equals("dodaj_kurs")) {
                onlineCourseManagementSystem.addCourse(scanner);
            } else if (functionality.equals("dodaj_studenta")) {
                onlineCourseManagementSystem.addStudent(scanner);
            } else if (functionality.equals("zapis_na_kurs")) {
                onlineCourseManagementSystem.studentEnrollment(scanner);
            } else if (functionality.equals("wyświetl_kursy")) {
                onlineCourseManagementSystem.displayCourses();
            } else if (functionality.equals("wyświetl_studentów")) {
                onlineCourseManagementSystem.displayStudents();
            } else if (functionality.equals("wyświetl_postępy_studentów")) {
                onlineCourseManagementSystem.displayStudents();
            } else if (functionality.equals("atkulizacja_postępu_studenta")) {
                onlineCourseManagementSystem.updateEnrollment(scanner);
            }else if (functionality.equals("zamknij_system")) {
                systemOn = false;
            } else {
                System.out.println("Incorrect value!");
            }
        }
    }
}
