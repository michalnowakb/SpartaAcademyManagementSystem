package com.sparta.e44.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AttendanceEntity {

    private boolean isPresent;

    @EmbeddedId
    private AttendanceId attendanceId;

    public AttendanceEntity(boolean isPresent, AttendanceId attendanceId) {
        this.isPresent = isPresent;
        this.attendanceId = attendanceId;
    }

    public AttendanceEntity(){}

    public AttendanceEntity(TraineeEntity trainee, LocalDate date) {
        attendanceId = new AttendanceId(trainee,date);
    }

    public boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean present) {
        isPresent = present;
    }

    public AttendanceId getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(AttendanceId attendanceId) {
        this.attendanceId = attendanceId;
    }
}
