package com.sparta.e44.entities;



import com.sparta.e44.entities.state.Classrooms;

import javax.persistence.*;
import java.util.List;

@Entity
public class ClassroomEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classroomId;

    @Enumerated(EnumType.STRING)
    private Classrooms classroomName;
    private int capacity;

    @OneToMany(mappedBy = "classroom")
    private List<TimeslotEntity> avaliableTimeslots;

    public ClassroomEntity(Classrooms classroomName, int capacity) {
        this.classroomName = classroomName;
        this.capacity = capacity;
    }

    public ClassroomEntity(){

    }
    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public Classrooms getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(Classrooms classroomName) {
        this.classroomName = classroomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
