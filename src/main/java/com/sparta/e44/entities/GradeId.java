package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Grade;

import java.io.Serializable;

public class GradeId implements Serializable {
    private int traineeId;
    private int moduleId;


    public GradeId(int traineeId, int moduleId) {
        this.traineeId = traineeId;
        this.moduleId = moduleId;
    }

    public GradeId(){}
}
