package com.sparta.e44.entities;


import com.sparta.e44.entities.state.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TraineeEntity extends AbstractPersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int traineeId;
    private String placement;

    public TraineeEntity(String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber, Gender gender, LocalDate startDate, String placement) {
        super(firstName, lastName, dateOfBirth, email, contactNumber, gender, startDate);
        this.placement = placement;
    }

    @OneToMany(mappedBy = "gradeId.trainee")
    private List<GradeEntity> grades;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "group_id")
    private TeachingGroupEntity teachingGroup;

    public TraineeEntity() {

    }


    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }


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

    public TeachingGroupEntity getTeachingGroup() {
        return teachingGroup;
    }

    public void setTeachingGroup(TeachingGroupEntity teachingGroup) {
        this.teachingGroup = teachingGroup;
    }
}
