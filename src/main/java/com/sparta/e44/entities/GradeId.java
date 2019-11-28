package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Grade;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradeId implements Serializable {


    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private TraineeEntity trainee;


    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeId gradeId = (GradeId) o;
        return Objects.equals(trainee, gradeId.trainee) &&
                Objects.equals(module, gradeId.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainee, module);
    }

    public GradeId(){}

    public GradeId(TraineeEntity trainee, ModuleEntity module) {
        this.trainee = trainee;
        this.module = module;
    }

    public TraineeEntity getTrainee() {
        return trainee;
    }

    public void setTrainee(TraineeEntity trainee) {
        this.trainee = trainee;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }
}
