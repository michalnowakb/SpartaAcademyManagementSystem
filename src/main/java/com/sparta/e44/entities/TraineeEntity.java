package com.sparta.e44.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TraineeEntity extends AbstractPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int traineeId;
    private String placement;


    @OneToMany(mappedBy = "gradeId.trainee")
    private List<GradeEntity> grades;

    public TraineeEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         char gender, LocalDate startDate,  String placedOrNot) {
        super(id, firstName, lastName, dateOfBirth, email, contactNumber, gender,startDate);
//        this.currentCourse = currentCourse;
        this.placement = placedOrNot;
//        this.currentCourse = currentGrade;
    }

    public TraineeEntity() {

    }

//    public String getCurrentCourse() {
//        return currentCourse;
//    }

//    public void setCurrentCourse(String currentCourse) {
//        this.currentCourse = currentCourse;
//    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

//    public String getCurrentGrade() {
//        return currentGrade;
//    }

//    public void setCurrentGrade(String currentGrade) {
//        this.currentGrade = currentGrade;
//    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int id){
        this.traineeId=id;
    }


    public List<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEntity> grades) {
        this.grades = grades;
    }


}
