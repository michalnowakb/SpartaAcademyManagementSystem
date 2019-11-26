package com.sparta.e44.entities;

public class CourseEntity
{
//    private int/string courseid;
    private String courseName;
    private String courseDescription;
    private String durationInWeeks;

    public CourseEntity() {}

    public CourseEntity(String coursename, String coursedescription, String durationinweeks) {
        this.courseName = coursename;
        this.courseDescription = coursedescription;
        this.durationInWeeks = durationinweeks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(String durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }
}
