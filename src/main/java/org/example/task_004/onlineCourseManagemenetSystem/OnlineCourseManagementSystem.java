package org.example.task_004.onlineCourseManagemenetSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OnlineCourseManagementSystem {
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public void addCourse(Scanner scanner) {
        int id = generateCourseId(courses);
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Teacher: ");
        String instructor = scanner.next();

        boolean addCourseOn = true;
        while (addCourseOn) {
            System.out.print("Course development or ux: ");
            String typeOfCourse = scanner.next();
            if (typeOfCourse.equals("development")) {
                List<String> programingLanguages = new ArrayList<>();
                boolean addedLanguagesOn = true;
                while (addedLanguagesOn) {
                    System.out.print("Give the programing languages, of the course or write 'close': ");
                    String programingLanguage = scanner.next();
                    if (!programingLanguage.equals("close")) {
                        programingLanguages.add(programingLanguage);
                    } else {
                        addedLanguagesOn = false;
                    }
                }
                System.out.print("Amount of hours: ");
                int duration = scanner.nextInt();
                ProgramingCourse programingCourse = new ProgramingCourse(id, title, instructor, duration,
                        programingLanguages);
                courses.add(programingCourse);
                addCourseOn = false;
            } else if (typeOfCourse.equals("ux")) {
                List<String> uxTools = new ArrayList<>();
                boolean addUxToolsOn = true;
                while (addUxToolsOn) {
                    System.out.print("Give the tool of ux or write 'close': ");
                    String uxTool = scanner.next();
                    if (!uxTool.equals("close")) {
                        uxTools.add(uxTool);
                    } else {
                        addUxToolsOn = false;
                    }
                }
                System.out.print("Amount of hours: ");
                int duration = scanner.nextInt();
                GraphicCourse graphicCourse = new GraphicCourse(id, title, instructor, duration, uxTools);
                courses.add(graphicCourse);
                addCourseOn = false;
            } else {
                System.out.println("Invalid value!");
            }
        }
        System.out.println("Course added!");
    }

    private static int generateCourseId(List<Course> courseList) {
        boolean correctValue = true;
        int randomIdCourse = 0;
        while (correctValue) {
            Random random = new Random();
            randomIdCourse = random.nextInt(1, 999);
            correctValue = false;
            for (Course course : courseList) {
                if (randomIdCourse == course.getId()) {
                    correctValue = true;
                    break;
                }
            }
        }
        return randomIdCourse;
    }

    public void addStudent(Scanner scanner) {
        int id = generateUserId(students);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Student student = new Student(id, name, email);
        students.add(student);
        System.out.println("Student added!");
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
        int idEnrollment = studentEnrollmentId(enrollments);
        Student assignStudent = null;
        boolean assignedStudentToEnrollmentOn = true;

        while (assignedStudentToEnrollmentOn) {
            displayStudents();
            System.out.println("Enter the id of the student you want to enroll in the course: ");
            int studentId = scanner.nextInt();
            for (Student student : students) {
                if (student.getId() == studentId) {
                    assignStudent = student;
                    assignedStudentToEnrollmentOn = false;
                }
            }
        }

        Course assignCourse = null;
        boolean assignedCourseToEnrollmentOn = true;
        while (assignedCourseToEnrollmentOn) {
            displayCourses();
            System.out.println("enter the id of the course you want to enroll the student in: ");
            int courseId = scanner.nextInt();
            for (Course course : courses) {
                if (course.getId() == courseId) {
                    assignCourse = course;
                    assignedCourseToEnrollmentOn = false;
                }
            }
        }

        double progress = 0;
        Enrollment enrollment = new Enrollment(idEnrollment, assignStudent, assignCourse, progress);
        enrollments.add(enrollment);
        System.out.println("Student assigned to course!");
    }

    private static int studentEnrollmentId(List<Enrollment> enrollmentList) {
        boolean correctValue = true;
        int randomIdEnrollment = 0;
        while (correctValue) {
            Random random = new Random();
            randomIdEnrollment = random.nextInt(1, 999);
            correctValue = false;
            for (Enrollment enrollment : enrollmentList) {
                if (randomIdEnrollment == enrollment.getEnrollmentId()) {
                    correctValue = true;
                    break;
                }
            }
        }
        return randomIdEnrollment;
    }

    public void displayCourses() {
        System.out.println("List of courses:");
        for (Course course : courses) {
            System.out.println("id: " + course.getId());
            System.out.println("title: " + course.getTittle());
            System.out.println("");
        }
    }

    public void displayStudents() {
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println("id: " + student.getId());
            System.out.println("name: " + student.getName());
            System.out.println("email: " + student.getEmail());
            System.out.println("");
        }
    }

    public void updateEnrollment(Scanner scanner) {
        System.out.println("Enrollments at course:");
        displayStudentProgress();
        boolean updateEnrollmentOn = true;
        while (updateEnrollmentOn) {
            System.out.println("Pick student enrollment id to update: ");
            int enrollmentId = scanner.nextInt();
            for (Enrollment enrollment : enrollments) {
                if (enrollment.getEnrollmentId() == enrollmentId) {
                    System.out.print("Set new progression for the task: ");
                    double progress = scanner.nextDouble();
                    enrollment.setProgress(progress);
                    updateEnrollmentOn = false;
                    System.out.println("Student enrollment updated!");
                }
            }
        }
    }

    public void displayStudentProgress() {
        System.out.println("Progress of students:");
        for (Enrollment enrollment : enrollments) {
            System.out.println("id: " + enrollment.getEnrollmentId() + "Course: " + enrollment.getCourse() + " " +
                    "student: " + enrollment.getStudent() + " " + "progress: " + enrollment.getProgress());
        }
    }

}
