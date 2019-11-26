package com.sparta.e44.controllers.entities;

public class CourseEntity
{
//    private int/string courseid;
    private String coursename;
    private String coursedescription;
    private String durationinweeks;

    public CourseEntity() {}

    public CourseEntity(String coursename, String coursedescription, String durationinweeks) {
        this.coursename = coursename;
        this.coursedescription = coursedescription;
        this.durationinweeks = durationinweeks;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    public String getDurationinweeks() {
        return durationinweeks;
    }

    public void setDurationinweeks(String durationinweeks) {
        this.durationinweeks = durationinweeks;
    }
}
