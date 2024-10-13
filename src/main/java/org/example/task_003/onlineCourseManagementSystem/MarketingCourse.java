package org.example.task_003.onlineCourseManagementSystem;

public class MarketingCourse extends Course{

    private String advertisingTools;

    public MarketingCourse(int id, String title, String describe) {
        super(id, title, describe);
    }

    public MarketingCourse() {

    }

    @Override
    void videoLessonsBasics() {
        System.out.println("Video - Marketing, basics");
    }

    @Override
    void videoLessonsAdvanced() {
        System.out.println("Video - Marketing for the advanced");
    }

    @Override
    void quiz() {
        System.out.println("Quiz on advertising products");
    }
}
