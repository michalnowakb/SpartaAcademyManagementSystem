package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Grade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@IdClass(GradeId.class)
public class GradeEntity {

    private Grade grade;
    @Id
    private int traineeId;
    @Id
    private int moduleId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "trainee_id")
    private TraineeEntity traineeEntity;


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "module_id")
    private ModuleEntity moduleEntity;


    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setGrade(String grade){this.grade= Grade.getGrade(grade);}

    public TraineeEntity getTraineeEntity() {
        return traineeEntity;
    }

    public void setTraineeEntity(TraineeEntity traineeEntity) {
        this.traineeEntity = traineeEntity;
    }

    public ModuleEntity getModuleEntity() {
        return moduleEntity;
    }

    public void setModuleEntity(ModuleEntity moduleEntity) {
        this.moduleEntity = moduleEntity;
    }


    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }


}
