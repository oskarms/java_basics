package org.example.task_004.onlineCourseManagemenetSystem;

import java.util.List;

public class GraphicCourse extends Course{
    private List<String> tools;
    public GraphicCourse(int id, String tittle, String instructor, int duration, List<String> tools) {
        super(id, tittle, instructor, duration);
        this.tools = tools;
    }
}
