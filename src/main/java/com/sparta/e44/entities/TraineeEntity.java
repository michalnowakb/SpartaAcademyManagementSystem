package com.sparta.e44.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class TraineeEntity extends AbstractPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int traineeId;
    private String currentCourse;
    private String placement;
    private String currentGrade;

    public TraineeEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         char gender, LocalDate startDate, String currentCourse, String placedOrNot, String currentGrade) {
        super(id, firstName, lastName, dateOfBirth, email, contactNumber, gender,startDate);
        this.currentCourse = currentCourse;
        this.placement = placedOrNot;
        this.currentCourse = currentGrade;
    }

    public TraineeEntity() {

    }

    public String getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(String currentCourse) {
        this.currentCourse = currentCourse;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int id){
        this.traineeId=id;
    }
}
