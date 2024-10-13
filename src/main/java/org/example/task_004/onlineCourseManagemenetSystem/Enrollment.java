package org.example.task_004.onlineCourseManagemenetSystem;

public class Enrollment {
    private int enrollmentId;
    private Student student;
    private Course course;
    private double progress;

    public Enrollment(int enrollmentId, Student student, Course course, double progress) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.progress = progress;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
