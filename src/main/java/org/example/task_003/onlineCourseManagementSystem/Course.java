package org.example.task_003.onlineCourseManagementSystem;

import java.util.List;

public class Course extends Material{
    private int id;
    private String title;
    private String describe;
    private List<Participant> participantList;

    public Course(int id, String title, String describe) {
        this.id = id;
        this.title = title;
        this.describe = describe;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }
}
