package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Grade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class GradeEntity {

    private Grade grade;

    @EmbeddedId
    private GradeId gradeId;

    public GradeEntity() {
    }

    public GradeEntity(GradeId gradeId, String grade) {
        this.gradeId = gradeId;
        this.grade = Grade.getGrade(grade);
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public GradeId getGradeId() {
        return gradeId;
    }

    public void setGrade(String g) {
        this.grade = Grade.getGrade(g);
    }

    public void setGradeId(GradeId gradeId) {
        this.gradeId = gradeId;
    }
}