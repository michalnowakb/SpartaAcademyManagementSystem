package com.sparta.e44.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class AttendanceId implements Serializable {

    @ManyToOne
    @JoinColumn(name="trainee_id")
    private TraineeEntity trainee;

    private LocalDate date;

    public AttendanceId(TraineeEntity trainee, LocalDate date) {
        this.trainee = trainee;
        this.date = date;
    }
    public AttendanceId(){}

    public TraineeEntity getTrainee() {
        return trainee;
    }

    public void setTrainee(TraineeEntity trainee) {
        this.trainee = trainee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
