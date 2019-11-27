package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Grade;

import javax.persistence.*;
import java.util.List;

public class GradeEntity {
    private Grade grade;


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
}
