package org.example.task_004.onlineCourseManagemenetSystem;

import org.example.task_004.projectTeamManagementSystem.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OnlineCourseManagementSystem {
    private List<Course> courses;
    private List<Student> students;
    private List<Enrollment> enrollments;

    public void addCourse(Scanner scanner) {
        System.out.print("id kursu: ");
        int id = scanner.nextInt();
        System.out.print("tytuł: ");
        String title = scanner.next();
        System.out.print("instruktor: ");
        String instructor = scanner.next();
        System.out.print("liczba godzin: ");
        int duration = scanner.nextInt();

        System.out.println("kurs programistyczny czy ux?");
        String typeOfCourse = scanner.next();

        boolean systemOn = true;
        while (systemOn == true) {
            if (typeOfCourse.equals("programistyczny")) {
                List<String> programingLanguages = new ArrayList<>();
                boolean addedLanguages = false;
                while (addedLanguages == false) {
                    System.out.print("Podaj języki programowania na kursie programistycznym lub wpisz 'zakończ'");
                    String programingLanguage = scanner.next();
                    if (!programingLanguage.equals("zakończ")) {
                        programingLanguages.add(programingLanguage);
                    } else {
                        addedLanguages = true;
                    }
                }
                ProgramingCourse programingCourse = new ProgramingCourse(id, title, instructor, duration,
                        programingLanguages);
                courses.add(programingCourse);
                systemOn = false;
            } else if (typeOfCourse.equals("ux")) {
                List<String> uxTools = new ArrayList<>();
                boolean addedTools = false;
                while (addedTools == false) {
                    System.out.print("narzędzie ux w kursie ux lub wpisz 'zakończ': ");
                    String uxTool = scanner.next();
                    if (!uxTool.equals("zakończ")) {
                        uxTools.add(uxTool);
                    } else {
                        addedTools = true;
                    }
                }
                ProgramingCourse programingCourse = new ProgramingCourse(id, title, instructor, duration, uxTools);
                courses.add(programingCourse);
                systemOn = false;
            } else {
                System.out.println("Niepoprawna wartość!");
            }
        }

        System.out.println("Dodałeś nowy kurs");
    }

    public void addStudent(Scanner scanner) {
        int id = generateUserId(students);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Student student = new Student(id, name, email);
        students.add(student);
    }

    private static int generateUserId(List<Student> studentList) {
        boolean correctValue = true;
        int randomIdUser = 0;
        while (correctValue) {
            Random random = new Random();
            randomIdUser = random.nextInt(1, 999);
            correctValue = false;
            for (Student student : studentList) {
                if (randomIdUser == student.getId()) {
                    correctValue = true;
                    break;
                }
            }
        }
        return randomIdUser;
    }

    public void studentEnrollment(Scanner scanner) {
        System.out.print("Podaj id zdarzenia zapisu na kurs: ");
        int idEnrollment = scanner.nextInt();

        Student assignStudent = null;
        boolean assignedStudentToEnrollment = false;
        while (assignedStudentToEnrollment == false) {
            displayStudents();
            System.out.println("Wybierz studenta, którego chesz zapisać na kurs, podaj jego id: ");
            int studentId = scanner.nextInt();
            for (Student student : students) {
                if (student.getId() == studentId) {
                    assignStudent = student;
                    assignedStudentToEnrollment = true;
                }
            }
        }

        Course assignCourse = null;
        boolean assignedCourseToEnrollment = false;
        while (assignedCourseToEnrollment == false) {
            displayCourses();
            System.out.println("Wybierz kurs, do którego chcesz zapisać studenta, podaj id kursu: ");
            int courseId = scanner.nextInt();
            for (Course course : courses) {
                if (course.getId() == courseId) {
                    assignCourse = course;
                    assignedCourseToEnrollment = true;
                }
            }
        }

        double progress = 0;
        Enrollment enrollment = new Enrollment(idEnrollment, assignStudent, assignCourse, progress);
        enrollments.add(enrollment);
    }

    public void displayCourses() {
        System.out.println("Kursy:");
        for (Course course : courses) {
            System.out.println(course + " ");
        }
    }

    public void displayStudents() {
        System.out.println("Studenci:");
        for (Student student : students) {
            System.out.println(student + " ");
        }
    }

    public void updateEnrollment(Scanner scanner) {
        System.out.println("Zapisy na kurs:");
        for (Enrollment enrollment : enrollments) {
            System.out.println("id: " + enrollment.getEnrollmentId() + " kurs: " + enrollment.getCourse() + " student" +
                    ": " + enrollment.getStudent() + " progres: " + enrollment.getProgress());
        }
        boolean enrollmentExist = false;
        while (enrollmentExist == false) {
            System.out.println("Wybierz id zapisu studenta do aktulizacji: ");
            int enrollmentId = scanner.nextInt();
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getEnrollmentId() == enrollmentId) {
                    System.out.print("Ustaw nowy progres zadania: ");
                    double progress = scanner.nextDouble();
                    enrollment.setProgress(progress);
                    enrollmentExist = true;
                    System.out.println("Wykonałeś aktulizacje zapisu studenta");
                }
            }
        }
    }
}
