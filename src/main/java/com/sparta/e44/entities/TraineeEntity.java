package com.sparta.e44.entities;


import com.sparta.e44.entities.state.Gender;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TraineeEntity extends AbstractPersonEntity implements Comparable<TraineeEntity> {
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
    @JoinColumn(name = "group_id")
    private TeachingGroupEntity teachingGroup;

    @OneToMany(mappedBy = "attendanceId.trainee")
    private List<AttendanceEntity> attendanceList;

    public TraineeEntity() {

    }

    public List<AttendanceEntity> getAttendance() {
        return attendanceList;
    }

    public void setAttendance(List<AttendanceEntity> attendance) {
        this.attendanceList = attendance;
    }

    public void addAttendance(AttendanceEntity attendance){
        this.attendanceList.add(attendance);
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

    public AttendanceEntity getAttendanceOnDate(LocalDate localDate){
        for(AttendanceEntity attendance:attendanceList){
            if(attendance.getAttendanceId().getDate().isEqual(localDate)){
                return attendance;
            }
        }
        return null;
    }

    public String colorAttendanceOnDate(LocalDate localDate){
        AttendanceEntity attendanceEntity = getAttendanceOnDate(localDate);
        if(attendanceEntity==null){
            return "orange";
        }else if(attendanceEntity.getIsPresent()){
            return "green";
        }else{
            return "red";
        }
    }

    @Override
    public int compareTo(TraineeEntity o) {
        return (getLastName()+' '+getFirstName()).compareTo(o.getLastName()+' '+o.getFirstName());
    }
}
