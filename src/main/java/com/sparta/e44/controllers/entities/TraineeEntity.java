package com.sparta.e44.controllers.entities;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class TraineeEntity extends AbstractPersonEntity {
    private String currentCourse;
    private String placedOrNot;
    private String currentGrade;

    public TraineeEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         char gender, LocalDate startDate, String currentCourse, String placedOrNot, String currentGrade) {
        super(id, firstName, lastName, dateOfBirth, email, contactNumber, gender, startDate);
        this.currentCourse = currentCourse;
        this.placedOrNot = placedOrNot;
        this.currentCourse = currentGrade;
    }

    public String getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(String currentCourse) {
        this.currentCourse = currentCourse;
    }

    public String getPlacedOrNot() {
        return placedOrNot;
    }

    public void setPlacedOrNot(String placedOrNot) {
        this.placedOrNot = placedOrNot;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }
}
